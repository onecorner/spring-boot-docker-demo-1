pipeline {
    agent none
    stages {
        stage('Back-end') {
            agent {
                docker {
                     image 'maven:3-alpine'
                     args '-v /jenkins/.m2:/root/.m2'
                }
            }
            steps {
                sh 'mvn --version'
                sh 'mvn -B -DskipTests clean package'
                sh "whereis mvn"
                sh "pwd"
            }
        }
        stage('docker-run') {
             agent  none
              steps {
                  sh "pwd"
                  sh "ls"
               }
        }
    }
}