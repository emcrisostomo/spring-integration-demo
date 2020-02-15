convert-to-kubernetes: | docker-compose kubernetes
	( cd kubernetes && kompose convert -f ../docker-compose/docker-compose.yml )

deploy-kubernetes: | kubernetes
	kubectl apply -f kubernetes/

undeploy-kubernetes: | kubernetes
	kubectl delete -f kubernetes/

deploy-swarm: | docker-compose
	docker stack deploy --compose-file=docker-compose/docker-compose.yml example-stack

undeploy-swarm: | docker-compose
	docker stack rm example-stack

docker-compose kubernetes:
	$(error Required directory is missing: $@)
