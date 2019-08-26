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
        stage('maven-test') {
            node {
                 docker.image('maven:3-alpine').inside(){
                     sh "pwd && ls"
                     sh "echo ------------------"
                     sh "./mvnw dockerfile:build"
                 }
            }
        }
    }
}