build:
	mvn clean install

run-client:
	./tool/script.sh build_client
	./tool/script.sh client

run-server:
	./tool/script.sh build_server
	./tool/script.sh server

