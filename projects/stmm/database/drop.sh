#!/bin/sh

psql -d postgres -h localhost -p 5432 -U postgres -f drop-user.sql
psql -d postgres -h localhost -p 5432 -U postgres -f drop-role.sql
