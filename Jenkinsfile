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
            }
        }
        stage("Build") {
        	agent { 
        		docker { 
        			image 'gradle:jdk8' 
        			reuseNode true
        		} 
        	}
            steps {
                sh 'gradle build -x test'
            }
        }
        stage("Test") {
            steps {
                sh 'gradle check'
            }
            post {
                always {
                    junit 'build/test-results/test/*.xml'
                 }
            }
        }
    }
}
