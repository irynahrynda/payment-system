# payment-system

Необходимо разработать веб-приложение, реализующее функциональность
платежного портала. Приблизительный сценарий:

1. Создание нескольких клиентов со счетами
2. Проведение платежей.
3. Получение информации по проведенным/забракованным платежам.

## Создание клиента

#### Запрос:

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

#### Ответ:

Код http: 201
{
"client_id": 123
}

## Поиск счета по идентификатору клиента

#### Входящие параметры:

client_id

#### Ответ сервиса:

#### Список счетов клиента
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

## Создание платежа

#### Запрос:

{
"source_acc_id": 654,
"dest_acc_id": 655,
"amount": 100.00,
"reason": "назначение платежа"
}

#### Ответ:

Код http: 201
{
"payment_id": 789
}

## Создание пачки платежей

#### Запрос:

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

#### Ответ:

Код http: 200
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



## Ошибки:

#### Общий формат ответа с ошибкой:

Код http: 500
Ошибки валидации входящих данных - код http: 400
{
"code": "код ошибки",
"text": "текст ошибки"
}

## Используемые библиотеки/фреймворки
1. SpringBoot 2
2. Hibernate, Spring data JPA
3. Spring JDBC
4. Postgresql 12
5. Maven/Gradle
