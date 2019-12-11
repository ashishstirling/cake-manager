FROM openjdk:8-jre-alpine
COPY target/cakemgr-0.0.1-SNAPSHOT.war /cakemgr-0.0.1-SNAPSHOT.war
CMD ["/usr/bin/java", "-jar", "/cakemgr-0.0.1-SNAPSHOT.war"]