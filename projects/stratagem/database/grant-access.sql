GRANT SELECT, INSERT, UPDATE, DELETE ON projects, tasks, project_tasks TO stratagem_std_user;
GRANT USAGE, SELECT, UPDATE ON tasks_task_id_seq, projects_project_id_seq TO stratagem_std_user;

GRANT SELECT, INSERT, UPDATE, DELETE ON app_users, roles, authorizations TO stratagem_std_user;
GRANT USAGE, SELECT, UPDATE ON app_users_user_id_seq, roles_role_id_seq, authorizations_authorization_id_seq TO stratagem_std_user;