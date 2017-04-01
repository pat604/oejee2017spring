CREATE TABLE roles (
	role_id SERIAL NOT NULL,
	role_name CHARACTER VARYING(100) NOT NULL,
	CONSTRAINT PK_ROLE_ID PRIMARY KEY (role_id) 
);
ALTER TABLE roles OWNER TO postgres;

CREATE TABLE app_users (
	user_id SERIAL NOT NULL,
	user_name CHARACTER VARYING(100) NOT NULL,
	user_password CHARACTER VARYING(100) NOT NULL,
	user_email CHARACTER VARYING(100) NULL,
	CONSTRAINT PK_USER_ID PRIMARY KEY (user_id) 
);
ALTER TABLE app_users OWNER TO postgres;
CREATE UNIQUE INDEX UI_USER_NAME ON app_users USING btree (user_name);

CREATE TABLE authorizations (
	authorization_id SERIAL NOT NULL,
	authorization_user_id INTEGER NOT NULL,
	authorization_role_id INTEGER NOT NULL,
	CONSTRAINT PK_AUTHORIZATION_ID PRIMARY KEY (authorization_id),
	CONSTRAINT FK_AUTHORIZATION_USER FOREIGN KEY (authorization_user_id)
	  REFERENCES app_users (user_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT FK_AUTHORIZATION_ROLE FOREIGN KEY (authorization_role_id)
	  REFERENCES roles (role_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
ALTER TABLE authorizations OWNER TO postgres;

-- ###########################################################################################

CREATE TABLE objective_statuses (
	status_id SERIAL NOT NULL,
	status_name CHARACTER VARYING(100) NOT NULL,
	CONSTRAINT PK_OBJECTIVE_STATUS_ID PRIMARY KEY (status_id)
);
ALTER TABLE objective_statuses OWNER TO postgres;

CREATE TABLE objectives (
	objective_id SERIAL NOT NULL,
	objective_name CHARACTER VARYING(100) NOT NULL,
	objective_description CHARACTER VARYING(500) NULL,
	objective_priority INTEGER NOT NULL,
	objective_status_id INTEGER NOT NULL,
	CONSTRAINT PK_OBJECTIVE_ID PRIMARY KEY (objective_id),
	CONSTRAINT FK_OBJECTIVE_STATUS_ID FOREIGN KEY (objective_status_id)
	  REFERENCES objective_statuses (status_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
ALTER TABLE objectives OWNER TO postgres;

CREATE TABLE objective_status_alterations (
	alteration_id SERIAL NOT NULL,
	alteration_objective_id INTEGER NOT NULL,
	alteration_status_id INTEGER NOT NULL,
	alteration_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
	CONSTRAINT PK_OBJECTIVE_ALTERATION_ID PRIMARY KEY (alteration_id),
	CONSTRAINT FK_OBJECTIVE_ALTERATION_STATUS_ID FOREIGN KEY (alteration_status_id)
	  REFERENCES objective_statuses (status_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT FK_OBJECTIVE_ALTERATION_OBJECTIVE_ID FOREIGN KEY (alteration_objective_id)
	  REFERENCES objectives (objective_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
ALTER TABLE objective_status_alterations OWNER TO postgres;

-- ###########################################################################################

CREATE TABLE project_statuses (
	status_id INTEGER NOT NULL,
	status_name CHARACTER VARYING(100) NOT NULL,
	CONSTRAINT PK_PROJECT_STATUS_ID PRIMARY KEY (status_id)
);
ALTER TABLE project_statuses OWNER TO postgres;

CREATE TABLE projects (
	project_id SERIAL NOT NULL,
	project_name CHARACTER VARYING(100) NOT NULL,
	project_status_id INTEGER NOT NULL,
	project_description CHARACTER VARYING(500) NULL,
	project_visibility BOOLEAN NOT NULL,
	CONSTRAINT PK_PROJECT_ID PRIMARY KEY (project_id),
	CONSTRAINT FK_PROJECT_STATUS_ID FOREIGN KEY (project_status_id)
	  REFERENCES project_statuses (status_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
ALTER TABLE projects OWNER TO postgres;

CREATE TABLE project_status_alterations (
	alteration_id SERIAL NOT NULL,
	alteration_project_id INTEGER NOT NULL,
	alteration_status_id INTEGER NOT NULL,
	alteration_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
	CONSTRAINT PK_PROJECT_ALTERATION_ID PRIMARY KEY (alteration_id),
	CONSTRAINT FK_PROJECT_ALTERATION_STATUS_ID FOREIGN KEY (alteration_status_id)
	  REFERENCES project_statuses (status_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT FK_PROJECT_ALTERATION_PROJECT_ID FOREIGN KEY (alteration_project_id)
	  REFERENCES projects (project_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
ALTER TABLE project_status_alterations OWNER TO postgres;

-- ###########################################################################################

CREATE TABLE tasks (
	task_id SERIAL NOT NULL,
	task_description CHARACTER VARYING(100) NOT NULL,
	task_project_id INTEGER NOT NULL,
	task_completion_percentage INTEGER NOT NULL,
	CONSTRAINT PK_TASK_ID PRIMARY KEY (task_id),
	CONSTRAINT FK_TASK_PROJECT FOREIGN KEY (task_project_id)
	  REFERENCES projects (project_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
ALTER TABLE tasks OWNER TO postgres;