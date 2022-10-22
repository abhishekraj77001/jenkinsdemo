pipeline {
    agent any
    
    environment {
		DOCKER_HUB_LOGIN=credentials('dockerhub-cred')
	}

    stages {
        stage ('Maven Compile Stage') {

            steps {
                withMaven(maven : 'maven_3_8_5') {
                	echo 'cleaning....!'
                    sh 'mvn clean install'
                }
            }
        }

        stage ('Maven Testing Stage') {

            steps {
                withMaven(maven : 'maven_3_8_5') {
			  echo 'testing....'
                    sh 'mvn test'
                }
            }
        }
        
        
        stage('Docker Build') {

			steps {
				echo 'building docker image'
				sh 'docker build -t abhishekraj7658/jenkinsdemo:latest .'
			}
		}
		
        stage('Docker Build') {

			steps {
				echo 'building docker image'
				sh 'docker build -t abhishekraj7658/jenkinsdemo:latest .'
			}
		}
		stage('DockerHub Login') {

			steps {
				echo 'logging to docker hub'
				sh 'docker login --username=$DOCKER_HUB_LOGIN_USR --password=$DOCKER_HUB_LOGIN_PSW'
			}
		}

		stage('Push TO Dockerhub') {

			steps {
				echo 'pushing docker image to dockerhub'
				sh 'docker push abhishekraj7658/jenkinsdemo:latest'
			}
		}
		
		stage ('Deploy') {
    		steps{
       			 sshagent(credentials : ['awsjenkinsdemos1']) {
            		sh 'ssh -o StrictHostKeyChecking=no ec2-user@43.204.101.27 uptime'
            		sh 'ssh -v ec2-user@43.204.101.27'
  					echo 'conecting...ec2'
  					sh pwd
        }
    }
}
    }
    post {
		always {
			sh 'docker logout'
		}
	}
}