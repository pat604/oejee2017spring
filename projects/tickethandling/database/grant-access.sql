GRANT SELECT, INSERT, UPDATE, DELETE ON component, customer, comp_in_system, employee, priority, status, ticket TO tickethandling_role;

GRANT USAGE, SELECT, UPDATE ON ticket_tic_id_seq TO tickethandling_role;