#!/bin/bash

echo "Checking Tomcat Status..."

systemctl status tomcat

echo ""

echo "Memory Usage"

free -h

echo ""

echo "Disk Usage"

df -h

echo ""

echo "Java Processes"

ps -ef | grep java