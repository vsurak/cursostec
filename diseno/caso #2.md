backend and data
syncronization of data
AI prompts
supabase
mongodb
redis
dynamodb
sql server
AI prompts


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
* La **integración con servicios externos** (plataformas de anuncios, CRM, herramientas de contenido, pagos y analítica) se debe realizar por medio de **APIs REST** o **servidores MCP**, dependiendo del tipo de servicio y del nivel de automatización requerido.
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

