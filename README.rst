REST API using Dropwizard with in memory database H2
====================================================

Very simple setup. Things as tests and authentication are lacking.

Starting the H2 database::

        java -jar h2/bin/h2*.jar


Create an employee::

        curl -H "Content-Type: application/json" -X POST -d '{"name":"test","phoneNumber":"90302131", "acronym": "mm"}' http://localhost:8080/Employee


Retreive all employees::

        curl localhost:8080/Employee/getAll
