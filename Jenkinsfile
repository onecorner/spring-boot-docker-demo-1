pipeline {
    agent none
    stages {
        stage('maven-build') {
            agent {
                     docker {
                           image 'maven:3-alpine'
                           args ['-v /jenkins/.m2:/root/.m2',' -v /var/run/docker.sock:/var/run/docker.sock']
                     }
            }
            steps {
                sh 'ls /var/run'
                sh 'mvn -B -DskipTests clean package --settings /var/jenkins_home/.m2/settings-docker.xml'
                sh 'mvn dockerfile:build --settings /var/jenkins_home/.m2/settings-docker.xml'
                sh 'mvn dockerfile:push'
            }
        }
        stage('docker-build&&run') {
             agent  any
             steps {
                  sh "pwd && ls"
                  sh "docker run  -v /jenkins/.m2:/root/.m2  --rm maven:3-alpine mvn package dockerfile:build --settings /root/.m2/settings-docker.xml"
             }
        }
        stage('docker-push') {
             agent  any
             steps {
                  sh "docker run -v /jenkins/.m2:/root/.m2 --rm maven:3-alpine  mvn dockerfile:push --settings /root/.m2/settings-docker.xml"
             }
        }
    }
}