pipeline {
  agent any
  stages {
    stage('checkout') {
      steps {
        echo 'Hello'
        git(url: 'https://github.com/mcurcija/s2i-enroute-demo.git', branch: 'master', changelog: true)
      }
    }
    stage('build') {
      steps {
        dir(path: 's2i-enroute-demo') {
          tool(type: 'hudson.plugins.gradle.GradleInstallation', name: 'gradle')
          jobDsl(scriptText: 'def GRADLE_HOME = tool name: \'gradle\', type: \'hudson.plugins.gradle.GradleInstallation\'     sh "${GRADLE_HOME}/bin/gradle tasks"')
        }
        
        sh 'env'
      }
    }
    stage('ship') {
      steps {
        echo 'shipping ...'
      }
    }
  }
}