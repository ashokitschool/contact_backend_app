pipeline {
    agent any
    
    tools{
        maven "Maven-3.9.9"
    }

    stages {
        stage('Git Clone') {
            steps {
               git branch: 'main', url: 'https://github.com/ashokitschool/contact_backend_app.git'
            }
        }
        stage('Maven Build'){
            steps{
             sh 'mvn clean package'
            }
        }
         stage('Docker Image Build'){
            steps{
             sh 'docker build -t ashokit/contact_backend_app .'
            }
        }
         stage('K8S Deployment'){
            steps{
             sh 'kubectl apply -f Deployment.yml'
            }
        }
    }
}
