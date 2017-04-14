CREATE TABLE guitarbrand (
	guitarbrand_id INTEGER NOT NULL,
	guitarbrand_name CHARACTER VARYING(100) NOT NULL,
	CONSTRAINT PK_GUITARBRAND_ID PRIMARY KEY (guitarbrand_id)
);
ALTER TABLE guitarbrand OWNER TO postgres;

CREATE TABLE guitarowner (
	guitarowner_id INTEGER NOT NULL,
	guitarowner_username CHARACTER VARYING(100) NOT NULL,
	guitarowner_email CHARACTER VARYING(100) UNIQUE NOT NULL, /* nem árt, ha unique ez a mező */
	guitarowner_password CHARACTER VARYING(100) NOT NULL,
	CONSTRAINT PK_GUITAROWNER_ID PRIMARY KEY (guitarowner_id)
);
ALTER TABLE guitarowner OWNER TO postgres;
CREATE UNIQUE INDEX UI_GUITAROWNER_EMAIL ON guitarowner USING btree (guitarowner_email);

CREATE TABLE guitar (
	guitar_id SERIAL NOT NULL,	
	guitar_guitarbrand_id INTEGER NOT NULL,
	guitar_serialnumber CHARACTER VARYING(100) NOT NULL,
	guitar_type CHARACTER VARYING(100) NOT NULL,
	guitar_color CHARACTER VARYING(100) NOT NULL,
	guitar_vintage INTEGER NOT NULL,	
	guitar_price REAL NOT NULL,
	guitar_guitarowner_id INTEGER NOT NULL,
	CONSTRAINT PK_GUITAR_ID PRIMARY KEY (guitar_id),
	CONSTRAINT FK_GUITAR_GUITARBRAND_ID FOREIGN KEY (guitar_guitarbrand_id)
	  REFERENCES guitarbrand (guitarbrand_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT FK_GUITAR_GUITAROWNER_ID FOREIGN KEY (guitar_guitarowner_id)
	  REFERENCES guitarowner (guitarowner_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
ALTER TABLE guitar OWNER TO postgres;
CREATE UNIQUE INDEX UI_GUITAR_SERIALNUMBER ON guitar USING btree (guitar_serialnumber);