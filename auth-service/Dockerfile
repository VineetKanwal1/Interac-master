FROM java:8-jre
MAINTAINER Vineet Kanwal

ADD ./target/auth-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/auth-service.jar"]

EXPOSE 5000