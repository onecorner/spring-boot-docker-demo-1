pipeline {
    agent {
        dockerfile {
            additionalBuildArgs  '--build-arg version=1.0.2'
        }
    }
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}