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
        stage('docker-build') {
             agent  none
             steps {
                  sh "pwd && ls && cd /jenkins/workspace/simple-java-maven-app"
                  sh "docker container run --rm zenika/alpine-maven mvn dockerfile:build"
             }
        }
    }
}