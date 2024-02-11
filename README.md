## Docs
Run and click [here](http://localhost:8085/swagger-ui.html) to see the documentation.

*Powered by Swagger using OPENAPI 3.0*

## Requests
- curl -X POST http://localhost:8085/students/verify-if-has-certification -d '{"email":"test@gmail.com", "technology":"java"}' -H 'Content-Type:application/json'

- curl -X POST http://localhost:8085/students/verify-if-has-certification -d '{"email":"test@gmail.com", "technology":"java"}' -H 'Content-Type:application/json'

- curl -X GET http://localhost:8085/questions/technology/JAVA

- curl -X POST http://localhost:8085/students/certification/answer -d '{"email": "two@test.com","technology": "JAVA","questionsAnswers": [{"questionId": "c5f02721-6dc3-4fa6-b46d-6f2e8dca9c66","alternativeId": "98f6891b-5f14-4b8e-bb87-46456a2610d4"},{"questionId": "b0ec9e6b-721c-43c7-9432-4d0b6eb15b01","alternativeId": "f8e6e9b3-199b-4f0d-97ce-7e5bdc080da9"},{"questionId": "f85e9434-1711-4e02-9f9e-7831aa5c743a","alternativeId": "d3e51a56-9b97-4bb8-9827-8bcf89f4b276"}]}' -H 'Content-Type:application/json'

- curl -X POST http://localhost:8085/students/certification/answer -d '{"email": "three@test.com","technology": "JAVA","questionsAnswers": [{"questionId": "c5f02721-6dc3-4fa6-b46d-6f2e8dca9c66","alternativeId": "bafdf631-6edf-482a-bda9-7dce1efb1890"},{"questionId": "b0ec9e6b-721c-43c7-9432-4d0b6eb15b01","alternativeId": "f8e6e9b3-199b-4f0d-97ce-7e5bdc080da9"},{"questionId": "f85e9434-1711-4e02-9f9e-7831aa5c743a","alternativeId": "d3e51a56-9b97-4bb8-9827-8bcf89f4b276"}]}' -H 'Content-Type:application/json'

- curl -X GET http://localhost:8085/ranking/top-10 -H 'Content-Type:application/json'


## Docker Postgres Commands

1. Run docker-compose up --build
2. `docker exec -it postgres psql -U postgres`
- \l - list databases
- \c - connect to database