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
       	  echo 'Hello'
        }
      }
    }
    stage('ship') {
      steps {
        echo 'building ...'
    	def GRADLE_HOME = tool name: 'gradle', type: 'gradle'
    	sh '${GRADLE_HOME}/bin/gradle tasks'        
      }
    }
  }
}