/* 
    This is the Pretested Integration Jenkinsfile
    It enables the pretested workflow for this repository, and will automatically be picked up by Jenkins
*/
node {
    stage("checkout") {
        //Using the Pretested integration plugin to checkout out any branch in the ready namespace
        checkout(
            [$class: 'GitSCM', 
            branches: [[name: '**/ready/*']], 
            doGenerateSubmoduleConfigurations: false, 
            extensions: [[$class: 'CleanBeforeCheckout'], 
            pretestedIntegration(gitIntegrationStrategy: squash(), 
            integrationBranch: 'master', 
            repoName: 'origin')], 
            submoduleCfg: [], 
            userRemoteConfigs: [[credentialsId: 'dbbd0007-7d31-43b8-adc4-7833e1cfd752', //remember to change credentials and url.
            url: 'git@github.com:csbc92/jenkins-workshop.git']]])
    }
    stage('Build') {
      //sh 'mvn clean package'
      sh 'docker run -i -v $PWD:/usr/src/mymaven -w /usr/src/mymaven --rm maven:3-jdk-8 mvn clean package'
   }
    stage('Javadoc') {
       // Run the goal site, which requires the Site plugin in POM file
       // Output is in folder target/site
       //sh 'mvn site'
       sh 'docker run -i -v $PWD:/usr/src/mymaven -w /usr/src/mymaven --rm maven:3-jdk-8 mvn site'
       archiveArtifacts 'target/site/*'
       
       // This archive are build already in with the build stage.
       // Requires the java-docs plugin in POM file
       archiveArtifacts 'target/apidocs/*'
   }
    stage("test"){
        // run maven tests here
        //sh 'mvn test'
        sh 'docker run -i -v $PWD:/usr/src/mymaven -w /usr/src/mymaven --rm maven:3-jdk-8 mvn test'
    }
    stage('Results') {
      junit '**/target/surefire-reports/TEST-*.xml'
      archiveArtifacts 'target/*.jar'
   }
    stage("publish"){
        //This publishes the commit if the tests have run without errors
        pretestedIntegrationPublisher()
    }
}
