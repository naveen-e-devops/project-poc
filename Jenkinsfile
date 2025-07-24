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
        stage('nexus-artifact-uploader'){
            steps{
                nexusArtifactUploader artifacts: [[artifactId: 'web-artifact', classifier: '', file: 'target/MyWebApp.war', type: 'war']], credentialsId: 'nexus-creds', groupId: 'web', nexusUrl: '13.233.129.186:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'web-repo', version: '${BUILD_ID}'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
                // Add your deployment commands here
                deploy adapters: [tomcat9(alternativeDeploymentContext: '', credentialsId: 'tomcat-creds', path: '', url: 'http://172.31.1.130:8080')], contextPath: 'july22', war: 'target/MyWebApp.war'
            }
        }
    }
}