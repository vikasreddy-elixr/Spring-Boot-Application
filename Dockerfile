FROM openjdk:17
LABEL maintainer="anyName"
ADD target/Spring_Boot_Application_jar Spring_Boot_Application.jar
ENTRYPOINT ["java", "-jar", "Spring_Boot_Application.jar"]
