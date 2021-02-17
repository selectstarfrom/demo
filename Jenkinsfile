pipeline {
    agent any
    tools {
        maven "mymaven363"
    }

    GITHUB_PROJECT = "https://github.com/selectstarfrom/demo.git"
    GITHUB_CREDENTIALS_ID = "cred_github" //maps to a Jenkins Credentials Vault ID
    APPLICATION_NAME = "Telcel"
    GITHUB_BRANCH = '${env.BRANCH_NAME}'

    stages {
        stage(" Listing Branches ") {
            echo "Initializing workflow "
            //checkout code
            echo GITHUB_PROJECT
            git url: GITHUB_PROJECT, credentialsId: GITHUB_CREDENTIALS_ID
            sh 'git branch - r | awk \'{print $1}\' ORS=\'\\n\' >branches.txt'
//            sh "'cut - d'/' -f 2 branches.txt > branch.txt"'
//            / / sh " sed s ' /origin" \ '///g branches.txt > branch.tx"
//sed 's/$/from S0 to S1/'
        }

        stage('get build branch Parameter User Input') {

            liste = readFile 'branch.txt'
            echo "please click on the link here to chose the branch to build"
            env.BRANCH_SCOPE = input message: 'Please choose the branch to build ', ok: 'Validate!',
                    parameters: [choice(name: 'BRANCH_NAME', choices: "${liste}", description: ' Branch to build ? ')]
        }

        stage('Checkout external proj') {
            echo "${env.BRANCH_SCOPE}"
            git branch: "${env.BRANCH_SCOPE}",
                    credentialsId: 'Telcel',
                    url: 'https://github.com/zagadishreddy/game-of-life.git'

            sh "ls -lat"
        }
    }
//    stage('Checkout') {
//        steps {
//            echo 'Running Stage: Checkout >>>'
////                git credentialsId: 'cred_github', url: 'https://github.com/selectstarfrom/demo'
//            git credentialsId: 'cred_github', branch: "${params.BRANCH}", url: 'https://github.com/selectstarfrom/demo.git'
//            sh 'git branch -r | awk \'{print $1}\' ORS=\'\\n\' >>branch.txt'
//        }
//    }
    stage('get build Params User Input') {
        steps {
            script {

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
