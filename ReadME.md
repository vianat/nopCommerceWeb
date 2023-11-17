#$ nopCommerceWeb

    Web Application Testing Project using Java, Selenium, and Cucumber.

## Description

    This project comprises automated tests for a web application using Java, Selenium WebDriver, and Cucumber.
    The tests are designed to validate the functionality of the application using the Behavior Driven Development (BDD) approach.

# Requirements

    * Java 20
    * Maven
    * Install browsers: Chrome 119+, Firefox 119+, Edge 119+, Safari

# Installation

    Clone the repository: git clone https://github.com/vianat/nopCommerceWeb.git

    Download all dependencies:

# Running:

    1. Navigate to the project directory:  cd nopCommerceMobile

    2. For Mac, run:  mvn test && open  target/cucumber-reports/report.html
       For Win, run:  mvn test && start target/cucumber-reports/report.html

# Project Structure:

     src/java/java/pages/ - pom pages code
     src/test/java/steps/ - test code
     src/test/java/features/ - cucumber scenario files