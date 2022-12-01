pipeline{
    agent any
    stages{
        stage('Hello'){
            steps{
                echo 'Hello World'
            }
        }
        stage('Master-only'){

            when{
                branch 'master'
            }
            steps{
                echo 'Auf Master branch'
            }
        }
        stage('Integration-only'){

           when{
               branch 'integration'
                  }
                   steps{
                     echo 'Auf Integration branch'
                   }
               }
           }
        }
        stage('Feature-only'){

           when{
               branch 'feature/*'
                  }
                   steps{
                     echo 'Auf Feature branch'
                   }
               }
           }
        }
    }
}