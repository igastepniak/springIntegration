--liquibase formatted sql

--changeset istepniak:create-advertisers-records

INSERT INTO client(id, secret_key, name, username, password, timezone, account_level, created_date, email, promo, terms_accepted_date, session_key) VALUES (2, 'e', 'Test 1', 'test1','EEE', 'UTC',1,'1970-01-01 00:00:00','test1@example.net','',NULL, '342f');
INSERT INTO client(id, secret_key, name, username, password, timezone, account_level, created_date, email, promo, terms_accepted_date, session_key) VALUES (3, 't', 'Test 2','test2','DDD', 'Europe/Oslo',1,'2010-10-17 14:19:47','test2@example.net','acme',NULL, 'pdzwr44');
INSERT INTO client(id, secret_key, name, username, password, timezone, account_level, created_date, email, promo, terms_accepted_date, session_key) VALUES (4, 'r', 'Test 4','test4','FFF', 'Europe/Oslo',1,'2010-10-28 15:48:54','test4@example.net','forum','2011-05-21 15:23:34', 'eeepdo3');
