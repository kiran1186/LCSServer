# LCSServer
This is Spring-boot application to fetch Longest Common Substrings from the given input SetofStrings.
### Instructions for Deployment and Running the Application
The LCS service is built using Spring-boot starter web which proides inbuild REST implementation.
1)Download the LCSServer.zip file and unzip it and place it in workspace. (For EX: C:\Workspace\LCSServer)
2)LCSServer project you can import in Intellij or Eclipse IDE and you can execute as Spring Application.
OR
3)Make sure that JAVA & Maven is installed in the System, if not sure please follow below.
•	Right click on My Computer >> Properties >> Advanced system settings >> System Properties window will get displayed Under Advanced >> Environment Variables
•	Click on New to set Environment Variables
•	Variable name: JAVA_HOME Variable value: C:\Program Files\Java\jdk1.8.0_201
•	Variable name: M2_HOME Variable value: C:\Program Files\apache-maven-3.8.1-bin
•	Variable name: Path Variable value: %M2_HOME%\bin
•   Verify the same by giving command in cmd terminal: mvn -v  and it should provide the maven version.

4) Open the terminal/cmd go to pom.xml path which is EX: C:\Workspace\LCSServer & execute the below for cleaning and packaging using MVN plugins
mvn clean package spring-boot:repackage

5) java -jar target\LCSServer-0.0.1-SNAPSHOT.jar
Execute the above command for running Spring-boot application which defaults to 8080 port, once you see below line it means service is up and ready for execution.
<TIMESTAMP>--- [           main] c.a.c.l.LcsServerApplicationTests        : Started LcsServerApplicationTests in 11.233 seconds (JVM running for 18.108)


6) http://localhost:8080/
Enter in the browser and you can see Home page screen.

7) Open the Postman for API verification, create new API request & use the below as information OR find the JSON request collection in src/main/test directory and import it to Postman.
URL value: http://localhost:8080/lcs
METHOD: HTTP POST 

Headers:
Content-Type: application/json

REQUEST BODY:

{
"setOfStrings": [
{"value": "comcast"},
{"value": "comcastic"},
{"value": "broadcomcaster"}
]
}
