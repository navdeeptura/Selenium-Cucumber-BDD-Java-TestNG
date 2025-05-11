# Selenium-Cucumber-BDD-Java-TestNG


**To run the test:** 

mvn clean test

mvn test -Dcucumber.filter.tags="@SmokeTest"

mvn clean test -Dtest=runners.CucumberTest -Dcucumber.filter.tags="@login"

mvn test -Dcucumber.filter.tags="@SmokeTest"