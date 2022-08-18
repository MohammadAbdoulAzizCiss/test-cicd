pipeline{
    agent any
    environment {
         imageName = "notification-service"
         dockerImage = ''
         version = "${BUILD_ID}"

        }
    tools {
        maven 'MavenJenkins'
        dockerTool 'DockerJenkins'
    }
    stages{
           stage('Build'){
                steps{
                    sh script: 'mvn clean install'
                }
            }
            stage('Test'){
                steps{
                    sh script: 'mvn test'
                }
            /*post{
                                    always{
                                    junit '/var/jenkins_home/workspace/MonDeuxiemePipeline/target/surefire-reports/TEST-*.xml'

                                    }
                                }*/

                            }
              stage('SonarQube analysis') {
                    steps{
                        withSonarQubeEnv(credentialsId: 'sonarJenkins', installationName:"SonarJenkins") {
                        sh 'mvn sonar:sonar'
                    }
              }
             }

            /*      stage("Quality Gate") {
                    steps {
                      timeout(time: 2, unit: 'MINUTES') {
                        waitForQualityGate abortPipeline: false
                      }
                    }
                  } */

            stage('Build image') {
              steps{
                script {
                  dockerImage = docker.build imageName
                }
              }
            }
            stage('Push') {
              steps{
                script {
                        sh 'docker tag notification-service  192.168.202.184:8083/notification-service:$version'
                        sh 'docker tag notification-service  192.168.202.184:8083/notification-service:latest'
                        sh 'docker login  192.168.202.184:8083/notification-service:latest -u admin -p admin'
                        sh 'docker push  192.168.202.184:8083/notification-service:$version'
                        sh 'docker push  192.168.202.184:8083/notification-service:latest'
                }
              }
            }
//             stage('Deploying') {
//               steps {
//                 script {
//                   kubernetesDeploy(configs: "deploymentservice.yml", kubeconfigId: "kubernetes")
//                 }
//               }
//             }
    }
}
