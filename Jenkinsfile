pipeline {
    agent {
          docker {
                image 'maven:3-alpine'
                args '-v /jenkins/.m2:/root/.m2  -v /var/run/docker.sock:/var/run/docker.sock'
          }
    }
    environment {
          dockerRepoUrl = "172.21.64.110:8082"
          dockerImage = "${dockerRepoUrl}/spring-boot-docker-demo"
          appName = app
    }
    stages {
        stage('maven-build') {
            steps {
                sh 'mvn -B -DskipTests clean package --settings /var/jenkins_home/.m2/settings-docker.xml'
            }
        }
        stage('docker-build') {
             steps {
                  sh 'mvn dockerfile:build --settings /var/jenkins_home/.m2/settings-docker.xml'
             }
        }
        stage('docker-run') {
             agent any
             steps {
                  sh "docker rm -f $(docker ps -q --filter 'name=${appName}')"
                  sh "docker run -p 8080:8080 -d --name app ${dockerImage}"
             }
        }
        stage('docker-push') {
             steps {
                sh 'mvn dockerfile:push --settings /var/jenkins_home/.m2/settings-docker.xml'
             }
        }
    }
}