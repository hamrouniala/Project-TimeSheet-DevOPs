
pipeline {
  environment {

        registry = "alahamrouni10/timesheet"

        registryCredential = 'alahamrouni10-dockerhub'

        dockerImage = ''

    }
    agent any
   
    
    stages {
        stage('Cloning Project from Git')
        {
            steps
            {
               git branch:'master', url:"https://github.com/hamrouniala/Project-TimeSheet-DevOPs"
            }
        }
         stage("Clean")
        {
            steps
            {
                sh "mvn clean"
            }
        }

        stage("UNit tests")
        {
            steps
            {
                sh "mvn test"
            }
        }
         
        
        stage(" Test SOnar")
        {
            steps
            {
                sh "mvn sonar:sonar"
            }
        }
        stage(" Packaging")
        {
            steps
            {
                sh "mvn package"
            }
        }

   }
    stage('Building our image') {
               steps {
                   script {
                       sh "docker version"
                       dockerImage = docker.build registry + ":$BUILD_NUMBER"
                   }
               }
           }
           stage('Deploy our image') {
                   steps {
                   script {
                       docker.withRegistry( '', registryCredential ) {
                           dockerImage.push()
                       }
                   }
               }
           }
           stage('Cleaning up') {
               steps {
                   sh "docker rmi $registry:$BUILD_NUMBER"
               }
           }
 }

          }
        
