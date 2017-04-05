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

INSERT INTO employee (emp_id, emp_name, emp_level, emp_email, emp_phone, emp_hiredate) VALUES ('E4412', 'Han Solo', 3, 'hansolo@millenium.fa', '00663756699', now()::timestamp);
INSERT INTO employee (emp_id, emp_name, emp_level, emp_email, emp_phone, emp_hiredate) VALUES ('E3333', 'Chewbacca', 2, 'chewie@millenium.fa', '00664562287', now()::timestamp);
INSERT INTO employee (emp_id, emp_name, emp_level, emp_email, emp_phone, emp_hiredate) VALUES ('E5643', 'Luke Skywalker', 3, 'luke@tatooine.sa', '00332341122', now()::timestamp);
INSERT INTO employee (emp_id, emp_name, emp_level, emp_email, emp_phone, emp_hiredate) VALUES ('E3562', 'R2-D2', 1, 'artwo@naboo.do', '00551231146', now()::timestamp);
INSERT INTO employee (emp_id, emp_name, emp_level, emp_email, emp_phone, emp_hiredate) VALUES ('E7865', 'C-3PO', 1, 'threepio@tatooine.sa', '00332341122', now()::timestamp);

INSERT INTO customer (cust_sys_id, cust_name, cust_address, cust_cont_name, cust_cont_phone, cust_cont_mail) VALUES ('AES-324', 'Galactic Empire Ltd.', '789987 Coruscant Palpatine Sqr. 0001', 'Mas Amedda', '00781256647', 'mas.amedda@empire.gov');
INSERT INTO customer (cust_sys_id, cust_name, cust_address, cust_cont_name, cust_cont_phone, cust_cont_mail) VALUES ('RTS-758', 'Rebel Alliance Co.', '13712 Yavin-4 Forest Fort 567', 'Leia Organa', '00451237654', 'leia.organa@rebellion.all');

INSERT INTO comp_in_system (cis_id, cis_sys_id, cis_comp_id, cis_description, cis_creationdate) VALUES (1, 'AES-324', 'XX-4C-ASD0', 'No descriprtion', now()::timestamp);
INSERT INTO comp_in_system (cis_id, cis_sys_id, cis_comp_id, cis_description, cis_creationdate) VALUES (2,'AES-324', 'YY-66-WERT', 'No descriprtion', now()::timestamp);
INSERT INTO comp_in_system (cis_id, cis_sys_id, cis_comp_id, cis_description, cis_creationdate) VALUES (3,'RTS-758', 'XX-4C-ASD0', 'No descriprtion', now()::timestamp);
INSERT INTO comp_in_system (cis_id, cis_sys_id, cis_comp_id, cis_description, cis_creationdate) VALUES (4,'RTS-758', 'AF-21-HJKG', 'No descriprtion', now()::timestamp);
INSERT INTO comp_in_system (cis_id, cis_sys_id, cis_comp_id, cis_description, cis_creationdate) VALUES (5,'RTS-758', 'TV-8G-MNBV', 'No descriprtion', now()::timestamp);

INSERT INTO ticket (tic_id, tic_sys_id, tic_sender_name, tic_priority, tic_business_imp, tic_steps_to_rep, tic_creationdate, tic_level, tic_processor_id, tic_status, tic_lastchanged) VALUES ('AES-324-201703160515', 'AES-324', 'Jar-Jar Binks', 4, '', '', now()::timestamp, 2, 'E4412', 1, now()::timestamp);
INSERT INTO ticket (tic_id, tic_sys_id, tic_sender_name, tic_priority, tic_business_imp, tic_steps_to_rep, tic_creationdate, tic_level, tic_processor_id, tic_status, tic_lastchanged) VALUES ('AES-324-201703161432', 'AES-324', 'Jar-Jar Binks', 5, '', '', now()::timestamp, 2, 'E3333', 1, now()::timestamp);
INSERT INTO ticket (tic_id, tic_sys_id, tic_sender_name, tic_priority, tic_business_imp, tic_steps_to_rep, tic_creationdate, tic_level, tic_processor_id, tic_status, tic_lastchanged) VALUES ('RTS-758-201703161712', 'RTS-758', 'Jar-Jar Binks', 4, '', '', now()::timestamp, 2, 'E7865', 1, now()::timestamp);