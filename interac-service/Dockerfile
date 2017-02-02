FROM java:8-jre
MAINTAINER Vineet Kanwal

ADD ./target/interac-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/interac-service.jar"]

EXPOSE 6000