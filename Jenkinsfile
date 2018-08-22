node {
   def mvnHome
   stage('Preparation') { // for display purposes
      // Get code from a GitHub repository
      //git credentialsId: 'dbbd0007-7d31-43b8-adc4-7833e1cfd752', url: 'git@github.com:csbc92/jenkins-workshop.git'
      
      checkout scm
   }
   stage('Build') {
      sh 'mvn clean package'
   }
   stage('Javadoc') {
       // Run the goal site, which requires the Site plugin in POM file
       // Output is in folder target/site
       sh 'mvn site'
       archiveArtifacts 'target/site/*'
       
       // This archive are build already in with the build stage.
       // Requires the java-docs plugin in POM file
       archiveArtifacts 'target/apidocs/*'
   }
   stage('Results') {
      junit '**/target/surefire-reports/TEST-*.xml'
      archiveArtifacts 'target/*.jar'
   }
}
