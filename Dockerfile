FROM openjdk:8u131-jre

MAINTAINER vijaya krishna "vijayakrishnajava@gmail.com"

ADD rollingstone-templateapi.jar webapp.jar

CMD ["java","-Xmx50m","-jar","webapp.jar"]
