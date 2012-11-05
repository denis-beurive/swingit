@ECHO OFF

set PWD=%~dp0

REM ----------------------------------------------------------------------------------
REM Application's JAR.
REM ----------------------------------------------------------------------------------

set BLUEPRINT=%PWD%jar\swingit.jar

REM ----------------------------------------------------------------------------------
REM Run the application with the correct class path.
REM
REM WARNING!
REM
REM The paths that appear in the class' path must *NOT* end with the character "\"!
REM    WRONG: -classpath "%PWD%"
REM    OK:    -classpath "%PWD%."
REM ----------------------------------------------------------------------------------

java -Dprogram.name="swingit.bat" ^
     -Dfile.encoding=UTF8 ^
     -classpath "%PWD%.";"%BLUEPRINT%" ^
     org.swingit.runtime.Run %*



