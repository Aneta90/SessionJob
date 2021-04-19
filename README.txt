Project version: 2021-04-19

1) Example usage using the provided test files:

  cd <project-root>
  mvn clean package
  java -jar target/SessionsJob-1.0.jar 'src/test/resources/input-statements.psv' 'target/actual-sessions.psv'
  
OR

  java -jar target/SessionsJob-1.0.jar src/test/resources/input-statements.psv target/actual-sessions.psv
  WITHOUT special character (')
  
  You can also run this App from IntelliJ adding arguments to Edit Configuration -> Program arguments -> src/test/resources/input-statements.psv target/actual-sessions.psv
  
  2) Tests:
  
  mvn -Dtest=ModifyRecordTest test
  mvn -Dtest=DurationAnalyzerTest test
  mvn -Dtest=EndTimeAnalyzerTest test
