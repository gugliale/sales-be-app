# sales-be-app
RESTful application with Spring Boot.

## PROBLEM: SALES TAXES
**Basic sales tax** is applicable at a rate of **10%** on all goods, **except** books, food, and medical products that are.
**Import duty** is an additional sales tax applicable on all imported goods at a rate of 5%, with no exemptions.

When I purchase items I receive a receipt which lists the name of all the items and their price (including tax), finishing with the total cost of the items, and the total amounts of sales taxes paid. 
The rounding rules for sales tax are that for a tax rate of n%, a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of sales tax.

## Running the application locally
To launch, build, and test this Spring Boot 3 application, ensure you have Maven installed and configured on your system.
There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.griesi.sales.SalesTaxesApplication` class from your IDE.

- Download the zip or clone the Git repository to your local machine
- Unzip the zip file (if you downloaded one)
- Open Command Prompt and Change directory (cd) to folder containing pom.xml
- Open IntelliJ
    - File -> Open -> Navigate to the folder where you unzipped the zip
    - Select the project
- Choose the Spring Boot Application file (search for @SpringBootApplication)
- Right Click on the file and Run

Alternatively to build the application, run the following command in your terminal:

```shell
mvn clean install

mvn spring-boot:run # To run the program

mvn test # Run all the unit test
```

### URLS
OpenAPI descriptions at: http://localhost:8080/v3/api-docs
API specification at: http://localhost:8080/swagger-ui/index.html