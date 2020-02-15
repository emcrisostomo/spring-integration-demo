CONSUMER_DEMO_PATH=spring-integration-rabbitmq-consumer-demo
PRODUCER_DEMO_PATH=spring-integration-rabbitmq-producer-demo

docker-build: | $(CONSUMER_DEMO_PATH) $(PRODUCER_DEMO_PATH)
	$(MAKE) -C $(CONSUMER_DEMO_PATH) docker-build
	$(MAKE) -C $(PRODUCER_DEMO_PATH) docker-build

$(CONSUMER_DEMO_PATH) $(PRODUCER_DEMO_PATH):
	$(error Required path cannot be found: $@)
