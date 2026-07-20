#!/bin/bash

BACKUP_DIR=/opt/backups

DATE=$(date +%Y%m%d_%H%M%S)

mkdir -p $BACKUP_DIR

cp /opt/tomcat/webapps/SecureBank.war \
$BACKUP_DIR/SecureBank_$DATE.war

echo "Backup completed successfully."