GRANT SELECT, INSERT, UPDATE, DELETE ON todo, sub_todo, priority, category, priority_to_todo, category_to_todo TO todomanager_role;
    
GRANT USAGE, SELECT, UPDATE ON todo_id_seq, sub_todo_id_seq, priority_id_seq, category_id_seq, priority_to_todo_id_seq, category_to_todo_id_seq TO todomanager_role;