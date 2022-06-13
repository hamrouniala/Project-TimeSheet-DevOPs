
pipeline {
    agent any
    tools {
        maven 'apache-maven-3.0.1' 
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
