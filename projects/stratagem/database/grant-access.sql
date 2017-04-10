GRANT SELECT, INSERT, UPDATE, DELETE ON app_users, roles, authorizations TO stratagem_std_user;
GRANT USAGE, SELECT, UPDATE ON app_users_user_id_seq, roles_role_id_seq, authorizations_authorization_id_seq TO stratagem_std_user;

GRANT SELECT, INSERT, UPDATE, DELETE ON objectives, projects, tasks, objective_projects, project_tasks TO stratagem_std_user;
GRANT USAGE, SELECT, UPDATE ON objectives_objective_id_seq, projects_project_id_seq, tasks_task_id_seq TO stratagem_std_user;

GRANT SELECT, INSERT, UPDATE, DELETE ON user_project_assignments TO stratagem_std_user;

GRANT SELECT, INSERT, UPDATE, DELETE ON impediments, remedies TO stratagem_std_user;
GRANT USAGE, SELECT, UPDATE ON impediments_impediment_id_seq, remedies_remedy_id_seq TO stratagem_std_user;