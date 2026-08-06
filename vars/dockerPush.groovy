def call(String imageName, String imageTag){


retry(3){

sh '''

docker push ${IMAGE_NAME}:${IMAGE_TAG}


docker push ${IMAGE_NAME}:${LATEST_TAG}

'''

}


}