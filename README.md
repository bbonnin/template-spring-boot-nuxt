# template-spring-boot-nuxt
Template for a project with Spring Boot for the services and Nuxt for the frontend.

> Inspired by: https://github.com/jonashackt/spring-boot-vuejs


## Project setup

```
template-spring-boot-nuxt
├─┬ backend     -> backend module with Spring Boot
│ ├── src
│ └── pom.xml
├─┬ frontend    -> frontend module with Nuxt
│ ├── src
│ └── pom.xml
└── pom.xml     -> Maven parent pom
```


## Dev

### Backend

* Run the backend (as any spring boot app)

* Test the API
```bash
$ curl localhost:8080/api/ping
pong

$ curl -XPOST 'localhost:8080/api/user?firstName=john&lastName=smith'
1

$ curl localhost:8080/api/user
[{"id":1,"firstName":"john","lastName":"smith"}]
```

### Frontend

* Test the frontend (with hot reloading)
```bash
$ cd frontend
$ npm run dev
```
* Open `http://localhost:3000`

> The API calls are redirected to the backend, so don't forget to start it !



## Build and run

* In the root directory: 
```bash
mvn clean package
```
> During this step, the frontend part is built and copied in the `resources`  directory of the backend.

* Now, you can run the app:
```bash
mvn --projects backend spring-boot:run
```

* Open `http://localhost:8080/`