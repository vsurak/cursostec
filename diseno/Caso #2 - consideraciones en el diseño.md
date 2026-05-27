# 1. Diseño de integración de sistemas

Para cada integración tener una ficha o card o spec que nos indique los requerimientos y condiciones de dicha intgración.

- Name: la plataforma a la que me integro
- Proveedor: nombre del proveedor
- Protocolo: TCP/IP, mcast, file sharing, FTP, websocket, pipeline de sistema operativo, driver en binario, REST api, GraphQL api, gRPC, etc 
- Security constraints: Api Key, session validated, MFA, login/password, credential, llave de encriptación, firma digital, security integrated with MS entra. 
- Donde se almacena o se configuran los parámetros de configuración, incluso si son parámetros seguros como api keys. 
- Throughput: cual es la capacidad del servicio al que me estoy integrando en tamaño y en tiempo. Uno de los puntos de quiebre más importantes, y con ello la estrategia de diseño para acomodarnos a ese throughput.  Tamaños de transferencia, tamaño de storage, duración de sesiones, tiempos de espera. 
- Anchos de banda, capacidad de procesamiento del sistema al que hay que conectar.
- Workload, por ejemplo si me conecto a una base de datos en producción. Escenario, tengo que conectar al SQL server que están usando en producción, y me mencionan que ese servidor pasa a un 70 a 85% de capacidad entre las 10am y las 5pm de Lunes a Viernes, y no quieren verse impactados cuando mi sistema intente extraer datos de ahi.
    - Estrategia:  extraer la información por batch entre las 8 y 9am y luego otra extracción entre las 10pm y 11pm. Job Scheduler, deployment del Job, diseñar deltas de las tablas fuentes, esto para no traerme información que ya me había traído. 


Ejemplo A: 

Sistema destino al que me voy a integrar
- Stripe, 1000 transacciones por segundo desde la misma fuenta y 1 cada 20 minutos si es el mismo card holder. 

Mi sistema:
- soy Temu y necesito pasar 8000 transacciones por segundo, al punto final del shoping cart puedo seleccionar una donación y un cupón para canjear x y z, y esto sucede entre 5 segundos a 5 minutos después de la primer compra. 

- Encolar las transacciones de pago y procesarlas en cola en batches de 1000 cuando se habla con stripe. 
-  Tendría la trnasaccion en pending hasta conocer si el usuario va a adquirir el cupon y la donación, para realizar una única transaccion diferida para cumplir el requerimiento

Ejemplo B:
Tengo que conectar con Claude Agent y los tiempos de respuesta son de 10 a 50 segundos. 

Mitigración: hacer el proceso asíncrono (object design pattern), tengo que integrar un servicio de notificaciones. DataDog, SendGrid, Push Notifications?

- Patrones de diseño a orientación a objetos que se requieran para interactuar. Proxy, Facade, Adapters, Async/Wait, DTOs, hay que especificar bien las clases y apuntarlas (pointer al codigo), colas. 

- Link to class, si ya existen classes que van hacer la interconexion entonces poner el link al /src/x/y/z


# 2. Diseño de patrones arquitectónicos
https://learn.microsoft.com/en-us/azure/architecture/patterns/


# 3. Agentic design patterns

https://machinelearningmastery.com/7-must-know-agentic-ai-design-patterns/


## Ejercicio de clase. 

En los grupos de caso #2, van a seleccionar un patrón arquitectónico y uno de agentic design asumiento uso de AI en su solución. Sugerir una caso de uso para cada patrón seleccionado dentro de su proyecto. Documentar el diseño de ambos patrones tomando en cuenta:

- Nombre del workflow
- Reto a resolver, dejando claro los problemas que la programación tradicional sin patrón podría traer
- Solución: el patrón a utilizar
- En la solución debe asegurarse de mostrar:
    - diseño de clases o de componentes que implementan el patrón (diagrama)
    - ubicación de dichas clases o componentes en el /src
    - restricciones y guías que deben seguir los desarrolladores
    - cómo hacer manejo de excepciones
    - en el caso de clases deben ser claro cuales cuales implementa cuáles métodos del patrón, así también como herencias
    - en el caso de ser componentes, debe ser claro la responsabilidad de cada componente , cuáles son sus inputs y cuáles son sus outputs. 

Al terminar a las 11:15am, pegar el nombre del grupo, los integrantes, y la documentación markdown de ambos patrones seleccionados. 

