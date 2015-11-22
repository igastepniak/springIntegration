--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: client; Type: TABLE; Schema: public; Owner: example_test; Tablespace: 
--

CREATE TABLE client (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    promo character varying(255) NOT NULL,
    username character varying(255) NOT NULL,
    password character varying(1024) NOT NULL,
    session_key character varying(512) NOT NULL,
    secret_key character varying(512) NOT NULL,
    timezone character varying(255) DEFAULT 'UTC'::character varying NOT NULL,
    account_level bigint DEFAULT 1 NOT NULL,
    created_date timestamp without time zone DEFAULT '2013-12-17 12:39:35'::timestamp without time zone,
    terms_accepted_date timestamp without time zone DEFAULT '2013-12-17 12:39:35'::timestamp without time zone
);


ALTER TABLE public.client OWNER TO example_test;

--
-- Name: databasechangelog; Type: TABLE; Schema: public; Owner: example_test; Tablespace: 
--

CREATE TABLE databasechangelog (
    id character varying(255) NOT NULL,
    author character varying(255) NOT NULL,
    filename character varying(255) NOT NULL,
    dateexecuted timestamp without time zone NOT NULL,
    orderexecuted integer NOT NULL,
    exectype character varying(10) NOT NULL,
    md5sum character varying(35),
    description character varying(255),
    comments character varying(255),
    tag character varying(255),
    liquibase character varying(20),
    contexts character varying(255),
    labels character varying(255)
);


ALTER TABLE public.databasechangelog OWNER TO example_test;

--
-- Name: databasechangeloglock; Type: TABLE; Schema: public; Owner: example_test; Tablespace: 
--

CREATE TABLE databasechangeloglock (
    id integer NOT NULL,
    locked boolean NOT NULL,
    lockgranted timestamp without time zone,
    lockedby character varying(255)
);


ALTER TABLE public.databasechangeloglock OWNER TO example_test;

--
-- Data for Name: client; Type: TABLE DATA; Schema: public; Owner: example_test
--

COPY client (id, name, email, promo, username, password, session_key, secret_key, timezone, account_level, created_date, terms_accepted_date) FROM stdin;
2	Test 1	test1@example.net		test1	EEE	342f	e	UTC	1	1970-01-01 00:00:00	\N
3	Test 2	test2@example.net	acme	test2	DDD	pdzwr44	t	Europe/Oslo	1	2010-10-17 14:19:47	\N
4	Test 4	test4@example.net	forum	test4	FFF	eeepdo3	r	Europe/Oslo	1	2010-10-28 15:48:54	2011-05-21 15:23:34
\.


--
-- Data for Name: databasechangelog; Type: TABLE DATA; Schema: public; Owner: example_test
--

COPY databasechangelog (id, author, filename, dateexecuted, orderexecuted, exectype, md5sum, description, comments, tag, liquibase, contexts, labels) FROM stdin;
0	istepniak	src/main/resources/pl/stepniak/example/changelog-001.xml	2015-11-22 20:47:25.850105	1	EXECUTED	7:9f42f66f49e572a7da7a215164f78dd8	createTable		\N	3.4.0	\N	\N
create-advertisers-records	istepniak	src/main/resources/pl/stepniak/example/create-client-records.sql	2015-11-22 20:47:25.934615	2	EXECUTED	7:fb05f40e5214aea131575c7e59eca1ca	sql		\N	3.4.0	\N	\N
\.


--
-- Data for Name: databasechangeloglock; Type: TABLE DATA; Schema: public; Owner: example_test
--

COPY databasechangeloglock (id, locked, lockgranted, lockedby) FROM stdin;
1	f	\N	\N
\.


--
-- Name: client_email_key; Type: CONSTRAINT; Schema: public; Owner: example_test; Tablespace: 
--

ALTER TABLE ONLY client
    ADD CONSTRAINT client_email_key UNIQUE (email);


--
-- Name: client_username_key; Type: CONSTRAINT; Schema: public; Owner: example_test; Tablespace: 
--

ALTER TABLE ONLY client
    ADD CONSTRAINT client_username_key UNIQUE (username);


--
-- Name: pk_client; Type: CONSTRAINT; Schema: public; Owner: example_test; Tablespace: 
--

ALTER TABLE ONLY client
    ADD CONSTRAINT pk_client PRIMARY KEY (id);


--
-- Name: pk_databasechangeloglock; Type: CONSTRAINT; Schema: public; Owner: example_test; Tablespace: 
--

ALTER TABLE ONLY databasechangeloglock
    ADD CONSTRAINT pk_databasechangeloglock PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

