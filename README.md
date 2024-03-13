# ChangeCalculator  

ChangeCalculator is a Spring Boot application that calculates the change to be returned based on the amount paid by the customer and the price of the product. It provides an endpoint to calculate the denominations of the change.

## Prerequisites

Before running the application, ensure that you have the following installed:

- Java Development Kit (JDK) version 17 or higher
- Apache Maven (if you prefer to build and run the application using Maven)

## Getting Started

1. Clone this repository:
```
   git clone https://github.com/techmacitoo/ChangeCalculator.git
```

2. Navigate to the project directory:
```
    cd ChangeCalculator
```

3. Build the project:
```
    mvn clean install -DskipTests
```

4. Run the application:
```
    mvn spring-boot:run
```

5. You can test it in two ways:
    1. Using Command propmt:
       1. After running application you'll be asked to enter 1st input 'Amount' then press enter.
       2. After that you will be asked to enter 2nd Input 'Product Price' then press enter.
       3. You will get output.
    
    2. Using Postman
        1. Open Postman
        2. Click on import 
        3. Paste this curl
        ```  
            curl --location 'http://localhost:8080/calculateChange' \
            --header 'Key: Content-Type' \
            --header 'Value: application/json' \
            --header 'Content-Type: application/json' \
            --data '{
                "amountPaid": 20.00,
                "productPrice": 5.50
            }'
        ```  
        4. Send Request
            You will output in response

