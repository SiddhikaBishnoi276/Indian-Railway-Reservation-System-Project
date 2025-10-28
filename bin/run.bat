@echo off
REM Go to project root
cd /d D:\finalcode

REM Compile all Java files inside src (recursively)
javac -cp ".;lib/mysql-connector-j-9.4.0.jar" -d src src\com\railway\*.java

REM Run the main class
java -cp ".;lib/mysql-connector-j-9.4.0.jar;src" com.railway.Menu

pause

