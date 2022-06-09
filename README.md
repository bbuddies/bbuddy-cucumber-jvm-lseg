# BBuddy-Cucumber-jvm

This is a project for a cucumber related practices training. It tests against a simple web application with UI and REST api.

## Prepare Environment
Install *Docker* and *Docker-Compose*. 
Use docker-compose from project root directory to start the system under test.
```zsh
docker-compose up -d
```

## Cucumber plugin for IntelliJ
If you are using IntelliJ Community/Educational Edition, please install `Cucumber for Java` plugin for better experience.

## Run Cucumber
It can be executed via IntelliJ or gradle cucumber task:
```zsh
./gradlew cucumber
```
It tests the web using Chrome browser. During the process, it may ask for permission to open chromedriver, please permit it.

## Web application
If you want to play with the application, you can open [http://localhost:8100/#/signin](http://localhost:8100/#/signin) in browser.
There is no default user to login, nor the register page. you can register a user via REST api.

Use http client embedded in IntelliJ:
```http request
POST http://localhost:4000/users/signup
Accept: application/json
Content-Type: application/json

{
  "email": "zbcjackson@odd-e.com",
  "password": "password"
}
###
```

Use curl command:
```zsh
curl -d '{"email": "zbcjackson@odd-e.com", "password": "password"}' -H 'Content-Type: application/json' http://localhost:4000/users/signup
```

Or use any other http tool you prefer, like PostMan.

## Database
It uses mysql as the database. Here is the connection information:
* User: nerd
* Password: dbs3cr3t
* Database: bbuddytest