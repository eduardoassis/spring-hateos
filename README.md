# spring-hateos
Learning spring hateoas

# Scenario:

We have a Product Entity with One to Many relationship with Image entity

Product also has a Many to One relationship with itself (Many Products to one Parent Product) 

1º Build a Restful service using JAX-RS to perform CRUD operations on a Product resource using Image as a sub-resource of Product.

2º Your API classes should perform these operations:

1) Create, update and delete products
2) Create, update and delete images
3) Get all products excluding relationships (child products, images) 
4) Get all products including specified relationships (child product and/or images) 
5) Same as 3 using specific product identity 
6) Same as 4 using specific product identity 
7) Get set of child products for specific product 
8) Get set of images for specific product


3º Build JPA/Hibernate classes using annotations to persist these objects in the database 

Technical Specification:

1) Maven must be used to build, run tests and start the application.
2) The tests must be started with the mvn test command.
3) The application must start with a Maven command: mvn exec:java, mvn jetty:run, mvn spring-boot:run, etc.
4) The application must have a stateless API and use a database to store data.
5) An embedded in-memory database should be used: either H2, HSQL, SQLite or Derby.
6) The database and tables creation should be done by Maven or by the application.
