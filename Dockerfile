FROM openjdk:11-jre
LABEL maintainer="BCP-BOOTCAMP"
COPY build/libs/bootcamp-shopvintage-apigateway-*SNAPSHOT.jar /opt/bootcamp-shopvintage-apigateway.jar
ENTRYPOINT ["java", "-Djava.file.encoding=UTF-8","-jar","/opt/bootcamp-shopvintage-apigateway.jar"]

## MULTI-STAGE
## Compilar, ejecutar test y Crear artefacto JAR
#FROM openjdk:11 AS BUILD_IMAGE
#ENV APP_HOME=/root/dev/app/
#RUN mkdir -p $APP_HOME/src/main/java
#WORKDIR $APP_HOME
#COPY build.gradle gradlew gradlew.bat $APP_HOME
#COPY gradle $APP_HOME/gradle
#COPY . .
#
#RUN ./gradlew --stacktrace clean test build
#
#RUN ls -lha
#
## Ejecutar la aplicación
#FROM openjdk:11-jre
#LABEL maintainer="BCP-BOOTCAMP"
#WORKDIR /root/
#COPY --from=BUILD_IMAGE /root/dev/app/build/libs/bootcamp-shopvintage-apigateway-*SNAPSHOT.jar /opt/bootcamp-shopvintage-apigateway.jar
#CMD ["java","-jar","/opt/bootcamp-shopvintage-apigateway.jar"]