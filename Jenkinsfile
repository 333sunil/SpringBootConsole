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
				        sh 'gradle build --no-daemon'
				    }
        		}
        	}
        	post {
        		failure {
				    sh 'exit 1'
				}
        	}
        }
        stage("Containerize") {
			stages {
				stage('Build Docker Image') {
				    steps {
				    	sh 'docker build -t springconsole:0.1 -f Dockerfile .'
				    }
				}
				stage('Test Docker Image') {
					agent { 
						docker { 
							image 'springconsole:0.1'
						} 
					}
				    steps {
				        sh 'java -version'
				        sh 'java -jar /app/SpringBootConsole.jar arg1'
				    }
				}
			}
        }
    }
}
