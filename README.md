# Kitopi interview app

## Description

It is a prototype of menu application.

## Technology stack 

* Java 11
* SpringBoot
* Lombok
* VAVR

## Actuator

[App info](http://localhost:8080/actuator/info)

[Health check](http://localhost:8080/actuator/health)

## Examples

##### Dish example 

{\
    "id": 10,\
    "name": "Caffe Late",\
    "description": "Caffe Late 300 ml",\
    "price": 11.00\
}

##### Adding dish example

http://localhost:8080/dishes

{\
    "name": "Big Mac",\
    "price": 20.00\
}

##### Get dish example

http://localhost:8080/dishes/1

