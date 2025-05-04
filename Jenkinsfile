pipeline {
    agent any
    tools {
        maven 'Maven396'  // Usa el nombre exacto configurado en Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                // Clonar el repositorio Git
                git branch: 'master', url: 'https://github.com/ElserManuel/TesJenkins.git'
            }
        }

        stage('Verificar Ambiente') {
            steps {
                sh 'echo "PATH = ${PATH}"'
                sh 'which java'
                sh 'java -version'
                sh 'which mvn'
                sh 'mvn -v'
            }
        }

        stage('Compilar') {
            steps {
                sh '''
                    export JAVA_HOME=/opt/java/openjdk
                    mvn clean install -DskipTests
                '''
            }
        }

        stage('Pruebas') {
            steps {
                sh '''
                    export JAVA_HOME=/opt/java/openjdk
                    mvn test
                '''
            }
        }

        stage('Empaquetar') {
            steps {
                sh '''
                    export JAVA_HOME=/opt/java/openjdk
                    mvn package -DskipTests
                '''
            }
        }
    }

    post {
        success {
            echo '✅ Build completado exitosamente.'
            archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
        }
        failure {
            echo '❌ Algo falló en el build.'
        }
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}