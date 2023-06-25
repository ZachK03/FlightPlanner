pipeline {
    agent any
    //test
    stages {
        stage('Build') {
            steps {
                git branch: 'main', url: 'https://github.com/ZachK03/FlightPlanner.git'
                bat './mvnw clean compile'
            }
        }
        stage('Test') {
            steps {
                bat './mvnw test'
            }

            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
        stage('Publish') {

        }
    }
}
