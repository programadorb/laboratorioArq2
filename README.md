## Laboratorio Arquitectura 2


## Integrantes
Alejandro Villegas Lopez.<br />
Daniel Molina Yepes.<br />
Johan Estiven Ospina Hincapié .<br />
Johan Camilo Suárez Lopera .<br />
Juan Pablo Rios Arenas .<br />
Juan Diego Isaza Londoño .<br />

## Descripción
Aplicación JEE que simula una pararela de pago

## Instrucciones despliegue
1. Iniciar el servidor Glassfish (glassfish-4.1.1).
2. Iniciar la base de datos Derby.
2. Correr el script "scripts/01-bd.sql" sobre una base de datos derby. (se puede usar el siguiente comando "ij 01-bd.sql").
3. Ejecutar el comando "mvn package".
4. Desplegar el archivo "target/laboratorio2.war" en el servidor Glassfish.
5. Acceder mediante la siguiente ruta  http://localhost:8080/laboratorio2/


