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
        stage('CODE ANALYSIS with SONARQUBE') {
          
		  environment {
             scannerHome = tool 'sonarqube-4'
          }

          steps {
            withSonarQubeEnv('SonarQube') {
               sh '''${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=web-app \
                   -Dsonar.projectName=web-app \
                   -Dsonar.projectVersion=1.0 \
                   -Dsonar.sources=src/ \
                   -Dsonar.java.binaries=target/classes \
                   -Dsonar.login=admin \
                   -Dsonar.password=admin123'''
            }

            //timeout(time: 1, unit: 'MINUTES') {
            //   waitForQualityGate abortPipeline: false
           // }
          }
        }
        stage('nexus-artifact-uploader'){
            steps{
                nexusArtifactUploader artifacts: [[artifactId: 'web-artifact', classifier: '', file: 'target/MyWebApp.war', type: 'war']], credentialsId: 'nexus-creds', groupId: 'web', nexusUrl: '13.232.129.50:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'web-repo', version: '${BUILD_ID}'
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