# caso #1, 10%

*instituto tecnológico de costa rica*, escuela de computación  
*bases de datos I*  
_prof. rodrigo núñez_  
*tipo:* individual  

## descripción
la empresa rvark ha comprado una flotilla de campers tipo rv para rentarlos en costa rica, cada RV tiene tamaños y características diferentes como las que se pueden ver en estos sitios:

https://www.hilltopcamper.com/blog/must-have-features-for-your-rv/ 

https://www.gorving.com/tips-inspiration/expert-advice/8-trending-rv-features-2021 

https://worldwidecampers.com/en-us/suppliers/bunk-campers/bunk-aero-plus/ 

https://worldwidecampers.com/en-us/suppliers/road-bear/slide-out-class-c-28-30-ft/ 


las personas van a ingresar a un sitio web donde van a poder ver todos los diferentes campers disponibles para las fechas deseadas, luego al oprimir el botón de cotizar, se le pedirá ciertos datos como nombre completo, nacionalidad, fecha de nacimiento, email y teléfono. con esa información se estaría creando una solicitud de camper que un operador va a leer y contactará a la persona para terminar de afinar detalles del camper, extras, precio final y realizar el pago, estos últimos pasos que hace el operador son controlados en un sistema aparte que no es parte de este caso.

## preliminar #1, 15 de febrero, 20pts 

1. cómo sería el diseño conceptual de datos de los campers?

2. cómo sería el diseño conceptual de datos de las solicitudes de cotización?

3. qué estandard de nombres utilizaría para este modelo de datos? cuáles reglas mínimas? 

- contenido de la entrega: pdf con el modelo conceptual y bullets con las reglas para el estandar de nombres 

## preliminar #2, 22 de febrero 
4. cómo podría hacerse el diseño físico de las fotografías de los campers? en workbench

5. cómo lograría tener tantos atributos diferentes por tipo de camper?

6. cómo podría hacerse el diseño físico de las solicitudes de cotización? 

- contenido de la entrega: pdf con el diseño físico hecho en workbench de las fotografías de los campers y las solicitudes de cotizacion 


# entrega final, 24 de febrero, 50pts
cuál sería el diseño de base de datos relacional ideal que usted implementaría en mysql para lograr tener el catálogo de los rvs con toda su información y que los usuarios puedan hacer la solicitud de cotización. una vez que tenga el diseño ideal pruébelo generandolo en mysql y agregando unos cuantos registros de prueba para demostrar que su diseño efectivamente funciona y cumple con lo solicitado. 

- contenido de la entrega: pdf con el modelo conceptual de datos, pdf con el modelo de datos físico, script generado para la creación de base de datos, los inserts y selects hechos para la prueba 

## aspectos operativos
- entrega al asistente al correo: fvsasistencia@gmail.com 

- subject: bases 1 - caso #1 - <entrega> 


---

# caso #2, 15%

*instituto tecnológico de costa rica*, escuela de computación  
*bases de datos I*  
_prof. rodrigo núñez_  
*tipo:* parejas  

## descripción

resultó que el servicio de copos y cocteles directamente en la playa resultó ser todo un éxito, ha generado empleo en la zona, encadenamiento de productores de licores, frutas para los cocteles, hielo, lácteos y hasta desarrollo de integraciones de software. es necesario ahora evolucionar el modelo para poder brindar un mayor servicio a los turistas que visitan nuestras playas, se han identificado los siguientes requerimientos clave:

1. los carritos algunas veces se quedan sin hielo o sin ingredientes suficientes, por lo que se requiere hacerles relleno de ingredientes conforme van vendiendo durante el día, dicho relleno debe considerarse entre el inventario de ingredientes que tiene un carrito. 

2. los coperos en algunos casos hacen turnos, es decir, un mismo carrito lo puede tener un copero en un horario y otro en otro horario. Cuando se da este tipo de relevo, el copero entrante tiene que recibir la caja y recibir el inventario de producto, el cuál podría estar de acuerdo con lo recibido, o recibirlo con diferencias. 

3. otra característica importante es que ahora las personas pueden ingresar a un sitio web y ordenar desde ahí sus copos y cocteles, el sitio web captura su ubicación geográfica en la playa para que alguno de los carritos cercanos pueda llegar y atender la solicitud. Al ordenar puede indicar los productos y la cantidad deseada, así como comentar si tiene algun requerimiento especial. 

4. además, ha tenido tanto éxito el servicio, que ahora se atienden múltiples playas de la zona, siempre es importante saber en que playa está cada carrito, el copero, y en cúal de ellas es que se realiza la venta y solicitudes de producto. Dado que las playas están a distancias diferentes, algunos productos podrían tener precios diferenciados según la playa en que se encuentren.

5. los coperos ganan un salario por una comisión de ventas, es decir, de cada producto que venden reciben un % el cuál debe ser configurable. Cada fin de semana el sistema determina lo vendido y ganado de cada copero y realiza el pago depositandole a su cuenta de banco la suma de los fees hechos durante la semana. 

*_usted ahora como estudiante debe abordar los siguientes retos:_* 

1. crear un diseño de base de datos que permita resolver esta nueva evolución del sistema de copos en la playa 

2. demostrar que su diseño responde correctamente llenandolo de datos ficticios de 6 meses de ventas hechas de más de 10 productos , donde ocurrieron de 10 a 60 ventas diarias por carrito, que existan al menos 3 playas y 15 carritos, 30 coperos; y que definitivamente las ventas sean mucho mayor durante sábados y domingos comparado con los días entre semana. 
registrar una venta deberá hacerse por medio de un stored procedure. 

3. demuestre que es posible crear una consulta o varias para saber cuánto se gasto, cuánto se ganó por semana en todo el negocio, además de saber cuánto se le debe pagar a cada copero. 

4. además demuestre que es posible mostrarle al dueño cada semana datos que confirmen que no se están robando o malgastando los ingredientes en la elaboración de los productos, entender los márgenes de ingredientes usados en ventas versus los ingredientes que se cargan en el carrito. cree vistas que le ayuden a realizar esta extracción de datos. 

5. debido a que pueden existir errores de conexión en las playas, se recomienda que modifique el stored procedure de registrar ventas para que sea transaccional. demuestre que se comporta correctamente la transacción cuando es exitosa o cuando falla. 

6. otro problema que podría darse y se le requiere que encuentre una solución tiene que ver con el inventario de ingredientes cuando un copero recibe el carrito, esto porque debe registrar los K ingredientes con sus cantidades según el conteo que haga, cómo podría ser dicha operación transaccional también. considere el uso de tablas temporales o tablas borrador. 


# preliminar #1, jueves 9 de marzo, 40pts 
- diseño de la base de datos terminado, entregado como pdf y como script de creación de mysql

# preliminar #2, martes 14 de marzo, 30pts
- base de datos llena , reto #2 #3 y #4
- entrega script de creación y llenado, además script con las consultas en mysql 

# entrega final, jueves 23 de marzo, 30pts
- diseño y script de creación de todo el modelo
- stored procedures transaccionales de los retos #5 y #6 

## aspectos operativos

- entrega al asistente al correo: fvsasistencia@gmail.com 

- subject: bases 1 - caso #2 - preliminar #x
