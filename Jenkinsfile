pipeline {
    agent {
        dockerfile {
            additionalBuildArgs  '--build-arg version=1.0.2'
        }
    }
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
    }
}