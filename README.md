# Spring
Implement Spring app and Junit tests for it. This application will be an internal company salary application with Object
Model: Employee, Position, Salary
and a few services

•	EmployeeService: hire/fire new Employees for the specific position
•	PositionService: CRUD over the list of available positions in company
•	SalaryService: bind salary to position based on yearly salary changes, inflation, $ course and another company events (by your choice)

      Emulate a few years of company life via console output and duplicate it to log file.

1.	Configure beans via XML
2.	Implement 3 services using different types of autowiring
3.	Pass bean references, string constants and primitive types as constructor parameters
4.	Use setter approach for passing another bean parameter
5.	Use SpEL to inject values (inline lists or math operations) with custom parser configuration
6.	Use correct validation for fields (for example: size of salary, age of Employee) based on JSR-303 Bean Validation API
7.	Provide tests for invalid data
8.	Use field-formatting API when it has a meaning
