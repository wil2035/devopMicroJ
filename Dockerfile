FROM openjdk:11-jre
WORKDIR /app
COPY ./target/microjava-1.0.0.jar .
EXPOSE 6000

CMD ["java", "-jar", "microjava-1.0.0.jar"]
