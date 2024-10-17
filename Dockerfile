FROM openjdk:11
EXPOSE 8080
COPY target/Book-App.jar Book-App.jar
ENTRYPOINT ["java","-jar","/Book-App.jar"]
