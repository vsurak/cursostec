# Etheria Global & Dynamic Brands Group

**Caso #2 - Bases de datos I - 20%** 

**Prof. Rodrigo Núñez** 

Ustedes han sido contratados por un holding comercial que opera bajo un modelo de negocio híbrido de importación y ventas digitales de alta gama. El grupo se divide en dos entidades operativas con naturalezas tecnológicas distintas.

---

# **Etheria Global: Sourcing & Logistics (PostgreSQL)**
Esta empresa se encarga de la cadena de suministro. Importan productos naturales y curativos exóticos de todo el mundo (bebidas, alimentos, cosmética dermatológica, capilar, aromaterapia, jabones y aceites esenciales).
* Todos los productos son de gama alta y poseen propiedades medicinales/saludables.
* Se importan en "bulk" (cajas sin marca ni etiquetado) en dólares (USD).
* Todo llega a un centro logístico en la costa Caribe de Nicaragua.

# **Dynamic Brands: AI-Driven Digital Retail (MySQL)**
Esta es una empresa de base tecnológica. Han desarrollado una IA capaz de generar sitios de e-commerce dinámicos. 
* A partir de parámetros (logo, enfoque, país), la IA despliega tiendas virtuales con marcas blancas. 
* Pueden abrir y cerrar "N" sitios en diferentes países de Latam con un solo clic, cada uno con un enfoque de marketing y mensajes distintos para el mismo producto base.

# El Flujo de Operación (El Reto Logístico)

1.  La demanda nace en los sitios de Dynamic Brands, está demanda instruye a Etheria Global cuánto debe importar de cada producto de cada país. 
2.  Dynamic Brands recibe la orden, extrae el producto del HUB en Nicaragua y lo etiqueta con la marca específica solicitada por el sitio web y país destino.
3.  Se prepara el empaque con los requisitos legales y permisos de salud del país destino.
4.  Un Courier Service externo (tercero) retira el producto y lo entrega al cliente final una vez que llega al país destino. 
5.  La venta final se realiza en la moneda local del país donde reside el comprador.

# La Problemática Gerencial
Actualmente, las bases de datos están aisladas. La alta gerencia es incapaz de responder preguntas críticas como:
* ¿Cuál es la rentabilidad real de una categoría (ej. Aceites) si el costo es en USD y la venta en Pesos Colombianos o Soles Peruanos?
* ¿Qué marca generada por IA es más efectiva comparada con los costos de importación?
* ¿Cuál es el margen por país considerando los gastos de envío y permisos?

# Requerimientos a trabajar del caso

Ustedes como proveedor deberán entregar un sistema integrado y contenedorizado que incluya:

* Archivos Markdown con los esquemas de tablas, tipos de datos, restricciones necesarios para el diseño de la solución.
* Script sql de PostgreSQL y MySQL de ambas bases de datos.
* Diagramas de ambas bases de datos (PostgreSQL y MySQL) en formato PDF.
* Para el llenado de datos de ambas bases de datos:
    * El llenado de datos siempre será por medio de Stored Procedures Transaccionales. Haga otro archivo de script para dichos procedures y orquestación de las llamadasa los stored procedures durante el proceso de llenado. Deben cargar al menos 5 países, 100 productos distribuidos entre los 5 países y 9 sitios web dinámicos. (todo esto es data, no implementación).
    * Los SP deben contar con manejo de excepciones
    * Implemente un SP independiente que registre cada paso ejecutado en las tablas de destino, este SP es llamado por los otros SP de inserción de datos
* Una solución técnica que permita cruzar los datos de ambas fuentes. Un dashboard gerencial que muestre indicadores de rentabilidad, efectividad de sitios y comparación de precios compra vs. venta. Valide con el profesor la forma en que pretende solucionar este reto. 
* Demuestre que la forma que diseñó para la información que requiere el dashboard, cumple que los datos unificados, son suficientes para obtener lo que actualmente la gerencia no puede analizar (mencionadas antes) y que permita ver otras aristas de la información.
* Imagine por ejemplo si el usuario podrá hacer consultas en lenguaje natural, su estrategia lograría a llegar a funcionar bajo esa modalidad?
* Todo el proyecto debe estar **contenedorizado (Docker)** para que pueda ser ejecutado con un solo comando.
* El trabajo se puede realizar en parejas. Deben tener un repositorio github unificado donde realicen el trabajo, cualquier duda será por medio del github.
* El profesor verificará en la revisión el aporte de ambos integrantes en el github.
* La pareja de trabajo tendrá derecho a dos revisiones completas de los modelos de la siguiente forma:  a) una en formato markdown, listo para ser enviado a las AI.  b) una en formato pdf ya como diseño visual ERD. 
* Fecha límite para canjear esas revisiones **jueves 9 de abril.**


# Temas recomendados para investigar

- Entiendan cómo afectan los costos de importación y en qué punto la responsabilidad pasa de un actor a otro.
- Cómo funciona un centro de distribución en una zona costera (Nicaragua) que recibe granel y despacha pedidos individuales etiquetados.
- Crucial para productos de salud y belleza. ¿Cómo rastrear un aceite desde el proveedor hasta el cliente final si el empaque cambia en el camino?
- El reto técnico principal es el "matrimonio" entre PostgreSQL y MySQL. Investiguen estrategias de ETL (Extract, Transform, Load),  métodos para extraer datos de dos motores distintos y unificarlos en una sola vista, cómo hacer dashboards de datos con múltiples fuentes de datos. 
- Comparen las ventajas de consultar una base desde otra versus crear un repositorio centralizado para la gerencia.
- Cómo manejar tablas que almacenan costos en USD y ventas en 10 monedas locales distintas de Latam, considerando la fluctuación del tipo de cambio.
- Investigar el concepto de Marca Blanca - white lableling
- Cómo una sola plataforma puede gestionar cientos de "marcas" o "sitios" de forma aislada pero centralizada.
- La lógica detrás de abrir y cerrar tiendas por temporada o por país con un solo clic.
- Cómo almacenar características de productos (aromas, ingredientes, beneficios) que cambian según el "enfoque de marca" que la IA decida aplicar.
- Propiedades ACID, especialmente la "Atomicidad" y "Aislamiento" en procesos de inventario.
- Patrones de Logging de Base de Datos, mejores prácticas para diseñar tablas de log que permitan reconstruir qué pasó en un SP si una transacción de importación falla a mitad de camino.
- Manejo de Excepciones (Try/Catch en SQL), diferencias de implementación entre los dialectos de Postgres y MySQL.
- Cómo afecta el tiempo de envío y la base de datos el hecho de que cada país pida requisitos distintos para productos "para la piel" o "ingesta".
- El impacto de los impuestos de importación (aranceles) versus los impuestos de venta al consumidor final.