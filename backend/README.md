Gradle Spring Example
==============================

Basic Java webapp using Gradle, Spring, Swagger, Gretty, and no XML!

This will be the start of the discussion-api, which allows people to create discussions and then comment on discussions.
Ideally this would be paired with a fancy frontend of some sort, but this repo only has the backend.  It is fully functional
through the swagger interface though, despite not being pretty.

Quick start
-----------
0. (OPTIONAL) `./gradlew tasks` to see a list of available Gradle commands
1. `./gradlew appRun` to compile and start embedded web server, all in one step
2. Point your browser to [http://localhost:8080/GradleSpringWebApp/swagger-ui.html](http://localhost:8080/GradleSpringWebApp/swagger-ui.html)
to view the Swagger UI page