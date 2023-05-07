
# Java Rest API Weather Sensor Simulation ❄️

The program simulates a weather sensor. This sensor measures the ambient air temperature and can detect whether it is raining or not.

## Tech Stack 🔧

**Client:** Postman

**Server:** Java, Spring Boot.


## A few words about building this project 🍃
This is one of my training projects, and since this is one of my first ones, I encountered a little difficulty in creating this project. For example, I didn't know how to send JSON to the server which would contain another object inside itself as JSON as well. 
#### 

I also have some issues with exception handling and maybe I overcomplicated things when they could have been simpler, but I'm trying to keep this project going and improve it both in terms of adding new features and making the code more compact and readable.

## API Reference ⚔️
I suggest you to use Postman to send requests.
#### Register a new sensor



```http
  POST /sensors/registration
```

```json
{
  "name": sensor
}
```

Registers a new sensor in the system. In other words, it simply adds the new sensor to the sensor table in the database. As you can see from the JSON - the sensors have only one field - the name.

#### Add new measurement
```http
  POST /measurements/add
```

```json
{
  "value": 25.7,
  "raining": true,
  "sensor": {
    "name": "Sensor"
  }
}
```
Adds a new measurement. This is the address where the real sensor would send its data.

#### Retrieve all measurements from DB
```http
  GET /measurements
```

#### Retrieve all measurements from DB
```http
  GET /measurements/rainyDaysCount
```
------
#### At the moment, the project has four fully working addresses: 
- Sensor registration
- Adding measurement from a sensor
- Getting all measurements
- Getting the number of rainy days

## Database
**Type of database used**: PostgreSQL

**Required database credentials**: Username, password

#### How to set up the database localy
- You're gonna need to download [PostgresSQL](https://www.postgresql.org/download/). 

- After that, using pgAdmin application that was installed on your machine with Postgres, make sure you created database (right click on the "Server" that is located on the right, create database, give it a name, and you're done).

#### How to connect to database

- Within your IDE (i'm using IntelliJ IDEA) In order to connect the project to the database you just created click the "stack shaped" icon on the right, then click "+", click "Data Source" choose PostgreSQL. 
- In _User_ field paste your username you wrote when you were downloading PostgreSQL and in _Password_ paste your password. In _Database_ paste the name of the database you created in pgAdmin. _Port_ should be _5432_ (if not, try _5433_). 

- Then click the _Test conenction_ button.

- Then, within the project you'll see file `application.properties.example`. Within lines `spring.datasource.username` and `spring.datasource.password` you should your __username__ (not the name of the database, but your username), and __password__

- In the line `spring.datasource.url` __after the port__ (_5432/5433_) type the name of the database you created in pgAdmin.

- Now you need to rename the `application.properties.example` file to `application.properties`

🥳 Congratulations! You just connected to the database.
## 🔗 Links
[![linkedin](https://img.shields.io/badge/instagram-E1306C?style=for-the-badge&logo=instagram&logoColor=white)](https://www.linkedin.com/)

[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/westernthug)

