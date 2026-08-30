/evaluar-estudiantes
<audios>C:\dev\conversatorios\#1\poo</audios>

<tema>
a.	Si java.lang.Math me da un amplio repertorio de operaciones, para que tengo el paquete de java.math

b.	Por qué si existen classes para Integer, Boolean, Float, Byte, etc existen primitivas? incluso esas clases muchas veces son creadas con primitivas, o tienen métodos que retornan primitivas. Si las primitivas tienen métodos para que existen las clases. Deberían ser una o la otra únicamente?

c.	Que controles y como puede administrar java lo que son procesos y threads desde las classes en java.lang

d.	Cuándo se construyen sistemas que van a ser usados en múltiples países, que ventajas me dota java.time

e.	Qué tipo de algoritmos, operaciones, técnicas, estructuras y/o soluciones puedo fácilmente crear con java.util, donde se vuelve un aliado en la programación?
</tema>

<criterios>
1. El estudiante dió más que definiciones teóricas de los conceptos, habló de casos concretos de uso, correlacionó el concepto con otros existentes para ampliar la comprensión. 20 shares.

2. El estudiante realizó programación ejemplo en código java para demostrar los aspectos estudiantes y para soportar las afirmaciones que está aportando. 30 shares.

3. El estudiante logró crear deducciones propias, simplificaciones propias, teorías propias sobre el entendimiento y uso de los conceptos y técnicas que está aplicando. 20 shares.

4. Pudo correlacionar los temas estudiados y expuestos con el entorno del mundo real, ya sea dentro del contexto de sus estudios en ingeniería de sistemas, o también contextualizando situaciones de desarrollo de programas de la vida real donde lo expuesto consolida esos escenarios. 25 shares.

5. Para aquello que no supo una respuesta, logro conectar múltiples conceptos estudiados para llegar a una respuesta que aún tal vez no sea correcta, tiene coherencia técnica. 15 shares.

6. No solo glorificó las caracteristicas del lenguaje, los paquetes, los alcances poniendo java como un gran lenguaje y plataforma de programación, si no que más bien, logró evidenciar en teoría y en código, deficiencias, mejoras y retos de uso de los diferentes paquetes, clases o implementaciones discutidas sobre su intervensión. 25 shares.
</criterios>

<estudiantes>
AGUILAR FONSECA HILARY,ZeusRojo
BARRANTES AZOFEIFA EDIER ISAAC,ThorAzul
COREA HERRERA STEVEN FERNANDO,OdinVerde
CUNIO LOPEZ PIERO ANTONIO,RaDorado
ESPINOZA ORTEGA MARIA JOSE,ApoloPlata
FERNANDEZ CASTRO ANTHONY,HeraNegro
HERNANDEZ CAMACHO IGNACIO,AteneaBlanco
HIDALGO TORRES JOSELYN MELISSA,HadesVioleta
LEIVA VILLALOBOS BRYAN JOSUE,DianaIndigo
MADRIGAL CAMPOS ANDRES,PoseidonNaranja
MONTERO VALVERDE ELIAN ESTEBAN,AresTurquesa
MOYA AGUILAR JOSE JULIAN,ErosCoral
OBANDO ARIAS YUNIER STEVEN,FreyaGris
ROJAS BARRIOS MARTIN FRANCISCO,LokiRosa
SANCHEZ POVEDA DANIEL,IsisBeige
SEAS ALVAREZ JORDAN LEONARDO,OsirisCian
SEGURA QUESADA KEYZEL ESTRELLA,AnubisAmbar
TARASOVA ARINA,BacoMarfil
TORRES ORELLANA ALEXIS,JanoCobre
VARGAS VARGAS GABRIEL,VulcanoBronce
VEGA HIDALGO EIMY GUADALUPE,VenusEscarlata
ZUNIGA PICADO DAVID,NeptunoJade
ZUNIGA ARROYO PATRICK SEBASTIAN,MartePerla
</estudiantes>

<notas del profesor>
ZUNIGA PICADO DAVID	NeptunoJade
-	Las clases int, bool, char, float se optimizan para uso de memoria, en cambio los wraper classes para programación orientada a objetos y estructuras de datos genéricas.  Eso son la forma en que java usa sus collections. 
-	
COREA HERRERA STEVEN FERNANDO	OdinVerde
-	Las primitivas son en java son operaciones fundamentales. 
FERNANDEZ CASTRO ANTHONY	HeraNegro
-	Antony menciona es para facilitar el uso de las mismas, es para hacer métodos más fácilmente de programación. 
SANCHEZ POVEDA DANIEL	IsisBeige
-	Math es para operadores aritméticos, en cambio el otro es para precisión financiera, también trae un tema de precisión de punto flotante.
-	El java.math BigInteger y BigDecimal son tamaños más arbitrarios, limitados por memoria ram, BigDecimal es más exacto para puntos flotantes y redondeos. 
-	Las classes genéricas se implementan para reutilizar código, cuando bajamos a nivel de ensamblador, si no se usa el reuse, que va ser un gasto inncesario de memoria. Las clases genéricas reusan código para reducir instanciación. 

MOYA AGUILAR JOSE JULIAN	ErosCoral
-	Existen ambos primitivos y clases, las primitivas son simples, se usan para ponerle un entero a una variable y ya, son casos de uso básicos, se necesitan más directos. En cambio las classes de java.lang, se crea un wrapper, es decir un envoltorio para poder usarlos en los array list por ejemplo que usan objetos y no valores, entonces ahí se logran 
-	En ocasiones se necesitan tener listas con valores null, entonces se podrían usar classes, sin necesidad de solo usar un primitivo
-	Se pueden usar métodos para operaciones distintas con los mismos wrappers, los primitivos los puedo usar para operaciones matemáticas
-	Es una sintaxis que confunde, los primitivos no son objetos como tales, los otros se trabajan diferentes. 
-	Toca el tema de boxing y unboxing. 
-	En los Threads se puede trabajar con estados, se puede asignar estados dependiendo si se necesita un multitasking que por ejemplo se suspende una y se inicia otra, también se pueden aplicar prioridades, puede ser complejo trabajarlo manualmente, puede ser complejo por lo que se debe tener cuidado porque se puede volver tedioso
-	En algunas ocasiones analizar si está bien hacer un multitasking o no, gestionar tareas, los pools de los hilos si es conveniente o no. 
-	
MONTERO VALVERDE ELIAN ESTEBAN	AresTurquesa
-	Los primitivos son muy simples, no pueden contener un null, en los colecciones los null pueden verse como un valor faltante, las colecciones necesitan un objeto para almacenar ese dato
-	Un proceso es un programa que tiene su propio espacio en la memoria, en cambio los threads pueden crear muchísimos
-	En java.lang hay classes como processbuilder para iniciar procesos externos, el Process representa y controla un proceso ya iniciado y también tenemos en Runtime que nos da el proceso de ejecución. 
-	La clase thread permite modificar o cambiar el hilo que está iniciado y finalmente tenemos Runnable que representa la tarea que ejecuta el hilo. 
-	La JVM se ejecuta como un proceso que tienen múltiples Theads, con el Thread y Runnable se pueden iniciar tareas concurrente, mientras que con ProcessBuilders podemos controlar programas externos. Java no controla directamente el procesador, si no que JVM administra los hilos, el OS participa en la planificación y ejecución. 
-	Como consecuencia si se crean muchos Threads una computadora podría no correr el programa. 
ZUNIGA ARROYO PATRICK SEBASTIAN	MartePerla
-	Existen las primitivas y las classes porque cumplen funciones distintas, en entorno de la programación permiten optimizar recursos
-	Permite tener eficiencia y productividad, es necesario que hayan diferentes interfaces java nos ayuda a que no inventemos cosa que ya estén diseñadas
-	Hay operaciones básicas que las primitivas funcionan de manera suficiente, y hay otras que son necesarias que usan métodos que no puede ser por primitivas. 
HERNANDEZ CAMACHO IGNACIO	AteneaBlanco
-	Los primitivos se pueden ver como un espacio de memoria más directo, entonces en un programa usar un primitivo y un objeto impacta el rendimiento
-	Las listas lo usan de cierta forma donde las listas genéricas pueden borrar los objetos que estén en el T el generic para poder quitarlo y poder aplicarlo 
-	La virtual machine de java siempre corre un solo proceso, pero se pueden crear hilos que se pueden separar de ese mismo proceso
-	Trabajar con hilos permite al programa tener multitasking, o si la maquina solo tiene un núcleo puede hacer líneas de ejecución temporales, haciendo que programas pesados se hagan más liviado
-	Cuando por un ejmplo un servidor web puede usar un pool thread de forma que pueda trabajar muchas solicitudes como una pila y así ir mejorando el rendimiento del programa como tal, se puede manipular con la clase Thread. Otro ejemplo de vida real es como cuando se descarga un archivo en segundo plano. 
-	Es importante usar esos Pool de hilos para no estar creando hilos manualmente, si son cientos de miles, abrir todos los hilos explota el programa, por eso el pool de hilos funciona correctamente. 
LEIVA VILLALOBOS BRYAN JOSUE	DianaIndigo
-	La clase importante es DateTime, que se relaciona a zonas horarias
-	Las habilidades que nos permite java útil nos permite tener coleciones de datos, pares clave valor, hacer búsquedas, elegir cual estructura nos sirve para el programa que estamos haciendo y procesar la información más eficienciente
-	
ROJAS BARRIOS MARTIN FRANCISCO	LokiRosa
-	Java.time permite seleccionar zonas horarias y mostrar el time de ese país en concreto
-	Java.time permite contar la diferencia entre zonas horarias para normalizar la hora, si se quiere un evento a cierta hora , se puede normalizar ese tiempo
-	Java.util implementa estructuras de datos que de no ser así habría que implementarlos a mano, como por ejemplo listas, hashmap, tree, sin necesidad de hacer toda la lógica
-	Los tiempos pueden estar en un array de java.util, ordenar por eventos por fecha, usando algunos de los sort que ya están proporcionados por java.util.
-	En java.util está Locale que permite obtener la ubicación,
MADRIGAL CAMPOS ANDRES	PoseidonNaranja
-	Hay otra class que se llama ZoneId que sirve para tener un ID de una zona para saber de donde es y luego lugares específicos como ciudades como costa rica, NYC, Madrid
-	Se puede usar para estructuras de datos, se pueden generar números aleatorios, tiene colas, mapas, arboles, listas y además se pueden usar como base para crear otras estructuras de datos
-	Las listas y estructuras de datos de java.util ya han sido probadas y no hay errores y son eficientes versus programa hecho desde cero
-	También se pueden hacer ordenamientos por letras como por ejemplo N de norte o S de Sur, también para ordenar en que orden de tiempo están ubicadas las cosas como en un árbol. 
-	Locale da el lenguaje. 
HIDALGO TORRES JOSELYN MELISSA	HadesVioleta
-	Se utiliza como uso diario para todos los programadores, permite hacer un código preciso funcional 

</notas del profesor>
