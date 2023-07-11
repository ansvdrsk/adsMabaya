

# API usage:

POST http://localhost:8080/create-campaign

BODY example:
{
  "name": "Example Campaign",
  "startDate": "2023-07-11",
  "productIds": [1, 2, 3],
  "bid": 0.5,
  "category": "Category1"
}

-----------------------

GET http://localhost:8080/serve-ad?category="Name of the Category"

-----------------------

# H2 Database

H2 database has GUI console for browsing the contents of a database.

When application is running go to:
http://localhost:8080/h2-console/

