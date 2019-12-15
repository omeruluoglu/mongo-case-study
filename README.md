# MongoDB Case

### Prerequisites

There are no special requirements.

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