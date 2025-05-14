# Instituto Tecnológico de Costa Rica 

**Profesor Rodrigo Nunez** 

**Curso de bases de datos I** 

**Casos a resolver durante el semestre - 80%** 



# Caso #1 - diseño de una base de datos relacional - 10%

A continuación se le va a presentar un conjunto de requerimientos de un software para dos sistemas, de los cuales solo va a trabajar en uno. Con ello usted va a realizar las preguntas que considere oportunas al cliente (profesor), listar entidades e investigar información asociada las entidades y el cómo se comportan. 

---

**Title: Payment Assistant** 

**Descripción**

Imagina un asistente personal que no solo recuerda tus pagos recurrentes, sino que también los ejecuta por ti con solo confirmar un recordatorio. Con tecnología de inteligencia artificial de vanguardia, nuestra app te permite registrar y programar pagos de servicios como luz, agua, renta y más, usando simplemente tu voz. Olvídate de fechas vencidas, multas o estrés financiero. Además, con planes flexibles que se adaptan a tus necesidades, disfrutas de una experiencia gratuita para un pago mensual y opciones premium para múltiples transacciones.

**Requerimientos Funcionales**

1. **Interacción por Voz:**
   - La aplicación debe permitir al usuario registrar pagos recurrentes (electricidad, agua, renta, pólizas, préstamos, etc.) mediante comandos de voz.
   - Debe procesar y entender el lenguaje natural para capturar detalles como el nombre del servicio, monto, fecha de pago y frecuencia.
   - Debe confirmar con el usuario los detalles capturados antes de guardarlos.

2. **Configuración de Pagos:**
   - El usuario debe poder configurar cuentas bancarias de origen (nombre del banco, número de cuenta, saldo disponible, etc.).
   - Debe permitir la vinculación de APIs bancarias o servicios de pago para realizar transacciones automáticas.
   - El usuario debe poder editar o eliminar cuentas y pagos configurados.

3. **Recordatorios y Confirmaciones:**
   - La aplicación debe enviar notificaciones push o SMS cuando se acerque la fecha de pago.
   - El usuario debe confirmar el monto, la cuenta de origen y autorizar el pago antes de que se ejecute.
   - En caso de no recibir confirmación, la aplicación debe enviar recordatorios adicionales.

4. **Ejecución de Pagos:**
   - La aplicación debe realizar pagos automáticos una vez que el usuario confirme.
   - Debe manejar transacciones exitosas y fallidas, registrando el estado de cada una.
   - En caso de fallo, debe notificar al usuario y permitir reintentar el pago.

5. **Registro y Historial:**
   - La aplicación debe almacenar un historial completo de pagos realizados, incluyendo monto, fecha, cuenta de origen y estado (éxito/fallo).
   - Debe permitir al usuario consultar y filtrar el historial de transacciones.

6. **Integración con APIs y SMS:**
   - Debe integrarse con APIs bancarias o servicios de pago para realizar transacciones.
   - Debe enviar y recibir SMS para confirmaciones y autorizaciones de pagos.

7. **Planes y Monetización:**
   - La aplicación debe ser gratuita para un pago único al mes.
   - Debe ofrecer planes de suscripción basados en la cantidad de pagos y transferencias mensuales.
   - Debe gestionar la facturación y renovación automática de suscripciones.

---

**Title: App assistant**

**Descripción**

Esta es una herramienta que no solo simplifica la capacitación de tus empleados, sino que también se convierte en un asistente experto para guiar paso a paso en tareas complejas dentro de cualquier aplicación. Con nuestra innovadora solución, tus equipos pueden grabar tareas específicas usando comandos de voz y acciones en su computadora o teléfono, creando una base de conocimiento impulsada por inteligencia artificial. Desde agregar una cuenta favorita en un banco hasta cancelar una suscripción en Netflix, nuestra app aprende y replica estos procesos, ofreciendo asistencia en tiempo real cuando los usuarios más lo necesitan. Con planes flexibles que crecen junto a tu empresa, comienza con una tarea gratuita y escala según tus necesidades.


**Requerimientos Funcionales**

1. **Grabación de Tareas:**
   - La aplicación debe permitir a los usuarios grabar tareas mediante comandos de voz y capturar las acciones realizadas en la computadora o dispositivo móvil.
   - Debe soportar la grabación en segundo plano (background mode) para capturar tanto las indicaciones verbales como las interacciones en pantalla.
   - El usuario debe poder pausar, reanudar y finalizar la grabación de una tarea.

2. **Almacenamiento y Procesamiento de Datos:**
   - La aplicación debe almacenar las tareas grabadas en una base de datos estructurada.
   - Debe procesar las grabaciones para extraer pasos clave y generar un flujo de trabajo automatizado.
   - Los datos deben ser utilizados para entrenar un modelo de inteligencia artificial (IA) que pueda replicar y explicar las tareas.

3. **Asistencia en Tiempo Real:**
   - La aplicación debe detectar cuando un usuario está intentando realizar una tarea en una aplicación específica.
   - Debe ofrecer asistencia mediante notificaciones preguntando si el usuario necesita ayuda.
   - Si el usuario acepta, la aplicación debe guiar paso a paso, indicando qué hacer y a dónde ir dentro de la aplicación.

4. **Interfaz de Usuario:**
   - Debe proporcionar una interfaz intuitiva para grabar, editar y revisar tareas.
   - Los usuarios deben poder buscar y acceder a tareas previamente grabadas.

5. **Gestión de Empresas y Usuarios:**
   - La aplicación debe permitir la creación de cuentas para empresas y usuarios individuales.
   - Cada empresa debe poder gestionar sus tareas grabadas y asignar permisos a sus empleados.
   - Debe incluir un sistema de roles (admin, editor, usuario básico, etc).

6. **Planes y Monetización:**
   - La versión gratuita debe permitir grabar una tarea por empresa.
   - Debe ofrecer planes de pago basados en la cantidad de tareas grabadas y el número de usuarios.
   - Implementar un sistema de facturación recurrente y gestión de suscripciones.

---

Ahora procedamos a resolver las siguientes actividades:

1. el profesor va a crear parejas de trabajo en forma aleatoria, cada pareja va a seleccionar un solo sistema de los anteriores. 

2. la pareja, como ingenieros consultores, tienen la responsabilidad de hacer un diseño completo de la base de datos para el sistema. El CTO del cliente, les ha pedido que dicha base de datos se implemente en MySQL.

3. el profesor clase con clase, va a abordar técnicas y patrones de diseño de base de datos; usted con su pareja de trabajo, irán creando el diseño por avances en Workbench. 

4. habran 3 entregables de diseño, donde cada entregable debe contar con:
- nombre de los integrantes de la pareja
- listado de entidades actualizado
- listados, screenshots, documentación general en cualquier formato que haya usado para sustentar la información que debe contar cada entidad 
- pdf del diseño hecho en workbench, diseño a nivel físico (Diseño lógico asigna nota de 0)

5. los entregables de diseño serán especificados por el profesor conforme  se vaya avanzando en el estudio de los patrones vistos en clase, los mismos se entregaron con un mensaje directo al profesor por discord


## Entregable 1 - 5%

el primer entregable deberá incluir todas las tablas relacionadas a: 

- usuarios y/o perfil de usuarios tanto para administrativos de la plataforma como para consumidores de la plataforma 

- permisos, roles, accesos, grants, denys y similares; y todo lo que sea necesario relacionar para que un usuario pueda verificar si puede o no realizar ciertas funciones en el sistema

- todo tipo de archivo, attachment, recording, streaming, media files, documentos almacenados y similares que requiera la plataforma y los cuales van a ser almacenados en algún servicio basado en IDs y URLs, o sea almacenamiento físico externo

- administración de empresas y los usuarios que pertenecen o no a empresas que acceden al servicio; o bien , cualquiera tipo de estructura organizacional que sea requerida

- transacciones, pagos, balances, devoluciones, reclamos, precios, renovaciones y todo aquello que tenga que ver con operaciones de dinero

- subscripciones, planes, vigencias, planes, limites de las subscripciones, registro de uso de las subscripciones y la forma de validar cuando se alcanzan los límites que las subscripciones requieran 

- bitácora o bitácoras del sistema

- tablas necesaria para soportar internacionalización de idiomas y monedas

Deberá documentar un mapeo entre el diseño de las tablas y la información descubierta por entidad, para garantizar que sus tablas cumplen con la totalidad de los campos necesarios y que se les asignó un tipo de dato adecuado para los campos de las tablas. 

El diseño debe cumplir con:
- llaves primarias y foráneas
- correctos ajustados los null y not null
- valores default en los campos que sea necesario
- los necesarios identities

Fecha de entrega: sábado 15 de marzo, 10am


## Entregable #2 - 5%

En este momento usted ya cuenta con una base de datos inicial para este problema, ahora deberá realizar dos actividades adicionales para terminar de practicar con workbench y mysql. 

1. complete las tablas que requiere su sistema que no fueron tomadas en cuenta en el entregable #1, en la mayoría de los casos dichas tablas van a estar relacionadas a las grabaciones, procesamientos de la AI, interacción del sistema con la AI, interacción del humano con la AI, comandos de voz, análisis y resultados que genera la AI y la ejecución propiamente de lo que hace el sistema. 

2. obtenga visto bueno del profesor del diseño final 

3. haga deployment de su base de datos a MySQL

4. Ahora proceda a crear un script de llenado de base de datos en un archivo SQL, en cual va a realizar los INSERT que sean necesarios para popular de información la base de datos, de forma que pueda retornar las siguientes consultas. A la par de cada consulta aparece la cantidad mínima de registros que se espera que retorne. Los scripts de las consultas deberían ir en un archivo SQL aparte. 

__4.1 listar todos los usuarios de la plataforma que esten activos con su nombre completo, email, país de procedencia, y el total de cuánto han pagado en subscripciones desde el 2024 hasta el día de hoy, dicho monto debe ser en colones__ (20+ registros)

__4.2 listar todas las personas con su nombre completo e email, los cuales le queden menos de 15 días para tener que volver a pagar una nueva subscripción__ (13+ registros)

__4.3 un ranking del top 15 de usuarios que más uso le dan a la aplicación y el top 15 que menos uso le dan a la aplicación__ (15 y 15 registros)

__4.4 determinar cuáles son los análisis donde más está fallando la AI, encontrar los casos, situaciones, interpretaciones, halucinaciones o errores donde el usuario está teniendo más problemas en hacer que la AI determine correctamente lo que se desea hacer, rankeando cada problema de mayor a menor cantidad de ocurrencias entre un rango de fechas__ (30+ registros)

Para entregar esto, haga un respositorio de git con un readme.md que contenga:

- integrantes
- link al script de creación de la base de datos
- link al script de llenado de datos, si llenar una tabla requiere de más de 15 registros, este llenado deberá hacerse procedimental por calculos y randoms controlados debidamente según la distribución de los datos necesaria para los resultados de las consultas, y no por medio de INSERTS exhaustivos 
- link al script con las consultas 
- para cada script de consulta, un data table que muestre los resultados de los datos obtenidos de la consulta
- se sugiere hacer los scripts y data tables embebidos en el md file para mayor facilidad de lectura
- debe ser notorio en los commits los aportes de cada integrante, caso contrario se rebajaran puntos a discresión
- último commit lunes 24 de marzo, media noche

Enviar el link al repositorio en mensaje directo a @Manollito por discord. 



# Caso #2 - 35% - TSQL, Seguridad, Concurrencia, Performance, Transacciones y Migrado de datos

La coorporación Dancing CaipirIA de Brasil ha iniciado operaciones en Costa Rica y con ello ha traído nuevos servicios digitales al país. Dicha organización se ha especializado por invertir mucho dinero en la creación de emprendimientos digitales en todo latinoamerica y para apoyar ese crecimiento también han comprado otras empresas consolidadas en los diferentes países donde deciden invertir. El CEO ha externado en una conferencia de prensa: 

<p align="center">
"A gente enxergou na Costa Rica, pelo seu tamanho e estabilidade econômica, um nicho ideal pra testar e lançar novos produtos e serviços que depois podem se espalhar por toda a região. Viemos pra dançar junto, brindar com caipirinhas temperadas com tecnologia e trocar ideias com nossos irmãos costarriquenhos e com as empresas tech do país."
</p>


Los altos directivos de Dancing CaipirIA, han selecionado Costa Rica como el espacio de laboratorio para probar un novedoso servicio llamado Soltura. Esta plataforma lo que busca es que las personas no tengan que preocuparse por estar contratando y pagando servicios por separado como por ejemplo gimnasios, spa, terapeutas, grooming de mascotas, escuelas de mascotas, paseos, hoteles, combustible, peluquería, dietas, entre muchas otras cosas más.

Soltura, ofrece paquetes básicos de vida por montos fijos mensuales, que tienen como beneficios principales la simplicidad del pago por parte de los consumidores, de forma que solo tienen que pagar una mensualidad a Soltura, y por otro lado, una reducción del costo de tales servicios para los consumidores. Para dar un ejemplo, suponga que Soltura entre sus paquetes podría tener en Costa Rica:

Paquete Profesional Joven: 

| Beneficio                              | Cantidad               |
|----------------------------------------|------------------------|
| Gimnasio SmartFit                      | 6 horas por semana     |
| Lavandería y aplanchado                | 1 servicio             |
| Limpieza básica de hogar               | 2 días                 |
| Combustible (gas o diésel)             | ₡50,000 colones        |
| Corte de pelo (Tito Barbers)           | 1 corte                |
| Cenas seleccionadas                    | 2 cenas                |
| Almuerzos seleccionados                | 4 almuerzos            |
| Plan móvil (Kolbi)                     | Ilimitado              |
| Parqueo                                | 10 horas               |


Paquete Full Modern Family: 

| Beneficio                              | Cantidad                     |
|----------------------------------------|------------------------------|
| Gimnasio (4 personas)                  | 4 horas por semana           |
| Yoga o Pilates (familiar)              | 4 horas                      |
| Grooming para mascota                  | 1 servicio                   |
| Revisión veterinaria                   | 1 consulta                   |
| Clases de natación o fútbol (niños)    | 3 clases                     |
| Combustible (gas o diésel)             | ₡100,000 colones             |
| Uber Eats                              | 10 pedidos (envío gratis + 20% dto.) |
| Uber Rides                             | ₡7,000 colones en viajes     |

También Soltura ofrece paquetes personalizados, donde las personas pueden tomar algún paquete, agregar y quitar beneficios de los disponibles y con ello hacerlo más a la medida, en este caso el precio mensual del paquete se calcula dependiendo de los servicios deseados. 

Los consumidores de Soltura, pagan una subscripción de tal forma que con solo un pago único pueden acceder a todos estos beneficios mensualmente, en las tiendas, proveedores, escuelas y demás que tenga contratados Soltura. En la mayoría de los casos, al aplicación de Soltura posee un código QR para los dueños de la subscripción y si es el caso para los miembros de la familia que el dueño de la subscripción incluya como miembro. 

También puede darse que a la hora de pagar algún servicio como por ejemplo gasolina, el miembro realiza el pago por medio de un QR, código o cupón o NFC que habilita la aplicación.

Para que esto sea posible Dancing CaipirIA agresivamente establece acuerdos comerciales con múltiples proveedores en el país, que a cambio de una masa crítica de usuarios estables y de la simplificación de costos operativos al resumir N personas en un solo pago; otorga a CaipirAI de honorosos descuentos de los cuales obtienen el margen y a la vez transfieren ahorro a los miembros de Soltura. 

Soltura, hace los cargos "ahead", es decir, que carga los montos a inicio a mes, antes de que las personas lo consuman, esto para evitar fraudes o cuentas por pagar con múltiples proveedores, si no que más bien los consumidores pagan por adelantado su mensualidad a Soltura. 

Los miembros de Soltura puede realizar los pagos de sus membresías por medio de cualquier tarjeta débido o crédito de costa rica, así como también tarjetas de crédito internacionales y plataformas de cobro como google wallet, apple wallet, apple pay, paypal. Si no hay una cancelación de servicio, el cargo se hace reguarlmente en los primeros 3 días del mes que no sea ni sábado ni domingo ni feriado. 

Los directivos y estrategas han hecho un amplio estudio del mercado con el que están seguro que triunfaran en suelo tico y con ello llevar Soltura a otros países de Latam. 

Dado que este proyecto es nuevo, su empresa ha sido contrata por Dancing CaipirIA; en la última reunión con el CTO Digão Nunesinhio, se les ha indicado que inicien con el diseño de la base de datos, pues en sus palabras ha dicho que tiene prioridad para el éxito del proyecto y que el motor de base de datos que se va a utilizar va a ser principalmente SQL Server. Aún así, dado que la plataforma Soltura es un app mobile, que se conecta a un backend con este SQL server, también se conoce que va existir una página web de Soltura, con paquetes informativos, promociones, mercadeo, media y más; este tipo de contenido se desea manejar en MongoDB; de la misma forma toda la plataforma de servicio al cliente, seguimento de casos, reviews y resolución de quejas también estará modelado en MongoDB.

## Diseño de la base de datos - 20pts

Proceda entonces en conjunto con sus colegas consultores de empresa a realizar el diseño de ambas bases de datos.

## Test de la base de datos - 65pts

Ahora que ya Soltura cuenta con un diseño de base de datos aprobados por los ingenieros, CTO, contrapartes ingenieros de Soltura, se les ha pedido que realicen pruebas contextuales para medir el comportamiento, técnicas, rendimiento y semántica de la base de datos diseñada en SQL Server. A continuación se detallan todos los test requeridos. 


### Población de Datos

- Crear scripts de llenado para la base de datos utilizando **solo T-SQL**, cumpliendo con:
  - El sistema opera al menos con **dos monedas** (ej. CRC y USD).
  - Al menos **25 usuarios con suscripciones activas** y **5 usuarios sin suscripción**, distribuidos entre diferentes regiones o afiliaciones.
  - Cargar los **catálogos base del sistema**: tipos de servicios (gimnasios, salud, parqueos, etc.), tipos de planes, métodos de pago, monedas, estados de suscripción, etc.
  - Llenar la tabla de **planes de suscripción**, con variaciones como: Joven deportista, Familia de Verano, Viajero frecuente, Nomada Digiital, etc.
  - Incluir al menos **7 empresas proveedoras de servicios**, cada uno ofreciendo **2 a 4 combinaciones de servicios** que se deben usar para crear de 7 a 9 planes diferentes.
  - Para cada plan de servicios, debe haber **3 a 6 subscripciones a usuarios diferentes no repetidos en otra combinación**. 
  

---

### Demostraciones T-SQL (uso de instrucciones específicas)

Todos las pruebas a continuación se deben hacer en uno o varios scripts TSQL. Perfectamente un solo query puede resolver varios puntos de las pruebas. 

1. Cursor **local**, mostrando que no es visible fuera de la sesión de la base de datos
2. Cursor **global**, accesible desde otras sesiones de la base de datos
3. Uso de un **trigger** (por ejemplo, para log de inserciones en pagos).
4. Uso de `sp_recompile`, cómo podría estar recompilando todos los SP existentes cada cierto tiempo?
5. Uso de `MERGE` para sincronizar datos de planes por ejemplo.
6. `COALESCE` para manejar valores nulos en configuraciones de usuario.
7. `SUBSTRING` para extraer partes de descripciones.
8. `LTRIM` para limpiar strings.
9. `AVG` con agrupamiento (ej. promedio de montos pagados por usuario).
10. `TOP` para mostrar top 5 planes más populares.
11. `&&` en que caso se usa
12. `SCHEMABINDING` demostrar que efectivamente funciona en SPs, vistas, funciones.
13. `WITH ENCRYPTION` demostrar que es posible encriptar un SP y que no lo violenten. 
14. `EXECUTE AS` para ejecutar SP con impersonificación, es posible? qué significa eso?
15. `UNION` entre planes individuales y empresariales por ejemplo.
16. `DISTINCT` para evitar duplicados en servicios asignados por ejemplo.

---

### Mantenimiento de la Seguridad

Esta parte se puede probar visualmente con el management studio y combinando con scripts que demuestren el comportamiento de lo configurado.

- Crear usuarios de prueba y:
  - Mostrar cómo permitir o denegar acceso a la base de datos, del todo poder verla o no, poder conectarse o no
  - Conceder solo permisos de `SELECT` sobre una tabla a un usuario específico. Será posible crear roles y que existan roles que si puedan hacer ese select sobre esa tabla y otros Roles que no puedan? Demuestrelo con usuarios y roles pertinentes. 
  - Permitir ejecución de ciertos SPs y denegar acceso directo a las tablas que ese SP utiliza, será que aunque tengo las tablas restringidas, puedo ejecutar el SP?
- habrá alguna forma de implementar RLS, row level security 
- Crear un **certificado y llave asimétrica**.
- Crear una **llave simétrica**.
- Cifrar datos sensibles usando **cifrado simétrico** y proteger la llave privada con las llaves asimétrica definidas en un certificado del servidor. 
- Crear un SP que descifre los datos protegidos usando las llaves anteriores.

---

### Consultas Misceláneas

- Crear **una vista indexada** con al menos 4 tablas (ej. usuarios, suscripciones, pagos, servicios). La vista debe ser **dinámica**, no una vista materializada con datos estáticos. Demuestre que si es dinámica. 
- Crear **un procedimiento almacenado transaccional** que realice una operación del sistema, relacionado a subscripciones, pagos, servicios, transacciones o planes, y que dicha operación requiera insertar y/o actualizar al menos 3 tablas.
- Escribir un `SELECT` que use `CASE` para crear una columna calculada que agrupe dinámicamente datos (por ejemplo, agrupar cantidades de usuarios por plan en rangos de monto, no use este ejemplo).
- Imagine una cosulta que el sistema va a necesitar para mostrar cierta información, o reporte o pantalla, y que esa consulta vaya a requerir:
  - 4 `JOIN`s entre tablas.
  - 2 funciones agregadas (ej. `SUM`, `AVG`).
  - 3 subconsultas or 3 CTEs
  - Un `CASE`, `CONVERT`, `ORDER BY`, `HAVING`, una función escalar, y operadores como `IN`, `NOT IN`, `EXISTS`.
  - Escriba dicha consulta y ejecutela con el query analizer, utilizando el analizador de pesos y costos del plan de ejecución, reacomode la consulta para que sea más eficiente sin necesidad de agregar nuevos índices. 
- Crear una consulta con al menos 3 `JOIN`s que analice información donde podría ser importante obtener un **SET DIFFERENCE** y un **INTERSECTION**
- Crear un procedimiento almacenado transaccional que llame a otro SP transaccional, el cual a su vez llame a otro SP transaccional. Cada uno debe modificar al menos 2 tablas. Se debe demostrar que es posible hacer `COMMIT` y `ROLLBACK` con ejemplos exitosos y fallidos sin que haya interrumpción de la ejecución correcta de ninguno de los SP en ninguno de los niveles del llamado. 
- Será posible que haciendo una consulta SQL en esta base de datos se pueda obtener un JSON para ser consumido por alguna de las pantallas de la aplicación que tenga que ver con los planes, subscripciones, servicios o pagos. Justifique cuál pantalla podría requerir esta consulta. 
- Podrá su base de datos soportar un SP transaccional que actualice los contratos de servicio de un proveedor, el proveedor podría ya existir o ser nuevo, si es nuevo, solo se inserta. Las condiciones del contrato del proveedor, deben ser suministradas por un **Table-Valued Parameter (TVP)**, si las condiciones son sobre items existentes, entonces se actualiza o inserta realizando las modificacinoes que su diseño requiera, si son condiciones nuevas, entonces se insertan. 
- Crear un `SELECT` que genere un archivo **CSV** de datos basado en un `JOIN` entre dos tablas 
- Configurar una **tabla de bitácora en otro servidor SQL Server** accesible vía **Linked Servers** con impersonación segura desde los SP del sistema. Ahora haga un SP genérico para que cualquier SP en el servidor principal, pueda dejar bitácora en la nueva tabla que se hizo en el Linked Server.

---

### Concurrencia

Para este ejercicio solo utilice T-SQL, no podría hacer uso de ningun operador de `LOCK` explícito de los que provee SQL Server. 

El objetivo de estas pruebas es ver el comportamiento de la base de datos bajo situaciones de alta concurrencia. Dado que no vamos a contar con tantos usuarios, las situaciones se van a diseñar utilizando `WAIT FOR DELAY` para controlar el flujo de ejecución que fuerce la situación que se daría ante alta concurrencia.

Normalmente para las pruebas tendrá dos conexiones abiertas simultáneas a la base de datos (dos scripts que correran por separado).

  - Cree una situación de **deadlocks entre dos transacciones** que podrían llegar a darse en el sistema en el momento de hacer un canje de un servicio donde el deadlock se de entre un `SELECT` y `UPDATE` en distintas tablas. 
  - Determinar si es posible que suceden **deadlocks en cascada**, donde A bloquea B, B bloquea C, y C bloquea A, debe poder observar el deadlock en algún monitor.
  - Determinar como deben usarse los niveles de isolacion: `READ UNCOMMITTED`, `READ COMMITTED`, `REPEATABLE READ`, `SERIALIZABLE`, mostrando los problemas posibles al usar cada tipo de isolación en casos particulares, se recomienda analizar casos como: obtener un reporte general histórico de alguna operación, calcular el tipo de cambio a utiliza en un momento dado, adquisición de planes cuando se están actualizando, cambios de precio durante subscripciones, agotamiento de existencias de algún beneficio.  
  - Crear un **cursor de update** que bloquee los registros que recorre uno a uno, demuestre en que casos dicho cursor los bloquea y en que casos no, para que el equipo de desarrollo sepa para que escenarios usar cursos y cuando no.
  - Defina lo que es la "transacción de volumen" de su base de datos, por ejemplo, en uber la transacción es buscar un driver, en paypal es procesar un pago, en amazon es buscar artículos, y así sucesivamente, es la operación que más solicitudes recibe el sistema, dicho esto: 
   - Determine cuántas transacciones por segundo máximo es capaz de procesar su base de datos, valide el método con el profesor
   - Determine como podría tripilar el valor averiguado anteriormente sin hacer cambios en su base de datos ni incrementar hardware ni modificando el query 

---

## Noticas de última hora - soltura ha iniciado adquisiciones en costa rica - 15pts

Previo a la semana santa, la empresa Soltura estuvo en conversaciones con los dueños e inversionistas de varias empresas ya establecidas en el país, entre ellas "payment assistant" y "app assistant" (como grupo de trabajo escogen solo una del entregable del caso #1), esas empresas ya han logrado cierta tracción y público en Costa Rica y han decidido que dichas aplicaciones podrían ser dadas como parte de los planes de subscripción de Soltura. 

En lugar de negociar con los dueños para verlos como proveedores, quieren usarlas para aumentar su cartera de usuarios, haciendo que por el mismo precio que ya pagan por el servicio, obtengan un plan que obtengan mínimo lo mismo y dos servicios más adicionales. Esto para el periodo de adquisición y dejar que los mismos usuarios posteriormente se muevan a otros planes. 

Esto ha hecho que ustedes como equipo de tecnología les toque realizar una migración de los datos importantes de la base de datos del sistema adquirido, a la base de datos del sistema de soltura. No se pretende copiar las tablas, si no más bien migrar los usuarios y sus subscripciones del sistema adquirido, de tal forma que esos usuarios y sus planes ahora sean parte de los usuarios y planes de soltura. Para esta migración se sabe lo siguiente con respecto al sistema adquirido (payment assistant, app assistant): 

1. Existen poco más de 1000 usuarios activos 

2. El 70% de los usuarios tienen un plan activo que se paga mensualmente y el resto un plan pagado anual. 

3. Hay 2 planes activos en el sistema. 

4. Las fechas de pago de los planes y los montos se deben conversar al momento de hacer la migración de datos. 

5. Los usuarios consumidores deben conversar sus permisos en el app.

6. Se debe crear algún tipo de mecanismo o tabla que haga correspondencia entre los usuarios del sistema adquirido y los usuarios en Soltura, de tal forma que para las rutinas en Soltura sea transparente el tipo de usuario .

7. Todos los usuarios migrados van a tener un nuevo usuario en Soltura con su email respectivo y sus datos respectivos de perfil de usuario, pero al hacer login deben estar forzados a ingresar un nuevo password pues no puede ser migrado el password del sistema anterior. 

8. Soltura va crear una imagen en el home page y un banner publicitario indicando que dicho sistema (payment assistant o app assistant) ahora es Soltura, la fecha a partir de cuando se hace la migración y un link hacia la guía de pasos que deben seguir los usuarios ese día (este link no existe solo se pone). No hay que hacer los banner ni nada, solo el ingreso de los datos en los collections respectivos.

EL CTO de soltura ha dejado abierta la opción de herramienta para hacer la migración de la base de datos de MySQL a SQL server, entre las opciones que estableció están: 

- DBT 
- Logstash 
- SQL Server Integration Services 
- Python notebook con Pandas 

## Entregable final 

- Todos los pasos anteriores se deberán documentar en un solo MD file en el repositorio con todas las secciones tal cual se han solicitado en este enunciado de caso #2 

- Se revisaran adicionalmente las bases de datos llenas en MySQL y en SQL Server 

- Los scripts se anclaran como bloques de código en el md file, no como links, pero también deberá haber un folder con los scripts 

- Muchos de los scripts se revisaran en ejecución con explicación de código y datos 

- Se revisará en forma general el diseño de la base de datos de Soltura 

- Las tareas que son aplicadas en SQL Server se revisarán directamente en SQL Server 

- Fecha para la última consulta: sábado 3 de mayo 

- Fecha para último commit: martes 6 de mayo 

- Revisión con cita programada a partir del miércoles 7 de mayo 



# Caso #3 - Voto Pura Vida -35%

Costa Rica no cuenta actualmente con un sistema oficial de voto electrónico como herramienta electoral, y su implementación enfrenta desafíos políticos, constitucionales y legales que requieren atención cuidadosa. Sin embargo, el concepto del voto electrónico va mucho más allá de las elecciones nacionales: puede ser utilizado para encuestas, consultas públicas, toma de decisiones en instituciones, validación ciudadana de propuestas o proyectos, y direccionamiento de políticas. En una sociedad democrática y digital, la participación no puede seguir limitada únicamente a eventos electorales cada varios años.

El objetivo del proyecto es crear una plataforma de voto electrónico que sea accesible, segura y multifuncional. Esta herramienta permitirá a ciudadanos y organizaciones registrar propuestas de diversa índole, desde decisiones administrativas hasta proyectos municipales o reformas legales, y someterlas a votación de públicos específicos. Las votaciones serán parametrizables, con reglas claras y mecanismos de validación, alcanzando poblaciones segmentadas según diversos criterios como edad, ubicación, afiliación o profesión. Este sistema busca promover un entorno donde la voz ciudadana pueda incidir de manera ágil y directa en múltiples esferas.

El resultado esperado es una Costa Rica más participativa, con una ciudadanía empoderada y con herramientas modernas para expresarse, influir y decidir. Se fomentará una cultura de transparencia, donde todas las votaciones serán públicas en contenido y resultados, pero asegurando que los votos individuales sean siempre anónimos. La plataforma brindará reportes en tiempo real, será altamente segura, y ofrecerá un respaldo técnico y criptográfico que garantice la integridad de cada voto emitido. Esto dará agilidad competitiva al país, permitiendo decisiones más rápidas, mejor informadas y colectivamente validadas.

---

**Requerimientos Funcionales**

* Los ciudadanos deberán registrarse utilizando MFA, prueba de vida, identidad digital y confirmaciones físicas y temporales
* Se generarán identidades cifradas con llaves propias que protegen la integridad de cada usuario
* Organizaciones e instituciones también podrán registrarse, únicamente a través de una persona física ya registrada
* En una fase posterior, extranjeros podrán registrarse, condicionados por listas blancas de IPs y países permitidos
* La validez de identidad deberá comprobarse periódicamente durante el tiempo de uso
* El sistema solicitará documentos digitales que pasarán revisión automática por IA
* Algunos registros requerirán aprobación mancomunada de 2 a 3 validadores humanos con llaves privadas distribuidas
* Cualquier persona física, o en representación de una organización, podrá presentar propuestas para votación
* Las propuestas pueden incluir temas como leyes, decisiones ejecutivas, proyectos municipales, innovaciones, reglamentos o admisiones
* Cada tipo de propuesta deberá cumplir con un set de requisitos: contenido, documentación, beneficios, impacto y cuantificación
* Se deben establecer reglas de validación específicas por tipo de propuesta y por sección del contenido
* El sistema debe permitir definir el público objetivo de cada votación usando criterios como edad, nacionalidad, sexo, educación, afiliación institucional, o listas específicas de identificadores
* Se podrá asignar peso diferenciado a los votos según el grupo poblacional
* Las votaciones tendrán plazos definidos y configurables
* Se debe configurar cómo se notificará el inicio de la votación
* Se establecerán reglas claras de aceptación, rechazo o calificación según el resultado de los votos
* Todas las votaciones serán públicas en contenido y resultados en la primera versión
* Los votos individuales serán anónimos y no podrán rastrearse
* El sistema deberá prevenir cualquier acceso no autorizado por parte de personal técnico o de red a la base de datos de votos
* Todo ciudadano registrado podrá consultar el listado de votaciones: abiertas, en curso y finalizadas
* Las votaciones finalizadas deben mostrar sus resultados de forma clara y accesible
* La información de las propuestas podrá visualizarse completa o mediante resúmenes adaptados al perfil del ciudadano, usando técnicas de síntesis automática y visualización (gráficas, comparativas, KPIs)
* El perfil de cada ciudadano determinará su elegibilidad para participar en cada votación
* La pertenencia a grupos, instituciones o comunidades también formará parte del perfil y podrá usarse para definir acceso a ciertas votaciones
* Cada ciudadano podrá emitir un solo voto por propuesta, sin posibilidad de modificación posterior
* Los resultados de una votación no se mostrarán hasta que se cierre el plazo de votación o hasta que todos los votantes elegibles hayan participado
* La plataforma debe registrar cada participación con un hash verificable y no rastreable al usuario

---

**Requerimientos No Funcionales**

* El sistema debe tener seguridad criptográfica avanzada para garantizar la integridad y confidencialidad de los votos
* Las identidades de usuarios deben estar protegidas con mecanismos de cifrado fuerte, llave privada, y validación biométrica
* La plataforma debe ser 100% web, accesible desde cualquier dispositivo con conexión segura
* Toda la infraestructura deberá estar hospedada en entornos con aislamiento lógico que impida accesos directos por parte de ingenieros o administradores del sistema
* Debe existir auditoría completa de cada proceso sin comprometer el anonimato de los votantes
* La base de datos debe tener control de acceso en múltiples niveles con segregación de roles
* Toda transacción debe ser firmada digitalmente y trazable sin comprometer la identidad del votante
* El sistema debe ser escalable para permitir desde pequeñas consultas internas hasta votaciones masivas a nivel nacional
* Las comunicaciones y transferencias deben usar canales cifrados end-to-end
* El sistema debe tener alta disponibilidad y mecanismos de recuperación automática ante fallos
* Debe haber monitoreo en tiempo real de seguridad, actividad sospechosa y estado general del sistema
* Todos los votos emitidos deben ser secretos, protegidos criptográficamente y sin asociación directa a la identidad del votante
* Los votos deben cumplir con los principios de **no repudio**, de forma que el sistema pueda demostrar que el voto fue emitido por un usuario válido y autorizado, sin posibilidad de negación posterior
* Pueden existir procesos manuales de verificación de datos en etapas como registro, validación de propuestas o aprobación de votaciones, especialmente en casos especiales o excepcionales
* Las verificaciones manuales deberán seguir esquemas de aprobación múltiple y estar registradas en el sistema con auditoría completa
* El sistema debe mantener un alto nivel de disponibilidad y tolerancia a fallos, garantizando la continuidad del proceso electoral digital
* Toda transmisión y almacenamiento de datos debe seguir estándares internacionales de cifrado y protección de datos (como **AES-256**, **TLS 1.3**, **ISO/IEC 27001**)
* La infraestructura deberá estar blindada contra accesos no autorizados, especialmente por parte de personal técnico (ingenieros de red, devops, etc.), utilizando técnicas como control de acceso lógico, zero-trust y enclave de datos confidenciales

## Modulo de crowdfunding

El módulo de **crowdfunding** del sistema de voto electrónico tiene como objetivo impulsar la innovación y el emprendimiento en Costa Rica mediante un proceso participativo, transparente y digitalmente gobernado. Este módulo permite que ciudadanos y organizaciones presenten propuestas de proyectos con potencial empresarial, los cuales podrán ser evaluados y validados por entidades especializadas como aceleradoras, incubadoras o grupos de inversión. Además, el gobierno puede intervenir para fomentar iniciativas alineadas con sus objetivos estratégicos, condicionando apoyos a criterios territoriales o sociales. Una vez validadas, las propuestas se publican para ser financiadas colectivamente por ciudadanos, y su ejecución es supervisada por la misma comunidad, que puede incluso votar para detener un proyecto en caso de irregularidades. La plataforma administra el flujo de capital, asegura la transparencia en el uso de fondos, y garantiza los retornos a los inversionistas conforme a los planes establecidos.

* Personas físicas u organizaciones registradas pueden presentar proyectos en forma de propuestas
* Las propuestas tendrán tipos diferenciados con reglas y validaciones específicas
* Existen grupos especiales registrados que pueden avalar propuestas: aceleradoras, incubadoras, grupos inversores
* Estos grupos deben declarar sus condiciones, honorarios, porcentajes de equity u otros esquemas de cobro
* Las propuestas pueden pasar por versiones sucesivas antes de someterse a votación final
* El gobierno puede otorgar aval mediante votación y añadir planes de uso e interés nacional
* El gobierno puede votar sobre beneficios especiales como incentivos de CCSS, Hacienda, entre otros
* También puede establecer condiciones como número de empleados, ubicación o sector económico para guiar el desarrollo
* Propuestas avaladas pueden ser publicadas por su autor cuando estén listas
* Las propuestas deben incluir presupuesto, plan de ejecución y plan de desembolso
* Los ciudadanos registrados pueden invertir directamente en los proyectos publicados
* La inversión es entregada completa por los ciudadanos al inicio
* La plataforma administra los desembolsos mensuales conforme al plan aprobado
* Se establece una fecha oficial de despliegue e inicio del proyecto
* Cualquier ciudadano puede actuar como fiscalizador durante la ejecución
* Las irregularidades pueden ser reportadas con evidencia y sometidas a votación por una población segmentada
* La votación puede decidir continuar o detener el proyecto
* Un proyecto detenido suspende los desembolsos y la adjudicación
* El plan de ejecución debe contemplar la forma de pago a los inversionistas y su plazo
* La plataforma es responsable de realizar los pagos a los inversionistas según el cronograma pactado
* En caso de incumplimiento, se inician procesos legales
* Los creadores del proyecto deben presentar mensualmente estados financieros y de resultados para los inversionistas y el público fiscalizador
* Considerar que este módulo es un indicio de otros módulos que se pueden construir basados en la plataforma de voting, podrían verse como parte del sistema o podrían diseñarse como una forma de integrar nuevos módulos o extensiones en el futuro

## Demo del Micitt

El Micitt debe presentar un prototipo de Voto Pura Vida a los poderes de la república enfocado en el caso de uso del crowdfunding para obtener el visto bueno con el que el proyecto irá avanzando. El Micitt ha seleccionado a su equipo de trabajo para crear este prototipo el cuál debe incluir:

### diseño de la base de datos

Para el desarrollo del **prototipo del sistema de voto electrónico**, se deben cumplir una serie de entregables técnicos enfocados en el **diseño, implementación y seguridad de la base de datos**, además de establecer buenas prácticas de versionamiento y documentación. El objetivo de esta fase es garantizar que el almacenamiento, procesamiento y protección de los datos cumplan con los requerimientos funcionales y no funcionales definidos previamente, especialmente en lo relacionado con la confidencialidad del voto, trazabilidad de procesos, segmentación por perfil, y auditoría.

* Se debe definir si el sistema utilizará una o varias bases de datos, pudiendo ser relacionales (como PostgreSQL o SQL Server), no relacionales (como MongoDB), o una combinación híbrida
* Diseñar e implementar las **tablas** (para relacional) y **colecciones** (para no relacional) necesarias para cubrir los flujos del sistema: usuarios, identidades, propuestas, votos, validaciones, logs, permisos, entre otros
* Considerar todos los requerimientos del sistema, tanto funcionales (votaciones, filtros por perfil, resultados, auditorías) como no funcionales (secreto del voto, no repudio, alta disponibilidad, cifrado de datos)
* Incorporar medidas robustas de **seguridad** en el diseño desde el inicio: separación de roles, control de acceso, cifrado en tránsito y en reposo, protección de llaves
* Crear un **script de llenado inicial (data seeding)** para las tablas o colecciones necesarias que permitan probar el prototipo (usuarios, propuestas de prueba, segmentos de población, reglas de votación, etc.)
* Diseñar y probar los **esquemas de seguridad nativos** del motor de base de datos: creación de roles, permisos, acceso segmentado y restricciones por IP o autenticación de múltiples factores (si aplica)
* Implementar mecanismos de **cifrado y descifrado** de datos sensibles (como votos, llaves, identidad del usuario) con herramientas como PGP, AES, RSA, o bibliotecas del motor de base de datos
* Diseñar e implementar un mecanismo seguro de **gestión de llaves**, contemplando llaves públicas, privadas y esquemas de compartición (por ejemplo, llave tri-partita) con acceso segregado
* Cada equipo tendrá derecho a **dos sesiones de revisión con el arquitecto de software (profesor)** vía videollamada. Es requisito que todo el grupo esté presente y con el diseño preparado
* Toda la documentación técnica, scripts, diagramas y estructuras deben estar centralizados en **un único repositorio en GitHub**
* Se debe implementar **control de versiones de la base de datos** utilizando la herramienta **Flyway**
  👉 [https://www.red-gate.com/products/flyway/](https://www.red-gate.com/products/flyway/)
* Todos los scripts, migraciones, seeds y actualizaciones estructurales deben ser gestionados y ejecutados exclusivamente mediante **Flyway**
* Considere en su diseño como eliminar o al menos reducir en gran medida el reproceso de contenido por AI

### implementación del API

Para la **implementación del API** del sistema de voto electrónico y crowdfunding, se desarrollará un service **serverless** en el lenguaje de programación que el equipo elija (por ejemplo, Python, Node.js, C#, Go, etc.). Aunque se trabajará bajo el enfoque tecnológico de **cloud computing (AWS o Azure)**, el **despliegue será completamente local**, garantizando que todos los miembros del grupo tengan la misma implementación y acceso a la base de datos de forma local. Este enfoque asegura consistencia, colaboración distribuida y portabilidad del entorno de desarrollo.

Los **endpoints de la API** se implementarán en **dos categorías: utilizando procedimientos almacenados (Stored Procedures)** y mediante un **ORM (Object-Relational Mapping)**. En esta sección se describen los endpoints correspondientes a cada categoría, con una descripción de alto nivel de los pasos que deben ejecutarse, teniendo en cuenta el **control transaccional**, **validaciones críticas** y la posible integración con servicios de IA.

---

### **Endpoints implementados por Stored Procedures**

**a) crearActualizarPropuesta**
Permite crear una nueva propuesta o actualizar una existente.

* Recibir datos del formulario y archivos adjuntos (documentación soporte)
* Insertar o actualizar información en las tablas/colecciones correspondientes
* Validar que el usuario tenga permisos de creación/edición sobre la propuesta
* Asociar la propuesta a su población meta: criterios como edad, grupo, región, etc.
* Enviar los datos a revisión interna (estado: *pendiente de validación*)
* Registrar el historial de cambios y generar hash de integridad
* Preparar contenido para revisión automatizada por IA
* Envolver todo el proceso en una transacción completa

**b) revisarPropuesta**
Proceso de validación y publicación de propuestas.

* Recibir el identificador de la propuesta
* Consultar su tipo y extraer sus criterios de validación
* Preparar payloads esperados para validación por IA o LLM (opcional pero obligatorio dejar estructuras preparadas)
* Procesar los resultados de IA/LLM o validaciones automáticas estructuradas
* Si cumple los requisitos, actualizar el estado de la propuesta a *publicada*
* Registrar validación, timestamp, resultado de revisión e identidad de los revisores
* Dejar trazabilidad del análisis técnico y la fuente de aprobación
* Ejecutar dentro de una transacción atómica para evitar estados inconsistentes

**c) invertir**
Permite a un ciudadano invertir en una propuesta abierta y aprobada.

* Validar que el proyecto esté en estado *aprobado para inversión*
* Verificar identidad del usuario y confirmar su registro en el sistema
* Validar el pago y confirmar el monto transferido por el inversionista
* Calcular el porcentaje accionario a entregar basado en monto y valor total
* Verificar que no se exceda el total permitido (overflow de inversión)
* Insertar registro de inversión, relación con propuesta y plan de entrega de fondos
* Generar calendario de revisión (fechas clave para fiscalización del proyecto)
* Preparar plan de desembolsos por tramos mensuales
* Ejecutar todos los pasos dentro de una transacción única

**d) repartirDividendos**
Distribuye dividendos a inversionistas de un proyecto activo.

* Validar que el proyecto esté en estado *ejecutando* y con fiscalizaciones aprobadas
* Recibir y verificar reporte de ganancias y disponibilidad de fondos para reparto
* Consultar los inversionistas y sus porcentajes de participación
* Calcular el monto a distribuir a cada inversionista según su equity
* Verificar que todos los inversionistas tengan medios de depósito válidos
* Generar transacciones de pago para cada inversionista
* Registrar el ciclo de distribución, con montos, fechas, e IDs de transacciones
* Ejecutar todo el proceso de forma segura y transaccional

---

### **Endpoints implementados por ORM**

A continuación se detallan los **endpoints implementados mediante ORM** para el prototipo del sistema de voto electrónico y crowdfunding. Estos endpoints están orientados a interacciones más dinámicas, de consulta, edición o configuración, y deben gestionarse mediante un ORM del lenguaje seleccionado (por ejemplo, **Entity Framework, SQLAlchemy, TypeORM, Prisma**, etc.). Todos deben incluir validaciones de seguridad, reglas de negocio y gestión de datos cifrados, según los estándares definidos para el sistema.


**a) votar**
Permite a un ciudadano emitir un voto sobre una propuesta activa.

* Validar credenciales del usuario
* Validar autenticación multifactor (MFA) y comprobación de vida
* Confirmar existencia activa del ciudadano en el sistema
* Verificar si el usuario está habilitado para votar en esa propuesta según su perfil
* Verificar que la propuesta siga abierta en el rango de fechas definido
* Confirmar que el usuario **no ha votado previamente** en esa propuesta
* Registrar el voto en la base de datos asociando la propuesta, fecha y decisión
* Cifrar el voto utilizando la llave vinculada a la identidad del votante
* Sumarizar el voto dentro de la colección de resultados cifrados sin exponer contenido
* Registrar trazabilidad y evento de participación

**b) comentar**
Permite agregar un comentario a una propuesta, sujeto a reglas de validación.

* Verificar si la propuesta permite comentarios
* Validar al usuario con credenciales y sesión activa
* Analizar el comentario y validar que cumpla con la estructura y documentación requerida
* Procesar validación automática de documentos o contenido adjunto (uso de IA opcional)
* Si se acepta, subir el comentario a la base con metadatos de usuario, propuesta y estado
* Si se rechaza, registrar el intento con motivo del rechazo y timestamp
* Todos los comentarios deben tener un estado: *pendiente, aprobado o rechazado*
* El contenido debe almacenarse cifrado si incluye archivos o documentos sensibles

**c) listarVotos**
Consulta los últimos cinco votos realizados por el usuario autenticado.

* Validar identidad del usuario, credenciales, MFA y prueba de vida
* Consultar en la base las cinco últimas propuestas en las que ha participado mediante voto
* Obtener la llave criptográfica del usuario
* Extraer los votos asociados, descifrarlos y mostrar: propuesta, fecha y decisión (resumen, no detalle)
* Registrar esta operación como evento de consulta auditada

**d) configurarVotacion**
Configura los parámetros de votación para una propuesta específica.

* Validar que el usuario tenga permisos para configurar esa propuesta
* Definir población meta mediante filtros como edad, sexo, nacionalidad, ubicación, instituciones, etc.
* Configurar la geografía y zona de impacto (nacional, regional, municipal, etc.)
* Establecer fechas de apertura y cierre de la votación
* Definir los votantes: listas directas, segmentadas o por reglas automáticas
* Establecer restricciones adicionales como IPs, accesos, horarios o turnos
* Especificar el tipo de votación: única, múltiple, calificación, etc.
* Cargar la(s) pregunta(s) asociada(s) a la propuesta y los posibles valores de respuesta
* Guardar la configuración completa de la votación en estado *preparado*
* Permitir actualizar esta configuración solo hasta que inicie el periodo de votación


### **Otros aspectos**
Todos los endpoints deberán:
* Estar versionado y almacenado en el repositorio GitHub del grupo
* Documentarse claramente con nombre, parámetros, lógica interna, y ejemplos de uso
* Usar mecanismos de protección de datos sensibles, roles y transacciones seguras
* Tener pruebas locales funcionales con datos del script de llenado de la base
* Funcionar como transacciones atómicas
* Dejar bitácora de lo acontecido

- el caso debe hacerse en grupos de 4, otro tamaño debe ser validado por el profesor
- todo debe documentarse en el repositorio único en github
- en la revisión todos los integrantes deben tener el ambiente completo funcionando en local
- fecha para la última consulta: Junio 6, 2025
- las revisiones inician a partir del 11 de Junio, 2025



