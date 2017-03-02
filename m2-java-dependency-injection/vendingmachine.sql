BEGIN TRANSACTION;

CREATE TABLE items
(
	slot char(2) NOT NULL,
	name varchar(32) NOT NULL,
	price numeric(3,2) NOT NULL,
	CONSTRAINT pk_items_slot PRIMARY KEY (slot)
);

INSERT INTO items VALUES ('A1', 'Potato Crisps', 3.05);
INSERT INTO items VALUES ('A2', 'Stackers', 1.75);
INSERT INTO items VALUES ('A3', 'Grain Waves', 2.75);
INSERT INTO items VALUES ('A4', 'Cloud Popcorn', 3.65);
INSERT INTO items VALUES ('B1', 'Moonpie', 1.80);
INSERT INTO items VALUES ('B2', 'Cowtales', 1.50);
INSERT INTO items VALUES ('B3', 'Wonka Bar', 1.50);
INSERT INTO items VALUES ('B4', 'Crunchie', 1.75);
INSERT INTO items VALUES ('C1', 'Cola', 1.25);
INSERT INTO items VALUES ('C2', 'Dr. Salt', 1.50);
INSERT INTO items VALUES ('C3', 'Mountain Melter', 1.50);
INSERT INTO items VALUES ('C4', 'Heavy', 1.50);
INSERT INTO items VALUES ('D1', 'U-Chews', 0.85);
INSERT INTO items VALUES ('D2', 'Little League Chew', 0.95);
INSERT INTO items VALUES ('D3', 'Chiclets', 0.75);
INSERT INTO items VALUES ('D4', 'Triplemint', 0.75);

COMMIT TRANSACTION;