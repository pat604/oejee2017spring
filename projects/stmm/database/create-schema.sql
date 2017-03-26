
CREATE SEQUENCE usertype_record_id_seq START 1;
CREATE TABLE usertype (
  usertype_record_id INT DEFAULT nextval('usertype_record_id_seq'),
	usertype_id CHARACTER VARYING(100) NOT NULL,
	usertype CHARACTER VARYING(100) NOT NULL,
	CONSTRAINT PK_USERTYPE_ID PRIMARY KEY (usertype_id)
);
ALTER TABLE usertype OWNER TO postgres;



CREATE SEQUENCE appuser_record_id_seq START 1;
CREATE TABLE appuser (
  appuser_record_id NUMERIC DEFAULT nextval('appuser_record_id_seq'),
  appuser_id CHARACTER VARYING(100) NOT NULL,
  username CHARACTER VARYING(100) NOT NULL,
  first_name CHARACTER VARYING(100) NOT NULL ,
  last_name CHARACTER  VARYING (100) NOT NULL ,
	wallet_id CHARACTER VARYING(100),
	password CHARACTER VARYING(100) NOT NULL,
	appuser_usertype_id CHARACTER VARYING(100) NOT NULL,
	CONSTRAINT PK_APPUSER_ID PRIMARY KEY (appuser_id),
	CONSTRAINT FK_USER_TYPE FOREIGN KEY (appuser_usertype_id)
	  REFERENCES usertype (usertype_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
ALTER TABLE appuser OWNER TO postgres;


CREATE SEQUENCE wallet_record_id_seq START 1;
CREATE TABLE wallet (
  wallet_record_id NUMERIC DEFAULT nextval('wallet_record_id_seq'),
  wallet_id CHARACTER VARYING(100) NOT NULL,
  amount NUMERIC,
  CONSTRAINT PK_WALLET_ID PRIMARY KEY (wallet_id)
);
ALTER TABLE wallet OWNER TO postgres;

ALTER TABLE appuser ADD CONSTRAINT FK_WALLET_IN_APPUSER FOREIGN KEY (wallet_id)
  REFERENCES wallet(wallet_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT;

CREATE SEQUENCE moneytransfer_state_record_id_seq START 1;
CREATE TABLE money_transfer_state (
  money_transfer_state_record_id INT DEFAULT nextval('moneytransfer_state_record_id_seq'),
  money_transfer_state_id CHARACTER VARYING(100),
  money_transfer_state_name CHARACTER VARYING(100),
  CONSTRAINT PK_MONEYTRANSFER_STATE PRIMARY KEY (money_transfer_state_id),
  UNIQUE (money_transfer_state_name)
);
ALTER TABLE money_transfer_state OWNER TO postgres;



CREATE SEQUENCE money_transfer_record_id_seq START 1;
CREATE TABLE money_transfer (
  money_transfer_record_id NUMERIC DEFAULT nextval('money_transfer_record_id_seq'),
  moneytransfer_id CHARACTER VARYING(100) NOT NULL,
  wallet_from CHARACTER VARYING(100) NOT NULL,
  wallet_to CHARACTER VARYING(100) NOT NULL,
  transferDate DATE,
  returnDate DATE,
  number_of_payments INT DEFAULT 1,
  money_transfer_state_id CHARACTER VARYING(30),
  CONSTRAINT PK_MONEY_TRANSFER PRIMARY KEY (moneytransfer_id),
  CONSTRAINT FK_MONEY_TRANSFER_FROM_WALLET FOREIGN KEY (wallet_from)
    REFERENCES wallet(wallet_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT FK_MONEY_TRANSFER_TO_WALLET FOREIGN KEY (wallet_to)
    REFERENCES wallet(wallet_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
ALTER TABLE money_transfer OWNER TO postgres;


CREATE SEQUENCE money_transfer_part_state_record_id START 1;
CREATE TABLE money_transfer_part_state (
  money_transfer_part_state_record_id INT DEFAULT nextval('money_transfer_part_state_record_id'),
  money_transfer_part_id CHARACTER VARYING(100) NOT NULL,
  money_transfer_part_name CHARACTER VARYING(100) NOT NULL
);
ALTER TABLE money_transfer_part_state OWNER TO postgres;



CREATE SEQUENCE money_transfer_part_id_seq START 1;
CREATE TABLE money_transfer_part (
  money_transfer_part_record_id NUMERIC DEFAULT nextval('money_transfer_part_id_seq'),
  money_transfer_part_id CHARACTER VARYING(100) NOT NULL ,
  money_transfer_id CHARACTER VARYING(100) NOT NULL ,
  return_date DATE,
  amount NUMERIC(2),
  CONSTRAINT PK_MONEAY_TRANSFER_PART PRIMARY KEY (money_transfer_part_id),
  CONSTRAINT FK_MONEY_TRANSFER_IN_MONEY_TRANSFER_PART FOREIGN KEY (money_transfer_id)
    REFERENCES money_transfer(moneytransfer_id)
);
ALTER TABLE money_transfer_part OWNER TO postgres;



CREATE SEQUENCE deadline_state_record_id_seq START 1;
CREATE TABLE deadline_state(
  deadline_state_record_id INT DEFAULT nextval('deadline_state_record_id_seq'),
  deadline_state_id CHARACTER VARYING(100) NOT NULL ,
  deadline_state_name CHARACTER VARYING(100) NOT NULL ,
  CONSTRAINT PK_DEADLINE_STATE PRIMARY KEY (deadline_state_id)
);
ALTER TABLE deadline_state OWNER TO postgres;



CREATE SEQUENCE deadline_record_id_seq START 1;
CREATE TABLE deadline (
  deadline_record_id NUMERIC DEFAULT nextval('deadline_record_id_seq'),
  money_transfer_part_id CHARACTER VARYING(100) NOT NULL ,
  deadline_id CHARACTER VARYING(100),
  deadline_state CHARACTER VARYING(100),
  CONSTRAINT PK_DEADLINE PRIMARY KEY (deadline_id),
  CONSTRAINT FK_MONEY_TRANSFER_PART_IN_DEADLINE FOREIGN KEY (money_transfer_part_id)
    REFERENCES money_transfer(moneytransfer_id)
);
ALTER TABLE deadline OWNER TO postgres;





