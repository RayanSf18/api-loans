# Loan API
 
Welcome to the Loan API README! 

This document provides comprehensive information about the backend application developed in Java with Spring Boot. 
The Loan API serves as a service to determine the loan options available to an individual based on specific criteria.

## Overview
The Loan API is a sophisticated backend application designed to analyze various factors and provide suitable loan options. 

It evaluates the following loan types:

 - Personal Loan: Interest rate of 4%.
 - Consignment Loan: Interest rate of 2%.
 - Guaranteed Loan: Interest rate of 3%.

Loan options available to an individual depend on specific variables, including:

 - Age
 - Salary
 - Location

## Usage
To utilize the Loan API, send a POST request to the following route:

Method POST:
```
localhost:8080/customer-loans
```
Include the following data in the request body:
```
{
  "age": 26,
  "cpf": "275.484.389-23",
  "name": "Vuxaywua Zukiagou",
  "income": 7000.00,
  "location": "SP"
}
```
Upon receiving the request, the service will respond with a JSON object containing the customer's name and a list of accessible loans with their respective types and interest rates. For example:
```
HTTP/1.1 200 Ok
Content-Type: application/json

{
  "customer": "Vuxaywua Zukiagou",
  "loans": [
    { "type": "PERSONAL", "interest_rate": 4 },
    { "type": "GUARANTEED", "interest_rate": 3 },
    { "type": "CONSIGNMENT", "interest_rate": 2 }
  ]
}
```
## Requirements
The Loan API evaluates the following criteria when determining loan eligibility:

 - Grant personal loan if the customer's salary is equal to or less than R$ 3000.
 - Grant personal loan if the customer's salary is between R$ 3000 and R$ 5000, and the customer is under 30 years old and resides in São Paulo (SP).
 - Grant consignment loan if the customer's salary is equal to or greater than R$ 5000.
 - Grant guaranteed loan if the customer's salary is equal to or less than R$ 3000.
 - Grant guaranteed loan if the customer's salary is between R$ 3000 and R$ 5000, and the customer is under 30 years old and resides in São Paulo (SP).

## Technologies Used

 - Java
 - Spring Boot
 - JUnit 5
 - Mockito

## Contributing
Contributions are welcome! Feel free to open issues or pull requests to improve the Loan API.

License
This project is licensed under the MIT License. See the LICENSE file for details.
