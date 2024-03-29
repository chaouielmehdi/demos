#!/bin/bash

source_secrets() {
        export SECRETS_DIR=/run/secrets
        if [ -d ${SECRETS_DIR} ] ; then
                # Sourcing secrets as ENV vars
                for VAR_NAME in $(ls -1 ${SECRETS_DIR}) ; do
                        VAR_VALUE=$(cat ${SECRETS_DIR}/${VAR_NAME})
                        export "$VAR_NAME"="$VAR_VALUE"
                done
        fi
}

source_secrets

java $JAVA_OPTS  -jar /app/app.jar
