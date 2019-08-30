pipeline {
    agent any
    environment {
          dockerRepoUrl = "172.21.64.110:8082"
          dockerImage = "${dockerRepoUrl}/spring-boot-docker-demo"
          appName = "app"
    }
    stages {
        stage('构建并且创建镜像') {
            agent {
                      docker {
                            image 'maven:3-alpine'
                            args '-v /jenkins/.m2:/root/.m2  -v /var/run/docker.sock:/var/run/docker.sock --settings /var/jenkins_home/.m2/settings-docker.xml'
                      }
            }
            steps {
                sh 'mvn -B -DskipTests clean package'
                sh 'mvn dockerfile:build'
                sh 'mvn dockerfile:push'
            }
        }
        stage('运行镜像'){
            agent any
            steps {
                sh 'docker run -p 8080:8080 -d --name app ${dockerImage}'
            }
        }
    }
}