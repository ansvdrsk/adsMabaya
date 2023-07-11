# online-sponsored-ads
online sponsored ads application

# API usage:

POST http://localhost:8080/create-campaign

BODY example:
{
    "name": "test",
    "startDate": "2021-01-22",
    "category": "SHOES",
    "bid": 12.0
}

-----------------------

GET http://localhost:8080/serve-ad?category?SHOES

-----------------------

# Database (H2 In Memory Database)

H2 database has an embedded GUI console for browsing the contents of a database and running SQL queries.

When application is running go to:
http://localhost:8080/h2-console/

Jdbc url: jdbc:h2:mem:testdb

username: sa
