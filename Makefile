build:
	mvn clean install

run-client:
	./tool/build-tool.sh
	./tool/bin build_client
	./tool/bin client

run-server:
	./tool/build-tool.sh
	./tool/bin build_server
	./tool/bin server

