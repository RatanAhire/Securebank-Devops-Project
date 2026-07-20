# ==========================================
# Base Image
# ==========================================

FROM tomcat:10.1-jdk17

# Remove Default Applications

RUN rm -rf /usr/local/tomcat/webapps/*

# Copy WAR File

COPY target/OnlineBankingPortal.war \
/usr/local/tomcat/webapps/ROOT.war

# Expose Port

EXPOSE 8080

# Start Tomcat

CMD ["catalina.sh","run"]