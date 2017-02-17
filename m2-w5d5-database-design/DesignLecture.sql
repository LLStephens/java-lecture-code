BEGIN TRANSACTION;

CREATE TABLE contacts
(
	id serial,
	first_name varchar(32) NOT NULL,
	last_name varchar(32),
	date_added timestamp DEFAULT NOW() NOT NULL,
	date_updated timestamp,
	CONSTRAINT pk_contacts_id PRIMARY KEY (id)
);

CREATE TABLE types
(
	id serial,
	type varchar(16) NOT NULL,
	is_address_type boolean NOT NULL,
	is_phone_type boolean NOT NULL,
	is_email_type boolean NOT NULL,
	CONSTRAINT pk_types_id PRIMARY KEY (id)
);

CREATE TABLE addresses
(
	id serial,
	contact_id integer NOT NULL,
	type_id integer NOT NULL,
	address varchar(64) NOT NULL,
	address_line_2 varchar(64),
	city varchar(32) NOT NULL,
	province varchar(32) NOT NULL,
	postal_code varchar(16),
	description varchar(32),
	CONSTRAINT pk_addresses_id PRIMARY KEY (id),
	CONSTRAINT fk_addresses_contacts_id FOREIGN KEY (contact_id) REFERENCES contacts(id),
	CONSTRAINT fk_addresses_types_id FOREIGN KEY (type_id) REFERENCES types(id)
);

CREATE TABLE phone_numbers
(
	id serial,
	contact_id integer NOT NULL,
	type_id integer NOT NULL,
	phone_number varchar(32) NOT NULL,
	description varchar(16),
	CONSTRAINT pk_phone_numbers_id PRIMARY KEY (id),
	CONSTRAINT fk_phone_numbers_contacts_id FOREIGN KEY (contact_id) REFERENCES contacts(id),
	CONSTRAINT fk_phone_numbers_types_id FOREIGN KEY (type_id) REFERENCES types(id)
);

CREATE TABLE emails
(
	id serial,
	contact_id integer NOT NULL,
	type_id integer NOT NULL,
	email varchar(64) NOT NULL,
	description varchar(16),
	CONSTRAINT pk_emails_id PRIMARY KEY (id),
	CONSTRAINT fk_emails_contacts_id FOREIGN KEY (contact_id) REFERENCES contacts(id),
	CONSTRAINT fk_emails_types_id FOREIGN KEY (type_id) REFERENCES types(id)
);

INSERT INTO types (id, type, is_address_type, is_phone_type, is_email_type) VALUES (1, 'Home', true, true, true);
INSERT INTO types (id, type, is_address_type, is_phone_type, is_email_type) VALUES (2, 'Work', true, true, true);
INSERT INTO types (id, type, is_address_type, is_phone_type, is_email_type) VALUES (3, 'Shipping', true, false, false);
INSERT INTO types (id, type, is_address_type, is_phone_type, is_email_type) VALUES (4, 'Billing', true, false, false);
INSERT INTO types (id, type, is_address_type, is_phone_type, is_email_type) VALUES (5, 'Mobile', false, true, false);
INSERT INTO types (id, type, is_address_type, is_phone_type, is_email_type) VALUES (6, 'Other', true, true, true);

SELECT setval(pg_get_serial_sequence('types', 'id'), 7);

-- Create a new contact
INSERT INTO contacts (id, first_name, last_name) VALUES (1, 'Bob', 'Smith');
INSERT INTO contacts (id, first_name, last_name) VALUES (2, 'Janis', 'Joplin');
INSERT INTO contacts (id, first_name, last_name) VALUES (3, 'Peter', 'Gabrial');

SELECT setval(pg_get_serial_sequence('contacts', 'id'), 4);

-- Add stuff for Bob
INSERT INTO emails (contact_id, type_id, email) VALUES (1, 1, 'Bob@BobsHouse.com');
INSERT INTO emails (contact_id, type_id, email) VALUES (1, 2, 'bsmith@NSA.gov');
INSERT INTO phone_numbers (contact_id, type_id, phone_number) VALUES (1, 5, '+12128675309');

-- Add stuff to Janis
INSERT INTO addresses (contact_id, type_id, address, city, province, description) VALUES (2, 6, '710 Ashbury St.', 'San Francisco', 'CA', 'Tour Bus');
INSERT INTO emails (contact_id, type_id, email) VALUES (2, 2, 'JJ@woodstock.com');
INSERT INTO emails (contact_id, type_id, email) VALUES (2, 1, 'janice@yahoo.com');

-- Add stuff to Peter
INSERT INTO phone_numbers (contact_id, type_id, phone_number) VALUES (3, 5, '555-5555');
INSERT INTO emails (contact_id, type_id, email) VALUES (3, 2, 'peter@pumpkineater.com');
INSERT INTO addresses (contact_id, type_id, address, city, province) VALUES (3, 1, '123 Salsbury Hill', 'Hampton', 'Surry');

COMMIT TRANSACTION;