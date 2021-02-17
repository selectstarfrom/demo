pipeline {
    agent any
    tools {
        maven "mymaven363"
    }

    properties([
            parameters([
                    gitParameter(branch: '',
                            branchFilter: 'origin/(.*)',
                            defaultValue: 'master',
                            description: '',
                            name: 'BRANCH',
                            quickFilterEnabled: false,
                            selectedValue: 'NONE',
                            sortMode: 'NONE',
                            tagFilter: '*',
                            type: 'PT_BRANCH')
            ])
    ])
    stages {
        stage('Checkout') {
            steps {
                echo 'Running Stage: Checkout >>>'
//                git credentialsId: 'cred_github', url: 'https://github.com/selectstarfrom/demo'
                git credentialsId: 'cred_github', branch: "${params.BRANCH}", url: 'https://github.com/selectstarfrom/demo.git'
            }
        }
        stage('Build') {
            steps {
                echo 'Running Stage: Build >>>'
//            sh "mvn -Dmaven.test.failure.ignore=true clean package"
                sh "mvn clean package"
            }
        }
        stage('Notify') {
            steps {
                echo 'Running Stage: Notify >>>'
                mail bcc: '', body: 'Jenkins build demo project', cc: '', from: 'codfrz@gmail.com', replyTo: '', subject: 'Demo Jenkins', to: 'this4coding@gmail.com'
            }
        }
    }
}
