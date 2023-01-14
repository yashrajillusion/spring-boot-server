# spring-boot-server
A webserver built on spring boot as to learn REST api authentication authorisation and sql db connection setup

## base url https://spring-yash-server.onrender.com

## Create user - /api/v1/auth/register

### req obj - {
    "firstname":"Nishant",
    "lastname":"Raj",
    "email":"n@r",
    "password":"your@123"
}

### res obj - {
    "message": "Account created Successfully",
    "statusCode": 201,
    "accessToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJuQHIiLCJpYXQiOjE2NzM2NzY4NzQsImV4cCI6MTY3MzY3ODMxNH0.Gp6xjW36j7Fa6yVpNvTG7WpaUanJt42GTC5eTeGec74"
}

## login user api/v1/auth/login

### req obj - {
    "email":"y@r",
    "password":"your@123"
}

## Add book - /book

### req obj - {
    "user":{
        "uuid": id of user from user table
    },
    "price":6000,
    "name":"Flutter script"
}


## Get all book /book
## Get/Put/Delete book by id /book/:id
