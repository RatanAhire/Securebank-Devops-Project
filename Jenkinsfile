pipeline {

    agent any

    environment {

        APP_NAME = "OnlineBankingPortal"

        TOMCAT_PATH = "/opt/tomcat/webapps"

    }

    stages {

        stage('Checkout') {

            steps {

                echo "Cloning Repository..."

                git branch: 'main',
                    url: 'https://github.com/YOUR_USERNAME/OnlineBankingPortal.git'

            }

        }

        stage('Build') {

            steps {

                echo "Building Maven Project..."

                sh 'mvn clean package'

            }

        }

        stage('Deploy') {

            steps {

                echo "Deploying WAR File..."

                sh """
                cp target/OnlineBankingPortal.war ${TOMCAT_PATH}/
                """

            }

        }

        stage('Restart Tomcat') {

            steps {

                sh """
                sudo systemctl restart tomcat
                """

            }

        }

    }

    post {

        success {

            echo "Application Deployed Successfully."

        }

        failure {

            echo "Pipeline Failed."

        }

    }

}