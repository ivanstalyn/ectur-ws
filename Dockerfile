FROM adoptopenjdk:11-jre-hotspot
RUN mkdir -p /usr/wsturistico/bin /usr/wsturistico/logs \
		&& chmod -R 775 /usr/wsturistico
WORKDIR /usr/wsturistico
COPY target/webservicesapp-0.0.1-SNAPSHOT.jar .
COPY src/main/resources/application.properties /usr/backendpatitas/bin/
RUN chmod 775 webservicesapp-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "webservicesapp-0.0.1-SNAPSHOT.jar","--spring.config.location=file:///usr/wsturistico/bin/application.properties"]
EXPOSE 8080
