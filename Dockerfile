FROM tomcat:8.0.50-jre8

MAINTAINER <omeruluoglu@gmail.comr>

RUN mkdir -p /usr/local/tomcat/properties

RUN rm -rf /usr/local/tomcat/webapps/ROOT

COPY case-middleware/target/case-middleware-1.0.0.war /usr/local/tomcat/webapps/ROOT.war

COPY case-middleware/src/main/resources/application.properties /usr/local/tomcat/properties/application.properties
