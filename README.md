# OlympicGamesStarter

This project was generated with [SPRING BOOT] version 3.0.6.


## 1. Getting started



### 1.1. Get source code of Api

```
$ git clone https://github.com/G-Wald/ApiChaptop.git
```

### 1.2. Get the database

Download xampp with this url
```
https://www.apachefriends.org/fr/index.html
```
Make sure to download Apache and SQL.

Launch Xampp.

On the control panel click on Admin MySQL.

It should redirect you to this address.

http://localhost/phpmyadmin/

Click on new Database use utf8mb4_general_ci type and a name it chatop.

Once created use the SQL file to increment the database.

You can found it on this project:

```
ApiChatop/database/script.sql
```


### 1.3. Lancer l'application

Use your IDE to open the project and run it or use the following command on your console

```
$ mvn spring-boot:run
```

### 1.4. Documentation

You can find a documentation on this url 

```
http://localhost:3001/api/swagger-ui/index.html
```
replace the port number if needed.