pipeline {
    agent any
    tools {
        maven "mymaven363"
    }

    stages {
        stages('Checkout') {
            git credentialsId: 'cred_github', url: 'https://github.com/selectstarfrom/demo'
        }
        stage('Build') {
//            sh "mvn -Dmaven.test.failure.ignore=true clean package"
            sh "mvn clean package"
        }
        stage('Notify') {
            mail bcc: '', body: 'Jenkins build demo project', cc: '', from: 'codfrz@gmail.com', replyTo: '', subject: 'Demo Jenkins', to: 'this4coding@gmail.com'
        }
    }
}