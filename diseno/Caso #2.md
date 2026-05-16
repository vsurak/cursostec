# Caso #2 - Diseño de un producto innovador

Para este momento su grupo de trabajo abordó una problemática, entrevistó personas para entender un aspecto particular de dicha problemática y por métodos determinó un problema específico a atacar e ideó una posible forma. 

El objetivo ahora es diseñar la solución completa para con ello implementar un MVP que va utilizar de demo comercial al cierre del curso. Esta caso tendrá las siguientes etapas:

1. Prototipado y refinamiento UX - 5%

2. Diseño del frontend - 10% 

3. Diseño del backend y data - 20% 

4. MVP - 10% 

5. Sales pitch y demo - 10% 

Para todo el desarrollo del caso #2, deberá tener un repositorio en github centralizado, con un readme.md en el root, donde todos van a trabajar en forma concurrente y colaborativa. Se revisará la participación y commits de todos los integrantes aportando el caso. Habrá una única revisión oficial final evaluada, cada grupo es responsable por las revisiones parciales para validar avances con el profesor. Tenga presente que la disponibilidad del profesor no es infinita y conforme se acerquen las fechas límite, más difícil será encontrar especio para hacer consultas y revisiones preliminares; por lo que se sugiere ir revisando en forma incremental. 


# 1. Prototipado y refinamiento UX – 5%

* Crear un prototipo funcional de la ventana principal de la aplicación.
* La ventana seleccionada debe representar el flujo principal relacionado con el problema definido en el *Problem Statement* y validado durante la dinámica de *Crazy 8s*.
* El prototipo debe incluir navegación básica, componentes interactivos y simulación mínima del comportamiento esperado.
* Montar el prototipo en una herramienta de *UX Testing* o prototipado interactivo (por ejemplo: Figma, Maze, Adobe XD, InVision u otra similar).
* Realizar sesiones de *UX Testing* con al menos 4 estudiantes del grupo de diseño que no pertenezcan al mismo equipo de trabajo.
* Definir previamente tareas concretas para los participantes del testing, por ejemplo: completar un flujo, encontrar una funcionalidad o interpretar información mostrada en pantalla.
* Documentar y evidenciar los resultados obtenidos durante el UX Testing: 

  * capturas de pantalla,
  * observaciones,
  * métricas básicas,
  * problemas detectados,
  * comentarios relevantes de los participantes.

* Identificar problemas de usabilidad, navegación, comprensión visual, accesibilidad o consistencia detectados durante las pruebas.
* Documentar y presentar las correcciones realizadas al prototipo basadas en los hallazgos obtenidos durante las sesiones de UX Testing.
* Explicar claramente qué problema resolvía cada corrección aplicada y cuál fue el criterio utilizado para tomar la decisión de diseño.

---

# 2. Diseño del frontend – 10%

Proceder con el diseño del frontend. A continuación, se enumeran varios aspectos esperados dentro de este diseño; sin embargo, el grupo no debe limitarse únicamente a estos puntos, sino abordar cualquier faceta relevante relacionada con la arquitectura, mantenibilidad, escalabilidad, seguridad y experiencia de usuario del frontend.

No olvidar en ningún momento que el objetivo de este `README.md` no es únicamente satisfacer requisitos académicos o cumplir una evaluación, sino brindar al equipo de desarrollo una guía técnica clara, detallada y útil sobre cómo se construirá la solución.

## Aspectos importantes a tomar en cuenta en el diseño del frontend

* Definir el *stack* de tecnologías y frameworks a utilizar, incluyendo versiones compatibles y justificación de elección.
* Definir el servicio de hosting y los servicios del proveedor cloud que serán utilizados.
* Explicar la estructura general del frontend y la organización de carpetas del proyecto.
* Documentar técnicas, consideraciones y ejemplos sobre cómo se desarrollarán los componentes visuales y su estructura en el código.
* Definir convenciones de nomenclatura para componentes, archivos, carpetas y estilos.
* Documentar lineamientos de CSS y estilos:

  * colores,
  * tipografías,
  * logos,
  * iconografía,
  * espaciados,
  * estilos reutilizables,
  * responsive design,
  * lineamientos de branding y etiquetado visual.

* Incluir el resultado del prototipado y las decisiones derivadas del UX Testing.
* Definir aspectos relacionados con:

  * autenticación,
  * autorización,
  * privacidad de datos,
  * cifrado,
  * masking de información,
  * manejo seguro de sesiones,
  * expiración de tokens,
  * validación de permisos.

* Documentar estándares y revisiones de seguridad aplicables, incluyendo prácticas basadas en OWASP.
* Explicar la estrategia de patrones arquitectónicos utilizados en el frontend.
* Explicar los patrones de diseño orientados a objetos o patrones de componentes utilizados.
* Documentar consideraciones de diseño relacionadas con:

  * session storage,
  * local storage,
  * web sockets,
  * comunicación asíncrona,
  * manejo de procesos largos,
  * eventos,
  * observabilidad,
  * monitoreo,
  * manejo de errores,
  * manejo de estados,
  * caching,
  * retries.

* Explicar cómo se manejará el consumo de APIs y el manejo de contratos de datos.
* Definir estrategias de CI/CD:

  * pipelines,
  * scripts de deployment,
  * validaciones automáticas,
  * análisis estático,
  * acciones automáticas de código.

* Documentar estrategias de:

  * unit testing,
  * integration testing,
  * UI testing,
  * cobertura mínima esperada.

* Incluir diagramas de arquitectura, diseño en capas o modelos C4.
* Explicar estrategias para optimización de rendimiento:

  * lazy loading,
  * code splitting,
  * reducción de bundles,
  * manejo eficiente de imágenes,
  * memoization,
  * virtualización.

* Siempre vincular las explicaciones a ejemplos reales de código ubicados en `/src` mediante enlaces directos.

---

# 3. Diseño del backend y data – 20%

De la misma forma, a continuación se enumeran varios aspectos de suma importancia a tomar en cuenta en el diseño del backend y la capa de datos. Sin embargo, los estudiantes no deben limitarse únicamente a estos puntos, sino utilizarlos como guía base para desarrollar un diseño técnico sólido y mantenible.

## Aspectos importantes a tomar en cuenta en el diseño del backend y data

* Definir el *stack* de tecnologías y frameworks a utilizar, incluyendo versiones compatibles.
* Definir el servicio de hosting y los servicios cloud que serán utilizados.
* Explicar las técnicas y patrones arquitectónicos implementados:

  * responsabilidades,
  * clases participantes,
  * activación de los patrones,
  * interacción entre componentes,
  * ventajas de uso,
  * ejemplos prácticos.

* Documentar patrones de diseño orientados a objetos:

  * implementación,
  * reglas,
  * clases participantes,
  * casos de uso,
  * ejemplos de código.

* Definir claramente el diseño en capas:

  * responsabilidades de cada capa,
  * restricciones,
  * qué debe y qué no debe implementarse en cada capa,
  * flujo de comunicación entre capas.

* Incluir diagramas de arquitectura y/o modelos C4.
* Documentar lineamientos claros sobre:

  * middlewares,
  * autenticación,
  * autorización,
  * manejo de errores,
  * observabilidad,
  * monitoreo,
  * procesos largos,
  * comunicación asíncrona,
  * integración con IA,
  * manejo de variables de entorno,
  * configuración,
  * caches,
  * queues,
  * manejo de conexiones,
  * connection pooling,
  * threading,
  * DTOs,
  * validación de datos.

* Definir estrategias de:

  * unit testing,
  * integration testing,
  * API testing,
  * health checks,
  * contract testing.

* Documentar paso a paso las reglas de negocio, algoritmos o procesos complejos que vayan más allá de operaciones CRUD simples.
* Explicar técnicas para mantener tamaños de bundles o artefactos reducidos y eficientes.
* Explicar cómo estará organizado el código para facilitar mantenimiento, navegación y escalabilidad del repositorio.
* Definir scripts y pipelines de CI/CD:

  * deployments,
  * automatizaciones,
  * validaciones automáticas,
  * análisis estático,
  * quality gates.

* Definir scripts y configuraciones para ambientes:

  * desarrollo,
  * staging,
  * producción.

* Incluir especificaciones en Markdown del diseño de la base de datos.
* Incluir especificaciones en Markdown de los agentes o herramientas automatizadas que revisan el diseño de base de datos.
* Diseñar la base de datos utilizando Markdown Database Language (DBML o equivalente).
* Incluir diagramas entidad-relación orientados específicamente al motor o motores de base de datos seleccionados.
* En caso de utilizar motores documentales o NoSQL:

  * diseñar usando el ORM correspondiente,
  * incluir ejemplos JSON representativos,
  * documentar estructura de documentos y colecciones.

* Incluir:

  * scripts de creación de base de datos,
  * scripts de seeding,
  * migraciones,
  * herramientas utilizadas,
  * estrategias de versionamiento y rollback.

* Definir estrategias de seguridad de datos:

  * cifrado,
  * auditoría,
  * trazabilidad,
  * manejo de secretos,
  * backups,
  * recuperación ante fallos.

* Siempre vincular las explicaciones a ejemplos reales de código ubicados en `/src` mediante enlaces o referencias claras.

4. MVP - 10% 
- pending to describe

5. Sales pitch y demo - 10% 
- pending to describe


# Fechas de revisión
- El grupo de trabajo, antes del 2 de junio, deberá bookear una fecha de revisión de 1.5 horas con el profesor, la fecha debe ser entre el 8 y el 20 de Junio. 

- El viernes 26 de junio de 9:30am a 11:20 será la presentación del sales pitch y demo, donde se dará la nota final del curso a cada estudiante. 