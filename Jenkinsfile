pipeline {
    agent any

    tools {
        maven 'Maven 3.9.6'
        jdk 'JDK 17'
    }

    stages {
        stage('Compilar') {
            steps {
                dir('C:\\Users\\gorse\\OneDrive\\Desktop\\AS222S6\\demo') {
                    sh 'mvn clean install -DskipTests'
                }
            }
        }

        stage('Pruebas') {
            steps {
                dir('C:\\Users\\gorse\\OneDrive\\Desktop\\AS222S6\\demo') {
                    sh 'mvn test'
                }
            }
        }

        stage('Empaquetar') {
            steps {
                dir('C:\\Users\\gorse\\OneDrive\\Desktop\\AS222S6\\demo') {
                    sh 'mvn package -DskipTests'
                }
            }
        }
    }

    post {
        success {
            echo '✅ Build completado localmente.'
        }
        failure {
            echo '❌ Algo falló en el build.'
        }
    }
}
