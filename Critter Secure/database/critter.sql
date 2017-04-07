DROP TABLE IF EXISTS message;
DROP TABLE IF EXISTS app_user;

DROP SEQUENCE message_message_id_seq;

CREATE TABLE app_user (
  user_name varchar(32) NOT NULL,     -- Username
  password varchar(32) NOT NULL,      -- Password (in plain-text)
  salt varchar(256) NOT NULL,		  -- Password Salt
  avatar_id integer,                  -- Avator Number (optional?)
  CONSTRAINT pk_app_user_username PRIMARY KEY (user_name)
);

CREATE SEQUENCE message_message_id_seq
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE message (
  message_id integer DEFAULT nextval('message_message_id_seq'::regclass) NOT NULL,
  sender_name varchar(32) NOT NULL,
  private boolean NOT NULL DEFAULT FALSE,
  receiver_name varchar(32),
  message_text varchar(200) NOT NULL,
  create_date timestamp NOT NULL DEFAULT now(),
  CONSTRAINT pk_message_message_id PRIMARY KEY (message_id)
);

ALTER TABLE message ADD FOREIGN KEY (sender_name) REFERENCES app_user(user_name);

-- Test data

INSERT INTO app_user (user_name, password, salt) VALUES ('gates', 'WzYbaCzcPr6PSX0W50gUWw==', 'SDJydqT014UpMj7hCx+1/aeV7HJ82PA+CxZm0BeelT75HfxhbnAH/w5AVIHoX+A6eGiyzIMPflQlLiYhQxtB8LqddoMPWIW6jsX3MrjuKZKlRdd52az4DXdV3jWzFb+CwkGjVlLZ0SE/NvNmMxoEcwKPEEnGevnkZ8T0ZJJdh/s=');
INSERT INTO app_user (user_name, password, salt) VALUES ('jobs', '4oM/sadeaSO27uqo5BjUZg==', 'GGQJ0g4eqopsi2HTa/uvBGSQrx8+AhhsK4DvSvQy10w9FMtcUxsvVS+MOIHUii6FoCSfQR/dJnoivxyeoRsZKU6xTGA2ByWmRI/6AJosGICwxG1s+YmgbaIqii7CtBW89r9P0uKQT8tUXW5HbXy+buQiifS8BhWr9A4YYdVcUAU=');
INSERT INTO app_user (user_name, password, salt) VALUES ('woz', '3OVAF52wRJaH34Jd84LAiw==', 'mkhoEViWKG/044kVyqGY4hnh3pU3vkCvreGdmVb81o1Jy0VcvY9/5TTbbJ8mHV1ueV2HKhVY0W22qg0avAGxsVe+8JXr1hONvig50GhDYUdVV+qZWjyYlRnT9XWQHUDEEGAPRmYmcU8U0nmDDxT1mh0L2yayfajmxqRlVYTi8Yw=');
INSERT INTO app_user (user_name, password, salt) VALUES ('ellison', 'xdtB3l+U+XLK7L4qemdL4w==', 'L6bgOH3ffWWGWv0S5Rtudu7FtGXn/I4hYksEEmO8vjTVh74zbvsYQtC58gWO4VvopGfE1CScD3VPLMxCgeaIpWy4WJW1bicjgA5mW8AKWYoMudYSDciNrWbjxH41JgIbWtz3mXo7JTQXU7sGyqTZRw7lghbaSrW09jovEfSc63U=');
INSERT INTO app_user (user_name, password, salt) VALUES ('kildall', 'Dy9UfeLCtUW2PrJlMVhfJw==', 'jrojMvgS+XDQq7NZqF/gXaDTzlR8/bLbLvg4q/TeerQqL/V1/8qt4WN8zQTZCttuwJ78JY4TJSgAbq50MKDD85pzLQ1XbZtWWc8nqV+IzNaKExNcPIbXY8Ol5EGkW4RY0zbv/QAJm0u9+z41NQOY4/ctm4YBSVV+aoOGMkgE7ME=');

INSERT INTO message (sender_name, private, receiver_name, message_text)
VALUES ('gates', true, 'jobs', 'hey');
INSERT INTO message (sender_name, private, receiver_name, message_text)
VALUES ('jobs', true, 'gates', 'hey back');
INSERT INTO message (sender_name, private, receiver_name, message_text)
VALUES ('gates', true, 'woz', 'what''s with steve?');
INSERT INTO message (sender_name, private, receiver_name, message_text)
VALUES ('woz', true, 'jobs', 'bill''s asking what''s with you');
INSERT INTO message (sender_name, private, receiver_name, message_text)
VALUES ('jobs', true, 'woz', 'bill can suck eggs');
INSERT INTO message (sender_name, private, receiver_name, message_text)
VALUES ('woz', true, 'gates', 'steve says hi');
INSERT INTO message (sender_name, private, receiver_name, message_text)
VALUES ('gates', true, 'jobs', 'woz said you said hi');
INSERT INTO message (sender_name, private, receiver_name, message_text)
VALUES ('ellison', true, 'kildall', 'bill and the two steves are losers');
INSERT INTO message (sender_name, private, receiver_name, message_text)
VALUES ('kildall', true, 'ellison', 'tell me about it');
INSERT INTO message (sender_name, private, receiver_name, message_text)
VALUES ('jobs', true, 'gates', 'wonder what ellison and kildall are whining about now');

INSERT INTO message (sender_name, private, receiver_name, message_text)
VALUES ('gates', false, null, 'Windoze 4Everrrrrrr!!!!!!');
INSERT INTO message (sender_name, private, receiver_name, message_text)
VALUES ('woz', false, null, 'Anybody interested in a game of AD&D?');
INSERT INTO message (sender_name, private, receiver_name, message_text)
VALUES ('ellison', false, null, 'I am better than everyone!');
INSERT INTO message (sender_name, private, receiver_name, message_text)
VALUES ('gates', false, null, 'I am richer than everyone!');

-- Gets the latest message id in a conversation between one named user (sender) and another named user (receiver),
-- plus the latest message id in any coversation where the first named user (sender) was was a receiver
-- select max(message_id) from message where (sender_name='gates' and receiver_name='jobs') or (receiver_name='gates') group by sender_name,receiver_name;

-- Wrap it as a subselect, and get the full latest message records in the conversations described above
--- select * from message where message_id in (select max(message_id) message_id from message where (sender_name='gates' and receiver_name='jobs') or (receiver_name='gates') group by sender_name,receiver_name);

-- Gets the latest message id in any conversation where the user was either the sender or the receiver
-- select max(message_id) from message where (sender_name='gates' and receiver_name is not null) or (receiver_name='gates') group by sender_name,receiver_name;

-- Wrap it as a subselect, and get the full latest message records in the conversations described above
-- select * from message where message_id in (select max(message_id) as message_id from message where (sender_name='gates' and receiver_name is not null) or (receiver_name='gates') group by sender_name,receiver_name);
