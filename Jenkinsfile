pipeline {
    agent any

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
				sh 'docker build -t abhishekraj76578/jenkinsdemo:latest .'
			}
		}
    }
}