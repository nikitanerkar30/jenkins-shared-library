def call(){


echo "======= DEPLOY DOCKER COMPOSE ======="


sh '''

docker rm -f employee-service || true

docker compose down || true


export IMAGE_TAG=${IMAGE_TAG}


docker compose up -d


'''


}