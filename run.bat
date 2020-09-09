@echo off

rem finishes the previous process if necessary 
for /f "tokens=5" %%a in ('netstat -aon ^| find ":10001" ^| find "LISTENING"') do taskkill /f /pid %%a
:exit

rem optimized mode
rem mvn -o wildfly-swarm:run -Plocal -DskipTests=true

rem dev mode
mvn install wildfly-swarm:run -Plocal -DskipTests=true