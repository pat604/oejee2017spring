CREATE TABLE anglerregistry.hal
(
  id bigint NOT NULL DEFAULT nextval('anglerregistry.hal_id_seq'::regclass),
  halnev text NOT NULL,
  minimummeret integer,
  napidarabszam integer NOT NULL,
  tilalmiidoszakkezdete date,
  tilalmiidoszakvege date,
  pusztulas integer,
  CONSTRAINT hal_pkey PRIMARY KEY (id),
  CONSTRAINT minmeret CHECK (minimummeret >= 0),
  CONSTRAINT napidarab CHECK (napidarabszam >= 0 OR napidarabszam = '-10'::integer),
  CONSTRAINT pusztul CHECK (pusztulas >= 0)
);



CREATE TABLE anglerregistry.horgasz
(
  id bigint NOT NULL DEFAULT nextval('anglerregistry.horgasz_id_seq'::regclass),
  nev text NOT NULL,
  anyjaneve text NOT NULL,
  szuletesiido date NOT NULL,
  szuletesihely text NOT NULL,
  irsz integer,
  varos text,
  cim text,
  tarsadalmimunka integer,
  eltiltas date,
  tage integer NOT NULL,
  CONSTRAINT horgasz_pk PRIMARY KEY (id),
  CONSTRAINT c_tag CHECK (tage = 0 OR tage = 1)
);



CREATE TABLE anglerregistry.horgaszto
(
  id bigint NOT NULL DEFAULT nextval('anglerregistry.horgaszto_id_seq'::regclass),
  vizterkod text NOT NULL,
  terulet integer NOT NULL,
  to_tipusa text,
  legnagyobbvizmelyseg integer,
  tulajdonos text NOT NULL,
  horgasztanya integer NOT NULL,
  CONSTRAINT horgaszto_pkey PRIMARY KEY (id),
  CONSTRAINT c_terulet CHECK (terulet >= 0),
  CONSTRAINT c_vizmelyseg CHECK (legnagyobbvizmelyseg > 0),
  CONSTRAINT tanya CHECK (horgasztanya = 0 OR horgasztanya = 1)
);



CREATE TABLE anglerregistry.engedely
(
  id bigint NOT NULL DEFAULT nextval('anglerregistry.engedely_id_seq'::regclass),
  horgaszid bigint NOT NULL,
  allamijegyid text NOT NULL,
  engedely_tipusa text NOT NULL,
  CONSTRAINT engedely_pkey PRIMARY KEY (id),
  CONSTRAINT engedely_fkey_horgasz FOREIGN KEY (horgaszid) 
	  REFERENCES anglerregistry.horgasz (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE
);



CREATE TABLE anglerregistry.telepites
(
  id bigint NOT NULL DEFAULT nextval('anglerregistry.telepites_id_seq'::regclass),
  toid bigint NOT NULL,
  halid bigint NOT NULL,
  datum date NOT NULL,
  kor integer NOT NULL,
  mennyiseg integer NOT NULL,
  tilalminapokszama integer,
  CONSTRAINT telepites_pkey PRIMARY KEY (id),
  CONSTRAINT c_telepites_hal_fk FOREIGN KEY (halid)
      REFERENCES anglerregistry.hal (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE,
  CONSTRAINT c_telepites_to_fk FOREIGN KEY (toid)
      REFERENCES anglerregistry.horgaszto (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE,
  CONSTRAINT c_telepites_kor CHECK (kor >= 0),
  CONSTRAINT c_telepites_mennyiseg CHECK (mennyiseg >= 0),
  CONSTRAINT c_telepites_tilalminapok CHECK (tilalminapokszama >= 0)
);



CREATE TABLE anglerregistry.fogasinaplo
(
  id bigint NOT NULL DEFAULT nextval('anglerregistry.fogasinaplo_id_seq'::regclass),
  engedelyid bigint NOT NULL,
  toid bigint NOT NULL,
  idopont timestamp with time zone NOT NULL,
  halid bigint NOT NULL,
  mennyiseg integer NOT NULL,
  CONSTRAINT c_fogasi_pk PRIMARY KEY (id),
  CONSTRAINT c_fogasi_engedely_fk FOREIGN KEY (engedelyid)
      REFERENCES anglerregistry.engedely (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE,
  CONSTRAINT c_fogasi_hal_fk FOREIGN KEY (halid)
      REFERENCES anglerregistry.hal (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE,
  CONSTRAINT c_fogasi_to_fk FOREIGN KEY (toid)
      REFERENCES anglerregistry.horgaszto (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE,
  CONSTRAINT c_fogasi_mennyiseg CHECK (mennyiseg >= 0)
);
