#!/bin/sh

su postgres -c "psql < ./scripts/db-create-test.sql";

su postgres -c "psql -U postgres -d example_test -f ./scripts/dump.sql";


