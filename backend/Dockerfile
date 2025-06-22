FROM openjdk:23-ea-2-oracle

#copy the jar file
COPY target/DeliveryMatch-0.0.1-SNAPSHOT.jar deliverymatch-app.jar
#run the app
ENTRYPOINT ["java","-jar","/deliverymatch-app.jar"]