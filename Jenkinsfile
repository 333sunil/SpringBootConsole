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
        stage("Docker Build and Test") {
        	agent { 
        		docker { 
        			image 'gradle:jdk8' 
        			reuseNode true
        		} 
        	}
        	stages {
        		stage("Build") {
        			steps {
				        sh 'gradle build -x test'
				    }
        		}
        	}
        }
        stage("Containerize") {
        	agent { dockerfile true }
			stages {
				stage('Test Docker') {
				    steps {
				        sh 'java -version'
				        sh 'java -jar SpringBootConsole.jar arg1'
				    }
				}
			}
        }
    }
}
