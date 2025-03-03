# QAVisaPageTest

## Overview  
QAVisaPageTest is an automated test suite for validating the functionality of a visa application page. This project includes Selenium-based test scripts and integrates a basic CI/CD pipeline using Jenkins.  

## Features  
- **Automated UI testing** for visa application workflows  
- **Form validation checks** (e.g., country selection, date selection, input validation)  
- **CI/CD integration** with Jenkins for automated test execution  

## Documentation  
📄 [Test Documentation](https://docs.google.com/spreadsheets/d/1zWYSYknuJpC6dZAxrm419Qie60ubFvgKFAZ67oEY9OU/edit?usp=sharing)  

## Getting Started  
### Prerequisites  
- Java Development Kit (JDK 21)
- Maven  
- Selenium WebDriver  
- ChromeDriver  
- Jenkins (optional for CI/CD)

# QAVisaPageTest

## Overview  
QAVisaPageTest is an automated test suite for validating the functionality of a visa application page. This project includes Selenium-based test scripts and integrates a basic CI/CD pipeline using Jenkins.  

## Features  
- **Automated UI testing** for visa application workflows  
- **Form validation checks** (e.g., country selection, date selection, input validation)  
- **CI/CD integration** with Jenkins for automated test execution  

## Documentation  
📄 [Test Documentation](https://docs.google.com/spreadsheets/d/1zWYSYknuJpC6dZAxrm419Qie60ubFvgKFAZ67oEY9OU/edit?usp=sharing)  

## Getting Started  

### Prerequisites  
- **Java Development Kit (JDK 21)**  
- Maven  
- Selenium WebDriver  
- ChromeDriver  
- Jenkins (optional for CI/CD)  

### Installation & Setup  

1. **Clone the repository:**  
   ```sh
   git clone https://github.com/ismail-x/QAVisaPageTest.git
   cd QAVisaPageTest
2. **Install dependencies using Maven:**
    ```sh
   mvn clean install
3. - running full test
     ```mvn test -P FullTest
   - running positive test
     ```mvn test -P PositiveTest
   - running invalid (negative test)
     ```mvn test -P InvalidTest
