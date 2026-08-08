def call(String namespace = "expense-dev") {

```
withCredentials([
    file(
        credentialsId: 'k8s-config',
        variable: 'KUBECONFIG'
    )
]) {

    sh """
        set -e

        echo "========================================="
        echo "Deploying Expense Management System"
        echo "========================================="

        echo "Kubernetes context:"
        kubectl config current-context

        echo "Kubernetes nodes:"
        kubectl get nodes

        echo "Applying namespace..."
        kubectl apply -f k8s/namespace.yaml

        echo "Applying MySQL resources..."
        kubectl apply -f k8s/mysql/ -n ${namespace}

        echo "Applying security resources..."
        kubectl apply -f k8s/security/ -n ${namespace}

        echo "Applying application resources..."
        kubectl apply -f k8s/app/ -n ${namespace}

        echo "Applying autoscaling resources..."
        kubectl apply -f k8s/autoscaling/ -n ${namespace}

        echo "Waiting for application rollout..."
        kubectl rollout status deployment/expense-app -n ${namespace} --timeout=180s

        echo "========================================="
        echo "Deployment status"
        echo "========================================="

        kubectl get deployment -n ${namespace}

        echo "========================================="
        echo "Pod status"
        echo "========================================="

        kubectl get pods -n ${namespace}

        echo "========================================="
        echo "Service status"
        echo "========================================="

        kubectl get svc -n ${namespace}

        echo "========================================="
        echo "Expense Management deployment completed"
        echo "========================================="
    """
}
```

}
