#!/bin/sh

APPNAME="Indexing tool"
APPJAR=./target/search-1.0.0-SNAPSHOT-index.jar

source ./scripts/setenv.sh

[ ! -d "$SEARCH_INDEX_PATH" ] && mkdir -p "$SEARCH_INDEX_PATH"

java -jar $APPJAR >> /dev/null
