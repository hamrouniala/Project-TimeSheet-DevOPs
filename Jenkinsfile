
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

        stage("Deploy artifact to nexus") {
            steps
            {
          sh "mvn clean package -DskipTests deploy:deploy-file -DgroupId=com.esprit.spring -DartifactId=Timesheet -Dversion=1.0 -DgeneratePom=true -Dpackaging=war -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/Timesheet-1.0.war"
         
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
        
