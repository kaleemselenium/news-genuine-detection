## Test project to validate the news is genuine or not

### Objective
Pick the first article from Guardian news and validate if the news article is genuine or fake.
It does so by running checks against search engines and validating number of keyword hits against desired thresholds

### Author
Kaleem  [kaleemurrehman@yahoo.com](kaleemurrehman@yahoo.com)

### Tech Stack
1) Java 8 or above
2) Maven 3
3) Selenium latest
4) Cucumber
5) Selenide
6) Spring framework

### About the framework
Framework is developed using [Selenide](https://selenide.org/)(Selenide is a framework for test automation powered by Selenium WebDriver that brings the following advantages:
* Concise fluent API for tests 
* Stable tests 
* Powerful selectors 
* Simple configuration
)

framework and spring framework with maven as build tool. Followed the Spring and Page Object pattern.

### Steps to run
1) Download or clone the project
2) Execute the command `mvn clean test` in project root directory to execute the tests

### Reports
HTML reports can be found at `target/cucumber-report/cucumber.html`
