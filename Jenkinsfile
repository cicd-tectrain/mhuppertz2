pipeline{
    agent any
    stages{

        //stage('Build Feature'){
        //    // Docker Agent
        //    agent{
        //        docker{
        //            image 'gradle:7.5.1-jdk17-focal'
        //        }
        //    }
        //    steps{
        //        echo 'Build Feature'
        //        sh 'ls -l'
        //        sh 'gradle --version'
        //        sh 'gradle clean build -x test'
        //        sh 'ls -la build/libs'
        //    }
        //}
        stage('Test Feature'){

            steps{
                echo 'Test Feature'
                //sh 'gradle test'
                //JUNit XML Reports
                sh 'ls -la build/test-results/test'
                sh 'ls -la build/reports/tests'
            }
            post {
                always{
                    junit 'build/test-results/test/*.xml'
                }
                success {
                    publishHTML target:[
                        allowMissing: true,
                        alwaysLinkToLastBuild: false,
                        keepAll: true,
                        reportDir: 'build/reports/tests/test',
                        reportFiles: 'index.html',
                        reportName: 'Test-Report'
                    ]
                }
            }
        }
        stage('Integrate Feature'){
            steps{
                echo 'Integrate Feature'
                sh 'git --version'
                sh 'git branch -a'
                sh 'git checkout integration'
                sh 'git pull'
                // todo find correct branch name
                sh 'git merge remotes/origin/feature/1'

                // push
                withCredentials([gitUsernamePassword(credentialsId: 'd2b7de2f-aa02-4ebf-9077-139b4f65a5da', gitToolName: 'Default')]){
                    sh 'git push origin integration'
                }
            }
        }
    }
}