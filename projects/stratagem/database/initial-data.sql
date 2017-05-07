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
SELECT SETVAL('roles_role_id_seq', COALESCE(MAX(role_id), 0) ) FROM roles;

INSERT INTO app_users (user_id, user_name, user_password_hash, user_role) VALUES 
(0, 'adam', '$2a$10$FPiPKeyDIYEHTu1Nx7GCJOO5.A4agR15rHiham3pgzhE5yNjshBJ.', 3),
(1, 'brent', '$2a$10$cRxiTtzegqpCu6ArnTNQ2et3l2bPIHzTuCvnyd89T/93VwZTW4jim', 3),
(2, 'chris', '$2a$10$Oer1r4GqXVbtjc5auNJcTeUaCmis2gVUmO1UiDitM5GkhQdenJHmm', 1),
(3, 'dennis', '$2a$10$xjom.FGpOcDDCoa2YcrFhuvR6W/hgHEwRJu4oFJ.Do6D8eMu8gN/m', 1),
(4, 'ellie', '$2a$10$3TxZKVQuSD.s9K.P/i1uX.vIk9HG9Q2vzjL0xanTZuEBqbsXwJBpm', 1),
(5, 'frank', '$2a$10$0Z9B1Z5GiJ0DFXwVHpYCBOkannkyArcKeZX1.DHDwNX/kweZ.vOTy', 1),
(6, 'gabrille', '$2a$10$g3tlhM1JGx.rckAiFiWT.Ok5xyvz1a878l41lVZuIilRzBa/FFjfa', 1),
(7, 'holly', '$2a$10$W/nRkIKvfZ.3cCbJCxghKujWqAIzf/meL2g2DEQKv9pLpkPq9YvaC', 1),
(8, 'ike', '$2a$10$q2DRoc37d30C9i2t6gLCGO7vAA2bJw2b4cjxZyD0Df9PDCTP0LWC2', 1),
(9, 'jenny', '$2a$10$R80wTRvd1xSdlyafWnt4HeVKaF7z239JY9Gb6G5WPIUShlMyWGLwq', 1),
(10, 'Kevin', '$2a$10$a3/8TbXxSBpDBk4kX1BJ1uVWqOTRT5DWcxULlUXHeri0t.xHh48BW', 1);
SELECT SETVAL('app_users_user_id_seq', COALESCE(MAX(user_id), 0) ) FROM app_users;

INSERT INTO authorizations (authorization_user_id, authorization_role_id) VALUES 
(0, 3),
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

INSERT INTO team_members (team_member_team_id, team_member_user_id) VALUES
(0, 0),
(0, 1),
(1, 2),
(1, 4),
(1, 5),
(2, 3),
(2, 6),
(2, 7),
(3, 8),
(3, 9),
(4, 3),
(4, 7);

-- ###########################################################################################

INSERT INTO objective_statuses (status_id, status_name) VALUES 
(0, 'PLANNED'),
(1, 'DESIGNATED'),
(2, 'CONTINUOUS'),
(3, 'DISCONTINUED'),
(4, 'COMPLETED');

INSERT INTO objectives (objective_id, objective_name, objective_description, objective_priority, objective_status_id) VALUES 
(0, 'Integration with augmented reality', '', 2, 1),
(1, 'Increase influence in market', 'Completing projects for our esteemed contacts', 1, 1),
(2, 'Test 1', 'test, id:2', 5, 0),
(3, 'Test 2', 'test, id:3', 5, 0);
SELECT SETVAL('objectives_objective_id_seq', COALESCE(MAX(objective_id), 0) ) FROM objectives;

INSERT INTO objective_missions (mission_id, mission_name, mission_description, mission_objective, mission_stage_id) VALUES
(0, 'Steps towards growing technologies', '', 0, 4);

INSERT INTO objective_status_alterations (alteration_id, alteration_objective_id, alteration_status_id, alteration_date) VALUES
(0, 0, 0, '2016/03/20 15:45:00'),
(1, 0, 1, '2016/06/05 11:50:00'),
(2, 1, 0, '2015/02/19 16:20:00'),
(3, 1, 2, '2015/04/27 10:30:00');

INSERT INTO objective_appointments(appointment_user_id, appointment_objective_id) VALUES
(0, 1);

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

INSERT INTO projects (project_id, project_name, project_description, project_status_id, project_deadline, project_visibility) VALUES 
(0, 'Ceraphis data deployment', 'Deployment of Ceraphis Solutions buisness data to data warehouse in India', 10, '2015/11/30 00:00:00', TRUE),
(1, 'QuickExtract app', 'Develop mobile app for QuickExtract', 7, NULL, TRUE),
(2, 'Grove BI outsourcing', '', 0, NULL, TRUE),
(3, 'Codename -NOVA-', 'Augmented reality utility tool for enterprise management', 5, '2017/05/26 00:00:00', FALSE),
(4, 'Test 1', 'Test 1 objective project', 0, NULL, TRUE),
(5, 'Test 2', 'Test 1 objective project', 0, NULL, TRUE),
(6, 'Test 3', 'Test 2 objective project', 0, NULL, TRUE),
(7, 'Codename -ISOCHRONE-', 'Recursive inlay of project system implementation', 5, NULL, FALSE);
SELECT SETVAL('projects_project_id_seq', COALESCE(MAX(project_id), 0) ) FROM projects;

INSERT INTO project_missions (mission_id, mission_name, mission_description, mission_project, mission_stage_id) VALUES
(0, 'Employee data visualization requests', '', 3, 2);

INSERT INTO project_managers (project_manager_project_id, project_manager_user_id) VALUES
(1, 1),
(2, 2),
(2, 3),
(3, 0),
(7, 0);

INSERT INTO product_owners (product_owner_project_id, product_owner_user_id) VALUES
(0, 0),
(3, 10),
(1, 0),
(7, 0);

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

INSERT INTO objective_projects (objective_project_objective, objective_project_project) VALUES
(0, 3),
(1, 0),
(2, 4),
(2, 5),
(3, 6);

-- ###########################################################################################

INSERT INTO tasks (task_id, task_name, task_description, task_completion_percentage, task_deadline) VALUES 
(0, 'Use-case test tool', 'Creating tool for efficient use-case testing', 30, NULL),
(1, 'Print matching', 'Matching watermark prints', 85, '2016/08/14 00:00:00'),
(2, 'Extraction planning', 'Planning extraction approach', 60, NULL),
(3, 'Backup system allocation', 'Allocating backup systems for overload evasion', 100, '2016/09/10 00:00:00'),
(4, 'Incident wrap up', 'Closing all end-to-end test incidents', 0, NULL),
(5, 'Stable build', 'Create maintainable build on CI server for ease of rollback', 100, NULL),
(6, 'Tab-like modal navigation', 'Investigate possibility to navigate between login and registration forms, in a tab-like manner. This might be a possible solution to the noticed UI bug.', 0, '2017/12/01 00:00:00'),
(7, 'REST', 'Create REST API module', 0, '2017/12/01 00:00:00'),
(8, 'RMI', 'Create Remote EJB module', 0, '2017/12/01 00:00:00');

-- INSERT INTO task_alterations

INSERT INTO project_tasks (project_task_project_id, project_task_task_id) VALUES
(0, 1),
(2, 2),
(2, 0),
(2, 3),
(1, 4),
(3, 5),
(7, 6),
(7, 7),
(7, 8);

INSERT INTO objective_tasks (objective_task_objective_id, objective_task_task_id) VALUES
(0, 2),
(2, 3),
(2, 3);

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

INSERT INTO project_impediments (project_impediment_project_id, project_impediment_impediment_id) VALUES
(3, 0),
(1, 1);

INSERT INTO task_impediments (task_impediment_task_id, task_impediment_impediment_id) VALUES
(4, 2);

INSERT INTO remedies (remedy_id, remedy_description, remedy_impediment_id, remedy_submission_date, remedy_provider) VALUES
(0, 'Use service control tool to generate project structure from existing endpoint meta data', 1, '2015/12/13 14:20:00', 1); 

-- ###########################################################################################

INSERT INTO task_dependencies (dependency_dependent, dependency_maintainer) VALUES
(5, 4);

INSERT INTO task_estimations (estimation_id, estimation_task, estimation_pessimist, estimation_realist, estimation_optimist) VALUES
(0, 4, '5 0:00:00', '4 0:00:00', '3 0:00:00');

-- ###########################################################################################

INSERT INTO team_objective_assignments (assignment_entrustor, assignment_recipient, assignment_objective) VALUES
(1, 1, 1);
INSERT INTO user_objective_assignments (assignment_entrustor, assignment_recipient, assignment_objective) VALUES
(2, 2, 3);
INSERT INTO team_project_assignments (assignment_entrustor, assignment_recipient, assignment_project) VALUES
(2, 2, 3);
INSERT INTO user_project_assignments (assignment_entrustor, assignment_recipient, assignment_project) VALUES
(0, 3, 2);
INSERT INTO team_task_assignments (assignment_entrustor, assignment_recipient, assignment_task) VALUES
(1, 2, 0);
INSERT INTO user_task_assignments (assignment_entrustor, assignment_recipient, assignment_task) VALUES
(0, 7, 1);

-- ###########################################################################################

INSERT INTO reviews (review_id, review_name, review_description, review_organizer, review_date) VALUES
(0, 'ARPA integration code review', 'Let us analyze our progress made with the new AR SDK', 0, '2016/09/15 14:00:00');

INSERT INTO review_invitations (invitaion_review, invitation_recipiant) VALUES
(0, 0),
(0, 3),
(0, 6),
(0, 7);