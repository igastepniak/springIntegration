build:
	mvn -f example-parent/pom.xml clean install

db-recreate:
	sudo sh scripts/db-drop.sh
	sudo sh scripts/db-create.sh

db-create:
	sudo sh scripts/db-create.sh

db-drop:
	sudo sh scripts/db-drop.sh

db-recreate-test:
	sudo sh scripts/db-drop-test.sh
	sudo sh scripts/db-create-test.sh

db-create-test:
	sudo sh scripts/db-create-test.sh

db-drop-test:
	sudo sh scripts/db-drop-test.sh
