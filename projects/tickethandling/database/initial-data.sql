INSERT INTO priority (prio_id, prio_description) VALUES (0, 'VERY_LOW');
INSERT INTO priority (prio_id, prio_description) VALUES (1, 'LOW');
INSERT INTO priority (prio_id, prio_description) VALUES (2, 'NORMAL');
INSERT INTO priority (prio_id, prio_description) VALUES (3, 'MEDIUM');
INSERT INTO priority (prio_id, prio_description) VALUES (4, 'HIGH');
INSERT INTO priority (prio_id, prio_description) VALUES (5, 'IMMEDIATE');

INSERT INTO status (stat_id, stat_description) VALUES (0, 'NEW');
INSERT INTO status (stat_id, stat_description) VALUES (1, 'IN_PROGRESS');
INSERT INTO status (stat_id, stat_description) VALUES (2, 'SOLUTION_PROVIDED');
INSERT INTO status (stat_id, stat_description) VALUES (3, 'SOLVED');
INSERT INTO status (stat_id, stat_description) VALUES (4, 'CLOSED');

INSERT INTO component (comp_id, comp_description, comp_creationdate) VALUES ('XX-4C-ASD0', 'No descriprtion', now()::timestamp);
INSERT INTO component (comp_id, comp_description, comp_creationdate) VALUES ('YY-66-WERT', 'No descriprtion', now()::timestamp);
INSERT INTO component (comp_id, comp_description, comp_creationdate) VALUES ('GZ-52-TZUU', 'No descriprtion', now()::timestamp);
INSERT INTO component (comp_id, comp_description, comp_creationdate) VALUES ('AF-21-HJKG', 'No descriprtion', now()::timestamp);
INSERT INTO component (comp_id, comp_description, comp_creationdate) VALUES ('GR-44-LLKJ', 'No descriprtion', now()::timestamp);
INSERT INTO component (comp_id, comp_description, comp_creationdate) VALUES ('TV-8G-MNBV', 'No descriprtion', now()::timestamp);

INSERT INTO employee (emp_id, emp_name, emp_password, emp_level, emp_email, emp_phone, emp_hiredate) VALUES ('E4412', 'Han Solo', 'root', 3,'hansolo@millenium.fa', '00663756699', '2017-04-23 22:43:25.259');
INSERT INTO employee (emp_id, emp_name, emp_password, emp_level, emp_email, emp_phone, emp_hiredate) VALUES ('E3333', 'Chewbacca', 'root', 2, 'chewie@millenium.fa', '00664562287', '2017-04-23 22:43:25.259');
INSERT INTO employee (emp_id, emp_name, emp_password, emp_level, emp_email, emp_phone, emp_hiredate) VALUES ('E5643', 'Luke Skywalker', 'root', 3, 'luke@tatooine.sa', '00332341122', '2017-04-23 22:43:25.259');
INSERT INTO employee (emp_id, emp_name, emp_password, emp_level, emp_email, emp_phone, emp_hiredate) VALUES ('E3562', 'R2-D2', 'root', 1, 'artwo@naboo.do', '00551231146', '2017-04-23 22:43:25.259');
INSERT INTO employee (emp_id, emp_name, emp_password, emp_level, emp_email, emp_phone, emp_hiredate) VALUES ('E7865', 'C-3PO', 'root', 1, 'threepio@tatooine.sa', '00332341122', '2017-04-23 22:43:25.259');

INSERT INTO role (role_id, role_name) VALUES (0, 'user');
INSERT INTO role (role_id, role_name) VALUES (1, 'admin');

SELECT SETVAL('role_role_id_seq', COALESCE(MAX(role_id), 1) ) FROM role;

INSERT INTO emprole (emprole_emp_id, emprole_role_id) VALUES ('E4412', 0);
INSERT INTO emprole (emprole_emp_id, emprole_role_id) VALUES ('E3333', 0);
INSERT INTO emprole (emprole_emp_id, emprole_role_id) VALUES ('E5643', 0);
INSERT INTO emprole (emprole_emp_id, emprole_role_id) VALUES ('E3562', 0);
INSERT INTO emprole (emprole_emp_id, emprole_role_id) VALUES ('E7865', 0);
INSERT INTO emprole (emprole_emp_id, emprole_role_id) VALUES ('E4412', 1);
INSERT INTO emprole (emprole_emp_id, emprole_role_id) VALUES ('E5643', 1);

INSERT INTO customer (cust_sys_id, cust_name, cust_address, cust_cont_name, cust_cont_phone, cust_cont_mail) VALUES ('AES-324', 'Galactic Empire Ltd.', '789987 Coruscant Palpatine Sqr. 0001', 'Mas Amedda', '00781256647', 'mas.amedda@empire.gov');
INSERT INTO customer (cust_sys_id, cust_name, cust_address, cust_cont_name, cust_cont_phone, cust_cont_mail) VALUES ('RTS-758', 'Rebel Alliance Co.', '13712 Yavin-4 Forest Fort 567', 'Leia Organa', '00451237654', 'leia.organa@rebellion.all');

INSERT INTO comp_in_system (cis_id, cis_sys_id, cis_comp_id, cis_description, cis_creationdate) VALUES (1, 'AES-324', 'XX-4C-ASD0', 'No descriprtion', now()::timestamp);
INSERT INTO comp_in_system (cis_id, cis_sys_id, cis_comp_id, cis_description, cis_creationdate) VALUES (2,'AES-324', 'YY-66-WERT', 'No descriprtion', now()::timestamp);
INSERT INTO comp_in_system (cis_id, cis_sys_id, cis_comp_id, cis_description, cis_creationdate) VALUES (3,'RTS-758', 'XX-4C-ASD0', 'No descriprtion', now()::timestamp);
INSERT INTO comp_in_system (cis_id, cis_sys_id, cis_comp_id, cis_description, cis_creationdate) VALUES (4,'RTS-758', 'AF-21-HJKG', 'No descriprtion', now()::timestamp);
INSERT INTO comp_in_system (cis_id, cis_sys_id, cis_comp_id, cis_description, cis_creationdate) VALUES (5,'RTS-758', 'TV-8G-MNBV', 'No descriprtion', now()::timestamp);

INSERT INTO ticket (tic_id, tic_sys_id, tic_sender_name, tic_priority, tic_business_imp, tic_steps_to_rep, tic_creationdate, tic_level, tic_processor_id, tic_status, tic_lastchanged) VALUES ('AES32420170316051534', 'AES-324', '', 4, '', '', '2017-04-21 22:43:25.259', 3, 'E4412', 1, '2017-04-23 22:43:25.259');
INSERT INTO ticket (tic_id, tic_sys_id, tic_sender_name, tic_priority, tic_business_imp, tic_steps_to_rep, tic_creationdate, tic_level, tic_processor_id, tic_status, tic_lastchanged) VALUES ('RTS75820170314051534', 'RTS-758', '', 2, '', '', '2017-03-16 05:15:34.200', 2, 'E3333', 2, '2017-04-23 22:43:25.259');
INSERT INTO ticket (tic_id, tic_sys_id, tic_sender_name, tic_priority, tic_business_imp, tic_steps_to_rep, tic_creationdate, tic_level, tic_processor_id, tic_status, tic_lastchanged) VALUES ('AES32420170416051534', 'AES-324', '', 3, '', '', '2017-03-16 05:15:34.356', 3, 'E5643', 3, '2017-04-23 22:43:25.259');
INSERT INTO ticket (tic_id, tic_sys_id, tic_sender_name, tic_priority, tic_business_imp, tic_steps_to_rep, tic_creationdate, tic_level, tic_status, tic_lastchanged) VALUES ('RTS75820170416051534', 'RTS-758', '', 1, '', '', '2017-03-16 05:15:34.356', 2, 1, '2017-04-23 22:43:25.259');
INSERT INTO ticket (tic_id, tic_sys_id, tic_sender_name, tic_priority, tic_business_imp, tic_steps_to_rep, tic_creationdate, tic_level, tic_status, tic_lastchanged) VALUES ('AES32420170317051534', 'AES-324', '', 5, '', '', '2017-03-16 05:15:34.356', 2, 2, '2017-04-23 22:43:25.259');
INSERT INTO ticket (tic_id, tic_sys_id, tic_sender_name, tic_priority, tic_business_imp, tic_steps_to_rep, tic_creationdate, tic_level, tic_status, tic_lastchanged) VALUES ('RTS75820170318051534', 'RTS-758', '', 0, '', '', '2017-03-16 05:15:34.356', 2, 3, '2017-04-23 22:43:25.259');
