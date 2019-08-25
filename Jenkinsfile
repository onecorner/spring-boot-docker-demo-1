node {
    checkout scm

    docker.image('maven:3-alpine').withRun() { c ->
        sh "ls"
        sh "pwd"
        sh "echo maven-run"
        docker.image('maven:3-alpine').inside {
            state("build"){
                sh "mvn --version"
            }
        }
    }
}