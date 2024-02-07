## Requests
- curl -X POST http://localhost:8085/students/verify-if-has-certification -d '{"email":"test@gmail.com", "technology":"java"}' -H 'Content-Type:application/json'

- curl -X GET http://localhost:8085/questions/technology/JAVA

## Docker Postgres

1. run docker-compose up --build
2. `docker exec -it postgres psql -U postgres`
- \l - list databases
- \c - connect to database