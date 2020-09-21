pipeline {
     agent any

    stages {
        stage('Build') {
            steps {
              git clone  'https://github.com/feuzegueye/ecommerce.git'      
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
