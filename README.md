# MongoDB Case

### Prerequisites

## Localhost

Case url on **http://localhost:8090/** with POST request

## Heroku

Case url on **https://mongo-case.herokuapp.com** with POST request

Example Post Request;

{
    "startDate":"2018-12-01",
    "endDate":"2019-12-01",
    "minCount":200,
    "maxCount":1000
}

```bash
curl -H "Content-Type: application/json" -X POST -d '{"startDate":"2018-12-01","endDate":"2019-12-01","minCount":200,"maxCount":1000}' http://localhost:8091/
```

```bash
curl -H "Content-Type: application/json" -X POST -d '{"startDate":"2016-12-01","endDate":"2019-12-01","minCount":100,"maxCount":100000}' https://mongo-case.herokuapp.com
```

### Installing

1\. Clone this repository

```bash
git clone https://github.com/omeruluoglu/mongo-case-study.git
```

2\. Build and install the archetype

```bash
maven clean install
```

3\. Get the .war file from `~/mongo-case-study/case-middleware/target/case-middleware-1.0.0.war`

## Running the tests

```bash
maven clean install
```

## Running with Docker

There is a Docker image on Docker Hub and you can run with docker-compose file.
```bash
docker-compose -f docker-compose.yml up
```

## Built With
* [Spring Boot](https://spring.io/projects/spring-boot) - Java Web Framework
* [Maven](https://maven.apache.org/) - Dependency Management
* [JUnit](http://junit.org/junit4/) - Unit Tests
* [Docker](https://www.docker.com/) - Docker Container

## Author

* [Omer Uluoglu](https://github.com/omeruluoglu)

## License

This project is licensed under the MIT License.