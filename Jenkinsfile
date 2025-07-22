pipeline {
    agent any
    stages {
        stage('clone') {
            steps {
                echo 'Cloning the repo...'
                sh 'git clone https://github.com/naveen-e-devops/project-poc.git'
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
            }
        }
    }
}
