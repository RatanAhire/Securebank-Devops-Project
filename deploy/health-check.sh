#!/bin/bash

URL=http://localhost:8080/SecureBank

STATUS=$(curl -o /dev/null -s -w "%{http_code}" $URL)

if [ "$STATUS" -eq 200 ]

then

echo "Application is UP"

else

echo "Application is DOWN"

exit 1

fi