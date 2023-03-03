# weeks from february 20th to march 3rd

## actividades fuera de clase

1. Realizar las siguientes lecturas

https://dev.mysql.com/doc/refman/8.0/en/create-table.html
de esta lectura se espera que sepa crear un table por comandos, definiendo como mínimo primary keys, foreign keys, default values, not null, comments, auto incrementales

https://dev.mysql.com/doc/refman/8.0/en/insert.html
sea capaz de insertar datos en una tabla especificando las columnas y sin especificarlo

https://dev.mysql.com/doc/refman/8.0/en/update.html
puede actualizar un dato de un campo específico usando algun campo o criterio de búsqueda

https://dev.mysql.com/doc/refman/8.0/en/delete.html
se considera capaz de borrar un registro específico, un subcojunto de registros o bien todos los registros

https://dev.mysql.com/doc/refman/8.0/en/select.html
es capaz de escribir un select especificando los campos, haciendo uso de aliases para los campos y las tablas, encontrar registros específicos o bien un subconjunto de registros delimitado por varios filtros, también puede ordenar los registros; además puede escoger la cantidad de registros que quiere retornar. 

las lecturas se van a comprobar por medio de un quiz práctico.

2. crear un diseño inicial en workbench para el caso #2, marcar con colores o etiquetas de colores los patrones de diseño de datos aplicados que sean evidentes en el diseño propuesto 


## actividades dentro de clase

1. utilizando el modelo del copero, proceda a hacer release de la base de datos a mysql
forward engineer para pasar del diagrama a la base de datos

2. con ayuda el profesor realice inserts, updates, deletes y selects en las tablas diseñadas

3. se van a crear grupos de trabajo en parejas de forma aleatoria, los grupos pueden ser blue o green, respectivamente van a agregarle al diseño de coperos el requerimiento asignado según el color.

_blue:_ el sistema ha sido todo un éxito y ahora es necesario tener varios carritos de copos y tener varios coperos para atender a lo largo de toda la playa, la demanda ha sido alta. Es necesario saber información como el nombre completo del copero, teléfono e identificación. Los carritos van a tener un tipo de placa de 4 dígitos y un color, con el cuál se van a identificar. A la hora de registrar las ventas va a ser necesario dejar claro de cuál carrito y de cuál copero se trata. 

_green:_ dado que son varios coperos, el dueño de la idea tiene temor que se desperdicie o que le roben producto como las leches, licores, mezclas, en general los ingredientes necesarios para hacer los copos y los cocteles. Para ello va ser necesario saber de los ingredientes disponibles la cantidad con la que salen los carritos a vender, también va ser necesario para cada producto saber la cantidad requerida de ingredientes. De esa forma, sabiendo la cantidad de ingredientes con los que sale el carrito en la mañana versus las ventas, queda claro cuánto de cada ingrediente se va acabando. El conteo de los ingredientes en la mañana debe estar asociado a un copero que acepta la cantidad con que recibe el carrito. 

4. Procedan a agregar a su modelo en workbench las tablas necesarias para resolver el requerimiento solicitado. Se procede a revisar los modelos propuestos. 

5. El profesor aleatoriamente ahora va a mezclar grupos verdes con azules para generar una versión unificada del modelo. Se procede a revisar los modelos propuestos. 

Patrones de diseño 
- maestro detalle
- media
- caracerísticas variables
- transacciones


Para efectos de valorar diseños

- se crean 5 canales para los 5 requerimientos del caso #2
- se unen parejas a los canales para que en conjunto generen una propuesta de diseño en workbench que cumpla con el requisito
- el profesor hará chequeos en todos los grupos para ver lo discutivo

