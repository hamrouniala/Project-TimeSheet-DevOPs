
pipeline {
    agent any
    tools {
        maven '3.8.1' 
    }
    
    stages {
        stage('Cloning Project from Git')
        {
            steps
            {
               git branch:'master', url:"https://github.com/hamrouniala/Project-TimeSheet-DevOPs"
            }
        }
         stage("clean install")
        {
            steps
            {
                sh "mvn clean install"
            }
        }

        stage("Build")
        {
            steps
            {
                sh "mvn compile"
            }
        }

        stage("Unit tests")
        {
            steps
            {
                sh "mvn test"
            }
        }

        stage("clean and packaging") {
            steps
            {
                mvn "mvn clean package"
            }
        }
    }
}
