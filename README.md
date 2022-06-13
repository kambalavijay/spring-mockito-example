# spring-mockito-example
Follow below steps to get to databse engine up and running so that unit tests for controller using mockito(MockMVC) run against that DB.

docker run --name postgres -e POSTGRES_PASSWORD=docker -d postgres

1. Run the above command to have the database server up and running
2. The application run against this database server
3. Unit tests run against h2 in-mem database.
