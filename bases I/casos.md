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

