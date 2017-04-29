INSERT INTO guitarbrand (guitarbrand_id, guitarbrand_name) VALUES (0, 'CORT');
INSERT INTO guitarbrand (guitarbrand_id, guitarbrand_name) VALUES (1, 'EPIPHONE');
INSERT INTO guitarbrand (guitarbrand_id, guitarbrand_name) VALUES (2, 'FENDER');
INSERT INTO guitarbrand (guitarbrand_id, guitarbrand_name) VALUES (3, 'GIBSON');
INSERT INTO guitarbrand (guitarbrand_id, guitarbrand_name) VALUES (4, 'GREG_BENNETT');
INSERT INTO guitarbrand (guitarbrand_id, guitarbrand_name) VALUES (5, 'IBANEZ');
INSERT INTO guitarbrand (guitarbrand_id, guitarbrand_name) VALUES (6, 'KRAMER');
INSERT INTO guitarbrand (guitarbrand_id, guitarbrand_name) VALUES (7, 'MUSIC_MAN');
INSERT INTO guitarbrand (guitarbrand_id, guitarbrand_name) VALUES (8, 'OVATION');
INSERT INTO guitarbrand (guitarbrand_id, guitarbrand_name) VALUES (9, 'SCHECTER');

INSERT INTO guitarowner (guitarowner_id, guitarowner_username, guitarowner_email, guitarowner_password) 
	VALUES (0, 'mitro.tamas', 'blacktom73@gmail.com', 'tamas');
INSERT INTO guitarowner (guitarowner_id, guitarowner_username, guitarowner_email, guitarowner_password) 
	VALUES (1, 'kovacs.lajos', 'kovacs.lajos@gmail.com', 'lajos');
INSERT INTO guitarowner (guitarowner_id, guitarowner_username, guitarowner_email, guitarowner_password) 
	VALUES (2, 'fekete.peter', 'fekete.peter@gmail.com', 'peter');

INSERT INTO guitar (guitar_guitarbrand_id, guitar_serialnumber, guitar_type, guitar_color, guitar_vintage, guitar_price, guitar_guitarowner_id) 
	VALUES (3, 'G0001', 'Les Paul Standard', 'Ebony', 1990, 500000, 0);
INSERT INTO guitar (guitar_guitarbrand_id, guitar_serialnumber, guitar_type, guitar_color, guitar_vintage, guitar_price, guitar_guitarowner_id) 
	VALUES (6, 'G0002', 'Striker 300HST', 'Metallic Red', 1989, 150000, 0);
INSERT INTO guitar (guitar_guitarbrand_id, guitar_serialnumber, guitar_type, guitar_color, guitar_vintage, guitar_price, guitar_guitarowner_id) 
	VALUES (4, 'G0003', 'AV7 Les Paul', 'Wine Red', 2009, 70000, 0);
INSERT INTO guitar (guitar_guitarbrand_id, guitar_serialnumber, guitar_type, guitar_color, guitar_vintage, guitar_price, guitar_guitarowner_id) 
	VALUES (2, 'G0004', 'American Standard Stratocaster', 'Sunburst', 1973, 350000, 2);