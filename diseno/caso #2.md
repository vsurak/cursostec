# Caso #2: PromptSales –  40%
Trabajo a realizarse en grupos de 3 a 4 personas. 

**Descripción**

SolidNY es una empresa radicada en Nueva York con 15 años de experiencia en mercadeo digital. Con el propósito de expandir su alcance y aprovechar el potencial de la inteligencia artificial, la compañía lanza una nueva marca llamada **PromptSales**, cuyo enfoque es cerrar ventas de forma eficiente y medible. Su criterio principal de éxito radica en la **cantidad y el monto de las ventas logradas**, utilizando una combinación de automatización, análisis de datos e inteligencia artificial aplicada a todas las etapas del embudo de ventas.

PromptSales está conformada por un ecosistema de subempresas interconectadas, cada una especializada en una etapa diferente del proceso de mercadeo y ventas. Aunque pueden operar de forma independiente, todas se integran en un flujo automatizado que cubre desde la creación de contenido hasta el cierre de ventas.

Las subempresas son: 


## PromptContent

Se encarga de generar contenido creativo para campañas de mercadeo. Sus productos y servicios incluyen:

* Creación de contenido textual, audiovisual e imágenes para redes sociales, anuncios y sitios web.
* Generación de material adaptable a resultados de motores de búsqueda y respuestas de inteligencia artificial.
* Uso de herramientas propias de IA para creación automatizada de contenido optimizado para distintos públicos meta.
* Integración con plataformas externas como Canva, Adobe, Meta Business Suite y OpenAI API, etc

## PromptAds

Responsable de la ejecución y optimización de campañas publicitarias.

* Diseño, segmentación y publicación de anuncios en redes sociales, email marketing, SMS, LinkedIn e influencers.
* Análisis en tiempo real del rendimiento de campañas.
* Generación automática de campañas a partir de datos de públicos meta y objetivos de venta.
* Integración con plataformas externas como Google Ads, Meta Ads, TikTok for Business, Mailchimp y plataformas de CRM.

## PromptCrm

Gestiona el seguimiento de los clientes potenciales hasta el cierre de la venta.

* Registro y clasificación automática de leads provenientes de distintas fuentes.
* Implementación de chatbots, voicebots y flujos automatizados de atención.
* Seguimiento de compradores y predicción de intención de compra mediante IA.
* Integración con plataformas como HubSpot, Salesforce, Zendesk, WhatsApp Business API, entre otras 

**Portal Web Unificado**

El portal unificado de **PromptSales** funciona como el centro de control donde los mercadólogos y agentes de ventas gestionan todas las actividades del ecosistema. Desde esta plataforma, se diseñan estrategias completas para los clientes, abarcando campañas, contenido, audiencias, medios y tiempos.

**Principales Funcionalidades**

* **Diseño de estrategias de mercadeo personalizadas**: los usuarios pueden definir mensajes, públicos meta, intenciones de campaña, productos o servicios y países objetivo.
* **Automatización con supervisión humana**: el sistema utiliza IA para generar automáticamente campañas, contenido, tiempos, medios y sugerencias, las cuales deben ser revisadas y aprobadas por personal autorizado antes de su ejecución.
* **Agenda inteligente de ejecución**: cada campaña tiene un calendario de tareas automatizadas con recordatorios, alertas y revisión de entregables.
* **Integración completa**: el portal se comunica con las plataformas de las tres subempresas y con servicios externos (CRM, redes sociales, plataformas de anuncios, herramientas de contenido y analítica).
* **Panel de resultados y analítica avanzada**: ofrece reportes en tiempo real sobre desempeño, tasa de conversión, inversión y retorno.
* **Gestión de suscripciones**: cada subempresa ofrece planes de servicio (tiers) que pueden ser contratados de forma individual o como parte del ecosistema integrado.

**Datos Relevantes a investigar para el sistem**

El ecosistema de PromptSales depende de la interacción entre varios tipos de datos y módulos de integración:

* **Datos de clientes**: información de empresas, productos, objetivos de venta, presupuestos y contactos.
* **Datos de campañas**: mensajes, medios, tiempos, presupuestos, métricas de rendimiento.
* **Datos de contenido**: materiales creados, formatos, versiones aprobadas, derechos de uso.
* **Datos de interacción**: leads, historial de comunicación, respuestas automáticas, comportamiento del usuario.
* **Datos de integración**: conexiones API, autenticaciones y sincronización de datos entre sistemas externos.
* **Módulos de IA**: generación de contenido, predicción de intención de compra, optimización de anuncios, análisis de sentimiento y ranking de performance.

### Visión técnica de PromptSales

* Las subempresas PromptContent, PromptAds y PromptCrm deben estar **interconectadas mediante servidores MCP (Model Context Protocol)**, permitiendo la comunicación segura y eficiente entre los sistemas de IA, automatización y gestión de datos.
* El **despliegue, orquestación y mantenimiento** de toda la infraestructura debe realizarse con **Kubernetes**, asegurando alta disponibilidad, balanceo de carga y escalabilidad dinámica de los servicios.
* La **integración con servicios externos e internos** (plataformas de anuncios, CRM, herramientas de contenido, pagos y analítica) se debe realizar por medio de **APIs REST** o **servidores MCP**, dependiendo del tipo de servicio y del nivel de automatización requerido.
* Todas las **aplicaciones web y paneles administrativos** deben desarrollarse y desplegarse en **Vercel**, aprovechando su integración nativa con frameworks modernos (Next.js, React) y su sistema de despliegue continuo (CI/CD).
* Se debe implementar una **base de datos Redis en la nube** centralizada para almacenar resultados temporales y datos cacheados, con el fin de:

  * Reducir la cantidad de llamadas a APIs REST y servidores MCP.
  * Reutilizar resultados frecuentes en procesos de IA y analítica.
  * Minimizar el consumo de tokens en modelos de inteligencia artificial.
  * Aumentar la velocidad de respuesta en consultas recurrentes.

### Requerimientos No Funcionales

_Rendimiento_ 

* El tiempo promedio de respuesta del portal web no debe exceder **2.5 segundos** en operaciones estándar.
* Las consultas cacheadas mediante Redis deben entregar resultados en menos de **400 milisegundos**.
* Los procesos de generación automática de contenido o campañas deben ejecutarse en menos de **7 segundos** para solicitudes simples y menos de **20 segundos** para ejecuciones complejas con IA.

_Escalabilidad_

* La arquitectura debe soportar un incremento de **hasta 10 veces** la carga base sin degradación perceptible del rendimiento.
* Kubernetes debe permitir **autoescalado horizontal** basado en CPU, memoria y número de solicitudes concurrentes.
* El sistema debe manejar simultáneamente **más de 5000 campañas activas** y **más de 300 agentes o usuarios concurrentes** distribuidos entre las subempresas.
* Las API de cualquiera de las plataformas podría llegar a alcanzar en el primer año hasta 100000 operaciones de usuario por minuto que requieren acceso a la base de datos, en horario habitual de 7am hasta 7pm. Y hasta 300 procesos no supervisados por minuto ejecutándose en background fuera de horario de oficina. 

_Tolerancia a Fallos_

* Disponibilidad mínima del sistema de **99.9% mensual**.
* Los contenedores críticos deben reiniciarse automáticamente ante fallos o degradación de servicio.
* Redis y las bases de datos deben contar con **replicación en tiempo real** y **failover automático**.
* Implementación de **backups automáticos diarios** y retención mínima de **30 días**.

_Seguridad_

* Autenticación y autorización mediante **OAuth 2.0** para todos los usuarios y servicios.
* Cifrado de todas las comunicaciones entre servicios con **TLS 1.3**.
* Cifrado de datos en reposo con **AES-256** en bases de datos y almacenamiento persistente.
* Auditoría y logging centralizado con retención de **90 días**.
* Cumplimiento con estándares de protección de datos internacionales (**GDPR, CCPA**) y políticas de acceso mínimo necesario (principio de least privilege).


# Actividades a realizar

Proceda a crear el diseño de la solución para este proyecto. Toda la documentación del diseño, guías, código fuente relacionado y demás debe estar en un repositorio de GitHub y documentada en un único archivo readme.md en la raíz del repositorio. La documentación debe permitir que cualquier miembro del equipo, al clonar el repositorio, pueda comprender todas las decisiones de diseño y trabajar directamente en los requerimientos sin necesidad de información adicional. Todas las secciones deben ser claras, cuantitativas, exactas y orientadas a la implementación, evitando juicios de valor o narrativas sobre atributos de productos o servicios generados por IA.

# Entregable 1 - 26 de octubre último commit - 5%

## Métricas de los requerimientos no funcionales

Documentar cada atributo no funcional con valores cuantitativos, parámetros técnicos y tecnologías a usar. Incluir ejemplos claros, abajo se documentan ejemplos de valores y tecnologías, pero ustedes deben diseñar y encontrar sus propios valores los cuales deben estar justificados por alguna teoría o práctica debidamente argumentada y analizada; realizando las extrapolaciones o cálculos que usted pueda diseñar bajo un algoritmo o método cuantitativo diseñado por el grupo mismo. 

### Performance

* Tiempo máximo permitido para una consulta estándar: 1.5 segundos.
* Tiempo máximo para resultados cacheados: 200 ms usando Redis.
* Tecnología: PostgreSQL, Redis; aquí pueden ser métricas por las técnologías clave por separado. 

### Scalability

* Debe soportar incremento de carga de hasta 10x sin degradación.
* Kubernetes configurado con autoescalado horizontal por CPU y memoria. Justificarlo con la configuracion de K8s.

### Reliability

* Tasa de errores máxima permitida: 0.1% de transacciones por día.
* Monitoreo con pg_stat_statements y logs centralizados.
* Es importante determinar como se monitorea y como se notifican alertas. 

### Availability

* Disponibilidad mínima: 99.9% mensual. En el diseño de infraestructura debe lograr verse como se logra esto, podría ir en el diagrama de arquitectura, pero sería mejor uno de infraestructura. 
* Redis y bases de datos con failover y replicación.
* Considere load balancers. 

### Security

* Autenticación: OAuth 2.0 y/o OpenID Connect.
* Cifrado TLS 1.3 en comunicación y AES-256 en reposo.

### Maintainability

* Código modular siguiendo DDD y separación de dominios.
* Documentación en readme.md y comentarios claros en código.

### Interoperability

* Integración de APIs REST y MCP servers entre subempresas y servicios externos.

### Compliance

* Cumplimiento de GDPR en gestión de datos sensibles.

### Extensibility

* Arquitectura modular, permite agregar nuevas subempresas o módulos sin alterar sistemas existentes.

## Domain driven design

Para esto proceda en esta sección a: 

* Identificar todos los dominios principales por subempresa y dominios globales.
* Definir contratos entre dominios mediante interfaces o APIs.
* Crear facades para simplificar la interacción entre subempresas y dominios.
* Diseñar pruebas unitarias y de integración por dominio.
* Diagrama de dominios que muestre dependencias, límites de contexto y flujos de datos.
* Asegurar independencia entre dominios internos y globales.
* Esta documentación debe estar debidamente vinculada y guiada por código en el repositorio. 

# Entregable 2 - 4 de noviembre último commit - 10%

## Diagrama de arquitectura

* Crear un diagrama general de todos los sistemas o subempresas, o diagramas individuales y luego un diagrama de alto nivel que integre todo.
* Documentar patrones de arquitectura usados, cómo y dónde se aplican.
* Definir si se usará REST o GraphQL, serverless o servidores dedicados, lenguajes de programación y microservicios.
* Justificar cómo conviven microservicios en caso de que se usen y domain driven design.
* Indicar uso de pub/sub o event driven design.
* Definir si se usará monolithic 
* Definir si se va usar algún API gateway.
* Incluir todos los layers de la arquitectura.
* Seleccionar cloud provider entre gRPC, AWS o Azure.
* Indicar el uso de Supabase y Vercel si fuese requerido y el como se va usar e integrar dentro de su arquitectura con el provedor de cloud. 
* Para el cloud provider seleccionado, detallar patrones, layers, configuración de componentes, ubicación de configuración en código y cómo se usan. Entre más servicios y componentes del cloud se use va a ser mejor, esto porque ahorra programación y reduce costos, además de ser componentes altamente escalables. 
* Dar guía de programación de todos los layers y validación de seguridad de métodos del backend.
* Incluir diagramas de clases de los puntos críticos, indicando patrones de diseño de objetos y cómo se aplican.
* El diagrama de arquitectura a nivel de layers y estructura debe hacer match con el diseño por dominios
* Numerar todas las tecnologías a usar y explicar integración en cada sistema.
* Indicar configuraciones especiales si aplica.
* Especificar versiones a usar y cómo se controlarán las versiones.
* Patrones arquitectónicos, layers de servicios o componentes de cloud y patrones de diseño orientados a objetos deben estar vinculados a código, el cual sirve de guía a los desarrolladores. 


# Entregable 3 final

* Incluir correcciones de entregables 1 y 2.
* No tiene fecha de último commit 
* Las revisiones se asignaran entre el 23 al 29 de noviembre
* Última fecha para consultas el 19 de noviembre 

## Diseño de base de datos

* Definir motores de base de datos para cada sistema, incluyendo elección de bases relacionales y al menos una que a su criterio puede ser no relacional.
* Diseñar al menos una base de datos relacional.
* Diseñar una base de datos no relacional con ejemplos ya sea en JSON o schemas en código.
* Implementar y probar un ejemplo de repository layer usando stored procedures, incluyendo operación de escritura y otra de lectura.
* Implementar y probar un ejemplo de repository layer usando ORM, incluyendo operación de escritura y otra de lectura.
* Agregar las previstas de cache y connection pool correspondientes en los repositories implementados. 
* Seleccione la tecnología y haga un diseño de procesos o data pipeline que va a permitir traer información de las bases de datos de las subempresas, sumarizandola en la base de datos de PromptSales. Se sugiere hacer un diagrama para esto y que tenga las reglas de los pipelines, no olvide agregar criterios de delta para evitar traer información repetida. 

## Diseño de MCP servers

* Dado que la base de datos de PromptSales es usada para: 
  
  * Registrar toda la información que se procesa en el portal web centralizado.
  * Almacena información resumida de efectividad de campañas para consultas rápidas, información que viene de los otros sistemas
  * Guarda información general de integración de las AI

* Diseñe e implemente un MCP server que permita realizar consultas en lenguaje natural sobre el rendimiento de las compañas, las ventas logradas, el alcance, los canales usados, la geografía usada y cualquier otra información que la AI pueda obtener.  
* Documentar pautas de creación de MCP servers: ubicación de configuración, reglas, código de implementación, tools, resources y prompts.
* Diseñar MCP servers valiosos para todo el sistema y diagramar la interacción entre ellos. Solo se diseñan por diagrama, no se implementan todos, solo el solicitado arriba. 

## Deployment
* Indicar la tecnologia, archivos y scripts que se van a utilizar para hacer el deployment en cloud, así como también para el CI CD, debidamente vinculado a código. 
* Indicar y guiar como se va a dar mantenimiento y deploy de los migrations de bases de datos
* Crear github actions básicos que al hacer push al branch principal de deployment se ejecute alguna operación o regla básica, esto para entrenar levemente el uso de estos actions en los procesos de deployment. 


## Testability

* Documentar y guiar el cómo se harían los siguientes tipos de pruebas, y a la vez implementar, ejecutar y documentar resultados de pruebas ejemplo que deben quedar en el source code y debidamente configuradas para su ejecución.  Se sugiere fuertemente que investigue la batería de servicios de diseño, mantenimiento, ejecución, actualización de QA soportada por AI, esto para que su diseño de pruebas se haga con prácticas recientes y herramientas con capacidades de AI:

  * Unit testing de al menos una clase.
  * Test de REST API, de una operación de lectura y otra de escritura. 
  * Test de seguridad, validar permisos grant y rechazo de accesos a algún método del API. 
  * Test de stress, con cierta cantidad aceptable para una sola computadora ejecutando el test y otra computadora mínimo soportando la infraestructura. 
  * Test de MCP servers, los 2 MCP servers creados anteriormente deben ser probados y que los resultados obtenidos sean corroborados automáticaente.  
  * Linter de código, su configuración y uso dentro de la solución. 

# Otros aspectos

* Enviar correo al profesor con el link del repo para revisión para cada entregable
* Designar un project manager que cree y distribuya tareas mediante Trello, comparta el board con el profesor al correo vsurak@gmail.com 
* Cada integrante del grupo debe mantener los tiquetes actualizados al menos una vez por semana.
* Crear canal de Discord para reportar dos veces por semana el "daily status", incluyendo logros, planes y bloqueos. Todos los integrantes deberán reportar dicho status. Esta participación será evaluada. El grupo debe decidir el día y hora en que todos van hacer el update. 
* Deployment en Kubernetes con configuración lista para cumplir todos los requerimientos funcionales y no funcionales a escala. Se revisaran los archivos de configuracion de deployment tanto de producción como dev. El deployment de dev debe ser posible verificar que se hace correctamente. 
* Mantener bitácora centralizada de uso de AI con fecha, hora, nombre del estudiante, prompt, resultado y método de validación o corrección de la salida obtenida por la AI. 
