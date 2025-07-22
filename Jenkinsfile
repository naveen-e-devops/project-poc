pipeline {
    agent any
    tools {
        maven 'maven3'
    }
    stages {
        stage('clone') {
            steps {
                echo 'Cloning the repo...'
               // sh 'git clone https://github.com/naveen-e-devops/project-poc.git'
            }
        }
        stage('Build') {
            steps {
                echo 'Build the code...'
                sh 'mvn install'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
                // Add your deployment commands here
                deploy adapters: [tomcat9(alternativeDeploymentContext: '', credentialsId: 'tomcat-creds', path: '', url: 'http://3.109.59.153:8080')], contextPath: 'july22', war: 'target/MyWebApp.war'
            }
        }
    }
}
