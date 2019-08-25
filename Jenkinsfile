node {
    checkout scm

    def mavenImage = docker.image('maven:3-alpine').withRun() { c ->
        sh "ls"
        sh "pwd"
        sh "echo maven-run"
    }

    mavenImage.inside {
        state("build"){
             sh "mvn --version"
        }
    }
}