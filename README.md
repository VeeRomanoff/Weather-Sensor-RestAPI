
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
