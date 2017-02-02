FROM java:8-jre
MAINTAINER Vineet Kanwal

ADD ./target/config.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/config.jar"]

EXPOSE 8888