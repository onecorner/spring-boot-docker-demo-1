pipeline {
    agent none
    stages {
        stage('maven-build') {
            agent {
                     docker {
                           image 'maven:3-alpine'
                           args '-v /jenkins/.m2:/root/.m2 '
                     }
            }
            steps {
                sh 'mvn -B -DskipTests clean package --settings /var/jenkins_home/.m2/settings-docker.xml'
            }
        }
        stage('docker-build&&run') {
             agent  any
             steps {
                  sh "pwd && ls /var/jenkins_home/"
                  sh "./mvnw dockerfile:build"
             }
        }
        stage('docker-push') {
             agent  any
             steps {
                  sh "./mvnw dockerfile:push"
             }
        }
    }
}