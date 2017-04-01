INSERT INTO roles (role_id, role_name) VALUES (0, 'pristine_user');
INSERT INTO roles (role_id, role_name) VALUES (1, 'general_user');
INSERT INTO roles (role_id, role_name) VALUES (2, 'test_user');
INSERT INTO roles (role_id, role_name) VALUES (3, 'general_manager');
INSERT INTO roles (role_id, role_name) VALUES (4, 'department_manager');
INSERT INTO roles (role_id, role_name) VALUES (5, 'central_manager');
INSERT INTO roles (role_id, role_name) VALUES (6, 'system_administrator');
SELECT SETVAL('roles_role_id_seq', COALESCE(MAX(role_id), 1) ) FROM roles;

INSERT INTO app_users (user_id, user_name, user_password) VALUES (0, 'adam', 'a123');
INSERT INTO app_users (user_id, user_name, user_password) VALUES (1, 'brent', 'b123');
INSERT INTO app_users (user_id, user_name, user_password) VALUES (2, 'chris', 'c123');
INSERT INTO app_users (user_id, user_name, user_password) VALUES (3, 'dennis', 'd123');
INSERT INTO app_users (user_id, user_name, user_password) VALUES (4, 'ellie', 'e123');
INSERT INTO app_users (user_id, user_name, user_password) VALUES (5, 'frank', 'f123');
INSERT INTO app_users (user_id, user_name, user_password) VALUES (6, 'gabrille', 'g123');
INSERT INTO app_users (user_id, user_name, user_password) VALUES (7, 'holly', 'h123');
INSERT INTO app_users (user_id, user_name, user_password) VALUES (8, 'ike', 'i123');
INSERT INTO app_users (user_id, user_name, user_password) VALUES (9, 'jenny', 'j123');
SELECT SETVAL('app_users_user_id_seq', COALESCE(MAX(user_id), 1) ) FROM app_users;

INSERT INTO authorizations (authorization_user_id, authorization_role_id) VALUES (0, 2);
INSERT INTO authorizations (authorization_user_id, authorization_role_id) VALUES (0, 5);
INSERT INTO authorizations (authorization_user_id, authorization_role_id) VALUES (1, 2);
INSERT INTO authorizations (authorization_user_id, authorization_role_id) VALUES (2, 2);
INSERT INTO authorizations (authorization_user_id, authorization_role_id) VALUES (3, 2);
INSERT INTO authorizations (authorization_user_id, authorization_role_id) VALUES (4, 2);
INSERT INTO authorizations (authorization_user_id, authorization_role_id) VALUES (5, 2);
INSERT INTO authorizations (authorization_user_id, authorization_role_id) VALUES (6, 2);
INSERT INTO authorizations (authorization_user_id, authorization_role_id) VALUES (7, 2);
INSERT INTO authorizations (authorization_user_id, authorization_role_id) VALUES (8, 2);
INSERT INTO authorizations (authorization_user_id, authorization_role_id) VALUES (9, 2);

INSERT INTO objective_statuses(status_id, status_name) VALUES (0, 'PLANNED');
INSERT INTO objective_statuses(status_id, status_name) VALUES (1, 'DESIGNATED');
INSERT INTO objective_statuses(status_id, status_name) VALUES (2, 'CONTINUOUS');
INSERT INTO objective_statuses(status_id, status_name) VALUES (3, 'DISCUNTINUED');
INSERT INTO objective_statuses(status_id, status_name) VALUES (4, 'COMPLETED');

INSERT INTO objectives (objective_id, objective_name, objective_description, objective_priority, objective_status_id) VALUES 
(0, 'Integration with augmented reality', '', 2, 1),
(1, 'Increase influence in market', 'Completing projects for our esteemed contacts', 1, 1);

INSERT INTO objective_status_alterations (alteration_id, alteration_objective_id, alteration_status_id, alteration_date) VALUES
(0, 0, 0, '2016/03/20 15:45:00'),
(1, 0, 1, '2016/06/05 11:50:00'),
(2, 1, 0, '2015/02/19 16:20:00'),
(3, 1, 2, '2015/04/27 10:30:00');

INSERT INTO project_statuses (status_id, status_name) VALUES (0, 'PROPOSED');
INSERT INTO project_statuses (status_id, status_name) VALUES (1, 'PENDING');
INSERT INTO project_statuses (status_id, status_name) VALUES (2, 'INITIATED');
INSERT INTO project_statuses (status_id, status_name) VALUES (3, 'UNDER_ANALYSIS');
INSERT INTO project_statuses (status_id, status_name) VALUES (4, 'IN_DESIGN');
INSERT INTO project_statuses (status_id, status_name) VALUES (5, 'IN_DEVELOPMENT');
INSERT INTO project_statuses (status_id, status_name) VALUES (6, 'CANCELED');
INSERT INTO project_statuses (status_id, status_name) VALUES (7, 'TESTING');
INSERT INTO project_statuses (status_id, status_name) VALUES (8, 'IN_CORRECTION');
INSERT INTO project_statuses (status_id, status_name) VALUES (9, 'VALIDATING');
INSERT INTO project_statuses (status_id, status_name) VALUES (10, 'DEPLOYING');
INSERT INTO project_statuses (status_id, status_name) VALUES (11, 'IMPLEMENTING');
INSERT INTO project_statuses (status_id, status_name) VALUES (12, 'INTEGRATING');
INSERT INTO project_statuses (status_id, status_name) VALUES (13, 'LIVE');
INSERT INTO project_statuses (status_id, status_name) VALUES (14, 'MAINTAINED_BY_OPERATIONS');
INSERT INTO project_statuses (status_id, status_name) VALUES (15, 'UPGRADING');
INSERT INTO project_statuses (status_id, status_name) VALUES (16, 'DISPOSED');

INSERT INTO projects (project_id, project_name, project_status_id, project_description, project_visibility) VALUES 
(0, 'Ceraphis data deployment', 10, 'Deployment of Ceraphis Solutions buisness data to data warehouse in India', TRUE),
(1, 'QuickExtract app', 7, 'Develop mobile app for QuickExtract', TRUE),
(2, 'Grove BI outsourcing', 0, '', TRUE),
(3, 'Codename -NOVA-', 5, 'Augmented reality utility tool for enterprise management', FALSE); 

INSERT INTO project_status_alterations (alteration_id, alteration_project_id, alteration_status_id, alteration_date) VALUES 
(0, 0, 1, '2015/06/03 10:15:00'),
(1, 0, 3, '2015/06/09 16:30:00'),
(2, 0, 4, '2015/06/12 10:15:00'),
(3, 0, 5, '2015/06/19 17:15:00'),
(4, 0, 7, '2015/06/25 11:15:00'),
(5, 0, 9, '2015/07/02 09:15:00'),
(6, 0, 10, '2015/07/15 10:15:00'),
(7, 1, 5, '015/08/07 17:15:00'),
(8, 1, 7, '2016/10/23 15:15:00'),
(9, 2, 0, '2016/11/26 10:15:00'),
(10, 3, 2, '2016/09/18 09:15:00'),
(11, 3, 4, '2016/10/01 15:15:00'),
(12, 3, 6, '2016/10/22 10:15:00'),
(13, 3, 5, '2016/12/12 09:15:00');

INSERT INTO tasks (task_id, task_description, task_project_id, task_completion_percentage) VALUES 
(16738267, 'Creating tool for efficient use-case testing', 1, 30),
(16098764, 'Matching watermark prints', 0, 85),
(17896372, 'Planning extraction approach', 2, 60),
(16906732, 'Allocating backup systems for overload evasion', 0, 100),
(17021230, 'Closing all end-to-end test incidents', 1, 0);