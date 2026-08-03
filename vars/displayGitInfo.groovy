def call(){

script {

    env.GIT_COMMIT_SHORT = sh(
        script:'git rev-parse --short HEAD',
        returnStdout:true
    ).trim()


    env.IMAGE_TAG="${BUILD_NUMBER}-${GIT_COMMIT_SHORT}"

}


sh '''

echo "========== GIT INFORMATION =========="

echo "Branch : $BRANCH_NAME"

git log -1 --pretty=format:"Commit : %H"

echo

git log -1 --pretty=format:"Author : %an"

echo

git log -1 --pretty=format:"Message : %s"

echo

echo "Short Commit : $GIT_COMMIT_SHORT"

'''

}