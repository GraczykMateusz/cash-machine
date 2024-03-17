FROM openjdk:21

RUN mkdir /opt/app

EXPOSE 8080

COPY delivery/target/cash-machine-*.jar /opt/app/cash-machine.jar

CMD ["java", "-jar", "/opt/app/cash-machine.jar"]

