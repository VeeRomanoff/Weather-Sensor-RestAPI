
# Java Rest API Weather Sensor Simulation ❄️

The program simulates a weather sensor. This sensor measures the ambient air temperature and can detect whether it is raining or not.

## Tech Stack 🔧

**Client:** Postman

**Server:** Java, Spring Boot.


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
