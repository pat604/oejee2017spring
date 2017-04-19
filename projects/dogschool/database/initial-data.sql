insert into instr_level (instr_level_name) values ('school_leader');
insert into instr_level (instr_level_name) values ('therapy');
insert into instr_level (instr_level_name) values ('medium');
insert into instr_level (instr_level_name) values ('basic');
insert into instr_level (instr_level_name) values ('assistant');

insert into course_type (course_type_name) values ('basic');
insert into course_type (course_type_name) values ('medium');
insert into course_type (course_type_name) values ('therapy');

insert into dog_size (dog_size_name) values ('mini');
insert into dog_size (dog_size_name) values ('midi');
insert into dog_size (dog_size_name) values ('maxi');

insert into dogschool (dogschool_name, dogschool_opened_in, dogschool_location) values ('Nepszigeti Kutyasuli', '1990', 'Bp. IV. Zsilip utca 2/c.');
insert into dogschool (dogschool_name, dogschool_opened_in, dogschool_location) values ('Ormezoi Kutyasuli', '2009', 'Bp. XI. Popradi ut - Balatoni ut sarok');
insert into dogschool (dogschool_name, dogschool_opened_in, dogschool_location) values ('Normafa Kutyasuli', '2013', 'Bp. XII. Konkoly Thege Miklos ut 27.');

insert into instructor (instructor_name, instructor_birth_year, instructor_zip_code, instructor_telephone, instructor_level, instructor_school_id_primary, instructor_school_id_secondary) values ('Korom Gabor', '1974', '1111', '703544362', 1, 2, 3);
insert into instructor (instructor_name, instructor_birth_year, instructor_zip_code, instructor_telephone, instructor_level, instructor_school_id_primary, instructor_school_id_secondary) values ('Kiss Agnes', '1980', '1044', '703511362', 1, 2, 1);
insert into instructor (instructor_name, instructor_birth_year, instructor_zip_code, instructor_telephone, instructor_level, instructor_school_id_primary, instructor_school_id_secondary) values ('Toth Istvan', '1982', '1034', '203511377', 1, 3, 2);
insert into instructor (instructor_name, instructor_birth_year, instructor_zip_code, instructor_telephone, instructor_level, instructor_school_id_primary) values ('Nagy Nori', '1984', '1222', '703544345', 2, 3);
insert into instructor (instructor_name, instructor_birth_year, instructor_zip_code, instructor_telephone, instructor_level, instructor_school_id_primary, instructor_school_id_secondary) values ('Kresak Miklos', '1992', '1221', '303544362', 3, 1, 3);
insert into instructor (instructor_name, instructor_birth_year, instructor_zip_code, instructor_telephone, instructor_level, instructor_school_id_primary) values ('Arvay Anita', '1998', '1052', '301111362', 3, 2);
insert into instructor (instructor_name, instructor_birth_year, instructor_telephone, instructor_level, instructor_school_id_primary, instructor_school_id_secondary) values ('Kiss Tibor', '1989', '202221362', 4, 2, 1);
insert into instructor (instructor_name, instructor_birth_year, instructor_zip_code, instructor_telephone, instructor_level, instructor_school_id_primary, instructor_school_id_secondary) values ('Nagy Malna', '1990', '1131', '202226362', 4, 1, 2);
insert into instructor (instructor_name, instructor_birth_year, instructor_telephone, instructor_level, instructor_school_id_primary) values ('Kiss Tibor', '1989', '202221962', 4, 2);
insert into instructor (instructor_name, instructor_birth_year, instructor_telephone, instructor_level, instructor_school_id_primary, instructor_school_id_secondary) values ('Kiss Marta', '1999', '202221911', 5, 3, 1);
insert into instructor (instructor_name, instructor_birth_year, instructor_telephone, instructor_level, instructor_school_id_primary) values ('Kovacs Eniko', '1960', '703221962', 5, 3);
insert into instructor (instructor_name, instructor_birth_year, instructor_telephone, instructor_level, instructor_school_id_primary) values ('Eszenyi Jozsef', '1972', '306621962', 5, 1);
insert into instructor (instructor_name, instructor_birth_year, instructor_telephone, instructor_level, instructor_school_id_primary, instructor_school_id_secondary) values ('Rozsa Imre', '1989', '307771962', 5, 2, 1);

update dogschool set dogschool_leader_id = 1 
	where dogschool_id = 1;
update dogschool set dogschool_leader_id = 2
	where dogschool_id = 2;	
update dogschool set dogschool_leader_id = 3
	where dogschool_id = 3;	
	
insert into course (course_school_id, course_course_type_id, course_dog_size_id, course_group_leader_id, course_assistant_primary_id, course_assistant_secondary_id, course_start) values (1, 1, 1, 7, 10, 12, date '2016-11-28');

