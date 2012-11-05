#!/bin/bash

SOURCE="${BASH_SOURCE[0]}"
while [ -h "$SOURCE" ] ; do SOURCE="$(readlink "$SOURCE")"; done
PWD="$( cd -P "$( dirname "$SOURCE" )" && pwd )"

# -----------------------------------------------------------------------
# Application's JAR
# -----------------------------------------------------------------------

BLUEPRINT=$PWD/jar/swingit.jar

java -Dprogram.name="swingit.sh" -Dfile.encoding=UTF8 -classpath "$PWD":"$BLUEPRINT" org.swingit.runtime.Run %*

