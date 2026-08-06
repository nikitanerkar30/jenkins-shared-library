def call(String usernameCredentialId, String passwordCredentialId){


withCredentials([
usernamePassword(
credentialsId:'dockerhub-credential',
usernameVariable:'DOCKER_USER',
passwordVariable:'DOCKER_PASS'
)

]){


sh '''

echo "$DOCKER_PASS" | docker login \
-u "$DOCKER_USER" \
--password-stdin

'''

}


}