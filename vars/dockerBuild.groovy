def call(){

echo "======= BUILD DOCKER IMAGE ======="


sh '''

docker build \
-t ${IMAGE_NAME}:${IMAGE_TAG} .


docker tag \
${IMAGE_NAME}:${IMAGE_TAG} \
${IMAGE_NAME}:${LATEST_TAG}


'''

}