#!/bin/sh

su postgres -c "psql < ./scripts/db-drop-test.sql"
