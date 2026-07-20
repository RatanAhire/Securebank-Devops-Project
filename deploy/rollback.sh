#!/bin/bash

LATEST_BACKUP=$(ls -t /opt/backups/*.war | head -1)

echo "Stopping Tomcat..."

systemctl stop tomcat

cp $LATEST_BACKUP \
/opt/tomcat/webapps/SecureBank.war

echo "Starting Tomcat..."

systemctl start tomcat

echo "Rollback completed."