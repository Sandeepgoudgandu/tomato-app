pipeline {
    agent any
    tools { maven 'Maven3'; jdk 'JDK11' }
    environment { DOCKER_IMAGE="yourdockerhub/food-delivery-app" }
    stages {
        stage('Checkout'){ steps{ git branch: 'main', credentialsId: 'github-creds', url: 'https://github.com/yourname/food-delivery-app.git' } }
        stage('Build'){ steps{ sh 'mvn clean install' } }
        stage('Sonar'){ steps{ withSonarQubeEnv('Sonar'){ sh 'mvn sonar:sonar' } } }
        stage('Nexus Deploy'){ steps{ sh 'mvn deploy' } }
        stage('Docker Build'){ steps{ sh 'docker build -t $DOCKER_IMAGE:latest .' } }
        stage('Docker Push'){ steps{ withCredentials([usernamePassword(credentialsId:"docker-creds", usernameVariable:"U", passwordVariable:"P")]){ sh "echo $P | docker login -u $U --password-stdin"; sh "docker push $DOCKER_IMAGE:latest"; } } }
        stage('K8s Deploy'){ steps{ withKubeConfig(credentialsId:'kubeconfig'){ sh 'kubectl apply -f k8s/' } } }
    }
}
