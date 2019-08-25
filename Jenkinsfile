pipeline {
    agent {
         docker {
               image 'maven:3-alpine'
               args '-v /jenkins/.m2:/root/.m2'
         }
    }
    stages {
        stage('maven-build') {
            steps {
                sh 'mvn -B -DskipTests clean package --settings /var/jenkins_home/.m2/settings-docker.xml'
            }
        }
        stage('docker-build') {
             steps {
                  sh "mvn dockerfile:build --settings /var/jenkins_home/.m2/settings-docker.xml"
             }
        }
    }
}