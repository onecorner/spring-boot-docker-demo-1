node {

       def mvnHome = tool 'maven-3.6.1'

       def dockerImage

       def dockerRepoUrl = "172.21.64.110:8081"
       def dockerImageName = "spring-boot-docker-demo"
       def dockerImageTag = "${dockerRepoUrl}/${dockerImageName}:${env.BUILD_NUMBER}"

       stage('Clone Repo') {
         checkout scm
         mvnHome = tool 'maven-3.6.1'
       }

       stage('Build Project') {
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
       }

   	stage('Publish Tests Results'){
         parallel(
           publishJunitTestsResultsToJenkins: {
             echo "Publish junit Tests Results"
   		     junit '**/target/surefire-reports/TEST-*.xml'
   		     archive 'target/*.jar'
           },
           publishJunitTestsResultsToSonar: {
             echo "This is branch b"
         })
       }

    stage('Build Docker Image') {
       sh "whoami"
       sh "ls -all /var/run/docker.sock"
       sh "mv ./target/spring-boot-docker-demo*.jar ./data"

       dockerImage = docker.build("spring-boot-docker-demo")
    }

    stage('Deploy Docker Image'){
       echo "Docker Image Tag Name: ${dockerImageTag}"

       sh "docker login -u admin -p admin123 ${dockerRepoUrl}"
       sh "docker tag ${dockerImageName} ${dockerImageTag}"
       sh "docker push ${dockerImageTag}"
    }

}