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
                sh "pwd"
                sh 'mvn -B -DskipTests clean package --settings /var/jenkins_home/.m2/settings-docker.xml'

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