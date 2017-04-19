--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.2
-- Dumped by pg_dump version 9.6.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE IF EXISTS stmmdb;
--
-- Name: stmmdb; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE stmmdb WITH TEMPLATE = template0 ENCODING = 'WIN1250' LC_COLLATE = 'Hungarian_Hungary.1250' LC_CTYPE = 'Hungarian_Hungary.1250';


ALTER DATABASE stmmdb OWNER TO postgres;

\connect stmmdb

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- Name: appuser_record_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE appuser_record_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE appuser_record_id_seq OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: appuser; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE appuser (
    appuser_record_id numeric DEFAULT nextval('appuser_record_id_seq'::regclass),
    appuser_id character varying(100) NOT NULL,
    username character varying(100) NOT NULL,
    first_name character varying(100) NOT NULL,
    last_name character varying(100) NOT NULL,
    appuser_wallet_id character varying(100),
    password character varying(100) NOT NULL,
    appuser_creditcard_id character varying(100)
);


ALTER TABLE appuser OWNER TO postgres;

--
-- Name: creditcard; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE creditcard (
    credit_card_record_number integer NOT NULL,
    creditcard_card_number character varying(16) NOT NULL,
    creditcard_card_holder_name character varying(100) NOT NULL,
    creditcard_expiry_year character varying(2) NOT NULL,
    creditcard_expiry_month character varying(2) NOT NULL,
    creditcard_id character varying(100) NOT NULL
);


ALTER TABLE creditcard OWNER TO postgres;

--
-- Name: creditcard_credit_card_record_number_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE creditcard_credit_card_record_number_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE creditcard_credit_card_record_number_seq OWNER TO postgres;

--
-- Name: creditcard_credit_card_record_number_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE creditcard_credit_card_record_number_seq OWNED BY creditcard.credit_card_record_number;


--
-- Name: money_transfer_record_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE money_transfer_record_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE money_transfer_record_id_seq OWNER TO postgres;

--
-- Name: money_transfer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE money_transfer (
    money_transfer_record_id numeric DEFAULT nextval('money_transfer_record_id_seq'::regclass),
    moneytransfer_id character varying(100) NOT NULL,
    wallet_from character varying(100) NOT NULL,
    wallet_to character varying(100),
    transferdate date,
    returndate date,
    money_transfer_state_id character varying(30),
    money_transfer_repayment_type character varying(100) NOT NULL,
    money_transfer_amount integer NOT NULL,
    money_transfer_return_amount integer NOT NULL,
    money_transfer_invest_period_month integer NOT NULL,
    money_transfer_state character varying(32) NOT NULL
);


ALTER TABLE money_transfer OWNER TO postgres;

--
-- Name: money_transfer_part_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE money_transfer_part_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE money_transfer_part_id_seq OWNER TO postgres;

--
-- Name: moneytransfer_per_day; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE moneytransfer_per_day (
    day character varying(8) NOT NULL,
    count bigint NOT NULL
);


ALTER TABLE moneytransfer_per_day OWNER TO postgres;

--
-- Name: moneytransfer_state_record_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE moneytransfer_state_record_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE moneytransfer_state_record_id_seq OWNER TO postgres;

--
-- Name: registration_per_day; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE registration_per_day (
    day character varying(8),
    count bigint
);


ALTER TABLE registration_per_day OWNER TO postgres;

--
-- Name: repayment_type; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE repayment_type (
    repayment_type_id character varying(100) NOT NULL,
    repayment_type_name character varying(100) NOT NULL
);


ALTER TABLE repayment_type OWNER TO postgres;

--
-- Name: repayment_unit; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE repayment_unit (
    repayment_unit_deadline date NOT NULL,
    repayment_unit_amount numeric NOT NULL,
    repayment_unit_id character varying(100) NOT NULL,
    repayment_unit_money_transfer_id character varying(100) NOT NULL
);


ALTER TABLE repayment_unit OWNER TO postgres;

--
-- Name: role_role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE role_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE role_role_id_seq OWNER TO postgres;

--
-- Name: userrole; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE userrole (
    userrole_id integer NOT NULL,
    userrole_appuser_id character varying(100) NOT NULL,
    userrole_usertype_id character varying(100) NOT NULL
);


ALTER TABLE userrole OWNER TO postgres;

--
-- Name: userrole_userrole_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE userrole_userrole_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE userrole_userrole_id_seq OWNER TO postgres;

--
-- Name: userrole_userrole_id_seq1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE userrole_userrole_id_seq1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE userrole_userrole_id_seq1 OWNER TO postgres;

--
-- Name: userrole_userrole_id_seq1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE userrole_userrole_id_seq1 OWNED BY userrole.userrole_id;


--
-- Name: usertype_record_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE usertype_record_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE usertype_record_id_seq OWNER TO postgres;

--
-- Name: usertype; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE usertype (
    usertype_record_id integer DEFAULT nextval('usertype_record_id_seq'::regclass),
    usertype_id character varying(100) NOT NULL,
    usertype character varying(100) NOT NULL,
    state integer NOT NULL
);


ALTER TABLE usertype OWNER TO postgres;

--
-- Name: wallet_record_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE wallet_record_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE wallet_record_id_seq OWNER TO postgres;

--
-- Name: wallet; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE wallet (
    wallet_record_id numeric DEFAULT nextval('wallet_record_id_seq'::regclass),
    wallet_id character varying(100) NOT NULL,
    amount numeric
);


ALTER TABLE wallet OWNER TO postgres;

--
-- Name: creditcard credit_card_record_number; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY creditcard ALTER COLUMN credit_card_record_number SET DEFAULT nextval('creditcard_credit_card_record_number_seq'::regclass);


--
-- Name: userrole userrole_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY userrole ALTER COLUMN userrole_id SET DEFAULT nextval('userrole_userrole_id_seq1'::regclass);


--
-- Data for Name: appuser; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO appuser (appuser_record_id, appuser_id, username, first_name, last_name, appuser_wallet_id, password, appuser_creditcard_id) VALUES (21, '20170405-5', 'nPisti', 'Pisti', 'Nagy', NULL, '$2a$10$WUpF4Rso99PJo7VsNWdS3O3tlbKvsbTDYRjuy0EszEZf.2nB6tOxW', NULL);
INSERT INTO appuser (appuser_record_id, appuser_id, username, first_name, last_name, appuser_wallet_id, password, appuser_creditcard_id) VALUES (20, '20170405-4', 'smiklos', 'Miklós', 'Sebestyén', 'W-20170405-4', '$2a$10$pJUihxmWEAyfWGiApqqqAOvzO0LSrzUF48yK3L7fcCY/TkApld5.C', 'CC-20170405-4');
INSERT INTO appuser (appuser_record_id, appuser_id, username, first_name, last_name, appuser_wallet_id, password, appuser_creditcard_id) VALUES (17, '20170402-2', 'pNagy', 'Péter', 'Nagy', 'W-20170402-2', '$2a$10$dQ4shd7MSrdBK7qZaCPrWO8gqKBEs2UwhAr1e9aS925lvcPSgq42K', 'CC-20170402-2');


--
-- Name: appuser_record_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('appuser_record_id_seq', 25, true);


--
-- Data for Name: creditcard; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO creditcard (credit_card_record_number, creditcard_card_number, creditcard_card_holder_name, creditcard_expiry_year, creditcard_expiry_month, creditcard_id) VALUES (14, '4321432143214321', 'MR PETER NAGY', '23', '12', 'CC-20170402-2');
INSERT INTO creditcard (credit_card_record_number, creditcard_card_number, creditcard_card_holder_name, creditcard_expiry_year, creditcard_expiry_month, creditcard_id) VALUES (15, '1234123412341234', 'MR MIKLOS SEBESTYEN', '23', '12', 'CC-20170405-4');


--
-- Name: creditcard_credit_card_record_number_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('creditcard_credit_card_record_number_seq', 15, true);


--
-- Data for Name: money_transfer; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO money_transfer (money_transfer_record_id, moneytransfer_id, wallet_from, wallet_to, transferdate, returndate, money_transfer_state_id, money_transfer_repayment_type, money_transfer_amount, money_transfer_return_amount, money_transfer_invest_period_month, money_transfer_state) VALUES (10, 'MT-20170419-4', 'W-20170402-2', NULL, NULL, NULL, NULL, 'M', 222, 244, 12, '0');
INSERT INTO money_transfer (money_transfer_record_id, moneytransfer_id, wallet_from, wallet_to, transferdate, returndate, money_transfer_state_id, money_transfer_repayment_type, money_transfer_amount, money_transfer_return_amount, money_transfer_invest_period_month, money_transfer_state) VALUES (11, 'MT-20170419-5', 'W-20170402-2', NULL, NULL, NULL, NULL, 'W', 222, 244, 6, '0');


--
-- Name: money_transfer_part_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('money_transfer_part_id_seq', 1, false);


--
-- Name: money_transfer_record_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('money_transfer_record_id_seq', 13, true);


--
-- Data for Name: moneytransfer_per_day; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO moneytransfer_per_day (day, count) VALUES ('20170416', 8);
INSERT INTO moneytransfer_per_day (day, count) VALUES ('20170417', 2);
INSERT INTO moneytransfer_per_day (day, count) VALUES ('20170419', 7);


--
-- Name: moneytransfer_state_record_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('moneytransfer_state_record_id_seq', 1, false);


--
-- Data for Name: registration_per_day; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO registration_per_day (day, count) VALUES ('20170502', 1);
INSERT INTO registration_per_day (day, count) VALUES ('20171002', 1);
INSERT INTO registration_per_day (day, count) VALUES ('20171202', 1);
INSERT INTO registration_per_day (day, count) VALUES ('20171702', 1);
INSERT INTO registration_per_day (day, count) VALUES ('20173402', 1);
INSERT INTO registration_per_day (day, count) VALUES ('20173802', 1);
INSERT INTO registration_per_day (day, count) VALUES ('20170602', 1);
INSERT INTO registration_per_day (day, count) VALUES ('20172002', 1);
INSERT INTO registration_per_day (day, count) VALUES ('20174202', 1);
INSERT INTO registration_per_day (day, count) VALUES ('20172202', 1);
INSERT INTO registration_per_day (day, count) VALUES ('20174302', 1);
INSERT INTO registration_per_day (day, count) VALUES ('20170402', 2);
INSERT INTO registration_per_day (day, count) VALUES ('20170405', 5);
INSERT INTO registration_per_day (day, count) VALUES ('20170409', 3);
INSERT INTO registration_per_day (day, count) VALUES ('20170411', 1);


--
-- Data for Name: repayment_type; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO repayment_type (repayment_type_id, repayment_type_name) VALUES ('M', 'Monthly');
INSERT INTO repayment_type (repayment_type_id, repayment_type_name) VALUES ('W', 'Weekly');


--
-- Data for Name: repayment_unit; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Name: role_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('role_role_id_seq', 1, false);


--
-- Data for Name: userrole; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO userrole (userrole_id, userrole_appuser_id, userrole_usertype_id) VALUES (5, '20170405-4', 'REGISTERED');
INSERT INTO userrole (userrole_id, userrole_appuser_id, userrole_usertype_id) VALUES (6, '20170405-5', 'REGISTERED');
INSERT INTO userrole (userrole_id, userrole_appuser_id, userrole_usertype_id) VALUES (8, '20170402-2', 'REGISTERED');


--
-- Name: userrole_userrole_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('userrole_userrole_id_seq', 1, false);


--
-- Name: userrole_userrole_id_seq1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('userrole_userrole_id_seq1', 8, true);


--
-- Data for Name: usertype; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO usertype (usertype_record_id, usertype_id, usertype, state) VALUES (9, 'REGISTERED', 'REGISTERED', 1);
INSERT INTO usertype (usertype_record_id, usertype_id, usertype, state) VALUES (10, 'RELIABLE', 'RELIABLE', 3);
INSERT INTO usertype (usertype_record_id, usertype_id, usertype, state) VALUES (11, 'SUSPICIOUS', 'SUSPICIOUS', -1);
INSERT INTO usertype (usertype_record_id, usertype_id, usertype, state) VALUES (12, 'OWING', 'OWING', -2);
INSERT INTO usertype (usertype_record_id, usertype_id, usertype, state) VALUES (13, 'PROVED', 'PROVED', 2);
INSERT INTO usertype (usertype_record_id, usertype_id, usertype, state) VALUES (14, 'ADMINISTRATOR', 'ADMINISTRATOR', 100);
INSERT INTO usertype (usertype_record_id, usertype_id, usertype, state) VALUES (15, 'GUEST', 'GUEST', -100);


--
-- Name: usertype_record_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('usertype_record_id_seq', 15, true);


--
-- Data for Name: wallet; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO wallet (wallet_record_id, wallet_id, amount) VALUES (15, 'W-20170402-2', 1532);
INSERT INTO wallet (wallet_record_id, wallet_id, amount) VALUES (13, 'W-20170405-4', 4080);


--
-- Name: wallet_record_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('wallet_record_id_seq', 15, true);


--
-- Name: creditcard creditcard_creditcard_id_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY creditcard
    ADD CONSTRAINT creditcard_creditcard_id_pk PRIMARY KEY (creditcard_id);


--
-- Name: moneytransfer_per_day moneytransfer_per_day_day_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY moneytransfer_per_day
    ADD CONSTRAINT moneytransfer_per_day_day_pk PRIMARY KEY (day);


--
-- Name: appuser pk_appuser_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY appuser
    ADD CONSTRAINT pk_appuser_id PRIMARY KEY (appuser_id);


--
-- Name: money_transfer pk_money_transfer; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY money_transfer
    ADD CONSTRAINT pk_money_transfer PRIMARY KEY (moneytransfer_id);


--
-- Name: userrole pk_userrole_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY userrole
    ADD CONSTRAINT pk_userrole_id PRIMARY KEY (userrole_id);


--
-- Name: usertype pk_usertype_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usertype
    ADD CONSTRAINT pk_usertype_id PRIMARY KEY (usertype_id);


--
-- Name: wallet pk_wallet_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY wallet
    ADD CONSTRAINT pk_wallet_id PRIMARY KEY (wallet_id);


--
-- Name: registration_per_day registration_per_day_day_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY registration_per_day
    ADD CONSTRAINT registration_per_day_day_key UNIQUE (day);


--
-- Name: repayment_type repayment_type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY repayment_type
    ADD CONSTRAINT repayment_type_pkey PRIMARY KEY (repayment_type_id);


--
-- Name: repayment_unit repayment_unit_repayment_unit_id_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY repayment_unit
    ADD CONSTRAINT repayment_unit_repayment_unit_id_pk PRIMARY KEY (repayment_unit_id);


--
-- Name: appuser_creditcard_number_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX appuser_creditcard_number_uindex ON appuser USING btree (appuser_creditcard_id);


--
-- Name: appuser_username_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX appuser_username_uindex ON appuser USING btree (username);


--
-- Name: creditcard_creditcard_card_number_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX creditcard_creditcard_card_number_uindex ON creditcard USING btree (creditcard_card_number);


--
-- Name: repayment_type_repayment_type_name_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX repayment_type_repayment_type_name_uindex ON repayment_type USING btree (repayment_type_name);


--
-- Name: ui_appuser_name; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX ui_appuser_name ON appuser USING btree (username);


--
-- Name: usertype_state_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX usertype_state_uindex ON usertype USING btree (state);


--
-- Name: appuser appuser_creditcard_creditcard_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY appuser
    ADD CONSTRAINT appuser_creditcard_creditcard_id_fk FOREIGN KEY (appuser_creditcard_id) REFERENCES creditcard(creditcard_id) ON UPDATE CASCADE ON DELETE SET NULL;


--
-- Name: appuser fk_wallet_in_appuser; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY appuser
    ADD CONSTRAINT fk_wallet_in_appuser FOREIGN KEY (appuser_wallet_id) REFERENCES wallet(wallet_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: repayment_unit repayment_unit_money_transfer_moneytransfer_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY repayment_unit
    ADD CONSTRAINT repayment_unit_money_transfer_moneytransfer_id_fk FOREIGN KEY (repayment_unit_money_transfer_id) REFERENCES money_transfer(moneytransfer_id) ON UPDATE SET DEFAULT ON DELETE SET DEFAULT;


--
-- Name: userrole userrole_appuser_appuser_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY userrole
    ADD CONSTRAINT userrole_appuser_appuser_id_fk FOREIGN KEY (userrole_appuser_id) REFERENCES appuser(appuser_id);


--
-- Name: userrole userrole_usertype_usertype_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY userrole
    ADD CONSTRAINT userrole_usertype_usertype_id_fk FOREIGN KEY (userrole_usertype_id) REFERENCES usertype(usertype_id) ON UPDATE CASCADE;


--
-- Name: appuser; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE appuser TO bookstore_role;


--
-- Name: usertype; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE usertype TO bookstore_role;


--
-- PostgreSQL database dump complete
--

