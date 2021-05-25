#!/bin/sh

APPNAME="Search tool"
APPJAR=./target/search-1.0.0-SNAPSHOT-search.jar
TERMS=$1

source ./scripts/setenv.sh

java -jar $APPJAR "$TERMS" >> /dev/null
