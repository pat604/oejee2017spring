INSERT INTO priorities (priority_id, priority_name) VALUES
(0, 'LOW'),
(1, 'MEDIUM'),
(2, 'HIGH'),
(3, 'VERY_HIGH');

INSERT INTO mission_stages (stage_id, stage_name) VALUES
(0, 'OPEN'),
(1, 'ADRESSED'),
(2, 'IN_PROGRESS'),
(3, 'DISCARDED'),
(4, 'ACCOMPLISHED');

-- ###########################################################################################

INSERT INTO roles (role_id, role_name) VALUES 
(0, 'pristine_user'),
(1, 'general_user'),
(2, 'general_manager'),
(3, 'department_manager'),
(4, 'central_manager'),
(5, 'system_administrator');
SELECT SETVAL('roles_role_id_seq', COALESCE(MAX(role_id), 1) ) FROM roles;

INSERT INTO app_users (user_id, user_name, user_password) VALUES 
(0, 'adam', 'a123'),
(1, 'brent', 'b123'),
(2, 'chris', 'c123'),
(3, 'dennis', 'd123'),
(4, 'ellie', 'e123'),
(5, 'frank', 'f123'),
(6, 'gabrille', 'g123'),
(7, 'holly', 'h123'),
(8, 'ike', 'i123'),
(9, 'jenny', 'j123'),
(10, 'Kevin', 'k123');
SELECT SETVAL('app_users_user_id_seq', COALESCE(MAX(user_id), 1) ) FROM app_users;

INSERT INTO authorizations (authorization_user_id, authorization_role_id) VALUES 
(0, 1),
(0, 3),
(1, 1),
(1, 3),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(10, 2);

INSERT INTO teams (team_id, team_name, team_leader) VALUES
(0, 'Management', 0),
(1, 'DevOps', 2),
(2, 'Back-end development', 3),
(3, 'Front-end development', 8),
(4, 'Quality assurance', 3);

INSERT INTO team_members (team_member_id, team_member_team_id, team_member_user_id) VALUES
(0, 0, 0),
(1, 0, 1),
(2, 1, 2),
(3, 1, 4),
(4, 1, 5),
(5, 2, 3),
(6, 2, 6),
(7, 2, 7),
(8, 3, 8),
(9, 3, 9),
(10, 4, 3),
(11, 4, 7);

-- ###########################################################################################

INSERT INTO objective_statuses(status_id, status_name) VALUES 
(0, 'PLANNED'),
(1, 'DESIGNATED'),
(2, 'CONTINUOUS'),
(3, 'DISCONTINUED'),
(4, 'COMPLETED');

INSERT INTO objectives (objective_id, objective_name, objective_description, objective_priority, objective_status_id) VALUES 
(0, 'Integration with augmented reality', '', 2, 1),
(1, 'Increase influence in market', 'Completing projects for our esteemed contacts', 1, 1);

INSERT INTO objective_missions (mission_id, mission_name, mission_description, mission_objective, mission_stage_id) VALUES
(0, 'Steps towards growing technologies', '', 0, 4);

INSERT INTO objective_status_alterations (alteration_id, alteration_objective_id, alteration_status_id, alteration_date) VALUES
(0, 0, 0, '2016/03/20 15:45:00'),
(1, 0, 1, '2016/06/05 11:50:00'),
(2, 1, 0, '2015/02/19 16:20:00'),
(3, 1, 2, '2015/04/27 10:30:00');

INSERT INTO objective_appointments(appointment_id, appointment_user_id, appointment_objective_id) VALUES
(0, 0, 1);

-- ###########################################################################################

INSERT INTO project_statuses (status_id, status_name) VALUES 
(0, 'PROPOSED'),
(1, 'PENDING'),
(2, 'INITIATED'),
(3, 'UNDER_ANALYSIS'),
(4, 'IN_DESIGN'),
(5, 'IN_DEVELOPMENT'),
(6, 'CANCELED'),
(7, 'TESTING'),
(8, 'IN_CORRECTION'),
(9, 'VALIDATING'),
(10, 'DEPLOYING'),
(11, 'IMPLEMENTING'),
(12, 'INTEGRATING'),
(13, 'LIVE'),
(14, 'MAINTAINED_BY_OPERATIONS'),
(15, 'UPGRADING'),
(16, 'DISPOSED');

INSERT INTO projects (project_id, project_name, project_description, project_visibility) VALUES 
(0, 'Ceraphis data deployment', 'Deployment of Ceraphis Solutions buisness data to data warehouse in India', TRUE),
(1, 'QuickExtract app', 'Develop mobile app for QuickExtract', TRUE),
(2, 'Grove BI outsourcing', '', TRUE),
(3, 'Codename -NOVA-', 'Augmented reality utility tool for enterprise management', FALSE);

INSERT INTO project_missions (mission_id, mission_name, mission_description, mission_project, mission_stage_id) VALUES
(0, 'Employee data visualization requests', '', 3, 2);

INSERT INTO project_managers (project_manager_id, project_manager_project_id, project_manager_user_id, project_manager_owner) VALUES
(0, 0, 0, TRUE),
(1, 1, 1, FALSE),
(2, 2, 2, FALSE),
(3, 2, 3, FALSE),
(4, 3, 0, FALSE),
(5, 3, 10, TRUE),
(6, 1, 0, TRUE);

INSERT INTO project_status_alterations (alteration_id, alteration_project_id, alteration_status_id, alteration_user_id, alteration_date) VALUES 
(0, 0, 1, 2, '2015/06/03 10:15:00'),
(1, 0, 3, 4, '2015/06/09 16:30:00'),
(2, 0, 4, 2, '2015/06/12 10:15:00'),
(3, 0, 5, 0, '2015/06/19 17:15:00'),
(4, 0, 7, 1, '2015/06/25 11:15:00'),
(5, 0, 9, 1, '2015/07/02 09:15:00'),
(6, 0, 10, 3, '2015/07/15 10:15:00'),
(7, 1, 5, 5, '2015/08/07 17:15:00'),
(8, 1, 7, 1, '2016/10/23 15:15:00'),
(9, 2, 0, 4, '2016/11/26 10:15:00'),
(10, 3, 2, 2, '2016/09/18 09:15:00'),
(11, 3, 4, 1, '2016/10/01 15:15:00'),
(12, 3, 6, 0, '2016/10/22 10:15:00'),
(13, 3, 5, 3, '2016/12/12 09:15:00');

INSERT INTO objective_projects (objective_project_id, objective_project_objective, objective_project_project) VALUES
(0, 0, 3),
(1, 1, 0),
(2, 1, 1),
(3, 1, 2);

-- ###########################################################################################

INSERT INTO tasks (task_id, task_name, task_description, task_completion_percentage) VALUES 
(0, 'Use-case test tool', 'Creating tool for efficient use-case testing', 30),
(1, 'Print matching', 'Matching watermark prints', 85),
(2, 'Extraction planning', 'Planning extraction approach', 60),
(3, 'Backup system allocation', 'Allocating backup systems for overload evasion', 100),
(4, 'Incident wrap up', 'Closing all end-to-end test incidents', 0),
(5, 'Stable build', 'Create maintainable build on CI server for ease of rollback', 100);

INSERT INTO project_tasks (project_task_id, project_task_project_id, project_task_task_id) VALUES
(0, 1, 0),
(1, 0, 1),
(2, 2, 2),
(3, 1, 4);

INSERT INTO objective_tasks (objective_task_id, objective_task_objective_id, objective_task_task_id) VALUES
(0, 1, 3);

-- ###########################################################################################

INSERT INTO impediment_statuses (status_id, status_name) VALUES
(0, 'OPEN'),
(1, 'ADRESSED'),
(2, 'BEING_PROCESSED'),
(3, 'SOLUTION_PROVIDED'),
(4, 'DUPLICATE'),
(5, 'DISMISSED'),
(6, 'CONFIRMED');

INSERT INTO impediments (impediment_id, impediment_name, impediment_description, impediment_priority_id, impediment_status_id, impediment_report_date, impediment_reporter, impediment_processor) VALUES
(0, 'Insufficient tools', 'ARPA SDK would serve as a huge advantage with development', 2, 1, '2016/10/25 14:45:00', 3, 5),
(1, 'Data connection', 'Unable to establish connection with service endpoint with OData componenet', 3, 6, '2015/12/11 16:10:00', 4, 1),
(2, 'Lingering numpad', 'A High level incident is not recreatable with our build, and transition at this point is not possible', 0, 2, '2016/09/03 10:40:00', 9, 0);

INSERT INTO project_impediments (project_impediment_id, project_impediment_project_id, project_impediment_impediment_id) VALUES
(0, 3, 0),
(1, 1, 1);

INSERT INTO task_impediments (task_impediment_id, task_impediment_task_id, task_impediment_impediment_id) VALUES
(0, 4, 2);

INSERT INTO remedies (remedy_id, remedy_description, remedy_impediment_id, remedy_submission_date, remedy_provider) VALUES
(0, 'Use service control tool to generate project structure from existing endpoint meta data', 1, '2015/12/13 14:20:00', 1); 

-- ###########################################################################################

INSERT INTO project_deadlines (deadline_id, deadline_project_id, deadline_date) VALUES
(0, 0, '2015/11/30 00:00:00'),
(1, 3, '2017/05/26 00:00:00');

INSERT INTO task_deadlines (deadline_id, deadline_task_id, deadline_date) VALUES
(0, 1, '2016/08/14 00:00:00'),
(1, 3, '2016/09/10 00:00:00');

INSERT INTO task_dependencies (dependency_id, dependency_dependent, dependency_maintainer, dependency_value) VALUES
(0, 5, 4, 100);

INSERT INTO task_estimations (estimation_id, estimation_task, estimation_pessimist, estimation_realist, estimation_optimist) VALUES
(0, 4, '5 0:00:00', '4 0:00:00', '3 0:00:00');

-- ###########################################################################################

-- INSERT INTO team_objective_assignments (assignment_id, assignment_entrustor, assignment_recipient, assignment_objective) VALUES
-- INSERT INTO user_objective_assignments (assignment_id, assignment_entrustor, assignment_recipient, assignment_objective) VALUES
INSERT INTO team_project_assignments (assignment_id, assignment_entrustor, assignment_recipient, assignment_project) VALUES
(0, 0 , 2, 3);
-- INSERT INTO user_project_assignments (assignment_id, assignment_entrustor, assignment_recipient, assignment_project) VALUES
-- INSERT INTO team_task_assignments (assignment_id, assignment_entrustor, assignment_recipient, assignment_task) VALUES
-- INSERT INTO user_task_assignments (assignment_id, assignment_entrustor, assignment_recipient, assignment_task) VALUES

-- ###########################################################################################

INSERT INTO reviews (review_id, review_name, review_description, review_organizer, review_date) VALUES
(0, 'ARPA integration code review', 'Let us analyze our progress made with the new AR SDK', 0, '2016/09/15 14:00:00');

INSERT INTO review_invitations (invitation_id, invitaion_review, invitation_recipiant) VALUES
(0, 0, 0),
(1, 0, 3),
(2, 0, 6),
(3, 0, 7);