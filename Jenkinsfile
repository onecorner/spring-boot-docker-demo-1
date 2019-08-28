pipeline {
    def dockerRepoUrl = "172.21.64.110:8082"
    agent {
          docker {
                image 'maven:3-alpine'
                args '-v /jenkins/.m2:/root/.m2  -v /var/run/docker.sock:/var/run/docker.sock'
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
                  sh 'mvn dockerfile:build --settings /var/jenkins_home/.m2/settings-docker.xml'
             }
        }
        stage('docker-push') {
             steps {
                sh "docker login -u admin -p admin123 ${dockerRepoUrl}"
                sh 'mvn dockerfile:push'
             }
        }
    }
}