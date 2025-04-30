## Week 9
# Week #9 

- llenar el siguiente template ejemplo para el caso 2 : 

Each decision must include:  
1. **Cloud service technology**  
2. **Object-oriented design patterns**  
3. **Class layers for data access**  
4. **Configuration policies/rules**  
5. **Expected benefits**  


a) la topología de los datos, si se trata de OLTP, maestro/esclavo, base de datos distribuida, base de datos replicada, geo distribuidas 

- lo que hay que documentar es los tipos y cantidad de bases de datos, por ejemplo:
"app asssistant consiste de una única base de datos en postgresql, hosted en RDS, el acceso deberá estar restringido por una VPC y un whitelist que permita conectar únicamente a los servicios desde AWS." 

- benefits: dado la técnica o tecnología seleccionada, cuáles son los beneficiones, ejemplo: 

- es open source, reduce costos de licencias
- support by AWS RDS
- benchmark de 10GB por minuto en X
- mongodb no emite errores ante información mal formada que no requiere almacenarse el 100% 


b) si se trata de un repositorio de big data como hive, fabric, bigtable, snowflake, hadoop, data lakes, data marts o cualquier integración para este tipo de procesamiento de gran escala 

- lo que se busca incluir en el diseño, es si la información de este sistema debe alimentar repositorios de datos de gran tamaño que se van a usar posteriormente para Ciencia de Datos o ML. 

Ejemplo: 

- no, no se estima para los siguientes años el uso de la data para ML o ciencia de datos.  

o 

- si, se va a requerir en el futuro un proceso de carga por lotes mensualmente a las 2am, a un datalake en snowflake para realizar análisis de comportamiento de los consumidores del app. 

- El servicio de snowflake va a usar de cloud provider a AWS
- Carga por lotes de los "deltas" mensualmente a partir de las 2am

delta = TotalRegistros - TotalRegistrosPasados; (un delta es la data que no se ha procesado aún)

Beneficios: 
- adopción temprana de ciencia de datos
- arquitectura del sistema nace alimentando un data repository para ciencia de datos 
- snowflake se puede utilizar en 3 diferentes cloud providers 
- snowflake se utiliza via SQL
- PowerBi y tableu que son las plataformas que se van a usar para análisis de datos se conectan de forma agnóstica a snowflake 


c) si usar un motor de base de datos relacional o documental tipo nonSQL 

Es la decisión del motor, casi que se tomó está decisión en el punto a) , podemos enfatizar.

- se hostead con RDS

Benefits: 

- el sistema es naturalmente transaccional por lo que debe mantener consistencia de datos
- transacciones "todo o nada" 

d) el tenancy y permiso de acceso de los datos, la privacidad, protección y seguridad de los datos como último punto de defensa de los sistemas 

Un ejercicio que podemos hacer para contestar esto, es imaginarnos que un atacante ya logró tener acceso a los datos, o simplemente aceptar esa posiblidad. Otras posibilidades que podrían aceptar es que hayan errores de programación que podrían exponer información que no le pertenece a un tenant, entonces la pregunta es, qué medidas tomo para evitar esto: 


Esta parte va o va, tenemos que identificar que requiere protección por cifrado y por hash: 

- hubo acceso a la base de datos: checksums, cifrado, hashes. Qué es lo que va ir cifrado en la base de datos. 


Ejemplo: 

- información a cifrar: 
    - información de contacto de las empresas 
    - la información de configuración de pagos para las membresías 
    - los emails de los usuarios 
    - sigo listando la información que debe ir cifrada 
    - todo password o pin hashed 
    - checksums en tablas de transacciones, pagos, logs, beneficios, etc 

Si, más de una compañía utiilzar mis servicios para operaciones propias, paso a ser un sistema multitenant y por ende debo garantizar que no se vean datos entre compañías (entre tenants): 

- riesgos de fallos por tenancy: en algunos casos se hace el tenancy por copia, en otros casos se hace el tenancy por copia de schema de la base de datos. Lo que se busca es que la información que le pertene a un tenant nunca esté física mezclada con la información de otro tenant; o sea que hice una transformación de mi sistema que es multitenant a ser de tenant único a nivel físico de los datos. 


- esto es típico reto de cualquier servicio SaaS 

- es mi sistema tenant o multitenant? app asistant es multitenant, porque hay varias empresas dentro del mismo sistema, hay riesgo de cross info. En el caso de payment assistant tengo un problema de multitenant en el caso de que empresas usen al sistema para el manejo automatizado de sus pagos. 

- una forma que siempre tiene riesgos para garantizar que un modelo multitenant no entregue información privada a otros tenant, es haciendo uuna capa de singletenant por software. Todos los servicios deben acceder solo por esta capa: 

Ejemplo: 
Strategy pattern y un builder para garantizar que todas las classes del layer de data access solo accedan a la DB por medio del layer de tenancymanager. 

Se restringe a todos los services a conectar con un single proxy y ese single proxy es el único autorizado a conectar con la DB (whitelist). 

beneficios : 

en el caso que me fui por copia:

- es imposible el cross data entre tenants 
- el rendimiento de un tenant no afecta el otro 
- escalabilidad individualizada 

en el caso de tenant manager layer: 
- reducción de costos de mantenimiento
- aprovechamiento de los recursos computacionales entre todos los tenant


e) el modelo y políticas para recuperación y tolerancia a fallas 


de diseno orientado a objetos - programación 

a) transaccional vía statements o stored procedures 

- el manejo de transacciones en la base de datos se hace a nivel de SP en el motor, o se hace a nivel de código, tomar en cuenta los retos de errores, drivers, procesos y demás a los que se está expuesto cuando se trabaja a nivel de código. 

b) uso de ORM 

si o no, si es si, cual ORM?

c) uso de pool de conexiones 
si o no, si si, static o dinamic, cualquiera de los tamaño inicial, tasa de crecimiento, libreria de pool a usar. 

d) uso de cache 

si o no, 

si, cuál, qué tecnología, qué cosas van a cache. cuál va a ser la llave de esos items en cache, flushing criteria. 

e) drivers nativos e interpretados 

nativos: ado.net, jdbc, python binaries 
interpretados: todo lo demás. ODBC, Pipe.. 

f) el diseño de los datos 

que cosas quiero que los desarrolladores tengan claro como se va a diseñar, y ahi agrego ejemplos de esos diseños de las tablas. Solo de las partes clave. NO todo el diseño de la base de datos.  

en el caso que haya tambien base de datos no relacional, el ejemplo de diseño puede ser con json ejemplos. 


# Week 10

- revisión del Ejercicio #5 

- Leer y analizar del libro "the-software-architect-elevator.epub", los capítulos capítulos 1,2,8,14,16,18,19. Evaluación en clase el miércoles 30 de abril. 


**Ejercicio #6**




- De la unidad 8, ver el tema de diseño orientado hacia AI, Agents y LLMs, realizar el siguiente ejercicio.


**Ejercicio #7 – Diseño de Base de Datos Semántica para Transporte Público en San José, Costa Rica**

**Contexto:**
El transporte público en la ciudad de San José es esencial para la movilidad de miles de personas cada día. Como ingeniero/a en computación, tu rol es modelar un aspecto clave del sistema utilizando técnicas modernas de diseño que consideren el posible uso de modelos de lenguaje (LLMs) o agentes inteligentes en el futuro.

**Objetivo:**
Selecciona uno de los siguientes aspectos del sistema de buses en San José y diseña un modelo de base de datos relacional que incorpore técnicas avanzadas de diseño:

- Rutas de buses
- Pasajeros y perfiles de viaje
- Zonas geográficas cubiertas
- Costos operativos o de mantenimiento
- Medios de pago utilizados en los buses

**El diseño debe aplicar las siguientes tres prácticas:**

1. **Incorporación de semántica**: Usa descripciones, categorías o relaciones tipo “es un”, “pertenece a”, “tiene” que ayuden a representar mejor el significado de los datos. 

2. **Audit Logs o Trazabilidad**: Incluye alguna forma de registro histórico o bitácora de eventos (por ejemplo, cambios en rutas, pagos realizados, mantenimiento hecho). 

3. **Datos naturales o representaciones textuales**: Agrega campos con descripciones en lenguaje natural, notas explicativas, o representaciones útiles para un agente o asistente virtual. 


Proceda entonces ha: 

1. Escoge uno de los temas propuestos. 

2. Diseña tu modelo de base de datos relacional usando alguna herramienta o dibujo a mano alzada para posterior tomar una foto. 

3. Enviarlo al asistente por discord indicando que es el ejercicio #7, incluyendo nombre completo y descripción de máximo 4 líneas de lo que se incorporó para cumplir con las 3 prácticas de diseño sugeridas. El ejercicio es individual. 
