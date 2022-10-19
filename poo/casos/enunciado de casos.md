# caso #1, 7%

*instituto tecnológico de costa rica*, escuela de computación  
*programación orientada a objetos*  
_prof. rodrigo núñez_  
*tipo:* grupal  

## descripción
El yate silent 60 es un navío de tipo catamaran que funciona con energía solar, representa un ícono del futuro de la navegación con cero emisiones. posee sistemas de paneles solares, sensores, optimización para el uso de energía, baterías de litio entre muchos otros avances tecnológicos. 

En general el silent 60 es todo un sistema integrado donde muchas partes interactúan y se relacionan entre sí con el fín de proveer:

- energía a toda la nave
- propulsión
- comunicación
- sistema de aguas y baños
- refrigeración para alimentos y aire acondicionado
- televisión
- entretenimientos
- iluminación
- sistemas de navegación

### parte 1
ahora se presenta el reto de hacer un diseño del funcionamiento de este yate en forma digital. para ello se van a conformar subgrupos que van a diseñar una parte de la funcionalidad de los sistemas del yate, para posteriormente crear todo el diseño completo. dicho diseño inicial es conceptual, es decir, son cajas con los nombres de los objetos, los atributos y las acciones del mismo cuando así sea necesario. para realizar dicho modelo se recomienda usar miro para montar dicho diseño en forma colaborativa. https://miro.com/

links relacionados 
- https://www.youtube.com/watch?v=P9ftIasJSfc
- https://www.youtube.com/watch?v=NQS__N4eXGc
- https://www.youtube.com/watch?v=kLHEuz3rsmk
- https://www.silent-yachts.com/silent60/

*grupos y asignación*

sistemas de refrigeración  
---------------------------------------------  
ALFARO CHAVERRI FEDERICO ALBERTO  
ALFARO GARCIA ISAAC GERMAN  
CUBILLO JARQUIN HELBERTH FABRICIO  
SEQUEIRA VARGAS ANTHONY STEVE  

entretenimiento, luces y cocina  
---------------------------------------------  
BARQUERO DIAZ JOSE PABLO  
CALVO HERNANDEZ SEBASTIAN  
ACUÑA CAMPOS CRISTOPHER ANTONIO  
UGALDE RIVAS YEINER ALONSO  

energía solar y baterías  
---------------------------------------------  
ALVARADO ANDRADE DANIELA  
CAMPOS ARGUEDAS OSCAR ANDRES  
AGUERO MATA MIGUEL EDUARDO  
KAUFFMANN PORCAR ERICK  

propulsión y motores  
---------------------------------------------  
BARQUERO BARRANTES BRYAN DANIEL  
MENDOZA MATA FIORELLA LUCIA  
FERNANDEZ SALAS JOSE DAVID  
UGALDE JIMENEZ DAVID FRANCISCO  

tratamiento de aguas  
---------------------------------------------  
MALLMA ZAMORA JUAN ERNESTO  
MONTERO ZUÑIGA AMANDA JESUS  
BRENES GARRO JOSE JULIAN  
RODRIGUEZ BRENES SEBASTIAN  
RODRIGUEZ CRUZ JORGE LUIS  

comunicaciones y navegación  
---------------------------------------------  
QUESADA CHAVES SARAH PRISCILLA  
ROBLES MATA JOSE ANDRES  
MADRIGAL CHINCHILLA JULIAN ANDRES  
VALVERDE ARGUEDAS SAMUEL  
XIE LI DAYANA  

### parte #2

una vez que tenga el diseño preliminar hecho proceda a leer las particularidades del lenguage java con respecto a tipos de datos y los arreglos en estos links https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html , https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html 

ahora usando una copia del diseño preliminar agregue a los atributos el tipo de dato respectivo a su diseño para que así empiece a parecerse a un diseño de objetos para un lenguaje determinado, en este caso java.

- fecha de revisión de las asignaciones: 10 y 12 de agosto
- fecha de entrega: jueves 18 de agosto antes de medio día
- entrega al asistente al correo: kevinqj.2002@gmail.com
- subject: poo - caso #1
- contenido: lista de los integrantes del grupo, un pdf con el diseño preliminar y otro pdf con el diseño con los atributos ajustados a los tipos de datos en java, un entregable por grupo.



# caso #2, 5%

*instituto tecnológico de costa rica*, escuela de computación  
*programación orientada a objetos*  
_prof. rodrigo núñez_  
*tipo:* individual  

## descripción
retomando el tema del yatch silent 60, el yate de energía solar, se quiere hacer una demostración de la eficiencia del consumo y carga energética del yate. para ello es necesario parametrizar valores de configuración como capacidad de carga de las baterías, velocidad de carga desde los paneles dependiendo de los niveles de sol a los que estén expuestos los páneles, velocidad en nudos del navío y el consumo de energía según la velocidad. 

cómo sería el diseño y la implementación de classes en java para el programa de demo que usted haría si debe cumplir lo siguiente: 

1. Los parámetros de carga energética y su consumo son configurables, se sabe que hay dos baterías y tres páneles pero dicha configuración se puede cambiar también, todo esto antes de correr el programa

2. La simulación debe durar entre 1.00 a 1.5 minutos máximo

3. Durante el periodo de simulación los paneles deberán estar expuestos a diferentes niveles de sol para que sea posible apreciar la velocidad de carga de las baterías

4. Durante el periodo de simulación el navío estará entre detenido hasta probar múltiples velocidades para poder corrobar el consumo energético de las baterías según la velocidad

5. El usuario podrá ver en la pantalla en todo momento el tiempo transcurrido de simulación, el nivel de energia de todas las baterías, el nivel de luz solar sobre los páneles y la velocidad del navío

6. Demuestre finalmente que es posible agregar varios otros elementos del yate que consuman energía dentro de la simulación y que esto no afecte el código realizado entre el punto #1 al #5, es decir, que puedo agregar y quitar componentes del Yate a antojo de quien configura la simulación, no importa si esto se hace desde el main, una classe con constantes o un archivo de configuración separado.  

Preliminares: 
Cómo crear un UI para el simulador en Java. Investigue y cree código ejemplo para crear una pantalla que pueda funcionar para visualizar dicho simulador en java. Deberá para ello seguir el patrón de diseño MVC. 

Miércoles 24 de agosto, 1 ejemplo entre los dos 

- ALFARO GARCIA ISAAC GERMAN 
- BARQUERO BARRANTES BRYAN DANIEL 

Cómo funcionan los hilos y el sleep en java. Investigue y cree código ejemplo para explicar el funcionamiento de los hilos de ejecución en java esto con el fin de que dicha tecnología nos permita construir el simulador que que requiere para el demo del consumo del yate.  

Miércoles 24 de agosto, ejemplos hechos entre los dos 

- QUESADA CHAVES SARAH PRISCILLA 
- SEQUEIRA VARGAS ANTHONY STEVE 


En forma individual las siguientes personas presentarán un diseño borrador en dibujo de como podrían modelar dicho simulador y sus reglas de comportamiento sin considerar el punto #6. 

Viernes 26 de agosto 

- MADRIGAL CHINCHILLA JULIAN ANDRES
- MONTERO ZUÑIGA AMANDA JESUS

- fecha de entrega: miércoles 31 antes de media noche
- entrega al asistente al correo: kevinqj.2002@gmail.com
- subject: poo - caso #2
- contenido: url en github con el código fuente del programa en el branch principal, en el mismo repositorio debe haber un readme.md con el modelo gráfico de objetos inicial que se hizo antes de iniciar la programación del simulador, además de las indicaciones de como se hace en su programa para configurar las reglas de carga y consumo de energía del simulador. 


# caso #3, 10%

*instituto tecnológico de costa rica*, escuela de computación  
*programación orientada a objetos*  
_prof. rodrigo núñez_  
*tipo:* individual  

## descripción
*virtual garden* 

el virtual garden es un programa que le permite a la persona ensayar sobre el cuido de diferentes tipos de plantas a lo largo de los años. para lograrlo, el usuario simplemente establece la duración del año en tiempo entrenamiento, por ejemplo, decir que un año equivale a 3 minutos de entrenamiento; la cantidad de estaciones 2 o 4. a partir de ahí puede seleccionar una planta para iniciar, todas inician siendo tamaño almácigo. El riego, el sol, alimentación y los cambios estacionales van haciendo a la planta cambiar tomando en cuenta factores como:

1. velocidad de crecimiento
2. alimentación que afecta color de hojas, floreo y frutos
3. la cantidad de agua que necesita para sobrevivir, crecer o morir 
4. alimentación necesaria para florear
5. alimentación necesaria para dar fruto
6. los niveles de sol que necesita para sobrevivir, crecer y morir

el usuario cuenta con las funciones de:

_abonar:_ selecciona una planta del jardín y al escoger dar alimento le suministra una porción. 

_regar:_ suministrando cierta cantidad de agua predeterminada a una de las plantas seleccionadas

una vez iniciado el entrenamiento, la planta iniciará su proceso natural de crecimiento; las diversas variables como las estaciones, el sol, la lluvia, el agua, el abono, tiempo transcurrido y demás, serán factores que irán afectando positiva o negativamente a la planta. 

hasta que la primer planta logre alcanzar al menos un 30% de su tamaño máximo, podrá agregar al jardín otra planta del tipo que desee y así sucesivamente para agregar más plantas al jardín.

el programa debe ser capaz de trabajar con cualquier cantidad de tipos de plantas y ser capaz de mantener el ciclo de vida permanente de cada planta por tiempo indefinido hasta que la planta muera. es importante tomar en cuenta que cada tipo de planta tiene su propio ciclo de vida, no todas son iguales. 

durante todo el proceso el usuario puede visualizar en la pantalla:

- una imagen de la planta en su estado; esto para determinar si la planta requiere más o menos ya sea agua o abono 
- la cantidad de años y días que han transcurrido en tiempo entrenamiento
- la fecha actual en tiempo entrenamiento
- la estación actual 
- la temperatura
- cuánto está lloviendo
- el tamaño de la porción de agua y abono respectivamente
- las acciones de abonar y regar

el objetivo final es que la persona aprenda cuál es la mejor época para sembrar cada tipo de planta, que aprenda cuáles florecen y cuales no, cuáles dan fruto y cuáles no, que sepa que cuidos darle según la edad y las condiciones del clima a travez del año. 

Cuál sería un diseño de objetos que permita programar en el menor tiempo posible, una solución para los requerimientos anteriores? Cómo podría la herencia y el polimorfismo darme ventajas estratégicas en la solución? 

Cómo hago para que el ciclo de vida de cada tipo de planta pueda ser diferente? Cómo selecciono que imagen mostrar tomando en cuenta tantas variables tales como: si está seca, si está pasada de agua, la edad de la planta, que si necesita abono o la quemé de tanto echarle? 

Cómo le voy a indicar al programa en que estación estamos? en que momento cambia de estación? entre que fechas debe suceder? y cómo hago para definir cuánto sol o lluvia va hacer cada día del año?

Cómo le indico al programa qué es bueno y qué es malo para cierto tipo de planta? Cómo sabe que le permite crecer, florear y dar frutos en cierto tiempo o del todo no lograrlo? Cómo me voy a dar cuenta que ya le toca morir sin hardcodear todos esos casos y el de todas las preguntas anteriores? Con qué diseño de objetos podría lograrlo?

los estudiantes serán quienes buscarán estrategias y formas de solucionar este problema aprovechando las técnicas aprendidas de orientación a objetos, deberán definir diversas reglas y mecanismos que le permita crear un programa flexible que cumpla los requisitos. encontrar respuesta en el diseño orientado a objetos para las interrogantes anteriores, que se presentan como retos de diseño y programación los cuales podrían simplificar o amplificar el tamaño y la complejidad del programa. 

proceda entonces a diseñar e implementar en java este programa de entrenamiento llamado virtual garden.

## asignaciones preliminares
cada estudiante tiene su creatividad propia, esa misma que le llevará a abordar este problema por frentes diferentes y aprenderemos de nuestra propia forma de atacar la complejidad y de las de los demás. por ello en cada bloque, tres estudiantes nos mostrarán su avance en la solución. el profesor le asignará una nota con respecto al nivel de avance utilizando las siguientes reglas:

1. _del 1 al 9 de setiembre, diseño de classes y/o estrategia de la solución:_ Responde a más del 80% de las interrogantes?(15) entre 50% a 80%(9), menos del 50%(4)

2. _del 12 al 21 de setiembre, pruebas de concepto:_ programé pruebas concretas de como voy a resolver los retos técnicos que me plantié en el bloque 1: en un 100%(15), 70%(10) o menos del 50%(6)

3. _del 28 set al 5 de octubre, all together:_ dividiendo la solución en 3 macro módulos: simulación, ciclo de vida y operativo, he logrado concluír a mínimo un 80% de cada macro módulo, ya sea de: los tres (15), simulación+operativo(7), ciclo de vida+operativo(12), simulacion+cicloc de vida(15), ciclo de vida(10), operativo(5), simulacion(10)  

## otros aspectos
- fecha de entrega: lunes 10 de octubre antes de medio día, último commit en github.
- última fecha para consulta: miércoles 5 de octubre
- revisión por cita






# caso #4, 53%

*instituto tecnológico de costa rica*, escuela de computación  
*programación orientada a objetos*  
_prof. rodrigo núñez_  
*tipo:* individual y grupos de 2  

## descripción
_*robot wars*_ https://www.youtube.com/watch?v=abrqn4nPw9k 

es hora de la guerra de robots, competencia donde personas de muchas disciplinas ponen a prueba su ingenio para crear robots que luchen hasta la destrucción o inhabilitación de sus enemigos, luchando en una arena con trampas que pueden causar severos daños a los robots. 

ahora tendrá la oportunidad de diseñar e implementar una arena de juego con robots de batalla diseñados por usted y sus compañeros, robots de software con armas especiales para poder librar las batallas. 


<img src="images/battlebots.jpg"/> 

_los robots_ 

los robots funcionan con una batería de 100 de energía, el movimiento, la velocidad, los ataques, consumen dicha energía en forma proporcional al alcance de esas variables (distancia, velocidad, fuerza): 

1. moverse (arriba, abajo, izquierda, derecha), se activa con las flechas direccionales, el robot va a tener una velocidad de pixeles por segundo teniendo un consumo de energía de 1 punto por cada 1000 pixeles recorridos. 

2. golpes, los golpes son físicos, mecánicos por así decirlo, van a tener una fuerza de 1 a 10, para cada nivel de fuerza se requiere 0.3 de energía, el golpe es disparado por un lado del robot (frente, atras, izquierda o derecha) y posee una distancia de impacto, es decir, que tan largo puede estar para pegar el golpe, cada 20 pixeles de dicha distancia incrementa el consumo de energía en un 10%. 

3. armas, son disparables a distancia, por ejemplo balas, fuego, cohetes, bolas de acero y similares. tienen igualmente un nivel de fuerza de 1 a 10 y consumen 0.2 de energía por cada nivel de fuerza, además tienen una velocidad en pixeles por segundo, consumiendo un 15% más de energía por cada 100 pixeles recorridos. 

4. daño, los robots sufren daños cuando reciben un golpe o un disparo y los daños se aplican segun el nivel de fuerza del golpe o arma recibida con la siguiente tabla:

- nivel 1 y 2; reducen la energía en un punto por cada nivel
- nivel 3,4,5; dañan un arma o golpe o dirección de movimiento en un 20% por cada nivel
- nivel 6,7,8; dañan un arma o golpe o dirección de movimiento en un 30% por cada nivel
- nivel 9, 10; dañan por completo una de las direcciones de movimiento

el elemento dañado se selecciona aleatoriamente y en el momento que dicho elemento se daña al 100% o más deja de funcionar por completo. 


_los competidores_ 

cada competidor de robot wars juega en una computadora separada, al iniciar ingresa su nombre, selecciona el robot que va a utilizar, arma al robot escogiendo un arma y dos golpes. una vez personalizado el robot da inicio para esperar que su contrincante haga lo mismo. tan pronto ambos esten listos inicia la pelea la cual durará hasta que alguno de los robots quede con 0 o menos de energía. 


_la arena_ 

la arena está compuesta por dos zonas rectángulares, cada zona en la respectiva computadora de cada jugador. cualquier jugador puede pasarse a la zona del otro de tal forma que ambas zonas realmente actuan como una sola. en todo momento debe ser posible ver el nombre y cuanta energía tienen los jugadores. es posible ver los golpes, disparos, movimiento y demás en forma fluída y animada. 

cada zona tendrá un máximo de 2 trampas, las trampas pueden afectar a cualquier jugador, dichas trampas se accionan en cualquier momento y reducen la energía del afectado en 5 puntos de energía, esto es si un robot pasa por encima de la trampa al mismo tiempo en que se activa. 

<img src="images/arena2.png"/> 

## aspectos técnicos 

- en forma individual, cada estudiante deberá implementar un robot, 3 golpes, 2 armas y una zona de la arena con sus trampas, esto equivale a un 25% del trabajo 
- el desplazamiento, los disparos y los golpes deben coincider en velocidad y posicionamiento
- cada jugador ve en la pantalla solo la zona en donde se encuentra su propio robot
- las armas y golpes son asignados al robot por "dependency injection" en tiempo de ejecución
- los robots deberán heredar de IRobot, si algún grupo necesita hacer una modificación a dicha classe deberá sincronizar con todo el grupo de poo
- la tasa de refrescado del juego en general debe ser máximo cada 300 milisegundos
- la comunicación entre las dos computadoras deberá hacerse vía red, se sugiere que sea por sockets
- el intercambio de mensajes entre las computadoras se debe hacer por serialización y deserialización de objetos, el formato puede ser binario o json, y cuando se enciende el server se decide el serializador a usar. dicha selección del serializador/deserializador debe lograrse por polimorfismo 
- tenga presente que al pasarse de una pantalla a otra puede existir un ajuste de dimensiones
- el servidor, la integración y todos los demás procesos se harán en parejas y corresponde a un 28%
- se evaluará el diseño de las classes, estrategia de objetos
- debe aplicar los patrones observer, producer/consumer, singleton, strategy y factory 
- las excepciones deben loguearse, conteniendo información como: fecha y hora, nombre de la classe donde sucede el error, el error o stacktrace, un código de error y una descripción corta. dichos códigos deben venir de una librería de constantes o de un archivo json que con el código de error se obtenga el mensaje de la descripción. 
- en al menos 3 procesos ponga en práctica los java stream functions. podría no limitarse a 3, pues son un excelente reemplazo para for's que hacen procesamientos de listas, arrays y collections que van a producir un resultado o una transformación. se reduce mucho el código, se simplifican muchas acciones. a continuación dos links de referencia: 

https://medium.com/javarevisited/how-to-use-streams-map-filter-and-collect-methods-in-java-1e13609a318b

https://www.amitph.com/java-filter-map-examples/

https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html 


## asignaciones preliminares
miércoles 26 de octubre
_federeico alfaro_ : demostrar como serializar y deserializar objetos usando json 

_isaac alfaro_ : demostrar como serializar y deserializar objetos usando bytes en binario

_jose pablo barquero_ : crear un ejemplo de cómo podría ser útil el patrón singleton para el caso

viernes 28 de octubre

_julian brenes_ : como funciona el dependency injection, generar un ejemplo útil para el caso 

_erick kauffman_ : cómo desplazar animadamente una imagen en un JFrame 

_juan ernesto mallma_ : cómo pintar y desplazar un dibujo hecho sobre graphics en java 

## otros aspectos
- fecha de entrega: miércoles 9 de noviembre antes de media noche, último commit en github.
- última fecha para consulta: viernes 4 de noviembre
- revisión por cita
