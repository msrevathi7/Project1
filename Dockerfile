FROM  amazoncorretto:17.0.7-alpine
EXPOSE 8089
ADD target/employee-jenkins-0.0.1-SNAPSHOT.war employee-jenkins-0.0.1-SNAPSHOT.war
ENTRYPOINT [ "java","-jar","/employee-jenkins-0.0.1-SNAPSHOT.war" ]