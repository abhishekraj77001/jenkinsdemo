FROM openjdk:8
EXPOSE 8084
ADD target/jenkinsdemo.jar jenkinsdemo.jar
ENTRYPOINT ["java","-jar","/jenkinsdemo.jar"]