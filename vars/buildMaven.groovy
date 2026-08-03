def call(){

echo "======= BUILD APPLICATION ======="

sh '''
mvn clean package
'''


junit allowEmptyResults:true,
      testResults:'target/surefire-reports/*.xml'


archiveArtifacts(
artifacts:'target/*.jar',
fingerprint:true
)

}