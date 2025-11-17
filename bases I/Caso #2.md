# Caso #2: PromptSales –  42%
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
* La **integración con servicios externos o internos** (plataformas de anuncios, CRM, herramientas de contenido, pagos y analítica) se debe realizar por medio de **APIs REST** o **servidores MCP**, dependiendo del tipo de servicio y del nivel de automatización requerido.
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

1. Diseñar las bases de datos de cada subempresa y la centralizada:

   * Crear la base de datos en Redis siguiendo la lógica de cacheo y almacenamiento temporal de resultados.
   * Crear la base de datos de PromptContent en MongoDB, pensando en colecciones para imágenes, descripciones, hashtags y logs de campañas.
   * Crear la base de datos de PromptAds en SQL Server, con tablas para campañas, canales, mercados, anuncios y resultados históricos.
   * Crear la base de datos de PromptCrm en SQL Server, con tablas para clientes, leads, interacciones y montos de venta.
   * Crear la base de datos centralizada de PromptSales en PostgreSQL, que consolide la información resumida de todas las subempresas, con métricas de desempeño y estado de campañas.

2. Crear scripts de llenado de datos para cada base (excepto Redis) con información suficiente y consistente para las actividades siguientes:

PromptContent

* Cargar al menos 100 imágenes de forma algorítmica, con descripciones amplias, coherentes y hashtags clasificadores.
* Indexar las descripciones usando una base de datos vectorial como Pinecone, Faiss o pgvector.
* Incluir datos necesarios para conectar al menos a una API externa que requiera autenticación por un método POST y que sea un api real.
* Configurar y probar un MCP server con dos tools:

  * getContent: recibe una descripción textual y retorna imágenes que coinciden y sus hashtags.
  * un segundo tool que reciba una descripción de campaña y público meta, almacene la solicitud y genere una bitácora de tres mensajes por población objetivo en función del mensaje recibido.

PromptAds

* Crear un stored procedure transaccional usando la plantilla "XXXXXSP_VerboEntidad" para crear una nueva campaña, utilice TVPs (Table-Valued Parameters) los cuales van a brindar ventajas al SP.
* Llenar de forma algorítmica un registro histórico de al menos 1000 campañas, teniendo un 30% activas y un 70% ya culminadas, todas entre el periodo Julio 2024 a Enero 2026, con picos pronunciados en diciembre, enero y otro mes de su elección. 
* Cada campaña debe incluir N canales de venta, N mercados y N anuncios, todos con resultados reales como likes, views, interacciones, ventas, horas de exposición, cantidad de público alcanzado, costo y revenue.
* Escriba queries que le permitan explicar el uso en SQL de EXCEPT, INTERSECT, MERGE, LTRIM, LOWERCASE, FLOOR, CEIL, UPDATE DE SELECT.
* Escriba un query que permita extraer dado un rango de fechas, aquellos Ads para una misma marca que hayan causado un sentimiento negativo en redes sociales y que hayan causado una baja comparada de reacción entre influencers. Debe ser posible identificar bien el canal, el tipo de sentimiento negativo y el % de baja que tuvo el canal o influencer. 
* Demostrar cómo monitorear el rendimiento de las consultas ejecutadas en esta base de datos.

PromptCrm

* Llenar la base con al menos 500,000 clientes generados algorítmicamente.
* Asociar cada cliente a campañas, variando entre 400 y 1000 clientes por campaña.
* Asegurar que los montos de ventas y el alcance coincidan con la información de PromptAds.
* Configurar un link server entre PromptCrm y PromptAds para consultas cruzadas.
* Cifrar información sensible como cédulas y datos de contexto usando un certificado X.509 en master, demostrando que se cifra y descifra correctamente.
* Mostrar que al hacer backup y restore en otro servidor, los datos cifrados no pueden ser descifrados.
* Usar CTE, Partition y Rank para generar consultas agrupadas por mes, año, distancia geográfica, canales de venta y mercados, detectando correlaciones entre comportamiento de campaña y compra.
* Crear al menos dos vistas para simplificar la consulta anterior y materializarlas con índices.
* Comparar con show estimated execution plan la consulta sin optimización y luego con vistas e índices para demostrar la mejora en rendimiento, considere en la vista mejorar la consulta estratégicamente. 
* Crear un stored procedure para registrar logs en la base de datos y pruebelo. 
* Desarrollar un conjunto de SP transaccionales que simulen:

  * Deadlock en cascada de tres transacciones.
  * Situaciones de incorrect summary problem, dirty read y lost update, y como esos mismos procedures o scripts, pueden arreglarse a nivel de código y que realicen la misma operación, pero previniendo que sucedan dichos problemas demostrados.
  * Simular un deadlock entre dos clientes en computadoras distintas.

PromptSales

* La misión de esta base de datos es registrar toda la información generada desde el portal web centralizado.
* Almacenar información sumarizada de la efectividad de campañas desde su creación hasta cierre.
* Crear un ETL que se ejecute cada 11 minutos para actualizar solo los valores sumarizados desde las otras bases de datos, considerando solo los delta de datos modificados.
* Usar cualquier herramienta de diseño visual de pipelines, no pandas o programadas, para desarrollar el ETL.
* Configurar un MCP server que permita consultas mediante lenguaje natural sobre el rendimiento de campañas, de forma que se pueda saber el alcance, porcentaje de éxito, ventas alcanzadas, cantidad de reacciones, canales en los que aplicó la campaña y otra información que la AI pueda determinar. 
* Crear scripts en PostgreSQL que demuestren y les sirva de apoyo para explicar: triggers, cursores, interbloqueos, extracción de metadata de tablas del sistema, monitoreo de consultas, coalesce, case, left join, right join, cross join, y control de permisos mediante grant y revoke para lectura y escritura.

Otros aspectos

* Todo el deployment se realizará con Kubernetes, pudiendo optar por montar el ambiente completo en cada computadora o usar una red distribuida con VPN. El deployment debe funcionar correctamente y de forma automática. 
* Cada base de datos y proceso se debe ejecutar en un pod separado, con configuración que cumpla los requerimientos funcionales y no funcionales a escala. 
* No se desarrollará el portal web, solo las bases de datos y las integraciones con MCP server. Se puede usar un MCP client existente si se requiere programar únicamente los servers.
* Se puede usar N8N si es necesario para flujos de integración, MCP servers y otros. 
* Mantener una bitácora de uso de AI en una tabla que incluya fecha y hora, nombre del estudiante, prompt, resultado del prompt, y método usado para validar o corregir el resultado, incluyendo optimizaciones y evitación de código hardcoded.
* Se revisará el uso correcto de github y la participación de todos los integrates en los commits
* Cada grupo deberá crear un text channel en discord con un nombre de grupo, y al menos dos veces por semana cada estudiante deberá dar un status report de lo que ha avanzado a ese momento, esto se evaluará. 
* Última fecha para revisiones preliminares de diseños de modelos de datos: martes 28 de octubre
* No habrá fecha para último commit pero las citas de revisión serán entre el 16 y el 22 de noviembre, 2025

---

Entregables de seguimiento

## Entregable #1 - preventive - no evaluado

1. Hacer el diseño de las 4 bases de datos, entregar por discord y recibir retroalimentación del profesor.

---

## Entregable #2 - tackle the unknown - 7% 

Este entregable se busca hacer pruebas de concepto, podría ser que el diseño no esté 100% corregido, que la carga de datos no sea completa y que falten varias otras cosas, pero se quiere enfocar en resolver aquello que es desconocido. Es decir, este entregable son más tipo pruebas de concepto para que logren dominar técnicas y tecnologías, en la revisión final se revisará todo completo. 

PromptContent
* Configurar y probar un MCP server con dos tools:
  * getContent: recibe una descripción textual y retorna imágenes que coinciden y sus hashtags.
  * un segundo tool que reciba una descripción de campaña y público meta, almacene la solicitud y genere una bitácora de tres mensajes por población objetivo en función del mensaje recibido. 

Para hacer esto va ser necesario darle a la AI un contexto que salga de este otro ejercicio: 
* Indexar las descripciones usando una base de datos vectorial como Pinecone, Faiss o pgvector.

PromptCrm
* Configurar un link server entre PromptCrm y PromptAds para consultas cruzadas.
* Cifrar información sensible como cédulas y datos de contexto usando un certificado X.509 en master, demostrando que se cifra y descifra correctamente.
* Mostrar que al hacer backup y restore en otro servidor, los datos cifrados no pueden ser descifrados.
* Comparar con show estimated execution plan la consulta sin optimización y luego con vistas e índices para demostrar la mejora en rendimiento, considere en la vista mejorar la consulta estratégicamente. 
* Desarrollar un conjunto de SP transaccionales que simulen:

  * Deadlock en cascada de tres transacciones.
  * Situaciones de incorrect summary problem, dirty read y lost update, y como esos mismos procedures o scripts, pueden arreglarse a nivel de código y que realicen la misma operación, pero previniendo que sucedan dichos problemas demostrados. 

Puede escoger solo uno de los problemas de niveles de isolación, pero no olvide que debe completarlos todos para el entregable final. 

PromptSales
* Crear un ETL que se ejecute cada 11 minutos para actualizar solo los valores sumarizados desde las otras bases de datos, considerando solo los delta de datos modificados.
* Usar cualquier herramienta de diseño visual de pipelines, no pandas o programadas, para desarrollar el ETL.

Ensayo
Crear y probar el deployment vía KS: 

* Todo el deployment se realizará con Kubernetes, pudiendo optar por montar el ambiente completo en cada computadora o usar una red distribuida con VPN. El deployment debe funcionar correctamente y de forma automática. 

Puede que no esté completo el deployment pero logra levantar un ambiente de varios servers funcionando. 

- Último día para consultas para este entregable jueves 6 de noviembre. 
- Se revisará con cita con el profesor entre el 9 y 12 de noviembre, 2025

---

## Entregable final - finalización de todas las taresa - 35%
- Para entre entregable se esperan las correciones del entregable #1 y #2
- Se evaluaran todas las actividades solicitadas del caso 
- La revisión será con cita y se tomaran en cuenta solo las personas presentes el día y hora de la revisión
- Última fecha de consultas viernes 21 de noviembre
- No hay fecha para el último commit
- Las revisiones se calendarizaran entre el 1ro y el 6 de noviembre
