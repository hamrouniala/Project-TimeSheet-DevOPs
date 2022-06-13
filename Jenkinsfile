
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
         stage("Build")
        {
            steps
            {
                sh "mvn compile"
            }
        }

        stage("test")
        {
            steps
            {
                sh "mvn package"
            }
        }

        stage(" Clean")
        {
            steps
            {
                sh "mvn test "
            }
        }

        stage("clean and packaging") {
            steps
            {
                mvn "mvn clean install"
            }
        }
    }
}
