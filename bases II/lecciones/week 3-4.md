# weeks from february 20th to march 3rd

## tópicos

1. último entregable de caso #1 
2. sql avanzado, instrucciones para análisis de datos 
3. introducción a bases de datos nonSQL y documentales 
4. introducción de mongodb 

## actividades fuera de clase

1. Cargar la base de datos del caso #2 

2. Estudiar las siguientes instrucciones avanzadas de SQL Server 

https://learn.microsoft.com/en-us/sql/t-sql/functions/row-number-transact-sql?view=sql-server-ver16

https://learn.microsoft.com/en-us/sql/t-sql/functions/ntile-transact-sql?view=sql-server-ver16

https://learn.microsoft.com/en-us/sql/t-sql/functions/last-value-transact-sql?view=sql-server-ver16

https://learn.microsoft.com/en-us/sql/t-sql/functions/first-value-transact-sql?view=sql-server-ver16

https://learn.microsoft.com/en-us/sql/t-sql/functions/lead-transact-sql?view=sql-server-ver16

https://learn.microsoft.com/en-us/sql/t-sql/functions/lag-transact-sql?view=sql-server-ver16

https://learn.microsoft.com/en-us/sql/t-sql/functions/rank-transact-sql?view=sql-server-ver16

https://learn.microsoft.com/en-us/sql/t-sql/functions/dense-rank-transact-sql?view=sql-server-ver16

https://learn.microsoft.com/en-us/sql/t-sql/functions/percent-rank-transact-sql?view=sql-server-ver16

https://learn.microsoft.com/en-us/sql/t-sql/functions/cume-dist-transact-sql?view=sql-server-ver16

Las lecturas anteriores se evaluaran con un ejercicio práctico a realizar en clase. 

3. Leer el siguiente resumen comparativo de noSQL versus SQL 
- NoSQL overview deck.pdf , está en el dropbox

esta lectura se evaluará por medio de un quiz

4. Bajar la imagen de mongodb en docker 

5. Estudiar en que consiste el formato de información json https://www.json.org/json-en.html y practique escribir jsons ya sea usando un editor de texto que permita formateo json como lo es sublimetext, o bien vscode o alguna herramienta online tal como https://jsonformatter.org/json-editor  o https://codebeautify.org/online-json-editor 


## actividades dentro de clase

Con la base de datos del caso #1 
-------------------------

1. se van a crear 4 grupos de trabajo y cada grupo de trabajo va a seleccionar un modelo de datos del caso #1 ya hecho de alguno de los miembros para trabajar este ejercicio. No hay ningun requerimiento específico del modelo pero va ayudar mucho si ya cuenta con datos cargados.

2. Los grupos van a tener un nombre y una responsabilidad 

redthief y pinkthief: los miembros de este equipo van a observar el modelo de datos seleccionado y van a escribir una lista de 2 situaciones en las que dicha base de datos podría verse comprometida a nivel de datos, se entiende como comprometida situaciones parecidas a las siguientes:

- un usuario interno del sistema con un nivel mínimo de sql y acceso a la base de datos podría "robar" dinero o productos 
- los empleados pudieran conseguir regalías, más dinero, ascensos, beneficios personales o evitar sanciones 
- podria sacar información valiosa que pueda ser usada en otras plataformas 
- el dba es el principal sospechoso 
- revelar los datos en forma pública haría que los consumidores no quieran usar el servicio

redlock y pinklock: examinando los procesos del sistema que debe seguir la base de datos, los miembros de este equipo van a asumir que hay una gran cantidad de usuarios de todo tipo usando el sistema, miles o cientos de miles. Asuma que se realizan muchas operaciones concurrentes en lineas de tiempo muy ajustadas, encuentre al menos 2 pares complementarios posibles de operaciones que podrían producir un deadlock en el sistema. Recomendaciones:

- declare con claridad cuáles son los supuestos de acceso múltiple en los procesos
- un par complementario se refiere a una transacción T1 que al realizar una operación, es muy probable que entre en deadlock con otra transacción T2 pues son procesos que pueden suceder de forma simultánea
- revise los flujos funcionales del sistema para encontrar posibles procesos independientes que entren en interbloqueos

Lo anterior cada grupo lo va a escribir en el espacio respectivo de cada grupo en el siguiente board:
https://jamboard.google.com/d/1VEytUfdJGQS_HyjleBUbeyXr1OjbhkgGfHx0WuxBxH0/edit?usp=sharing

3. Se realiza un intercambio bidireccional según el color, redthief va a resolver los retos de redlock y viceversa. Por otro lado pinkthief va a resolver los retos de pinklock y viceversa. 

*_Temas recomendados a investigar para resolver problemas de seguridad de datos_* 

- checksum by sha2/md5
- cryptography in sql server
- logs
- impersonate

*_Temas recomendados a investigar para resolver problemas deadlocks_* 

- transaction isolation level
- locks in transactions 
- temporary tables 
- mem tables
- design for insertions 

4. Se van hacer exposiciones de las soluciones que se calificaran usando un jurado conformado por el profesor y un miembro de cada equipo 
https://www.scrumpoker-online.org/en


Con la base de datos proporcionada por el profesor
-------------------------

1. realizar los ejercicios del caso #2 

ejercicio #1
ARAYA PADILLA RICHARD ARMANDO
GUILLEN RAMIREZ HECTOR DANIEL
BARBOZA ARTAVIA JOSE MARIO
MURCIA MORA CARLOS ANTONIO
RODRIGUEZ MURILLO MANUEL ALEJANDRO
SALAZAR RODRIGUEZ DAVID ALBERTO

ejercicio #2
CORDOBA CHEVEZ KEVIN GERARDO
CRUZ SOLIS EVELYN DE LOS ANGELES
CRUZ GUZMAN SEBASTIAN ERNESTO
ACUÑA LOPEZ RODOLFO DAVID
BRENES GARITA ALEXANDER DE JESUS

ejercicio #3
ALFARO PARRALES MONICA MARIA
HIDALGO NAVARRO JOSE PABLO
MARRERO VIQUEZ ALFREDO BERNARDO
RODRIGUEZ GARCIA PAUL ANDRES
MOLINA PERAZA LUIS FERNANDO

ejercicio #4
QUIROS ARAYA STEPHANIE VIVIANA
VARGAS MESEN SEBASTIAN ALONSO
NUÑEZ CRUZ KEVIN VINICIO
SANCHEZ RODRIGUEZ CAMILO
VASQUEZ MONSALVE JAVIER ENRIQUE

ejercicio #5
CHAVES REYES AXEL ALEXANDER
SANABRIA MARROQUIN RAUL
SAMUELS PINNOCK IAN SHEMAR
NAVARRO BADILLA DEYNER ANDRES
GUZMAN RAMIREZ ESTEBAN DE JESUS
ALVAREZ MAYORGA JOSUE


NonSQL e intro a mongoDB
-------------------------

1. Hacer el quiz de comprobación de lectura nonSQL

2. Ingresar a la consola de mongodb, creando una base de datos que se llama turismorural

3. Diseñe un json para alguno de los siguientes contextos

    3.1 se desea desplegar en una página web relacionada al volcán irazú un catálogo de souvenirs disponible para la venta al turismo , solo interesa el despligue de los souvenirs y que los mismos tengan categorías para poder encontrarlos más fácilmente

    3.2 se quiere desplegar en una página web todos los festejos populares, turnos, corridas de toros que están sucediendo a lo largo del país a partir de la fecha actual 

4. Proceda a crear un collection basado en el json del modelo anteriormente hecho y salve al menos 3 registros diferentes 

5. Haga el display de todos los registros usando un pretty

6. Haga el display de uno de los registros usando alguna igualdad en la búsqueda 

