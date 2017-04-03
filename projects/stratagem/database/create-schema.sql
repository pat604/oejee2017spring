CREATE TABLE priorities (
	priority_id SERIAL NOT NULL,
	priority_name CHARACTER VARYING(100) NOT NULL,
	CONSTRAINT PK_PRIORITY_ID PRIMARY KEY (priority_id) 
);

-- ###########################################################################################

CREATE TABLE roles (
	role_id SERIAL NOT NULL,
	role_name CHARACTER VARYING(100) NOT NULL,
	CONSTRAINT PK_ROLE_ID PRIMARY KEY (role_id) 
);
CREATE TABLE app_users (
	user_id SERIAL NOT NULL,
	user_name CHARACTER VARYING(100) NOT NULL,
	user_password CHARACTER VARYING(100) NOT NULL,
	user_email CHARACTER VARYING(100) NULL,
	CONSTRAINT PK_USER_ID PRIMARY KEY (user_id) 
);
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
CREATE TABLE teams (
	team_id SERIAL NOT NULL,
	team_name CHARACTER VARYING(100) NOT NULL,
	CONSTRAINT PK_TEAM_ID PRIMARY KEY (team_id)
);
CREATE TABLE team_members (
	team_member_id SERIAL NOT NULL,
	team_member_team_id INTEGER NOT NULL,
	team_member_user_id INTEGER NOT NULL,
	CONSTRAINT PK_TEAM_MEMBER_ID PRIMARY KEY (team_member_id),
	CONSTRAINT FK_TEAM_MEMBER_TEAM_ID FOREIGN KEY (team_member_user_id)
	  REFERENCES app_users (user_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT FK_TEAM_MEMBER_USER_ID FOREIGN KEY (team_member_team_id)
	  REFERENCES teams (team_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);

-- ###########################################################################################

CREATE TABLE objective_statuses (
	status_id SERIAL NOT NULL,
	status_name CHARACTER VARYING(100) NOT NULL,
	CONSTRAINT PK_OBJECTIVE_STATUS_ID PRIMARY KEY (status_id)
);
CREATE TABLE objectives (
	objective_id SERIAL NOT NULL,
	objective_name CHARACTER VARYING(100) NOT NULL,
	objective_description CHARACTER VARYING(1000) NULL,
	objective_priority INTEGER NOT NULL,
	objective_status_id INTEGER NOT NULL,
	CONSTRAINT PK_OBJECTIVE_ID PRIMARY KEY (objective_id),
	CONSTRAINT FK_OBJECTIVE_STATUS_ID FOREIGN KEY (objective_status_id)
	  REFERENCES objective_statuses (status_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
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
CREATE TABLE objective_appointments (
	appointment_id SERIAL NOT NULL,
	appointment_user_id INTEGER NOT NULL,
	appointment_objective_id INTEGER NOT NULL,
	CONSTRAINT PK_OBJECTIVE_APPOINTMENT_ID PRIMARY KEY (appointment_id),
	CONSTRAINT FK_OBJECTIVE_APPOINTMENT_OBJECTIVE_ID FOREIGN KEY (appointment_objective_id)
	  REFERENCES objectives (objective_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT FK_OBJECTIVE_APPOINTMENT_USER_ID FOREIGN KEY (appointment_user_id)
	  REFERENCES app_users (user_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);

-- ###########################################################################################

CREATE TABLE project_statuses (
	status_id INTEGER NOT NULL,
	status_name CHARACTER VARYING(100) NOT NULL,
	CONSTRAINT PK_PROJECT_STATUS_ID PRIMARY KEY (status_id)
);
CREATE TABLE projects (
	project_id SERIAL NOT NULL,
	project_name CHARACTER VARYING(100) NOT NULL,
	project_description CHARACTER VARYING(1000) NULL,
	project_visibility BOOLEAN NOT NULL,
	CONSTRAINT PK_PROJECT_ID PRIMARY KEY (project_id)
);
CREATE TABLE project_managers (
	project_manager_id SERIAL NOT NULL,
	project_manager_project_id INTEGER NOT NULL,
	project_manager_user_id INTEGER NOT NULL,
	project_manager_owner BOOLEAN NOT NULL,
	CONSTRAINT PK_PROJECT_MANAGER_ID PRIMARY KEY (project_manager_id),
	CONSTRAINT FK_PROJECT_MANAGER_PROJECT FOREIGN KEY (project_manager_project_id)
	  REFERENCES projects (project_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT FK_PROJECT_MANAGER_USER FOREIGN KEY (project_manager_user_id)
	  REFERENCES app_users (user_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
CREATE TABLE project_status_alterations (
	alteration_id SERIAL NOT NULL,
	alteration_project_id INTEGER NOT NULL,
	alteration_status_id INTEGER NOT NULL,
	alteration_user_id INTEGER NOT NULL,
	alteration_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
	CONSTRAINT PK_PROJECT_ALTERATION_ID PRIMARY KEY (alteration_id),
	CONSTRAINT FK_PROJECT_ALTERATION_STATUS_ID FOREIGN KEY (alteration_status_id)
	  REFERENCES project_statuses (status_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT FK_PROJECT_ALTERATION_PROJECT_ID FOREIGN KEY (alteration_project_id)
	  REFERENCES projects (project_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT FK_PROJECT_ALTERATION_USER_ID FOREIGN KEY (alteration_user_id)
	  REFERENCES app_users (user_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);

-- ###########################################################################################

CREATE TABLE tasks (
	task_id SERIAL NOT NULL,
	task_name CHARACTER VARYING(100) NOT NULL,
	task_description CHARACTER VARYING(1000) NULL,
	task_completion_percentage INTEGER NOT NULL,
	CONSTRAINT PK_TASK_ID PRIMARY KEY (task_id)
);
CREATE TABLE project_tasks (
	project_task_id SERIAL NOT NULL,
	project_task_project_id INTEGER NOT NULL,
	project_task_task_id INTEGER NOT NULL,
	CONSTRAINT PK_PROJECT_TASK_ID PRIMARY KEY (project_task_id),
	CONSTRAINT FK_PROJECT_TASK_PROJECT FOREIGN KEY (project_task_project_id)
	  REFERENCES projects (project_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT FK_PROJECT_TASK_TASK FOREIGN KEY (project_task_task_id)
	  REFERENCES tasks (task_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
CREATE TABLE objective_tasks (
	objective_task_id SERIAL NOT NULL,
	objective_task_objective_id INTEGER NOT NULL,
	objective_task_task_id INTEGER NOT NULL,
	CONSTRAINT PK_OBJECTIVE_TASK_ID PRIMARY KEY (objective_task_id),
	CONSTRAINT FK_PROJECT_TASK_PROJECT FOREIGN KEY (objective_task_objective_id)
	  REFERENCES objectives (objective_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT FK_PROJECT_TASK_TASK FOREIGN KEY (objective_task_task_id)
	  REFERENCES tasks (task_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);

-- ###########################################################################################

CREATE TABLE impediment_statuses (
	status_id SERIAL NOT NULL,
	status_name CHARACTER VARYING(100),
	CONSTRAINT PK_IMPEDIMENT_STATUS_ID PRIMARY KEY (status_id)
);
CREATE TABLE impediments (
	impediment_id SERIAL NOT NULL,
	impediment_name CHARACTER VARYING(100) NOT NULL,
	impediment_description CHARACTER VARYING(2000) NULL,
	impediment_priority_id INTEGER NOT NULL,
	impediment_status_id INTEGER NOT NULL,
	impediment_report_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
	impediment_reporter INTEGER NOT NULL,
	impediment_processor INTEGER NULL,
	CONSTRAINT PK_IMPEDIMENT_ID PRIMARY KEY (impediment_id),
	CONSTRAINT FK_IMPEDIMENT_PRIORITY_ID FOREIGN KEY (impediment_priority_id)
	  REFERENCES priorities (priority_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT FK_IMPEDIMENT_REPORTER FOREIGN KEY (impediment_reporter)
	  REFERENCES app_users (user_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT FK_IMPEDIMENT_PROCESSOR FOREIGN KEY (impediment_processor)
	  REFERENCES app_users (user_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
CREATE TABLE project_impediments (
	project_impediment_id SERIAL NOT NULL,
	project_impediment_project_id INTEGER NOT NULL,
	project_impediment_impediment_id INTEGER NOT NULL,
	CONSTRAINT PK_PROJECT_IMPEDIMENT_ID PRIMARY KEY (project_impediment_id),
	CONSTRAINT FK_PROJECT_IMPEDIMENT_PROJECT_ID FOREIGN KEY (project_impediment_project_id)
	  REFERENCES projects (project_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT FK_PROJECT_IMPEDIMENT_IMPEDIMENT_ID FOREIGN KEY (project_impediment_impediment_id)
	  REFERENCES impediments (impediment_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
CREATE TABLE task_impediments (
	task_impediment_id SERIAL NOT NULL,
	task_impediment_task_id INTEGER NOT NULL,
	task_impediment_impediment_id INTEGER NOT NULL,
	CONSTRAINT PK_TASK_IMPEDIMENT_ID PRIMARY KEY (task_impediment_id),
	CONSTRAINT FK_TASK_IMPEDIMENT_TASK_ID FOREIGN KEY (task_impediment_task_id)
	  REFERENCES tasks (task_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT FK_TASK_IMPEDIMENT_IMPEDIMENT_ID FOREIGN KEY (task_impediment_impediment_id)
	  REFERENCES impediments (impediment_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
CREATE TABLE remedies (
	remedy_id SERIAL NOT NULL,
	remedy_description CHARACTER VARYING(2000),
	remedy_impediment_id INTEGER NOT NULL,
	remedy_submission_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
	remedy_provider INTEGER NOT NULL,
	CONSTRAINT PK_REMEDY_ID PRIMARY KEY (remedy_id),
	CONSTRAINT FK_REMEDY_IMPEDIMENT FOREIGN KEY (remedy_impediment_id)
	  REFERENCES impediments (impediment_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT FK_REMEDY_PROVIDER FOREIGN KEY (remedy_provider)
	  REFERENCES app_users (user_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
	
-- ###########################################################################################
	
CREATE TABLE project_deadlines (
	deadline_id SERIAL NOT NULL,
	deadline_project_id INTEGER NOT NULL,
	deadline_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
	CONSTRAINT PK_PROJECT_DEADLINE_ID PRIMARY KEY (deadline_id),
	CONSTRAINT FK_PROJECT_DEADLINE_PROJECT_ID FOREIGN KEY (deadline_project_id)
	  REFERENCES projects (project_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
CREATE TABLE task_deadlines (
	deadline_id SERIAL NOT NULL,
	deadline_task_id INTEGER NOT NULL,
	deadline_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
	CONSTRAINT PK_TASK_DEADLINE_ID PRIMARY KEY (deadline_id),
	CONSTRAINT FK_TASK_DEADLINE_TASK_ID FOREIGN KEY (deadline_task_id)
	  REFERENCES tasks (task_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
CREATE TABLE task_dependencies (
	dependency_id SERIAL NOT NULL,
	dependency_dependent INTEGER NOT NULL,
	dependency_maintainer INTEGER NOT NULL,
	dependency_value INTEGER NULL,
	CONSTRAINT PK_TASK_DEPENDENCY_ID PRIMARY KEY (dependency_id),
	CONSTRAINT FK_TASK_DEPENDENCY_DEPENDENT FOREIGN KEY (dependency_dependent)
	  REFERENCES tasks (task_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT FK_TASK_DEPENDENCY_MAINTAINER FOREIGN KEY (dependency_maintainer)
	  REFERENCES tasks (task_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
	
-- ###########################################################################################

ALTER TABLE priorities OWNER TO postgres;
ALTER TABLE roles OWNER TO postgres;
ALTER TABLE app_users OWNER TO postgres;
ALTER TABLE authorizations OWNER TO postgres;
ALTER TABLE teams OWNER TO postgres;
ALTER TABLE team_members OWNER TO postgres;
ALTER TABLE objective_statuses OWNER TO postgres;
ALTER TABLE objectives OWNER TO postgres;
ALTER TABLE objective_status_alterations OWNER TO postgres;
ALTER TABLE objective_appointments OWNER TO postgres;
ALTER TABLE project_statuses OWNER TO postgres;
ALTER TABLE projects OWNER TO postgres;
ALTER TABLE project_status_alterations OWNER TO postgres;
ALTER TABLE tasks OWNER TO postgres;
ALTER TABLE project_tasks OWNER TO postgres;
ALTER TABLE objective_tasks OWNER TO postgres;
ALTER TABLE impediment_statuses OWNER TO postgres;
ALTER TABLE impediments OWNER TO postgres;
ALTER TABLE project_impediments OWNER TO postgres;
ALTER TABLE task_impediments OWNER TO postgres;
ALTER TABLE remedies OWNER TO postgres;
ALTER TABLE project_managers OWNER TO postgres;
ALTER TABLE project_deadlines OWNER TO postgres;
ALTER TABLE task_deadlines OWNER TO postgres;
ALTER TABLE task_dependencies OWNER TO postgres;