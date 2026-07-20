#!/bin/bash

echo "Cleaning workspace..."

rm -rf target/

echo "Removing old WAR..."

rm -f /opt/tomcat/webapps/SecureBank.war

echo "Cleanup completed."