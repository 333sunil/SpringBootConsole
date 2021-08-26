pipeline {
    agent any
    options {
            timestamps()
            buildDiscarder logRotator(numToKeepStr: '10')
            preserveStashes()
            skipDefaultCheckout()
    }
    stages {
        stage("Checkout") {
            steps {
                deleteDir()
                checkout scm
                script {
                	env.GIT_URL = sh(returnStdout: true, script: 'git config remote.origin.url').trim()
                	env.GIT_COMMIT = sh(returnStdout: true, script: 'git rev-parse HEAD')
                }
                //sh 'chmod +x gradlew' 
                sh 'env'
            }
        }
    }
}
