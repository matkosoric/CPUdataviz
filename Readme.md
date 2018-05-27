# Data visualization project

This is a simple Spring Boot MVC application that parses info about graphics cards from a csv file, creates list of beans and loads them into an in-memory H2 database. Upon REST request, application will display two graphs with D3 javascript library.

## Access adress
```
http://localhost:8080/GPU-memory
```
## or
```
http://localhost:8080/GPU-speed
```


### Original dataset
http://www.kaggle.com/iliassekkaf/computerparts

## Built With

* [Spring Boot](https://projects.spring.io/spring-boot/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [D3](https://d3js.org/) - Javascript library for data visualization
* [H2](http://www.h2database.com) - In-memory database

## Screenshot

![alt text](https://github.com/matkosoric/GPUdataviz/src/main/resources/screenshot.jpg)