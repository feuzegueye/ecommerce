pipeline {
     agent any

    stages {
        stage('Build') {
            steps {
             bat 'mvn clean compile'     
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
