INSERT INTO todo (name, description, state, deadline) VALUES ('clean the house', 'Cleaning the floor and the windows properly.', 0, '2017-11-01');
INSERT INTO todo (name, description, state, deadline) VALUES ('prepare for zh', 'Learning subject x to have a passing grade.', 0, '2017-11-01');

INSERT INTO sub_todo (todo_id, name, description, state) VALUES (1, 'clean the floor', '', 0);
INSERT INTO sub_todo (todo_id, name, description, state) VALUES (1, 'clean the windows', '', 0);

INSERT INTO priority (name, priority_value) VALUES ('important', 1);
INSERT INTO priority (name, priority_value) VALUES ('little bit important', 2);
INSERT INTO priority (name, priority_value) VALUES ('not important', 3);

INSERT INTO category (name, description) VALUES ('chores', 'Things to do around the house.');
INSERT INTO category (name, description) VALUES ('school', 'School related works.');

INSERT INTO priority_to_todo (id, priority_id, todo_id) VALUES (0, 2, 1);
INSERT INTO category_to_todo (id, category_id, todo_id) VALUES (0, 1, 1);