INSERT INTO guitarbrand (guitarbrand_id, guitarbrand_name) VALUES (0, 'GIBSON');
INSERT INTO guitarbrand (guitarbrand_id, guitarbrand_name) VALUES (1, 'FENDER');
INSERT INTO guitarbrand (guitarbrand_id, guitarbrand_name) VALUES (2, 'KRAMER');
INSERT INTO guitarbrand (guitarbrand_id, guitarbrand_name) VALUES (3, 'IBANEZ');
INSERT INTO guitarbrand (guitarbrand_id, guitarbrand_name) VALUES (4, 'CORT');
INSERT INTO guitarbrand (guitarbrand_id, guitarbrand_name) VALUES (5, 'GREG BENNETT');
INSERT INTO guitarbrand (guitarbrand_id, guitarbrand_name) VALUES (6, 'OVATION');
INSERT INTO guitarbrand (guitarbrand_id, guitarbrand_name) VALUES (7, 'SCHECTER');
INSERT INTO guitarbrand (guitarbrand_id, guitarbrand_name) VALUES (8, 'MUSIC MAN');
INSERT INTO guitarbrand (guitarbrand_id, guitarbrand_name) VALUES (9, 'EPIPHONE');

INSERT INTO guitarowner (guitarowner_id, guitarowner_username, guitarowner_email) VALUES (0, 'mitro.tamas', 'blacktom73@gmail.com');
INSERT INTO guitarowner (guitarowner_id, guitarowner_username, guitarowner_email) VALUES (1, 'kovacs.lajos', 'kovacs.lajos@gmail.com');
INSERT INTO guitarowner (guitarowner_id, guitarowner_username, guitarowner_email) VALUES (2, 'fekete.peter', 'fekete.peter@gmail.com');

INSERT INTO guitar (guitar_guitarbrand_id, guitar_type, guitar_color, guitar_vintage, guitar_price, guitar_guitarowner_id) VALUES (0, 'Les Paul Standard', 'Ebony', 1990, 500000, 0);
INSERT INTO guitar (guitar_guitarbrand_id, guitar_type, guitar_color, guitar_vintage, guitar_price, guitar_guitarowner_id) VALUES (2, 'Striker 300HST', 'Metallic Red', 1989, 150000, 0);
INSERT INTO guitar (guitar_guitarbrand_id, guitar_type, guitar_color, guitar_vintage, guitar_price, guitar_guitarowner_id) VALUES (5, 'AV7 Les Paul', 'Wine Red', 2009, 70000, 0);
INSERT INTO guitar (guitar_guitarbrand_id, guitar_type, guitar_color, guitar_vintage, guitar_price, guitar_guitarowner_id) VALUES (1, 'American Standard Stratocaster', 'Sunburst', 1973, 350000, 2);
