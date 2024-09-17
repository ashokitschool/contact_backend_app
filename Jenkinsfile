pipeline {
    agent any
    
    tools{
        maven "Maven-3.9.9"
    }

    stages {
        stage('Git Clone') {
            steps {
               git branch: 'main', url: 'https://github.com/ashokitschool/contact_ui_ng_app.git'
            }
        }
        
         stage('Docker Image Build'){
            steps{
             sh 'docker build -t ashokit/contact_ui_app .'
            }
        }
         stage('K8S Deployment'){
            steps{
             sh 'kubectl apply -f contact_ui_deployment.yml'
            }
        }
    }
}
