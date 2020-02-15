convert-to-kubernetes: | docker-compose kubernetes
	( cd kubernetes && kompose convert -f ../docker-compose/docker-compose.yml )

deploy-on-kubernetes: | kubernetes
	kubectl apply -f kubernetes/

undeploy-on-kubernetes: | kubernetes
	kubectl delete -f kubernetes/

docker-compose kubernetes:
	$(error Required directory is missing: $@)
