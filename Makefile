CONSUMER_DEMO_PATH=spring-integration-rabbitmq-consumer-demo
PRODUCER_DEMO_PATH=spring-integration-rabbitmq-producer-demo

.PHONY: docker-build docker-daemon-build
docker-build docker-daemon-build: | $(CONSUMER_DEMO_PATH) $(PRODUCER_DEMO_PATH)
	$(MAKE) -C $(CONSUMER_DEMO_PATH) $@
	$(MAKE) -C $(PRODUCER_DEMO_PATH) $@

.PHONY: display-dependency-updates
display-dependency-updates:
	./mvnw versions:display-dependency-updates

.PHONY: display-plugin-updates
display-plugin-updates:
	./mvnw versions:display-plugin-updates

.PHONY: display-property-updates
display-property-updates:
	./mvnw versions:display-property-updates

.PHONY: maven-wrapper
maven-wrapper:
	./mvnw -N io.takari:maven:wrapper

$(CONSUMER_DEMO_PATH) $(PRODUCER_DEMO_PATH):
	$(error Required path cannot be found: $@)
