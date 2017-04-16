psql -d postgres -h localhost -p 5432 -U postgres -f create-role.sql
psql -d postgres -h localhost -p 5432 -U postgres -f create-user.sql
psql -d stmmdb -h localhost -p 5432 -U postgres -f stmmdb_pg_dump.sql