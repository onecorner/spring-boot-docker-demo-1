pipeline {
    agent any
    stages {
        stage('build') {
            agent {
                docker {
                      image 'maven:3-alpine'
                      args '-v /jenkins_home/.m2:/root/.m2'
                 }
            }
            steps {
                sh 'mvn -B -DskipTests clean package'
            }

        }
        stage('build-on-docker') {
                    agent {
                         dockerfile true
                    }
                    steps {
                        echo "build on docker"
                    }

        }
    }
}