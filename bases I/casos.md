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

