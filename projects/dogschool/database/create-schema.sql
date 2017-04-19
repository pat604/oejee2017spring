
create table instr_level {
	instr_level_id serial not null,
	instr_level_name character varying(100) not null,
	
	constraint pk_instr_level_id primary key (instr_level_id)
};

alter table instr_level OWNER to postgres;


create table course_type {
	course_type_id serial not null,
	course_type_name character varying(100) not null,
	
	constraint pk_course_type_id primary key (course_type_id)
};

alter table course_type OWNER to postgres;


create table dog_size {
	dog_size_id serial not null,
	dog_size_name character varying(100) not null, 
	
	constraint pk_dog_size_id primary key (dog_size_id)
};

alter table dog_size OWNER to postgres;


create table dogschool (
	dogschool_id serial not null,
	dogschool_name character varying(100) not null,
	dogschool_opened_in character varying(4) not null,
	dogschool_location character varying(100) not null,
	dogschool_leader_id integer,
	
	constraint pk_dogschool_id primary key (dogschool_id)
);

alter table dogschool OWNER to postgres;


create table instructor (
	instructor_id serial not null,
	instructor_name character varying(100) not null,
	instructor_birth_year character varying(4) not null,
	instructor_zip_code character varying(4),
	instructor_telephone character varying(12) not null,
	instructor_level_id integer not null,
	instructor_school_id_primary integer, 
	instructor_school_id_secondary integer,
	
	constraint pk_instructor_id primary key (instructor_id),
	
	constraint fk_instructor_school_id_primary foreign key (instructor_school_id_primary)
	references dogschool (dogschool_id) match simple ON UPDATE RESTRICT ON DELETE RESTRICT,
	
	constraint fk_instructor_school_id_secondary foreign key (instructor_school_id_secondary)
	references dogschool (dogschool_id) match simple ON UPDATE RESTRICT ON DELETE RESTRICT,
	
	constraint fk_instr_level_id foreign key (instructor_level_id)
	references instr_level (instr_level_id) match simple ON UPDATE RESTRICT ON DELETE RESTRICT
);

alter table instructor OWNER to postgres;


alter table dogschool
	add constraint fk_dogschool_leader_id foreign key (dogschool_leader_id)
	references instructor (instructor_id) match simple ON UPDATE RESTRICT ON DELETE RESTRICT;
	

create table course {
	course_id serial not null,
	course_school_id integer not null,
	course_course_type_id integer not null,
	course_dog_size_id integer not null, 
	course_group_leader_id integer not null,
	course_assistant_primary_id integer not null, 
	course_assistant_secondary_id integer,
	course_start date not null,
	
	constraint pk_course_id primary key (course_id),
	
	constraint fk_course_school_id foreign key (course_school_id)
	references dogschool (dogschool_id) match simple ON UPDATE RESTRICT ON DELETE RESTRICT,
	
	constraint fk_course_course_type_id foreign key (course_course_type_id)
	references course_type (course_type_id) match simple ON UPDATE RESTRICT ON DELETE RESTRICT,
	
	constraint fk_course_dog_size_id foreign key (course_dog_size_id)
	references dog_size (dog_size_id) match simple ON UPDATE RESTRICT ON DELETE RESTRICT,
	
	constraint fk_course_group_leader_id foreign key (course_group_leader_id)
	references instructor (instructor_id) match simple ON UPDATE RESTRICT ON DELETE RESTRICT,
	
	constraint fk_course_assistant_primary_id foreign key (course_assistant_primary_id)
	references instructor (instructor_id) match simple ON UPDATE RESTRICT ON DELETE RESTRICT,
	
	constraint fk_course_assistant_secondary_id foreign key (course_assistant_secondary_id)
	references instructor (instructor_id) match simple ON UPDATE RESTRICT ON DELETE RESTRICT

};

alter table course OWNER to postgres;