@echo off
mvn clean compile && java -cp target/classes com.parse.equation.Parser
