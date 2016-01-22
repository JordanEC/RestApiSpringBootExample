## RestApiSpringBootExample
REST API using: Spring Boot + Spring security + OAuth2 + Hibernate + MySQL + Jackson + Retrofit.

## How to run:
-Create database with 'schema.sql' script.

-Insert some data with 'data.sql' script.

-Set your MySQL credentials in applications.properties.

-Set server's auth credentials applications.properties and client's auth in TokenTest.java

-Run.

## API paths:

/oauth/token : methods=[POST]

/v3/confederations/name={name} : methods=[GET]

/v3/confederations : methods=[POST, GET]

/v3/confederations/{id} : methods=[GET, PUT, DELETE]

/v3/confederations/{id}/countries : methods=[GET]

/v3/countries/name={name} : methods=[GET]

/v3/countries/{id} : methods=[GET, PUT, DELETE]

/v3/countries : methods=[POST, GET]

/v3/countries/{id}/players : methods=[GET]

/v3/countries/{id}/confederation : methods=[GET]

/v3/players/name={name} : methods=[GET]

/v3/players/{id} : methods=[GET, PUT, DELETE]

/v3/players : methods=[POST, GET]

/v3/players/older={age} : methods=[GET]

/v3/players/{id}/team : methods=[GET]

/v3/players/{id}/country : methods=[GET]

/v3/players/{id}/sponsor : methods=[GET]

/v3/sponsors/name={name} : methods=[GET]

/v3/sponsors/{id} : methods=[GET, PUT, DELETE]

/v3/sponsors : methods=[POST, GET]

/v3/sponsors/{id}/teams : methods=[GET]

/v3/sponsors/{id}/players : methods=[GET]

/v3/stadiums/name={name} : methods=[GET]

/v3/stadiums/{id} : methods=[GET, PUT, DELETE]

/v3/stadiums : methods=[POST, GET]

/v3/stadiums/{id}/teams : methods=[GET]

/v3/teams/name={name} : methods=[GET]

/v3/teams/{id} : methods=[GET, PUT, DELETE]

/v3/teams : methods=[POST, GET]

/v3/teams/{id}/stadiums : methods=[GET]

/v3/teams/{id}/players : methods=[GET]

/v3/teams/{id}/country : methods=[GET]

/v3/teams/{id}/sponsors : methods=[GET]
