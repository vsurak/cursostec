# weeks from march 13th to 24th

## actividades fuera de clase

1. Realice el siguiente tutorial con las categorías del 1 al 6, https://www.mongodb.com/docs/manual/tutorial/getting-started/  

2. Realice el siguiente tutorial https://www.w3schools.com/mongodb/mongodb_get_started.php
hasta Aggregation $match inclusive. 

3. Video tutorial opcional de 30 minutos, https://www.youtube.com/watch?v=pWbMrx5rVBE

Los tutoriales se verificaran por medio de un ejercicio práctico a realizar el miércoles 22 de marzo, quiz #8

subject: Bases de datos II - quiz #8
to: fvsasistencia@gmail.com

4. desarrollo del caso #3

## actividades dentro de clase

1. Introducción teorica al por qué usamos non SQL y en general bases de datos documentales como mongo, non sql.pdf, dropbox

2. Estudie en conjunto con el profesor los tipos de modelaje documental para mongoDB, one to one, one to many embedded, one to many references

https://www.mongodb.com/docs/manual/tutorial/model-embedded-one-to-one-relationships-between-documents/

3. Ejercicio de diseño básico en mongodb, quiz #6. En la siguiente imagen encontrará una salida de un listing de airbnb. Proceda a realizar un diseño documental acorde a este display, para todos los campos. Diseñe el json ejemplo para dos propiedades e insertalas en un collection hecho en mongo. Deberá entrega los json y screenshots de las operaciones de insert/write, y de la operación find con pretty. 

subject: Bases de datos II - quiz #6
to: fvsasistencia@gmail.com
fecha de entrega: viernes 17 a medio noche

<img src="airbnb_mongo_design.png" width=50% height=50%>

```sh
docker run --name mimongoserver -d mongo

docker exec -it mimongoserver bash

mongosh

show databases;

db.characters.insert({"id" : 1,"nombre": "Kevin","nivel": 10,"atuendo": {"camisa": "blanco","pantalon":"negro","zapatos": "negro"}});

show databases;

show collections;

db.characters.find();

```

4. Grupos de lectura sobre la arquitectura de mongodb, MongoDB_Architecture_Guide.pdf, dropbox, quiz #7

A continuación aparecen diferentes tópicos desarrollados en el documento anteriormente mencionado y grupos de trabajo asignados por el profesor. Procedan en grupo a estudiar y analizar la sección específica y diseñen un tipo de infograma que permita explicar resumidamente las capacidades y características técnicas de mongo que se explican en dicha sección del documento.

Detalles

- asegúrese de dar más énfasis en lo visual que lo textual
- apóyese de figuras, formas o metáforas visuales
- tenga siempre presente que la audiencia son sus compañeros de clase y tiene la responsabilidad de explicarles en detalle lo estudiado
- una vez que tenga la imagen lista proceda a pegar un mensaje en el canal general de discord antes de las 11am del día de hoy 17 de marzo, el mensaje debe contener: título del tema, lista de integrantes que participaron en el ejercicio, imagen desarrollada

La evaluación de este quiz #7 se hará mediante el material compartido en dicho channel. 

Tópicos:

How we run applications
VARGAS MESEN SEBASTIAN ALONSO
CORDOBA CHEVEZ KEVIN GERARDO
QUIROS ARAYA STEPHANIE VIVIANA


Key innovations in mongodb
RODRIGUEZ MURILLO MANUEL ALEJANDRO
SANABRIA MARROQUIN RAUL

Query types
HIDALGO NAVARRO JOSE PABLO
ALFARO PARRALES MONICA MARIA
ALVAREZ MAYORGA JOSUE

Indexing
MURCIA MORA CARLOS ANTONIO
CRUZ SOLIS EVELYN DE LOS ANGELES
GUILLEN RAMIREZ HECTOR DANIEL

Auto Sharding
MOLINA PERAZA LUIS FERNANDO
SANDI BARRANTES STUART JOSUE
CHAVES REYES AXEL ALEXANDER

Consistency and durability
RODRIGUEZ GARCIA PAUL ANDRES
CRUZ GUZMAN SEBASTIAN ERNESTO
NUÑEZ CRUZ KEVIN VINICIO

Journaling
BARBOZA ARTAVIA JOSE MARIO
NAVARRO BADILLA DEYNER ANDRES
VASQUEZ MONSALVE JAVIER ENRIQUE

Replication
BRENES GARITA ALEXANDER DE JESUS
SANCHEZ RODRIGUEZ CAMILO
GUZMAN RAMIREZ ESTEBAN DE JESUS

Security
ARAYA PADILLA RICHARD ARMANDO
SALAZAR RODRIGUEZ DAVID ALBERTO
ACUÑA LOPEZ RODOLFO DAVID

Si alguna persona no fué asignada a un grupo unirse al de "Key innovations in mongodb".


Se evalua por exposición de grupo en clase. 

5. Introducción a sharding y replica set

6. Ejercicio de implementación de un cluster en mongodb, para caso caso #4