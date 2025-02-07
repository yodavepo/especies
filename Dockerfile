FROM openjdk:17-oracle
LABEL maintainer="David V.P. <davepo@ib.unam.mx>"
EXPOSE 8081
ARG JAR_FILE=target/*.jar
COPY target/*.jar app.jar
CMD ["java", "-jar", "/app.jar"]
