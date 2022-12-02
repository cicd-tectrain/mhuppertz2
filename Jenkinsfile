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
                sh 'gradle clean build -x'
            }
        }
        stage('Test Feature'){
            steps{
                echo 'Test Feature'
            }
        }
        stage('Integrate Feature'){
            steps{
                echo 'Integrate Feature'
            }
        }
    }
}