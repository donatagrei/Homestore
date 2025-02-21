# React Native UI Test Automation

This repository contains **automated UI tests** written in **Java**, using **Selenium WebDriver** and **JUnit 5** for testing the [**Homestore**](https://themes.woocommerce.com/homestore/) e-commerce web application.

## Overview

The automated tests validate some core functionalities of the Homestore web application, ensuring smooth operation of:
- Login: testing authentication with valid and invalid credentials, error handling, and password recovery.
- Product Search & Filtering: ensuring accurate search results, pagination, and filtering functionality.
- Product Details & Cart: verifying product descriptions, pricing, and correct cart behavior.
  
These tests ensure smooth navigation, product interaction, and a seamless shopping experience.

## Prerequisites

Before running the automated tests, ensure the following are installed:
- **Java Development Kit (JDK) 17** or later
- **Maven** for dependency management
- **Google Chrome** (or another supported browser)
- **Chromedriver** (compatible with your Chrome version)
- 
## Setup

1. **Clone this repository:**
   ```bash
   git clone https://github.com/donatagrei/donatagrei/Homestore.git
   
2. **Navigate to the project directory:**
   ```bash
   cd Homestore

3. **Install the required dependencies using Maven:**
   ```bash
   mvn clean install

## Tests execution

### Using Maven
To execute all tests, run:
  ```bash
  mvn test
  ```

### Using IDE
Tests can also be run individually from an IDE such as IntelliJ IDEA or Eclipse by selecting and running specific test classes.

## Folder structure

- **/src/main/java/pages:** contains the utility classes, test pages.
- **/src/test/java/tests:** contains the test cases.
- **/src/test/utils:** contains utility classes.
  
## Project structure

Tests are structured using POM (Page Object Model), allowing for easy readability and maintenance. The tests are organized as follows:
- **BaseTest:** sets up and tears down the WebDriver.
- **LoginTest:** tests for user authentication scenarios.
- **FilterAndSearchTest:** tests for search and filter functionalities.
- **DetailedProductPageTest:** validates product details and cart functionalities.

## Dependencies

The project relies on the following dependencies, as specified in the `pom.xml` file:

- **Selenium Java:** version 4.25.0
- **JUnit Jupiter API:** version 5.11.3
- **JUnit Jupiter Params:** version 5.11.3
- **JavaFaker:** version 1.0.0
- **AssertJ Core:** version 3.26.3 

## Author

Donata Greičiūtė - donata.greiciute97@gmail.com
