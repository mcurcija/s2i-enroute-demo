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
          tool(name: 'GRADLE', type: 'gradle')
        }
        
      }
    }
    stage('ship') {
      steps {
        echo 'shipping ...'
      }
    }
  }
}