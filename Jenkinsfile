pipeline {
    agent any
    tools {
        maven "mymaven363"
    }

    stages {
        stage('Checkout') {
            steps {
                git credentialsId: 'cred_github', url: 'https://github.com/selectstarfrom/demo'
            }
        }
        stage('Build') {
            steps {
//            sh "mvn -Dmaven.test.failure.ignore=true clean package"
                sh "mvn clean package"
            }
        }
        stage('Notify') {
            steps {
                mail bcc: '', body: 'Jenkins build demo project', cc: '', from: 'codfrz@gmail.com', replyTo: '', subject: 'Demo Jenkins', to: 'this4coding@gmail.com'
            }
        }
    }
}