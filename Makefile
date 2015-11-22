build:
	mvn -f example-parent/pom.xml clean install

db-recreate:
	sudo sh scripts/db-drop.sh
	sudo sh scripts/db-create.sh

db-create:
	sudo sh scripts/db-create.sh

db-drop:
	sudo sh scripts/db-drop.sh
