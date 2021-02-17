pipeline {
    agent any
    tools {
        maven "mymaven363"
    }

//    parameters {
//        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'main', name: 'BRANCH', type: 'PT_BRANCH'
//    }

//    properties([
//            parameters([
//                    gitParameter(branch: '',
//                            branchFilter: 'origin/(.*)',
//                            defaultValue: 'master',
//                            description: '',
//                            name: 'BRANCH',
//                            quickFilterEnabled: false,
//                            selectedValue: 'NONE',
//                            sortMode: 'NONE',
//                            tagFilter: '*',
//                            type: 'PT_BRANCH')
//            ])
//    ])
    stages {
        stage('Checkout') {
            steps {
                echo 'Running Stage: Checkout >>>'
//                git credentialsId: 'cred_github', url: 'https://github.com/selectstarfrom/demo'
                git credentialsId: 'cred_github', branch: "${params.BRANCH}", url: 'https://github.com/selectstarfrom/demo.git'
                sh 'git branch -r | awk \'{print $1}\' ORS=\'\\n\' >>branch.txt'
            }
        }
        stage('get build Params User Input') {
            steps{
                script{

                    liste = readFile 'branch.txt'
                    echo "please click on the link here to chose the branch to build"
                    env.BRANCH_SCOPE = input message: 'Please choose the branch to build ', ok: 'Validate!',
                            parameters: [choice(name: 'BRANCH_NAME', choices: "${liste}", description: 'Branch to build?')]


                }
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
