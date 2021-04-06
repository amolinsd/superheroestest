# superheroestest
Superheroes project as Test for Oxigent

Documentación Api:

Definición:

Se ha realizado una API utilizando Spring Boot 2 y Java 11 que guarda los datos en una bbdd H2 que utiliza memória local. Este tipo de bbdd es muy útil para este tipo de 
aplicaciones porque simplifica mucho su integración pero hay que tener en cuenta que funcionarà solo mientras el servidor este levantando y que si lo reiniciamos, la información
que contenga se perderà.

Servicios:

Para poder trabajar con la lista de Superheroes se ha utilizado principalmente el JpaRepository. A continuación se detallan las acciones que realiza:

*createSuperhero -> Crea un nuevo superheroe en la base de datos.
*updatedSuperhero -> Actualiza los datos del superheroe medante el id.
*getAllSuperheroes -> Recupera la lista de superheroes.
*getAllSuperheroesByPartName -> Recupera la lista de superheroes que contienen en el nombre el parametro enviado.
*getSuperheroById -> Recupera un superheroe mediante el id.
*deleteSuperhero -> Elimina un superheroe mediante el id.

Testeo:

Se han realizado los tests para varios servicios en la clase SuperHeroesApplicationTests a modo de ejemplo (JUnit).

Para probar la Api, se ha realizado la siguiente colección en Postman -> https://www.getpostman.com/collections/4786e412b2ee14c80424-

Docker:

Se ha integrado el Dockerfile i el plugin Eclipse Docker Tooling pero por imcompatibilidades con el entorno no se ha podido dockerizar el proyecto.








