pipeline {
  agent {
    node {
      label 'demo'
    }

  }
  stages {
    stage('') {
      steps {
        git(url: 'https://github.com/shadow99g/TraductorApi.git', branch: 'master', changelog: true)
      }
    }
  }
}