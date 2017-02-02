FROM java:8-jre
MAINTAINER Vineet Kanwal

ADD ./target/registry.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/registry.jar"]

EXPOSE 8761