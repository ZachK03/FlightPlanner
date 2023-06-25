pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                git branch: 'main', url: 'https://github.com/ZachK03/FlightPlanner.git'
                bat './mvnw clean compile'
            }
        }
    }
}
