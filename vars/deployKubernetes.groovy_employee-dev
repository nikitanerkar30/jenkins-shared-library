def call(String namespace = "employee-dev") {

    withCredentials([
        file(credentialsId: 'k8s-config',
             variable: 'KUBECONFIG')
    ]) {

        sh """
        echo "Deploying application to Kubernetes"

        kubectl config current-context

        kubectl get nodes

        kubectl apply -f k8s/ -n ${namespace}

        kubectl get pods -n ${namespace}
        """
    }
}