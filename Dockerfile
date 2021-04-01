FROM openjdk:11
VOLUME /tmp
ADD ./target/stock-0.0.1-SNAPSHOT.jar stock-manager.jar
ENTRYPOINT ["java", "-jar", "/stock-manager.jar"]