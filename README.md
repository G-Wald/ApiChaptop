# ApiChaptop starter

This project was generated with [SPRING BOOT] version 3.0.6.


## 1. Getting started

Make sure you have java on your computer

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

Launch Xampp, Apache and MySQl.

On the control panel click on Admin MySQL.

It should redirect you to this address.

http://localhost/phpmyadmin/

Click on new Database use utf8mb4_general_ci type and a name it chatop.

Once created use the SQL file to increment the database.

You can find it on this project:

```
ApiChatop/database/script.sql
```
if you have this error

1067 invalid default value for "created_at"

please change your global mode by putting this command

```
set global sql_mode = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
```

### 1.3. Lancer l'application

Before launch please enter your database information on application.properties

```
spring.datasource.url= "your db url"
spring.datasource.username="your db username"
spring.datasource.password="your db password"
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

Use an IDE to open the project and build it and run it

If you don't have an IDE, you can dowload Intellij.

Open the project with Intellij.

Go to ApiChatopApplication.

Build the application with the green hammer on the top of your window.

Run it with the button play. 

(If you can run and build check if you have a SDK install)


### 1.4. Documentation

You can find a documentation on this url 

```
http://localhost:3001/api/swagger-ui/index.html
```
replace the port number if needed.