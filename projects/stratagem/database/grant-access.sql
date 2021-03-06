GRANT SELECT, INSERT, UPDATE, DELETE ON 
app_users, roles, authorizations, teams, team_members TO stratagem_std_user;
GRANT USAGE, SELECT, UPDATE ON 
app_users_user_id_seq, roles_role_id_seq, authorizations_authorization_id_seq, teams_team_id_seq TO stratagem_std_user;

GRANT SELECT, INSERT, UPDATE, DELETE ON 
objectives, projects, tasks, task_dependencies, 
objective_projects, objective_tasks, project_tasks TO stratagem_std_user;
GRANT USAGE, SELECT, UPDATE ON 
objectives_objective_id_seq, projects_project_id_seq, tasks_task_id_seq TO stratagem_std_user;

GRANT SELECT, INSERT, UPDATE, DELETE ON 
impediments, remedies, project_impediments, task_impediments TO stratagem_std_user;
GRANT USAGE, SELECT, UPDATE ON 
impediments_impediment_id_seq, remedies_remedy_id_seq TO stratagem_std_user;

GRANT SELECT, INSERT, UPDATE, DELETE ON 
team_objective_assignments, team_project_assignments, team_task_assignments, 
user_objective_assignments, user_project_assignments, user_task_assignments TO stratagem_std_user;
