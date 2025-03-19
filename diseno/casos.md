# Instituto Tecnológico de Costa Rica
**Profesor Rodrigo Nunez**
**Curso de diseño de software**
**Casos a resolver - 80%**




# Caso #1 - primer acercamiento al diseño de alto nivel, 10% 

A continuación se le va a presentar un conjunto de requerimientos de un software para dos sistemas, de los cuales solo va a trabajar en uno. Con ello usted va a realizar las preguntas que considere oportunas al cliente (profesor), con lo cual va a empezar a tomar decisiones de cómo se va a realizar el diseño de este sistema. Los pasos para completar este caso se irán dando conforme avancen las lecciones. 


## Title: Payment Assistant

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


**Requerimientos No Funcionales**

1. **Escalabilidad:**
   - La aplicación debe soportar 1,000 usuarios en fase beta y escalar a 100,000 usuarios en 6 meses.
   - El backend debe ser capaz de manejar picos de uso durante fechas de pago recurrentes.

2. **Seguridad:**
   - Todos los datos sensibles (cuentas bancarias, contraseñas, tokens de API) deben estar encriptados.
   - Debe cumplir con estándares de seguridad como PCI DSS para manejo de pagos.
   - Implementar autenticación de dos factores (2FA) para acceso a la aplicación.

3. **Rendimiento:**
   - La aplicación debe tener un tiempo de respuesta menor a 2 segundos para la mayoría de las operaciones.
   - Las notificaciones y recordatorios deben enviarse en tiempo real.

4. **Disponibilidad:**
   - La aplicación debe tener un uptime del 99.9%.
   - Debe implementarse un sistema de backup y recuperación ante desastres.

5. **Compatibilidad:**
   - Debe funcionar en las últimas versiones de Android (10+) e iOS (14+).
   - Debe ser compatible con diferentes dispositivos (smartphones y tablets).

6. **Usabilidad:**
   - La interfaz debe ser intuitiva y accesible para usuarios no técnicos.
   - Debe soportar múltiples idiomas (español, inglés, etc.).

**Requerimientos de Infraestructura**

1. **Hosting:**
   - Uso de servicios en la nube (AWS, Google Cloud, Azure) para alojar el backend y la base de datos.
   - Implementación de balanceadores de carga y autoescalado.

2. **Monitorización:**
   - Uso de herramientas como Prometheus, Grafana o New Relic para monitorizar el rendimiento y la disponibilidad.
   - Implementación de alertas automáticas para errores y fallos.

3. **CI/CD:**
   - Implementación de pipelines de integración y despliegue continuo (GitHub Actions, Jenkins, GitLab CI).


## Title: App assistant

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

**Requerimientos No Funcionales**

1. **Escalabilidad:**
   - La aplicación debe soportar 900 usuarios en la fase beta y escalar a 500,000 usuarios en dos años.
   - El backend debe ser capaz de manejar múltiples grabaciones y solicitudes de asistencia simultáneamente.

2. **Seguridad:**
   - Todos los datos sensibles grabados deben estar encriptados tanto en tránsito como en reposo.
   - Debe cumplir con regulaciones de privacidad como GDPR (Europa) y CCPA (California).
   - Implementar autenticación de dos factores (2FA).

3. **Rendimiento:**
   - La aplicación debe tener un tiempo de respuesta menor a 3 segundos para la mayoría de las operaciones.
   - Las grabaciones y procesamientos de IA deben realizarse sin afectar el rendimiento del dispositivo.

4. **Compatibilidad:**
   - Debe funcionar en sistemas operativos Windows, macOS, iOS y Android.
   - Debe ser compatible con navegadores web (como Chrome, Firefox, Safari) si se implementa como plugin.
   - Debe soportar integración con aplicaciones comunes (bancos, Netflix, erp, sap, web apps, etc.).

5. **Usabilidad:**
   - La interfaz debe ser intuitiva y accesible para usuarios no técnicos.
   - Debe incluir tutoriales y guías para facilitar la adopción de la aplicación.


**Requerimientos de Infraestructura**

1. **Hosting:**
   - Uso de servicios en la nube (AWS, Google Cloud, Azure) para alojar el backend y la base de datos.
   - Implementación de balanceadores de carga y autoescalado para manejar picos de uso.

2. **Monitorización:**
   - Uso de herramientas como Prometheus, Grafana o New Relic para monitorizar el rendimiento y la disponibilidad.
   - Implementación de alertas automáticas para errores y fallos.

3. **CI/CD:**
   - Implementación de pipelines de integración y despliegue continuo (GitHub Actions, Jenkins, GitLab CI).


## Entregable #1 - 3%

1. el profesor va a crear parejas de trabajo en forma aleatoria

2. la pareja, como ingenieros consultores, están en el predicamente de obtener del cliente tanta información como sea posible sobre el sistema, busque siempre simplificar los problemas del cliente para que también su diseño y solución se reduzca lo más posible.

3. Para el martes 25 de febrero, envíe un mensaje de discord al cliente, con el cuestionario de preguntas sobre el sistema. 

4. Obtenga las respuetas del cliente esa misma semana

5. Para el viernes 28 antes de las 5pm, envíe en un mensaje al profesor los una aproximación inicial a muy alto nivel de cómo ustedes como consultores ven diseñada esta solución, incluyendo en el mensaje: 

a) retos principales y más complejos de esta aplicación 

b) determinar la lista de requerimientos que va a ser imposible lograr en un 100% (del todo no, o si es parcialmente especificar lo que podrían alcanzar hacer) 

c) listar las tecnologías lenguajes, frameworks, servicios y plataformas respectivas para: frontend/mobile, backend, bases de datos, AI, 3rd parties, cloud/hosting, devops y QA. Justique el uso de cada item dentro del app, escribiendo la responsabilidad que va a tener dentro del sistema. Por ejemplo:  react/native, para generar el código del app mobile tanto en android como en ios.  


## Entregable #2 - 7%

1. Investigue como realizar un goal map en referencia a técnicas como google sprint o design thinking 

2. Proceda a crear un goal diagram ubicando el objetivo principal del sistema lo más a la derecha del diagrama y las entidades involucradas a la izquierda. Rellene el workflow del mapa y diagramelo en alguna herramienta que se lo permita. 

3. Determine entonces usando ese mapa cuales son los estados que garantizan el éxito del sistema, aquellos puntos que son más valiosos para lograr el objetivo principal del sistema, los cuales van a hacer que el usuario acepte o no el uso de esta aplicación.

4. Una vez determinados los más importantes, listelos y proceda a diseñar las pantallas de su sistema que realizarían dichos flujos del mapa.

5. Diseñe los wireframes en blanco y negro de las pantallas necesarias para esos flujos prioridad #1 para el negocio.

6. Cree las pantallas a modo mockup o mimic utilizando alguna AI que genere código en el lenguaje que haya seleccionado en el entregable #1. Si ninguna AI genera para ese lenguaje, entonces proceda a utilizar plantillas para crear las pantallas diseñadas. 

7. Proceda a realizar un test de usabilidad con al menos 3 personas (que no sean estudiantes del Tec), de las pantallas diseñadas utilizando alguna herramienta de testing de usuabilidad digital en la nube, recopile los resultados. 

8. Documenten todo el entregable del punto 1 al 7 en un md file en github, dividiendose el trabajo a su criterio. Debe ser evidente los commits de cada integrante en las diversas secciones del documento md. Solo un md file. En la documentación debe dejar claro las evidencias de que las pruebas de usabilidad se hicieron con personas reales no estudiantes del Tec. Fotografías de personas frente a una computadora no es evidencia, no debe caber duda en la evidencia de que esa persona hizo esa prueba. 

9. La revisión será con el profesor, y se espera que cualquier miembro del grupo de trabajo sea capaz de defender, explicar y realizar raciocinios y conclusiones sobre todo el entregable, de lo contrario se le asignará una nota de cero.

La entrega será enviándole al profesor un correo con los integrantes y el link al url público de github el cual contiene el MD file, fecha máxima para la entrega domingo 9 de marzo, 10pm.  Fecha límite para consultas viernes 7 de marzo a medio día. 


# Caso #2 - diseño del FE y BE, 20% 

El caso #2 se realizará en grupos de 3 a 4 personas máximo, los estudiantes deciden como armar los grupos y no es necesario mantener la pareja anterior. Los grupos se deben reunir y analizar los resultados y diseños hechos en el caso #1, rescatar aquello que sea más aprovechable para este siguiente entregable. Si en el grupo quedan integrantes de payment assistant y app assistant mezclados, deben decidir como grupo a cuál plataforma entregarse. 

Este caso pretende completar aspectos del diseño de objetos y arquitectónicos de la solución. El profesor dará una inducción sobre diagramas de arquitectura y sus diseños para que tengamos una base de lo que se quiere lograr principalmente.

En el caso #1 entregable #1, los integrantes habían sacado una primer aproximación de las tecnologías que se pretendían usar para la implementación de la solución, al crear estos nuevos grupos, reúnase con sus compañeros y consoliden un stack. Al igual que en los entregables anteriores, cree un repositorio en gihub que pueda acceder todos los miembros del grupo y creer una estructura inicial y proceda a ir creando las diferentes secciones, toda la documentación esta vez será en inglés.

Estructura sugerida :

- "# System name - set your own name" 

- "*Members* - list the names of the group members" 

- "## Description: Write a brief description of the system, highlighting its strengths"

- "## Stack: write down the final stack to be use decided for the group"

- "## Frontend design specifications"

- "### Authentication platform", Conduct research to determine which service platform you will use for authentication, ensuring that it offers at least: 

   a) login y password 

   b) login y password automatic screen generation or SDK for screen generation 

   c) compatible with your FE programming language  

   d) access by API available 

   e) MFA and a sandbox for testing purpose 
   

- Using a demo code, proceed to test how the chosen platform works and how the login screen can be customized. Document this process in the MD file. The demo code must be use in the selected programming language of the FE. 

- Using Postman, make API calls to simulate authentication with MFA. Document the process and save your own Postman collection for future review

- suggested platforms to look into: auth0, okta, cognito, MS entra, onelogin, firebase, veriam

el resto de la especificación de este caso está en progreso. 

