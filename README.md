# Retail Bill Calculation

Exposed Rest service endpoint calculates the net amount for the below based on below scenarios

1. If the user is an employee of the store, he gets a 30% discount
2. If the user is an affiliate of the store, he gets a 10% discount
3. If the user has been a customer for over 2 years, he gets a 5% discount.
4. For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45
as a discount).
5. The percentage based discounts do not apply on groceries.
6. A user can get only one of the percentage based discounts on a bill.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

1) JRE 1.8
2) Postman

### Installing

A step by step series of examples that tell you how to get a development env running

1) Download the jar file
2) Run below command in terminal/cmd
    java -jar net-retail 0.0.1-SNAPSHOT.jar


### Testing

1) Open Postman
2) Open new tab and select POST
3) Add this url http://localhost:8084/getNetAmount
4) Paste the below JSON in request, select raw and JSON format for request type
    
                    {
                   "customer":{
                      "customerName":"suresh",
                      "isEmployee":true,
                      "isAffliate":true,
                      "customerSince":"01-01-2019"
                   },
                   "products":[
                      {
                         "productName":"Atta",
                         "unitPrice":10,
                         "units":5,
                         "isGroceries":true
                      },
                      {
                         "productName":"Bowl",
                         "unitPrice":109.89,
                         "units":5,
                         "isGroceries":false
                      }
                   ]
                }
  5) You should get below output
                 {
                "billTotal": 414.61,
                "date": "2019-05-29T08:08:07.377+0000"
                 }
