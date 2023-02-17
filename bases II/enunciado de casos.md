# caso #1, 10%

*instituto tecnológico de costa rica*, escuela de computación  
*bases de datos II*  
_prof. rodrigo núñez_  
*tipo:* parejas  

## descripción
la empresa ferianueva de costa rica quiere crear una plataforma web donde las personas inscritas puedan comprar frutas, verduras y otros productos de consumo que estaban destinados a ser desperdicio. ferianueva se encarga de recoger dichas frutas y verduras, restaurarlos para que sean aprovechables para consumo; tomar productos procesados o otros que tienen defectos o fechas próximos a vencimiento que ha recolectado de un proceso logístico y los vende en un ecomerce. una vez que una persona registrada compra los productos, ferianueva se encarga de entregarlos en una única ruta que hace 2 veces por semana.

entre los retos más importantes que tiene feria nueva son:

1. mantener el inventario de productos disponible incluso con antelación desde antes de irlo a recoger y luego de restaurarlo

2. organizar en el espacio físico de bodegaje el producto listo para vender y entregar

3. que el camión de entrega sepa bien que productos son los que tiene que entregarle a cada persona en la ruta en ese día

4. asegurarse que el consumidor reciba un producto en buen estado y que el repartidor le haya dado un servicio amable y completo

proceda a realizar un diseño para la base de datos de ferianueva hecho en sql server. luego una vez que tenga el diseño proceda a cargar de información de tal forma que se tengan: 

- al menos 15 productos
- al menos 20 personas registradas
- entre 1 a 3 ordenes de varios productos por persona en 4 semanas en el pasado y que hayan sido entregadas

el líder técnico quiere que usted le demuestre con su base de datos diseñada, implementada y con datos que podrá dar respuesta a las siguientes incognitas:

## preliminar #1, 15 de febrero, 20pts
1. cuál es el top 5 de compradores estrella

2. cuál es el top 5 de productos más vendidos en los últimos 15 días

3. cuál es el total de compras por persona

4. cuál es el total vendido por producto 

- contenido: un archivo sql con todos los scripts necesarios

## preliminar #2, 22 de febrero, 40pts

5. determinar si existe al menos una diferencia de carga de trabajo del 20% entre los dos días de entrega

6. cuáles son las principales razones por las que el consumidor devuelve producto

7. demostrar que las operaciones de ordenar productos y agregar productos a bodega pueden ser transaccionales 

8. demostrar si va a ser posible crear vistas que ayuden a la implementación del sistema

- contenido: un archivo sql con todos los scripts necesarios

## entrega final #3, 27 de febrero, 40pts
9. demostrar bajo que circustancias en su modelo podrían suceder problemas de dirty read, lost update y phantoms

10. demostrar bajo que circustancias en su modelo podrían darse deadlocks 

11. como se defiende su modelo ante fraudes donde el sistema se ve comprometido con los datos para beneficio de alguna persona 

- contenido: un archivo sql con todos los scripts necesarios

## aspectos operativos
- entrega al asistente al correo: fvsasistencia@gmail.com
- subject: bases 2 - caso #1 - <entregable> 


