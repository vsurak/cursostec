# caso #1, 10%

_instituto tecnológico de costa rica_, escuela de computación  
_bases de datos I_  
_prof. rodrigo núñez_  
_tipo:_ individual

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

## preliminar #2, 22 de febrero, 30pts

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

_instituto tecnológico de costa rica_, escuela de computación  
_bases de datos I_  
_prof. rodrigo núñez_  
_tipo:_ parejas

## descripción

resultó que el servicio de copos y cocteles directamente en la playa resultó ser todo un éxito, ha generado empleo en la zona, encadenamiento de productores de licores, frutas para los cocteles, hielo, lácteos y hasta desarrollo de integraciones de software. es necesario ahora evolucionar el modelo para poder brindar un mayor servicio a los turistas que visitan nuestras playas, se han identificado los siguientes requerimientos clave:

1. los carritos algunas veces se quedan sin hielo o sin ingredientes suficientes, por lo que se requiere hacerles relleno de ingredientes conforme van vendiendo durante el día, dicho relleno debe considerarse entre el inventario de ingredientes que tiene un carrito.

2. los coperos en algunos casos hacen turnos, es decir, un mismo carrito lo puede tener un copero en un horario y otro en otro horario. Cuando se da este tipo de relevo, el copero entrante tiene que recibir la caja y recibir el inventario de producto, el cuál podría estar de acuerdo con lo recibido, o recibirlo con diferencias.

3. otra característica importante es que ahora las personas pueden ingresar a un sitio web y ordenar desde ahí sus copos y cocteles, el sitio web captura su ubicación geográfica en la playa para que alguno de los carritos cercanos pueda llegar y atender la solicitud. Al ordenar puede indicar los productos y la cantidad deseada, así como comentar si tiene algun requerimiento especial.

4. además, ha tenido tanto éxito el servicio, que ahora se atienden múltiples playas de la zona, siempre es importante saber en que playa está cada carrito, el copero, y en cúal de ellas es que se realiza la venta y solicitudes de producto. Dado que las playas están a distancias diferentes, algunos productos podrían tener precios diferenciados según la playa en que se encuentren.

5. los coperos ganan un salario por una comisión de ventas, es decir, de cada producto que venden reciben un % el cuál debe ser configurable. Cada fin de semana el sistema determina lo vendido y ganado de cada copero y realiza el pago depositandole a su cuenta de banco la suma de los fees hechos durante la semana.

_*usted ahora como estudiante debe abordar los siguientes retos:*_

1. crear un diseño de base de datos que permita resolver esta nueva evolución del sistema de copos en la playa

2. demostrar que su diseño responde correctamente llenandolo de datos ficticios de 6 meses de ventas hechas de más de 10 productos , donde ocurrieron de 10 a 60 ventas diarias por carrito, que existan al menos 3 playas y 15 carritos, 30 coperos; y que definitivamente las ventas sean mucho mayor durante sábados y domingos comparado con los días entre semana.
   registrar una venta deberá hacerse por medio de un stored procedure.

3. demuestre que es posible crear una consulta o varias para saber cuánto se gasto, cuánto se ganó por semana en todo el negocio, además de saber cuánto se le debe pagar a cada copero.

4. además demuestre que es posible mostrarle al dueño cada semana datos que confirmen que no se están robando o malgastando los ingredientes en la elaboración de los productos, entender los márgenes de ingredientes usados en ventas versus los ingredientes que se cargan en el carrito. cree vistas que le ayuden a realizar esta extracción de datos.

5. debido a que pueden existir errores de conexión en las playas, se recomienda que modifique el stored procedure de registrar ventas para que sea transaccional. demuestre que se comporta correctamente la transacción cuando es exitosa o cuando falla.

6. otro problema que podría darse y se le requiere que encuentre una solución tiene que ver con el inventario de ingredientes cuando un copero recibe el carrito, esto porque debe registrar los K ingredientes con sus cantidades según el conteo que haga, cómo podría ser dicha operación transaccional también. considere el uso de tablas temporales o tablas borrador.

# preliminar #1, jueves 9 de marzo, 40pts

- diseño de la base de datos terminado, entregado como pdf y como script de creación de mysql

# entrega final, lunes 27 de marzo, 60pts

- base de datos llena , reto #2 #3 y #4
- entrega script de creación y llenado, además script con las consultas en mysql
- diseño y script de creación de todo el modelo
- stored procedures transaccionales de los retos #5 y #6
- si va a ree entregar , enviar al asistente el mismo subject y concatenar en mayuscula REENTREGA

## aspectos operativos

- entrega al asistente al correo: fvsasistencia@gmail.com
- subject: bases 1 - caso #2 - preliminar #x
- si va a ree entregar , enviar al asistente el mismo subject y concatenar en mayuscula REENTREGA

---

# caso #3, 30%

_instituto tecnológico de costa rica_, escuela de computación  
_bases de datos I_  
_prof. rodrigo núñez_  
_tipo:_ parejas

## descripción

la organización costarricense _*esencial verde*_ es reconocida como la mayor autoridad mundial en el tema de gestión integral de los residuos en el continente americano y algunos países de europa. es la organización más grande que vela por el correcto manejo de los deseños generados de procesos productivos y de servicios al consumidor.

<img src="https://github.com/vsurak/cursostec/blob/master/bases%20I/media/rediduos.png" width=50% height=50%>

esencial verde para llevar a cabo su ardua misión de mantener bajo control una gran cantidad de residuos que otras empresas y personas producen, creando un balance con el ambiente debe valerse de muchos actores y procesos:

1. cuenta con una red registrada de productores de residuos, estos son desde detallistas como supermercados, restaurantes, oficentros y centros comerciales; grandes cadenas como por ejemplo KFC, Taco Bell, hoteles y otros; hasta residuos industriales relacionados a industrias de manufactura de productos y alimentos como grandes fábricas. La organización tiene correctamente mapeados a esos productores geográficamente, con información de contacto y conoce perfectamente sus ciclos de recolección en cada país y localidad, pues pueden variar de una a otra.

2. además, ha propiciado la creación de empresas locales y regionales para la recolección, empresas que han sido debidamente capacitadas y certificadas para realizar la labor de recolección de desechos en los productores de cierta zona.

3. el proceso de recolección de desechos puede suceder de 3 formas:

- esencial verde por medio de sus flotillas llega a los productores de residuos a recolectarlos
- una empresa de recoleción los recoje en los productores y seguidamente los lleva al punto de recolección más cercano de esencial verde
- el productor de los desechos lleva directamente los mismos al punto de recolección más cercano de esencial verde

4. para que la recolección sea satisfactoria ya sea el productor de desechos o las empresas recolectoras de desechos, deben utilizar recipientes de almacenamiento especializados según el tipo de desecho: químicos, aceites, aguas, cartón, papel, aluminio, biodegradable, etc. Existen diversos tipos de recipientes con multiples capacidades o tamaños, y cada tipo de recipiente puede ser usado para ciertos tipos de desechos específicos. Todos los recipientes poseen un peso lo que permite calcular fácilmente el peso de los residuos y todos los recipientes son reutilizables.

5. los recipientes deben tener un trazabilidad precisa, pues es de suma importancia poder saber con exactitud el origen y recorrido en el proceso completo que hayan tenido los residuos.

6. en todo proceso de recolección de residuos, se retiran aquellos usados y se entregan equivalentes ya limpios, podría ser necesario agregar nuevos recipientes ya sea por deterioro de alguno que haya que sacar de circulación o bien porque se necesitan más pues la cantidad de residuo ha incrementado.

7. esencial verde una vez que tiene los residuos en sus plantas los clasifica como desechos tratables y desechos reciclables/reutilizables. cuando se trata de desechos tratables, estos según el tipo de desecho van a recibir un procedimiento para su síntesis o al menos para que sea menos dañino antes de liberarse al ambiente. Todos estos procedimientos tienen un costo dependiendo del desecho y el volúmen del mismo. Cuando se trata de desechos reciclables, quiere decir que van a ser convertidos en otro producto, ese proceso de conversión tiene un costo, ulteriormente el nuevo productopuede ser vendido, generando una ganancia basada en las ventas del producto y los costos de producción.

8. cuando hay venta de productos basados en residuos, primero se cubren los costos de producción y las ganancias son repartidas entre los diversos actores del ciclo, entiéndase productures, recolectores, gobierno general, gobierno local, asociaciones, esencial verde o algun otro. quienes son esos actores y el % correspondiente a cada uno, se pacta en un contrato con las partes indicadas al momento que algún productor desea procesar sus residuos con esencial verde, y por ello, dependiendo del tipo de residuo, recolección, cantidad, periodicidad y varios otros criterios negociados se estableces tales porcentajes.

9. esencial verde es una organización internacional, por lo cual debe ser capaz de entregar sus sistemas en múltiples idiomas, realizar cobros y pagos multimoneda y su plataforma tecnológica es accedida desde cualquiera de los países donde opera.

10. existen empresas que son tan altamente contaminantes que les imposible equilibrar su deuda ambiental con respecto a la producción de residuos, entonces esas empresas tienen la posibilidad de pagarle a otros productores de residuos su factura de recolección y tratamiento de desechos.

# preliminar #1, martes 4 de abril, 10pts

- cada pareja de trabajo hará 2 preguntas al representante de esencial verde (el profesor) para aclarar requerimientos
- las preguntas no deberán ser repetidas entre los grupos de trabajo
- las preguntas deberán escribirse en el siguiente documento, cada pareja de trabajo use un card del documento para agregar sus dos preguntas. https://1drv.ms/w/s!AhkFUQ-eTrzhi59UKDb5TJQO6pkiQA?e=HButzG
- aproveche el ejercicio para hacer preguntas sustanciosas, apoyelas en imágenes, diseños de tablas, scripts, esquemas o media de apoyo

# preliminar #2, jueves 13 de abril, 15pts

- primer diseño de base de datos hecho en sql server, formato pdf
- enviar al profesor máximo a media noche
- email vsurak@gmail.com
- el profesor no hará revisiones completas de diagramas previo a este preliminar, solo consultas específicas
- este preliminar servirá como revisión general del diagrama

# preliminar #3, jueves 4 de mayo, 40pts

el arquitecto de la solución quiere someter su diseño a varios criterios de aceptación y así asegurar una escalabilidad mínima del sistema deseado, estos son los criterios a demostrar:

- debe ser posible hacer migrations de versiones de bases de datos para controlar lo que se encuentra en desarrollo, qa, stagging y production. se ha dado la directiva de que la creación inicial de la base de datos, todo lo que sea relacionado a creación de tablas irá en un script de ignición o cero, y que posteriormente cada item ya sea función, stored procedure, trigger, views, alters y similares, deberán llevar control de versiones un item por archivo. para simplificar la actualización y controlar las migraciones se va a utilizar [flyway](https://flywaydb.org/).

- basado en su diseño, si existe una consulta que requiera al menos 4 joins, cuál opción sería más eficiente: encapsular el query en una vista dinámica o en una vista indexada. Si hay diferencia encontrar una justificación teórica que justifique el hallazgo. la cantidad de datos deben ser lo suficiente para encontrar diferencias

- determinar una norma de estrategia de optimización para su diseño de base de datos, determinar una consulta real del sistema que contenga todos los componentes comunes de un query: fields, joins, left/right join, aggregate functions, except/intersect, group by, sort, for json, wheres sobre campos primary y non primary, igualdades y desigualdades. retornando una cantidad generosa de registros evalúe tiempos de ejecución y plan de ejecución de la consulta, y con ello diseñe un conjunto de pasos o normas, que debe seguir el equipo de desarrollo para garantizar que las consultas complejas se optimicen de una forma estandard y ordenada para la organización. Justifique cada normal con scripts ejemplos para hacer la demostración en tiempo real.

- basado en la plantilla para stored procedures transaccionales con error handling y nested transactions handling de sql server, cree un stored procedure realmente funcional para el sistema que reciba por parámetro al menos un [TVP](https://learn.microsoft.com/en-us/sql/relational-databases/tables/use-table-valued-parameters-database-engine?view=sql-server-ver16)

```sql
-----------------------------------------------------------
-- Autor: Rnunez
-- Fecha: 12/12/2011
-- Descripcion: esta description en comentarios queda almacenada
-- Otros detalles de los parametros
-----------------------------------------------------------
-- Author: pedro perez
-- Fecha: 04-21-2021
-- Desc: actualiza la tabla de xyz bla bla bla
-----------------------------------------------------------
CREATE PROCEDURE [dbo].[XXXXXXSP_VerboEntidad]
	@Param1 NVARCHAR(35),
	@Param2 BIGINT
AS
BEGIN

	SET NOCOUNT ON -- no retorne metadatos

	DECLARE @ErrorNumber INT, @ErrorSeverity INT, @ErrorState INT, @CustomError INT
	DECLARE @Message VARCHAR(200)
	DECLARE @InicieTransaccion BIT

	-- declaracion de otras variables

	-- operaciones de select que no tengan que ser bloqueadas
	-- tratar de hacer todo lo posible antes de q inice la transaccion

	SET @InicieTransaccion = 0
	IF @@TRANCOUNT=0 BEGIN
		SET @InicieTransaccion = 1
		SET TRANSACTION ISOLATION LEVEL READ COMMITTED
		BEGIN TRANSACTION
	END

	BEGIN TRY
		SET @CustomError = 2001

		-- put your code here

		IF @InicieTransaccion=1 BEGIN
			COMMIT
		END
	END TRY
	BEGIN CATCH
		SET @ErrorNumber = ERROR_NUMBER()
		SET @ErrorSeverity = ERROR_SEVERITY()
		SET @ErrorState = ERROR_STATE()
		SET @Message = ERROR_MESSAGE()

		IF @InicieTransaccion=1 BEGIN
			ROLLBACK
		END
		RAISERROR('%s - Error Number: %i',
			@ErrorSeverity, @ErrorState, @Message, @CustomError)
	END CATCH
END
RETURN 0
GO
```

- simplifique por medio de un [CTE](https://learn.microsoft.com/en-us/sql/t-sql/queries/with-common-table-expression-transact-sql?view=sql-server-2017) la consulta más optimizada del ejercicio de la norma de optimización y averigue si existe diferencia sustancial de rendimiento para que esto también sea agregado a la norma del equipo de desarrollo

- para realizar los ejercicios anteriores va a necesitar data, puede usar cualquier tipo de generación aleatoria pues se están ejercitando habilidades de "tunning de la base de datos"

- el entregable es un repositorio en git con los archivos de flyway, cualquier otro script adicional para realizar pruebas y la norma de optimización en pdf

# preliminar #4, conectividad a la base de datos, 13 de mayo, 35pts

- ahora el arquitecto de soluciones necesita que usted diseñe la forma en que los programas van a interactuar con la base de datos, definiendo los layers necesarios para acceder y trabajar con la misma desde las aplicaciones

- para ello deberá probar dos formas de interconectividad, la primera hacer un acceso cliente servidor desde una aplicación programada en el lenguaje de su preferencia, por ejemplo .net, java, go, python, etc, uno que le permita construir un UI y que exista un driver nativo, jdbc, ado.net y en última instancia odbc. Escoja alguna de las siguientes pantallas para realizar su programa de prueba:
  a) chequear los residuos que un transportista recolector se va a llevar de un productor de residuos, haciendo el canje de recipientes respectivos
  b) registrar las ventas de productos reciclados realizando la asignación de montos respectivos según contratos
  (valide el mockup de la pantalla seleccionada con el diseño de la base de datos y el profesor)

- la segunda forma deberá hacerse por medio de un api en REST, para ello el profesor le va a proporcionar una [base hecha en nodejs](https://github.com/vsurak/cursostec/tree/master/baseservice) , para probarlo, implemente un stored procedure que retorne al menos 500 registros, luego proceda a habilitar dos endpoints que llamen a dicho stored procedure, respetando los layers del servicio REST proporcionado, uno debe hacer uso de un conexión pool y otro que no lo use. Los endpoints deben retornar json.

- hecho lo anterior proceda a probar con postman su servicio rest, haciendo pruebas de stress sin superar los 20 hilos de ejecución y determine en las métricas de postman versus las métricas del activity monitor de su sql server, cuál de los endpoints obtiene mejores prestaciones y el por qué, esto puede documentarlo entre postman, un documento, screenshots y cualquier otro material de apoyo

- la revisión de este preliminar será con cita de revisión con el asistente, la aplicación y el servicio rest deberá estar en un solo repositorio de git, se tomará en cuenta los commits de cada integrante

- se daran 15 puntos extras si implementa y mide otro endpoint utilizando algún ORM

- el último commit en git deberá ser el 11 de mayo a media noche

## aspectos operativos

- [temporal tables para mantener historiales de datos](https://learn.microsoft.com/en-us/sql/relational-databases/tables/temporal-tables?view=sql-server-ver16)

# caso #4, 25%

_instituto tecnológico de costa rica_, escuela de computación  
_bases de datos I_  
_prof. rodrigo núñez_  
_tipo:_ parejas

## descripción

el caso número 4 es continuación del caso número 3, en el sentido que se va a utilizar la misma base de datos, pueden continuar trabajando con la misma pareja o pueden cambiar. en el caso de cambiar de pareja, si y solo si, ambas personas trabajaron en forma conjunta en el caso #3, las dos personas tienen derecho a usar la base de datos y todo lo construido hasta el caso 3, de lo contrario y conversado con el profesor, solo uno de los integrantes tendría derecho a utilizar el trabajo previo.

# preliminar #1, 26 de mayo, 40pts

- utilizando los stored procedures existentes o bien creando nuevos pero que no sean forzados, si no que deben ser stored procedures que realmente van a ser necesarios para que el sistema funcione, proceda a averiguar bajo que situaciones particulares en el orden de ejecución de cuales quiera dos stored procedures transaccionales, podría producirse alguno de los siguientes problemas:

  a) dirty read
  b) lost update
  c) phantom
  d) deadlock

- especifique en los comentarios del script, bajo que escenario del sistema podría llegar a suceder eso, haga las pruebas vía script demostrando que si es posible que se de dicha situación

- seguidamente proponga una nueva versión de dichos SP los cuales podrían implicar cambios de código y hasta cambios de diseño, que eliminen o reduzcan sustancialmente la aparición de dicho problema

- finalmente para terminar de demostrar que su base de datos va a poder operar el día a día de esencial verde, proceda con las siguientes tareas de mantenimiento:

  a) demuestre que es posible tener SP encriptados y que un atacante no va a poder ver el código del mismo [tip](https://www.mssqltips.com/sqlservertip/7465/encrypt-stored-procedure-sql-server/)
  b) por medio de un script asegúrese que un schemabinding nos proteje la lógica de negocios de la base de datos ante cambios estructurales en las tablas
  c) cree dos jobs del sistema, uno que recompile todos los stored procedures, sacando la lista de los mismos de las vistas del sistema, y que eso lo haga 1 vez por semana. Finalmente, otro que se encargue de pasar los registros de la bitácora del sistema a una bitácora gemela en un linked server, garantizando la transferencia de los registros y con ello eliminando los registros pasados y así mantener la bitácora con un tamaño aceptable, dicha operación debe hacerse 2 veces por semana.

- la revisión será con cita con el profesor

# final, 11 de junio, 60pts

en esta ultima entrega vamos a utilizar la misma base de datos buscando terminar ciertos aspectos operativos que son normales en ambientes de bases de datos, esto tiene que ver con reportería, seguridad, backup y restore. los siguientes son implementaciones de experimentos que podrá realizar para poner en práctica dichas 3 áreas que están intrinsicamente relacionadas a bases de datos

- cree usuarios en la base de datos que le permita probar lo siguiente:
  a) es posible negar todo acceso a las tablas de la base de datos y operarla únicamente por medio de ejecución de stored procedures
  b) es posible restringir la visibilidad de columnas a ciertos usuarios
  c) se pueden crear roles, y que usuarios pertenezcan a roles, dichos roles podrían tener restricciones de tablas y columnas que aplican a los usuarios que pertenecen a dicho role
  d) como resuelve sql server prioridades de permisos en la jerarquía, por ejemplo que un nivel superior niego acceso a algo y un nivel inferior se le asigne
- de manera práctica demuestre como funciona y un backup con su restore respectivo, usando métodos full e incremental

- usando una herramienta de reporting, por ejemplo microsoft reporting services (se puede usar en docker), powerbi, tableau o kibana, cree un reporte del sistema con la siguiente especificación:

  - titulo del reporte
  - subtitulo del reporte es el rango de fechas de los datos del reporte
  - contenido: seleccionando el país o una región de forma exclusiva y un rango de fechas, despliegue para todos los tipos de residuos el total recolectado por industria, lo que ha costado procesar dicho total de residuo, lo que se ha cobrado por procesarlo y la diferencia o ganancia neta.
  - columnas: país o región, industria, tipo de residuo, costo, venta y ganancia, estas últimas en la moneda base, por ejemplo $
  - ordenado ascendente por país o región, industria y tipo de residuo
  - ordenado descendente por ganancia
  - deberá tener un subtotal por industria y un total al final del reporte

- finalmente, la gerencia quiere poder visualizar gráficamente cuáles ciudades o localidades están enviando sus desechos a cuáles centros de recolección, pudiendo observar dicha relación y su volumen acumulado a la fecha. También se quiere ver dicha relación por empresa productora y por empresas recolectoras. Para ello cree las consultas necesarias o bien haga el data export que genere un CSV que pueda ser cargado a neo4J para visualizar dicha relación.

- la revisión será con cita con el profesor, será 100% demostrativo en las herramientas
