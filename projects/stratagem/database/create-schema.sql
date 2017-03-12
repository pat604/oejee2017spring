CREATE TABLE project_statuses (
	status_id INTEGER NOT NULL,
	status_name CHARACTER VARYING(100) NOT NULL,
	CONSTRAINT PK_STATUS_ID PRIMARY KEY (status_id)
);

ALTER TABLE project_statuses OWNER TO postgres;

CREATE TABLE projects (
	project_id INTEGER NOT NULL,
	project_name CHARACTER VARYING(100) NOT NULL,
	project_status_id INTEGER NOT NULL,
	CONSTRAINT PK_PROJECT_ID PRIMARY KEY (project_id),
	CONSTRAINT FK_PROJECT_STATUS_ID FOREIGN KEY (project_status_id)
	  REFERENCES project_statuses (status_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);

ALTER TABLE projects OWNER TO postgres;

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

CREATE UNIQUE INDEX UI_TASK_COMPLETION ON tasks USING btree (task_completion_percentage);