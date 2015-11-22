#!/bin/sh

su postgres -c "psql < ./scripts/db-create.sql";

