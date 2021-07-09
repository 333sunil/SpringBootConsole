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
        	agent { 
        		dockerfile {
        			filename 'Dockerfile'
        		} 
        	}
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
