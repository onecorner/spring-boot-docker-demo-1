node {
   stage('Clone Repository') {
        checkout scm
   }
   stage('Build Maven Image') {
        docker.build("maven-build")
   }

   stage('Run Maven Container') {

        //Remove maven-build-container if it exists
        sh " docker rm -f maven-build-container"

        //Run maven image
        sh "docker run --rm --name maven-build-container maven-build"
   }

   stage('Deploy Spring Boot Application') {

         //Remove maven-build-container if it exists
        sh " docker rm -f java-deploy-container"

        sh "docker run --name java-deploy-container --volumes-from maven-build-container -d -p 8080:8080 172.21.64.110:8081/spring-boot-docker-demo"
   }

}