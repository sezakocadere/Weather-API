# Weather-API

## About The Project

This project using **Spring Boot**, **Open Feign**, **Swagger**, **Lombok** and **Java 17**.

Open Feign makes a good choice to consume an API. This services consumes the Foreca API. ( *https://developer.foreca.com/* ).
Foreca Weather API standard package includes access to point forecasts and weather maps.
Access tokens are provided to data API calls in the header (**Authorization: Bearer < token >**). You can access api key for 30 days: *com.weather.weather.constants.Constants*



This is divided to layers:

+ **client** : For Feign clients.
+ **controller** : For endpoints.
+ **model** : Maps the objects return by the API in this case.
+ **service** : Business logic. It transforms the results we get from the Foreca API.


## API DOCS

Type | API Request | Info |
|--|--|--|
| GET | weather/current/{cityName}|List of current weather estimate|
| GET | weather/weekly/{cityName} |List of daily forecasts, up to 7 days|


### Clone The Repo:
``` $ git clone https://github.com/sezakocadere/Weather-API.git ```


## Swagger Integration
http://localhost:8080/swagger-ui/


## Scenario
- [x] Show the daily, weekly weather report according to the country / city information that we will get from the user.
- [x] The request will first come to the API you will write, then after you receive the request, you will request the Free Weather APIs and return this information.
- [x] Making a correct API structure.
- [x] Making validations on your model or parameters. Handling exceptions.

## Current weather estimate
```
localhost:8080/weather/current/istanbul [GET]

Response Body
{
    "pressure": 1031.15,
    "time": "2023-02-11T17:46+03:00",
    "windSpeed": 3,
    "symbolPhrase": "partly cloudy",
    "temperature": 5,
    "feelsLikeTemp": 2,
    "locationName": "Istanbul"
}
```

## Daily forecasts, up to 7 days 
```
localhost:8080/weather/weekly/istanbul [GET]

Response Body
[
    {
        "pressure": null,
        "time": "2023-02-11",
        "windSpeed": 5,
        "symbolPhrase": null,
        "temperature": 7,
        "feelsLikeTemp": null,
        "locationName": "Istanbul"
    },
    {
        "pressure": null,
        "time": "2023-02-12",
        "windSpeed": 3,
        "symbolPhrase": null,
        "temperature": 7,
        "feelsLikeTemp": null,
        "locationName": "Istanbul"
    },
    {
        "pressure": null,
        "time": "2023-02-13",
        "windSpeed": 5,
        "symbolPhrase": null,
        "temperature": 8,
        "feelsLikeTemp": null,
        "locationName": "Istanbul"
    },
    {
        "pressure": null,
        "time": "2023-02-14",
        "windSpeed": 4,
        "symbolPhrase": null,
        "temperature": 8,
        "feelsLikeTemp": null,
        "locationName": "Istanbul"
    },
    {
        "pressure": null,
        "time": "2023-02-15",
        "windSpeed": 6,
        "symbolPhrase": null,
        "temperature": 8,
        "feelsLikeTemp": null,
        "locationName": "Istanbul"
    },
    {
        "pressure": null,
        "time": "2023-02-16",
        "windSpeed": 4,
        "symbolPhrase": null,
        "temperature": 8,
        "feelsLikeTemp": null,
        "locationName": "Istanbul"
    },
    {
        "pressure": null,
        "time": "2023-02-17",
        "windSpeed": 3,
        "symbolPhrase": null,
        "temperature": 9,
        "feelsLikeTemp": null,
        "locationName": "Istanbul"
    }
]
```
## Wrong type endpoint
```
localhost:8080/weather/weekly/3432 [GET]

Response Body
{
    "message": "City/Country Not Found",
    "status": "NOT_FOUND",
    "timeStamp": "2023-02-11"
}
```

## Images From Swagger UI

![Screenshot 2023-02-11 at 17 50 50](https://user-images.githubusercontent.com/38151013/218265478-3268941a-89b2-4c07-9330-2edcf954c2fd.png)

![Screenshot 2023-02-11 at 17 52 57](https://user-images.githubusercontent.com/38151013/218265489-7b15301f-9b01-47a0-99eb-b5df23e22a5d.png)

![Screenshot 2023-02-11 at 17 53 48](https://user-images.githubusercontent.com/38151013/218265492-de0e10cd-0560-4b46-8911-5c1b44b83e69.png)

