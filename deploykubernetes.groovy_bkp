def call(String imageName,
         String imageTag,
         String namespace = "expense-dev") {

    withCredentials([
        file(credentialsId: 'k8s-config',
             variable: 'KUBECONFIG')
    ]) {

        sh """
        echo "Deploying application to Kubernetes..."

        kubectl config current-context

        kubectl get nodes

        #Apply application manifests
        kubectl apply -f k8s/app/ -n ${namespace}

        kubectl apply -f k8s/security/ -n ${namespace}

        kubectl apply -f k8s/autoscaling/ -n ${namespace}

        # Update deployment with the newly built image
        kubectl set image deployment/expense-app \
        expense-app=${imageName}:${imageTag} \
        -n ${namespace}

        #Wait for rollout to finish
        kubectl rollout status deployment/expense-app -n ${namespace}

        kubectl get pods -n ${namespace}

        kubectl get svc -n ${namespace}
        """
    }
}