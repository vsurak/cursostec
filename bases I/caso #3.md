# Caso #3 - Gathel, Gaming the life - 45%

**Gathel** es un juego digital de predicciones basado en acciones y eventos de la vida real de las personas, validados mediante redes sociales e inteligencia artificial.

Al registrarse en la plataforma, los jugadores pueden asociar una o varias cuentas de redes sociales, por ejemplo Instagram o TikTok. Esto permite que Gathel solicite autorización para acceder automáticamente a publicaciones, historias, reels, videos y demás contenido público o autorizado por el usuario.

Cada jugador inicia con un balance inicial de **100 puntos (pts)** dentro de la plataforma.

---

# Ejemplo de un día de juego en Gathel

* Elizabeth publica en Instagram que está entrenando para una maratón.

* John, seguidor de Elizabeth, crea en Gathel la siguiente proposición:

  > “Elizabeth no asistirá a la maratón.”

* Karina, también seguidora de Elizabeth, propone:

  > “Elizabeth terminará la maratón dentro de los primeros 30 lugares.”

* La misma Elizabeth crea una proposición sobre sí misma:

  > “Voy a lograr al menos el décimo lugar en la maratón.”

* Antes de que cualquier proposición sea publicada, un sistema de inteligencia artificial analiza automáticamente el contenido para detectar y bloquear temas:

  * ilegales,
  * violentos,
  * sexuales,
  * discriminatorios,
  * fraudulentos,
  * o cualquier otro contenido que viole normas éticas, morales o legales de la plataforma.
  * existen términos y condiciones, reglas claras en la plataforma de lo que se puede o no proponer, de forma que se respete la integridad moral, física y de salud de la persona

* Los demás jugadores de Gathel pueden votar por las proposiciones que consideran más interesantes o más probables de ocurrir.

* Elizabeth tiene la capacidad de rechazar cualquier proposición sobre ella que considere ofensiva, invasiva o inaceptable.

* Ningún jugador puede visualizar cuál proposición tiene más votos. Únicamente Elizabeth puede ver esa información.

* Después de 24 horas desde la creación de la primera proposición relacionada con el evento, Gathel muestra cuál fue la propuesta ganadora.

* Elizabeth decide si acepta o rechaza oficialmente la proposición seleccionada.

* Si Elizabeth rechaza la proposición:

  * pierde 1 punto de su balance,
  * la proposición se cierra,
  * y no se habilitan predicciones sobre ella.

* Si Elizabeth acepta la proposición:

  * inicia oficialmente el concurso,
  * define la fecha y hora límite para recibir predicciones,
  * y la proposición pasa al estado “activa”.

---

# Sistema de predicciones

* Los jugadores pueden predecir si la proposición se cumplirá o no.

* Las predicciones pueden realizarse utilizando:

  * puntos virtuales,
  * dinero real,
  * o ambos mecanismos según las reglas del evento.

## Predicciones con puntos

* Cada jugador puede arriesgar un máximo de 1 punto por predicción.
* Los puntos funcionan como una moneda virtual interna del juego.

## Predicciones con dinero real

* El jugador puede decidir cuánto dinero desea arriesgar en una predicción.
* El monto apostado puede incrementarse en cualquier momento antes de la fecha de cierre de la proposición.
* Una vez cerrada la etapa de predicciones, ya no se permiten modificaciones.

---

# Validación del resultado

* El día del evento, Elizabeth publica evidencia del resultado utilizando contenido como:

  * fotos,
  * videos,
  * stories,
  * publicaciones,
  * o transmisiones.

* El contenido debe incluir referencias o hashtags asociados a Gathel.

* Gathel utiliza inteligencia artificial, modelos de análisis multimedia y múltiples agentes automáticos para:

  * analizar el contenido,
  * validar autenticidad,
  * detectar manipulación,
  * interpretar resultados,
  * y determinar automáticamente si la proposición se cumplió o no.

* En caso de ambigüedad, Gathel puede solicitar evidencia adicional o validación manual por parte del jugador.

---

# Distribución de recompensas

## Cuando se usan puntos

* Los jugadores que pierden la predicción pierden el punto invertido.
* El total de puntos perdidos se distribuye proporcionalmente entre los jugadores ganadores, deduciendo antes una comisión de puntos para la plataforma y otra comisión de puntos para el jugador que ejecutó la porposición. 

## Cuando se usa dinero real

* Los jugadores que pierden, pierden el dinero arriesgado.
* El monto total acumulado se distribuye proporcionalmente entre los ganadores.
* Antes de distribuir el dinero, Gathel deduce una comisión de la plataforma y una comisión para el jugador que ejecutó la proposición. 

---

# Casos especiales

## Imposibilidad de validar el resultado

Si Gathel no logra validar correctamente el resultado de una proposición, incluso con apoyo del jugador:

* todos los participantes recuperan:

  * sus puntos,
  * y su dinero invertido,

* mientras que el jugador asociado a la proposición pierde un 15% de sus puntos actuales como penalización.

Por esta razón, Gathel siempre valida antes de aceptar una proposición que el jugador tenga suficientes puntos para cubrir posibles penalizaciones.

---

# Economía del juego

* Los jugadores pueden retirar ganancias en dinero real mediante transferencias bancarias u otros métodos habilitados por la plataforma.

* Si un jugador se queda sin puntos, puede adquirir más mediante compra directa.

* Empresas y comercios afiliados en cada país pueden ofrecer productos o servicios canjeables por puntos de Gathel.

* Gathel mantiene eventos y proposiciones activas continuamente entre jugadores conectados a la plataforma.


# Actividades a realizar en el caso

Crear un repositorio unificado donde lo integrantes del grupo trabaje de forma colaborativa. Se revisaran aportes, commits a lo largo de la resolución del caso. El caso se trabajará en máximo grupos de 3. 

## Diseño de la base de datos

* Proceda a realizar el diseño de la base de datos de Gathel utilizando un formato de especificación en Markdown para documentar las tablas, relaciones, restricciones, índices y reglas principales del modelo de datos.

* Genere el diseño en DBML a partir de la especificación realizada.

* Escriba y documente en el repositorio uno o varios agentes de AI encargados de revisar el diseño de la base de datos. Estos agentes deben analizar aspectos como:

  * reglas de negocio,
  * seguridad,
  * economía del juego,
  * transferencias y pagos,
  * procesamiento de AI,
  * integración con redes sociales,
  * normalización,
  * diseño optimizado para altos volúmenes de inserts y pocos updates,
  * autenticación y autorización,
  * eventos del juego,
  * monitoreo,
  * observabilidad,
  * auditoría,
  * trazabilidad,
  * rendimiento,
  * particionamiento,
  * índices,
  * y escalabilidad.

* Evidencie los resultados obtenidos por los agentes de análisis y documente claramente las mejoras realizadas sobre el diseño original a partir de sus recomendaciones.

* Genere el diagrama final de la base de datos para SQL Server en formato PDF y envíelo al profesor para una revisión preliminar.

* Documente todo el proceso en el `README.md` del repositorio. Cualquier archivo adicional ubicado dentro de `/src` debe ser referenciado mediante enlaces claros desde el `README.md`.

* Investigue, pruebe y documente el funcionamiento de la herramienta de migraciones Flyway en SQL Server. Debe incluir:

  * instalación,
  * configuración,
  * estructura de carpetas,
  * versionamiento,
  * ejecución de migraciones,
  * rollback (si aplica),
  * y hallazgos relevantes obtenidos durante las pruebas.

* Cree la estructura de carpetas de Flyway correspondiente al proyecto.

* Cree un script de seeding e intégralo dentro de Flyway. Con esto se debe garantizar que todos los integrantes del equipo tengan exactamente la misma estructura y contenido inicial de base de datos en sus ambientes locales.

* El script de seeding debe generar, como mínimo:

  * 1000 jugadores,
  * 5000 proposiciones,
  * 250000 eventos asociados a las proposiciones,
  * y los registros de pagos correspondientes a las 5000 proposiciones.
  * no hacer esto con inserts exhaustivos, si no con bucles

* El proceso de seeding debe contemplar:

  * integridad referencial,
  * consistencia de datos,
  * generación realista de información,
  * distribución variada de eventos,
  * timestamps coherentes,
  * y relaciones válidas entre jugadores, proposiciones, predicciones, pagos y resultados.

* **De aquí en adelante todos los scripts que se van a solicitar como parte de este caso deberán administrarse y versionarse por medio de flyway y gitbub**

## Live coding
- El estudiante creará scripts ejemplos pero también se le pedirá que haga queries en "live coding" durante la revisión, que cubran los siguientes puntos:

    - SELECT, INSERT, DELETE, UPDATE, JOINS (NATURAL-INNER-LEFT-RIGHT)
    - Common table expressions
    - Queries y subqueries
    - Creación y uso de vistas
    - Uso de instrucciones como CASE, EXIST, NOT EXISTS 
    - Operaciones de conjunto como IN, NOT IN, MERGE, INTERSECT
    - Table value parameters en stored procedures y functions
    - Selects de JSON con tablas de forma mezclada
    - Crear CSV basados en queries
    - Diferencia entre un cursor global y uno local
    - Uso de triggers
    - sp_recompile
    - coalesce
    - funciones agregadas
    - rank, dense_rank, rownumber y partition by
    - Union, Distinct
    - schema binding y with encryption

- Al estudiante también se le solicitará que explique como funcionan las instrucciones antes mencionadas en este ejercicio usando los scripts proporcionados

# Security Lab

* El estudiante deberá crear usuarios de prueba dentro de la base de datos.

* Deberá construir un ejercicio utilizando SQL Server Management Studio que permita demostrar los siguientes escenarios:

  * Creación de roles de usuario con permisos específicos.

  * Asignación de usuarios a distintos roles.

  * Demostrar que un usuario puede poseer:

    * permisos asignados directamente,
    * y permisos heredados mediante roles.

  * Validar escenarios donde:

    * un usuario no pueda realizar `SELECT` sobre una tabla específica,
    * pero sí pueda acceder indirectamente a dicha información mediante la ejecución de un Stored Procedure o Function con permisos autorizados.

  * Validar escenarios donde:

    * un usuario tenga permisos de lectura sobre una tabla,
    * pero no permisos de escritura,
    * o viceversa.

* Demostrar que es posible aplicar **Data Masking** sobre campos sensibles.

* Demostrar que es posible aplicar **Row-Level Security (RLS)** basado en el usuario autenticado sobre alguna tabla del sistema.

* Demostrar el uso de cifrado de contraseñas utilizando un master certificate 

* Documentar scripts, configuraciones, usuarios creados, resultados esperados, y evidencia de ejecución. Esto se validará en forma demostrativa durante la revisión. 

---

# Transacciones y concurrencia

* Todos los ejercicios deben realizarse mediante scripts SQL, utilizando uno o múltiples archivos según sea necesario. Esto se validará en forma demostrativa en la revisión. 

* Demostrar el comportamiento de un flujo exitoso, y uno fallido, cuando existen 3 Stored Procedures transaccionales ejecutándose de forma anidada y ocurre un fallo en el último SP de la cadena, mientras aún existen operaciones pendientes en los niveles superiores.

* Simular un **deadlock** utilizando dos Stored Procedures con operaciones de escritura concurrentes.

  * No se permite utilizar instrucciones explícitas de locking.
  * Sí se permite utilizar `WAITFOR DELAY` para facilitar la sincronización del escenario.

* Demostrar que puede ocurrir un deadlock provocado por:

  * una operación de lectura (`SELECT`),
  * y una operación de escritura concurrente.

* Demostrar un escenario de deadlock cíclico del tipo:

  ```
  T1 → T2 → T3 → T1
  ```

* Demostrar los problemas potenciales asociados a los niveles de aislamiento:

  * `READ UNCOMMITTED`
  * `READ COMMITTED`
  * `REPEATABLE READ`
  * `SERIALIZABLE`

* El estudiante debe comprender y documentar claramente:

  * qué problemas pueden ocurrir en cada nivel,
  * cómo identificarlos,
  * y cómo mitigarlos o solucionarlos en escenarios reales.

* Crear todos los Stored Procedures transaccionales necesarios para soportar el MVP del proyecto.

* Todos estos scripts son mantenidos en flyway. 

---

# Gathel MVP

## Frontend del MVP

* Crear e implementar la pantalla principal de Gathel utilizando herramientas o asistencia de AI si así lo desea el estudiante.

* El estudiante puede decidir si el MVP será:

  * una aplicación web,
  * o una aplicación Android.

## Funcionalidades mínimas esperadas en el MVP

* Login y logout.

* Visualizar en la pantalla principal:

  * balance de puntos,
  * balance de dinero real,
  * y actividad básica del jugador.

* Crear una proposición:

  * para otro jugador,
  * o para sí mismo.

* Visualizar proposiciones activas disponibles para realizar pronósticos.

* Realizar pronósticos utilizando:

  * puntos,
  * o dinero real.

* Visualizar los resultados de proposiciones finalizadas.

* La comunicación entre frontend y backend debe realizarse mediante un REST API.

---

## Backend del MVP

* Implementar un REST API para el MVP utilizando el lenguaje de programación de preferencia del estudiante.

* Implementar todos los endpoints requeridos por el frontend del MVP.

* Todas las operaciones de lectura deberán realizarse utilizando un ORM.

* Todas las operaciones de escritura deberán ejecutarse llamando directamente a Stored Procedures.

* Habilitar y configurar un esquema de **fixed-size connection pooling** para las conexiones hacia la base de datos.

---

## Consideraciones del MVP

Dado que se trata de un MVP, múltiples funcionalidades avanzadas quedan fuera del alcance inicial. Por ejemplo:

* no existe integración real con AI,
* no existe backoffice administrativo,
* no se implementan todos los flujos operativos completos en el frontend,
* y algunos procesos internos serán ejecutados manualmente mediante scripts o Stored Procedures.

Por esta razón, cualquier funcionalidad necesaria para demostrar correctamente el MVP, pero que no forme parte directa del frontend o backend definidos anteriormente, podrá resolverse mediante scripts SQL o Stored Procedures ejecutados directamente en la base de datos.

Por ejemplo:

* El MVP permite crear una proposición, pero no necesariamente incluye:

  * votaciones,
  * aceptación formal,
  * fechas límite,
  * cierre automático de pronósticos.

* Estos procesos pueden implementarse mediante scripts o SPs.

* De igual forma, procesos como:

  * calificación de resultados,
  * distribución de ganancias,
  * cálculo de pagos,
  * cierre de eventos,
  * o penalizaciones,

  pueden resolverse utilizando Stored Procedures o scripts adicionales fuera del flujo principal del frontend.


# Entrega
- Deberá entregar un único URL de github donde esté el repositorio completo del proyecto con los scripts, diagramas, código fuente de MVP, especificaciones markdown del diseño, definición de agentes utilizados de AI

- El MVP debe ser posible ejecutarlo de manera contenerizada usando docker-compose. SQL server puede correrse nativo en una computadora o usando docker. 

- Fecha limite para enviar el diseño de la base de datos en PDF a revisión con el profesor: domingo 24 de mayo.  

- Las revisiones serán con cita de 1.5 horas entre el 14 y el 24 de Junio. No hay fecha límite para el último commit. 