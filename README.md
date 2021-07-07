### Challenge Clients Brasil Prev
#### CRUD Challenge for BrasilPrev - Java - BackEnd
Build a REST API with the functionalities of a register of your customers (name,
cpf and address).

#### 2.Stack
* Java 11 (OpenJDK)
* Maven (3.8.1)
* Springboot (2.5)
* Mysql (8.0)
* OAUTH2

#### 3. Run in dev environment
#### 3.1 environment
1. Install [OpenJDK 11](https://openjdk.java.net/install/)
2. Install [Maven](https://maven.apache.org/install.html)
3. Install [Mysql8](https://dev.mysql.com/downloads/)
4. IDE (Ex: [IntelliJ IDEA](https://www.jetbrains.com/idea/download/))

#### 3.2 Variáveis de ambiente
>-DDEBUG=true  (Set true to start the application with start date)

>-DDB_HOST=172.17.0.2 (Address used to connect with MySQL)

>-DDB_PORT=3306 (MySQL port)

>-DDB_NAME=bprev (Database name)

>-DDB_USER=root (Database user)

>-DDB_PASSWORD=root (Database password)

#### 3.3 Running the application with an IDE (Ex: [Intellij IDEA](https://www.jetbrains.com/help/idea/spring-boot.html))
#### 3.4 Running the application through maven
```bash
mvn spring-boot:run -Dspring.profiles.active="prod" -Dspring-boot.run.jvmArguments="-DDEBUG=true -DDB_HOST=172.17.0.2 -DDB_PORT=3306 -DDB_NAME=client -DDB_USER=root -DDB_PASSWORD=root"
```

#### 3.5 Auto generated documentation [/swagger.html](http://localhost:8000/swagger.html) da API

#### 3.6 Postman Collection can be found [here](https://documenter.getpostman.com/view/8357607/Tzm5GwFQ)

#### 3.7 Running tests
```bash
mvn test -DargLine="-DDEBUG=true -DDB_HOST=172.17.0.2 -DDB_PORT=3306 -DDB_NAME=bprev -DDB_USER=root -DDB_PASSWORD=root"
```


#### 3.7 Default ApiClient and User
Basic Auth:
> username= client
> password= 123456

Defaul User:
> grant_type=password

> username=admin@admin.com

> password=123456

### 4. API

#### 4.1 Description
Simple CRUD application for clients

#### 4.1 Solution
The API has the following modules

#### 4.1.1 Users
#### 4.1.2 Security
#### 4.1.3 Clients

### 4. Deploy

<!-- CONTACT -->
### Contact

Leoncio Ferreira - [LinkedIn](https://www.linkedin.com/in/leoncio-ferreira/) - leonfers@hotmail.com

Project Link: [https://github.com/leonfers/teste-banco](https://github.com/leonfers/teste-banco)