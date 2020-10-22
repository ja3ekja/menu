# Kitopi interview app

## Description

It is a prototype of menu application.

## Technology stack 

* Java 11
* SpringBoot
* Lombok
* VAVR

## Actuator

[Health check](http://localhost:8080/actuator/health)

[App info](http://localhost:8080/actuator/info)
```json
{
   "site":{
      "name":"Kitopi interview task",
      "authors":"Jacek Feliksiak"
   },
   "git":{
      "branch":"master",
      "commit":{
         "id":"d9211a6",
         "time":"2020-10-22T10:59:53Z"
      }
   },
   "build":{
      "artifact":"menu",
      "name":"menu",
      "time":"2020-10-22T12:13:18.649Z",
      "version":"0.0.1-SNAPSHOT",
      "group":"com.kitopi"
   }
}
```

## Examples

##### Dish example 
```json
{
    "id": 10,
    "name": "Caffe Late",
    "description": "Caffe Late 300 ml",
    "price": 11.00
}
```
##### Adding dish example

http://localhost:8080/dishes
```json
{
    "name": "Big Mac",
    "price": 20.00
}
```
##### Get dish example

http://localhost:8080/dishes/1

