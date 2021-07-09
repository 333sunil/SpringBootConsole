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
				        sh 'gradle build'
				    }
        		}
        	}
        }
        stage("Containerize") {
			stages {
				stage('Build Docker Image') {
				    steps {
				    	sh 'docker build -t SpringConsole:0.1 -f Dockerfile .'
				    }
				}
				stage('Test Docker Image') {
					agent { 
						docker { 
							image 'SpringConsole:0.1'
						} 
					}
				    steps {
				        sh 'java -version'
				        sh 'java -jar SpringBootConsole.jar arg1'
				    }
				}
			}
        }
    }
}
