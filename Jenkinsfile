node {

        // reference to maven
       // ** NOTE: This 'maven-3.6.1' Maven tool must be configured in the Jenkins Global Configuration.
       def mvnHome = tool 'maven-3.6.1'

       // holds reference to docker image
       def dockerImage
       // ip address of the docker private repository(nexus)

       def dockerRepoUrl = "172.21.64.110:8081"
       def dockerImageName = "spring-boot-docker-demo"
       def dockerImageTag = "${dockerRepoUrl}/${dockerImageName}:${env.BUILD_NUMBER}"

       stage('Clone Repo') { // for display purposes
         checkout scm
         mvnHome = tool 'maven-3.6.1'
       }

       stage('Build Project') {
         // build project via maven
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
       // build docker image
       sh "whoami"
       sh "ls -all /var/run/docker.sock"
       sh "mv ./target/spring-boot-docker-demo*.jar ./data"

       dockerImage = docker.build("spring-boot-docker-demo")
    }

    stage('Deploy Docker Image'){

       // deploy docker image to nexus

       echo "Docker Image Tag Name: ${dockerImageTag}"

       sh "docker login -u admin -p admin123 ${dockerRepoUrl}"
       sh "docker tag ${dockerImageName} ${dockerImageTag}"
       sh "docker push ${dockerImageTag}"
    }

}