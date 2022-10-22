pipeline {
    agent any

    stages {
        stage ('Maven Compile Stage') {

            steps {
                withMaven(maven : 'maven_3_8_5') {
                	echo 'cleaning....!'
                    sh 'mvn clean compile'
                }
            }
        }

        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'maven_3_8_5') {
			  echo 'testing....'
                    sh 'mvn test'
                }
            }
        }
    }
}