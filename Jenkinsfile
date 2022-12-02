pipeline{
    agent any
    environment {
        INTEGRATION_BRANCH = 'integration'
    }
    stages{

        stage('Build Feature'){

            // limit branches
            when{
                branch 'feature/*'
                beforeAgent true
            }
            // Docker Agent
            agent{
                docker{
                    image 'gradle:7.5.1-jdk17-focal'
                }
            }
            steps{
                echo 'Build Feature'
                sh 'ls -l'
                sh 'gradle --version'
                sh 'gradle clean build -x test'
                sh 'ls -la build/libs'
            }
        }
        stage('Test Feature'){
            // limit branches
            when{
                branch 'feature/*'
                beforeAgent true
            }
            // Docker Agent
            agent{
                docker{
                    image 'gradle:7.5.1-jdk17-focal'
                }
            }
            steps{
                echo 'Test Feature'
                sh 'gradle test'
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
            // limit branches
            when{
                branch 'feature/*'
                beforeAgent true
            }
            steps{
                echo 'Integrate Feature'
                sh 'git --version'
                sh 'git branch -a'
                sh 'git checkout integration'
                sh 'git pull'
                // todo find correct branch name
                sh 'git merge remotes/origin/feature/1'

                // push
                //withCredentials([gitUsernamePassword(credentialsId: 'github_token', gitToolName: 'Default')]){
                withCredentials([gitUsernamePassword(credentialsId: 'ac738b71-20de-4cb7-aa10-0f0213e75700', gitToolName: 'Default')]){
                    sh 'git push origin integration'
                }
            }
        }

        // ===================== INTEGRATION =======================

        stage('Build Integration'){

            // limit branches
            when{
                branch "${INTEGRATION_BRANCH}"
                beforeAgent true
            }
            // Docker Agent
            agent{
                docker{
                    image 'gradle:7.5.1-jdk17-focal'
                }
            }
            steps{
                echo 'Build Feature'
                sh 'ls -l'
                sh 'gradle --version'
                sh 'gradle clean build -x test'
                sh 'ls -la build/libs'
            }
        }
        stage('Test Integration'){
            // limit branches
            when{
                branch "${INTEGRATION_BRANCH}"
                beforeAgent true
            }
            // Docker Agent
            agent{
                docker{
                    image 'gradle:7.5.1-jdk17-focal'
                }
            }
            steps{
                echo 'Test Feature'
                sh 'gradle test'
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

        //stage('Integrate Integration'){
        //    // limit branches
        //    when{
        //        branch "${INTEGRATION_BRANCH}"
        //        beforeAgent true
        //    }
        //    steps{
        //        echo 'Integrate Feature'
        //        sh 'git --version'
        //        sh 'git branch -a'
        //        sh 'git checkout integration'
        //        sh 'git pull'
        //        // todo find correct branch name
        //        sh 'git merge remotes/origin/feature/1'
        //
        //        // push
        //        //withCredentials([gitUsernamePassword(credentialsId: 'github_token', gitToolName: 'Default')]){
        //        withCredentials([gitUsernamePassword(credentialsId: 'ac738b71-20de-4cb7-aa10-0f0213e75700', gitToolName: 'Default')]){
        //            sh 'git push origin integration'
        //        }
        //    }
        //}


    }
}