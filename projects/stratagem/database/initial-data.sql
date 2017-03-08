INSERT INTO statuses (status_id, status_name) VALUES (0, 'PROPOSED');
INSERT INTO statuses (status_id, status_name) VALUES (1, 'PENDING');
INSERT INTO statuses (status_id, status_name) VALUES (2, 'INITIATED');
INSERT INTO statuses (status_id, status_name) VALUES (3, 'UNDER_ANALYSIS');
INSERT INTO statuses (status_id, status_name) VALUES (4, 'IN_DESIGN');
INSERT INTO statuses (status_id, status_name) VALUES (5, 'IN_DEVELOPMENT');
INSERT INTO statuses (status_id, status_name) VALUES (6, 'CANCELED');
INSERT INTO statuses (status_id, status_name) VALUES (7, 'TESTING');
INSERT INTO statuses (status_id, status_name) VALUES (8, 'VALIDATING');
INSERT INTO statuses (status_id, status_name) VALUES (9, 'DEPLOYING');
INSERT INTO statuses (status_id, status_name) VALUES (10, 'IMPLEMENTING');
INSERT INTO statuses (status_id, status_name) VALUES (11, 'INTEGRATING');
INSERT INTO statuses (status_id, status_name) VALUES (12, 'LIVE');
INSERT INTO statuses (status_id, status_name) VALUES (13, 'MAINTAINED_BY_OPERATIONS');
INSERT INTO statuses (status_id, status_name) VALUES (14, 'UPGRADING');
INSERT INTO statuses (status_id, status_name) VALUES (15, 'DISPOSED');

INSERT INTO projects (project_id, project_name, project_status_id) VALUES (0, 'Deploy Ceraphis data to India warehouse', 10);
INSERT INTO projects (project_id, project_name, project_status_id) VALUES (1, 'Develop mobile app for QuickExtract', 7); 
INSERT INTO projects (project_id, project_name, project_status_id) VALUES (2, 'Grove BI outsourcing', 0); 

INSERT INTO tasks (task_id, task_description, task_project_id, task_completion_percentage) VALUES (16738267, 'Creating tool for efficient use-case testing', 1, 30);
INSERT INTO tasks (task_id, task_description, task_project_id, task_completion_percentage) VALUES (16098764, 'Matching watermark prints', 0, 85);
INSERT INTO tasks (task_id, task_description, task_project_id, task_completion_percentage) VALUES (17896372, 'Planning extraction approach', 2, 60);
INSERT INTO tasks (task_id, task_description, task_project_id, task_completion_percentage) VALUES (16906732, 'Allocating backup systems for overload evasion', 0, 100);
INSERT INTO tasks (task_id, task_description, task_project_id, task_completion_percentage) VALUES (17021230, 'Closing all end-to-end test incidents', 1, 0);