FROM eclipse-temurin:17-jre-focal
ADD target/*.jar mynikerunsdataloader.jar
RUN sh -c 'touch /mynikerunsdataloader.jar'
EXPOSE 8080
ENTRYPOINT [ "sh", "-c", "java -jar /mynikerunsdataloader.jar" ]
