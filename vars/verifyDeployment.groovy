def call(){


sh '''

echo "===== RUNNING CONTAINERS ====="


docker ps


echo


docker inspect ${CONTAINER_NAME} \
--format='{{.State.Status}}'


'''


}