docker-build:
	$(MAKE) -C spring-integration-rabbitmq-consumer-demo docker-build
	$(MAKE) -C spring-integration-rabbitmq-producer-demo docker-build
