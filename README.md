# SpringBoot-Gradle-Template

In this template we are trying to implement a basic **CRUD (Create Read Update Delete)** operation through an API implementation.
The project in itself will be part of a bigger implementation of a backend database and a front end UI. For now, lets implement the API transaction layer. We are using SpringBoot for this. 

Easiest place ( IDE Agnostic) to start from scratch to initilize a springboot project is with [Spring Initilizer](https://start.spring.io/) .      
The project initilized will be similiar to the sturcture below. I have used the params :
```
Gradle Project , Java , SpringBoot:2.3.1 , Group: com.template , Artifact: Springbootgradle , Packaging: Jar , Java:11
```

```
SpringBoot-Gradle-Template
├─ .git
├─ .gitignore
├─ README.md
├─ gradle
│  └─ wrapper
│     ├─ gradle-wrapper.jar
│     └─ gradle-wrapper.properties
├─ gradlew 
├─ gradlew.bat
├─ build.gradle
├─ setting.gradle
└─ src
   ├─ main
   │  ├─ java
   │  │  └─ com
   │  │     └─ template
   │  │        └─ springbootgradle
   │  │           └─ SpringbootgradleApplication.java
   │  └─ resources
   │     └─ application.properties
   └─ test
      └─ java
         └─ com
            └─ template
               └─ springbootgradle
                  └─ SpringbootgradleApplicationTests.java
```
The file **SpringbootgradleApplication.java** is the main file which is where the spring will start executing. We are following a [MVCS](https://mvcs.io/) pattern of design. Please go through the literrature if want to know more about this design pattern. 
I will create three packages representing my crontrollers,model and service layer. I have created the same layer on the test section for our unit test just for the service cause thats the section that requires those unit tests.
My project looks as such:



```
SpringBoot-Gradle-Template
├─ .git
├─ .gitignore
├─ Dockerfile
├─ README.md
├─ gradle
│  └─ wrapper
│     ├─ gradle-wrapper.jar
│     └─ gradle-wrapper.properties
├─ gradlew
├─ gradlew.bat
├─ build.gradle
├─ setting.gradle
└─ src
   ├─ main
   │  ├─ java
   │  │  └─ com
   │  │     └─ template
   │  │        └─ springbootgradle
   │  │           ├─ SpringbootgradleApplication.java
   │  │           ├─ controllers
   │  │           │  └─ CitizenController.java
   │  │           ├─ models
   │  │           │  └─ Citizen.java
   │  │           └─ services
   │  │              └─ CitizenService.java
   │  └─ resources
   │     └─ application.properties
   └─ test
      └─ java
         └─ com
            └─ template
               └─ springbootgradle
                  └─ services
                     └─ CitizenServiceTest.java
```
**build.gradle :** This file represents the setting of build settings of the gardle project. A few important ones are the java version declared by <em>sourceCompatibility</em>. 

**SpringbootgradleApplication.java :** Acts as an entry point for our application and enable us to serve our application.

**Citizen.java :** Java POJO that will be served by the API. It has the variables and its getters and setters.

**CitizenService.java :** Service layer which we will act as the interface to interact with our data. This layer will be extended later to interact with the database. For now we will have a static list act as our database in this layer.

**CitizenController.java :** Create a Controller layer which be used to manipulate our data. We annotate it with **@RestController** this enables you to get json objects from each function without explicity telling the function to return a json object.Intialize the CitizenService and annotate it with **@Autowired** (feature of spring framework enables you to inject the object dependency implicitly). Create five functions/methods in the CitizenController Class. Each of these moethods are annotated with **@RequestMapping.**  This enables the accesor of the api (whether a browser of postman client) to reach the request api as shown below. The function calls a method in the topic service class which loads all the topics. This way each access path is declared in controller and the implementation is moved to service class.

With the application ready we can build the application with the gradle wrapper
```
./gradlew clean build
```
This builds the executable jar which can be run as:
```
java -jar ./build/libs/springbootgradle-0.0.1-SNAPSHOT.jar
```
* the name of the jar depends on the parameter provided from the build.gradle file

The api exposed from this template are:
```
- GET | http://localhost:8080/citizens 
Gets a list of all citizens

- POST | http://localhost:8080/citizen/set
Inserts a new citizen when provided in the body of the request in the following format
{
	"id": 4,
	"name": "bruce wayne"
}

- UPDATE | http://localhost:8080/citizen/update
Update a exiting entry in the list of citizens
{
	"id": 4,
	"name": "bruce willis"
}

- DELETE | http://localhost:8080/citizen/delete
Delete a existing entry from the list of citizen
{
	"id": 4,
	"name": "bruce willis"
}
```
You can test these out on postman.

### Dockerize 

If this looks good, we will put it in docker. Make sure you login to your dockerhub profile on your terminal before running the script. Create a  dockerhub account for free.
```
#login
docker login --username=yourhubusername --email=youremail@company.com
```
after login
```
# ./dockerize.sh ARG1 ARG2 ARG3

# ARG1 - username for dockerhub
# ARG2 - imagename that you want to publish
# ARG3 - image version (latest by default)

# In out case

./dockerize.sh anupam007 spring-boot-gradle-template 0.0.1
```
This also create a local image for us to test.
```
docker run -it -p 8080:8080 anupam007/spring-boot-gradle-template:0.0.1
```
Interact with your application again on the postman.










