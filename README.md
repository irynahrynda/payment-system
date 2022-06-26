# payment-system

This is a simple web application that implements the functionality of payment system.

It provides some functionality:

### - Creating a client
#### Request:
{
"first_name": "Имя",
"last_name": "Фамилия",
"accounts" : [
{
"account_num": "123456789",
"account_type": "card/simple",
"balance": 5000.00
},
{
"account_num": "987654321",
"account_type": "card/simple",
"balance": 10000.00
}
]
}

#### Response:
Код http: 201
{
"client_id": 123
}


### - Search for an account by client ID
#### Input parameters:

client_id

#### Service response: List of customer accounts
[
{
"account_id": 654,
"account_num": "123456789",
"account_type": "card/simple",
"balance": 5000.0
},
{
"account_id": 655,
"account_num": "987654321",
"account_type": "card/simple",
"balance": 10000.0
}
]


### - Creating a payment
#### Request:
{
"source_acc_id": 654,
"dest_acc_id": 655,
"amount": 100.00,
"reason": "назначение платежа"
}

#### Response:
Code http: 201
{
"payment_id": 789
}


### - Creating list of payments
#### Request:
[
{
"source_acc_id": 654,
"dest_acc_id": 655,
"amount": 100.00,
"reason": "назначение платежа"
},
{
"source_acc_id": 655,
"dest_acc_id": 654,
"amount": 1000.00,
"reason": "назначение платежа"
}
]

#### Response:
Code http: 200
[
{
"payment_id": 789,
"status": "ok"
},
{
"payment_id": 790,
"status": "error"
}
]


### - Errors (Exceptions):
#### General answer format with an error:
Code http: 500
Incoming data validation errors - код http: 400
{
"code": "error code",
"text": "error text"
}

### - Libraries/frameworks used
1. SpringBoot
2. Hibernate, Spring data JPA
3. Spring JDBC
4. Postgre/ sql 
5. Maven/Gradle
