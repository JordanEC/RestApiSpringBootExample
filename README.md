# RestApiSpringBootExample
REST API using: Spring Boot + Hibernate + MySQL + Jackson + Retrofit

# How to run:
-Create database with 'schema.sql' script.

-Insert some data in the database with 'data.sql' script.

-Set your MySQL credentials in the applications.properties file.

-Run.

# API paths:

/v3/confederations/name={name} | methods=[GET]

/v3/confederations/create | methods=[POST]

/v3/confederations/{id} | methods=[GET]

/v3/confederations/{id}/update | methods=[PUT]

/v3/confederations/{id}/delete | methods=[DELETE]

/v3/confederations | methods=[GET]

/v3/confederations/{id}/countries | methods=[GET]

/v3/countries/name={name} | methods=[GET]

/v3/countries/{id} | methods=[GET]

/v3/countries/{id}/update | methods=[PUT]

/v3/countries/{id}/delete | methods=[DELETE]

/v3/countries | methods=[GET]

/v3/countries/{id}/players | methods=[GET]

/v3/countries/{id}/confederation | methods=[GET]

/v3/countries/create | methods=[POST]

/v3/players/name={name} | methods=[GET]

/v3/players/read | methods=[POST]

/v3/players/{id} | methods=[GET]

/v3/players/{id}/update | methods=[PUT]

/v3/players/{id}/delete | methods=[DELETE]

/v3/players | methods=[GET]

/v3/players/older={age} | methods=[GET]

/v3/players/{id}/team | methods=[GET]

/v3/players/{id}/country | methods=[GET]

/v3/players/{id}/sponsor | methods=[GET]

/v3/sponsors/name={name} | methods=[GET]

/v3/sponsors/{id} | methods=[GET]

/v3/sponsors/{id}/update | methods=[PUT]

/v3/sponsors/{id}/delete | methods=[DELETE]

/v3/sponsors | methods=[GET]

/v3/sponsors/{id}/teams | methods=[GET]

/v3/sponsors/{id}/players | methods=[GET]

/v3/sponsors/create | methods=[POST]

/v3/stadiums/name={name} | methods=[GET]

/v3/stadiums/create | methods=[POST]

/v3/stadiums/{id} | methods=[GET]

/v3/stadiums/{id}/update | methods=[PUT]

/v3/stadiums/{id}/delete | methods=[DELETE]

/v3/stadiums | methods=[GET]

/v3/stadiums/{id}/teams | methods=[GET]

/v3/teams/name={name} | methods=[GET]

/v3/teams/create | methods=[POST]

/v3/teams/{id} | methods=[GET]

/v3/teams/{id}/update | methods=[PUT]

/v3/teams/{id}/delete | methods=[DELETE]

/v3/teams | methods=[GET]

/v3/teams/{id}/stadiums | methods=[GET]

/v3/teams/{id}/players | methods=[GET]

/v3/teams/{id}/country | methods=[GET]

/v3/teams/{id}/sponsors | methods=[GET]