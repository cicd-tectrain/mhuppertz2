pipeline{
    agent any
    stages{

        stage('Build Feature'){
            // Docker Agent
            agent{
                docker{
                    image 'gradle:7.5.1-jdk17-focal'
                }
            }
            steps{
                echo 'Build Feature'
                sh 'gradle clean build -x test'
                sh 'ls -la build/libs'
            }
        }
        stage('Test Feature'){
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
                    junit 'build/test-results/test'
                }
            }
        }
        stage('Integrate Feature'){
            steps{
                echo 'Integrate Feature'
            }
        }
    }
}