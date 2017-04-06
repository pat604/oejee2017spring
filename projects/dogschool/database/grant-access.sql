GRANT SELECT, INSERT, UPDATE, DELETE ON
dogschool, instructor TO dogschool_role;
GRANT USAGE, SELECT, UPDATE ON
dogschool_dogschool_id_seq TO dogschool_role;
GRANT USAGE, SELECT, UPDATE ON
instructor_instructor_id_seq TO dogschool_role;