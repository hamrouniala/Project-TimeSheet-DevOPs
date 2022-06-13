
pipeline {
    agent any
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
