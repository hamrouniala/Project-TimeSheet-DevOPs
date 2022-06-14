
pipeline {
    agent any
    tools {
        maven '3.6.3' 
    }
    
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
                sh "ls .mvn "
                sh "chmod +x mvnw
                sh ''' ./mvnw deploy:deploy-file \
                             -DgroupId=tn.esprit \
                             -DartifactId=Timesheet \
                             -Dversion=1.0 \
                             -DgeneratePom=true \
                             -Dpackaging=war \
                             -DrepositoryId=deploymentRepo \
                             -Durl=http://localhost:8081/repository/maven-releases/ \
                             -Dfile=target/Timesheet-1.0.war
                    '''
            }
        }
    }
}
