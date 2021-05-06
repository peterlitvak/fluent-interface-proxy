#!/bin/bash
##
# $1 - version
# $2 - full pach to the project build directory
# $3 - full path top the local repo
##
mvn install:install-file -DgroupId=com.github.davidmarquis \
  -DartifactId=fluent-interface-proxy -Dversion=$1 \
  -Dfile=$2/target/fluent-interface-proxy-$1.jar \
  -Dsources=$2/target/fluent-interface-proxy-$1-sources.jar \
  -Djavasoc=$2/target/fluent-interface-proxy-$1-javadoc.jar \
  -Dpackaging=jar \
  -DgeneratePom=true \
  -DlocalRepositoryPath=$3 \
  -DcreateChecksum=true \
  -DpomFile=$2/pom.xml
