def call(){


echo """

====================================

Application : ${APP_NAME}

Branch      : ${BRANCH_NAME}

Build       : ${BUILD_NUMBER}

Commit      : ${GIT_COMMIT_SHORT}

Image       : ${IMAGE_NAME}:${IMAGE_TAG}

Workspace   : ${WORKSPACE}

Node        : ${NODE_NAME}

====================================


"""


}