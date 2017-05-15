INSERT INTO todo (name, description, state, deadline) VALUES ('Buying groceries', 'Buying groceries in the shop.', 0, '2017-11-01');
INSERT INTO todo (name, description, state, deadline) VALUES ('Create a todo app', 'Creating a todo app for javaEE.', 0, '2017-05-18');
INSERT INTO todo (name, description, state, deadline) VALUES ('Testing todo app', '', 0, '2017-05-18');
INSERT INTO todo (name, description, state, deadline) VALUES ('Show todo app', '', 0, '2017-05-18');

INSERT INTO sub_todo (todo_id, name, description, state) VALUES (1, 'Go to the shop', '', 0);
INSERT INTO sub_todo (todo_id, name, description, state) VALUES (1, 'Buying vegatables', '', 0);
INSERT INTO sub_todo (todo_id, name, description, state) VALUES (1, 'Buying meat', '', 0);

INSERT INTO priority (name, priority_value) VALUES ('important', 1);
INSERT INTO priority (name, priority_value) VALUES ('little bit important', 2);
INSERT INTO priority (name, priority_value) VALUES ('not important', 3);

INSERT INTO category (name, description) VALUES ('chores', 'Things to do around the house.');
INSERT INTO category (name, description) VALUES ('school', 'School related works.');
INSERT INTO category (name, description) VALUES ('general', 'General todos.');

INSERT INTO priority_to_todo (priority_id, todo_id) VALUES (2, 1);
INSERT INTO category_to_todo (category_id, todo_id) VALUES (1, 1);