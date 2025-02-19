# week from may 1st to 5th

## actividades fuera de clase
- estudiar el capítulo 21, hasta el punto 21.3 inclusive, y adicionalmente la sección 21.6. Esta se evaluará en un quiz práctico que será el #11 y un quiz teórico que será enviado al correo el miércoles 3, el cual sería el quiz #12. 


## actividades en clase

- ejecución del quiz #11, estudio y prueba de los problemas de concurrencia en base de datos 

1. crear una tabla que liste 3 posibles stored procedures que sean necesarios para que el sistema del caso #3 efectivamente funcione, es decir:
    - existen una operación atómica que realizar un usuario o un proceso que debe modificar más de una tabla bajo los principios ACID
    - enfóquese en transacciones que se realicen de forma más seguida en la operación día a día de esencial verde 
    - para cada stored procedure transaccional defina en pseudo SQL las operaciones de lectura y escritura que debe realizar en orden

2. proceda a estudiar en que consiste el lost update y los deadlocks

3. mezclando la sintaxis del punto #1 de forma análoga a como navatte desarrolla las operaciones read y write, determine un caso posible según sus transacciones donde podría darse un lost update y un deadlock 

4. el profesor podría solicitarle que exponga lo realizado en el punto #1 y #3

subject: Bases de datos I - quiz #11
entrega al asistente al final de clase, incluir material hecho en el punto #1 y #3

- explicación del recurso crítico que significa las conexiones a la base de datos y de ser posible de lo que es REST

5. A continuacón aparecen una serie de temas con una lista de interrogantes que desafían las soluciones implementadas participantes del "big picture" de las arquitecturas end to end, en un contexto enfocado en su relación con las bases de datos:

### database conexion pooling
1. cómo me explicarían es el funcionamiento en tamaños fijos y en tamaños con comportamientos más personalizados, cómo para que casos de sistemas de la vida real creen que podría funcionar una estrategia versus la otra. 

2. por qué razón consideran que esta técnica podría reducir sustancialmente el uso de recursos en los servidores y hasta incluso incrementar el rendimiento?

### database cache 
1. cuáles son los principios en los que se basa una cache para agilizar la obtención de datos de tal forma que favorezca a la información más altamente consultada?

2. Que soluciones o productos que faciliten la incorporación de una cache en una arquitectura de datos podrían recomendar y por cuál razón, si se tratara de una plataforma que atiende a casi 10 millones de personas que necesitan consultar información geo localizada. 


### ORM Object to relational maping
1. que ventajas podría tener un equipo de desarrollo de utilizar un ORM en lugar de llamadas directas a stored procedures, contemplando, la forma en que dichas consultas en ORM son traducidas a operaciones del motor de base de datos específico.

2. compare el cómo se hacen consultas con funciones agregadas y condicionales entre la forma de hacerlo en un ORM versus SQL, cree que podría haber ventajas o desventajas entre ambas opciones? Bajo que situaciones recomendaría uno u otro?


### REST and json
1. como podríamos entender la diferencia y la función que existe entre http, rest y services para lograr crear plataformas capaces de crecer de 100 usuarios a miles de usuarios?

2. que ejemplos podría explicar en como la representación de datos en formato json podría facilitar la transferencia de datos al frontend para construir contenido web más rápido?

