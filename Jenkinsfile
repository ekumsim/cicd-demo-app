pipeline {
    agent any
    stages {
        stage('Docker node test') {
            steps {
                sh 'echo clean package'
                sh './mvnw clean install -DskipTests'
            }
        }
         stage('Test') {
            steps {
                 sh 'echo demo test'
                 sh './mvnw  test'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'echo image'
                 sh """
                docker images
                docker build -t ekumsim/ci-demo:v0.4 .
                docker images
                docker login -u ekumsim -p Thinkpad@1437
                docker push ekumsim/ci-demo:v0.4
                """ 
            }
        }
        stage('Push Docker Image') {
            steps {
                sh 'pwd'
                sh """
                    docker ps
                    docker run -d -p 9000:9000 ekumsim/ci-demo:v0.4
                    docker ps
                    docker stop \$(docker ps -q) 
                """
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            junit 'target/surefire-reports/*.xml'
           /*  cleanWs()
            dir("${env.WORKSPACE}@tmp") {
              deleteDir()
            }
            dir("${env.WORKSPACE}@script") {
              deleteDir()
            }
            dir("${env.WORKSPACE}@script@tmp") {
              deleteDir()
            } */
        }
    }
}
