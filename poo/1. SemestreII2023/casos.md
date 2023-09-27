# caso #1, the self thinking house, 10%

_instituto tecnológico de costa rica_, escuela de computación  
_programación orientada a objetos_  
_prof. rodrigo núñez_  
_type:_ couples

## descripción

existe una casa donde ocurren sucesos aparentemente paranormales, los vecinos han reportado que la casa se abre por la mañana, apagando las luces, abriendo las ventanas e iniciando el día como cualquier otra casa. se ensucia como toda casa, se limpia como toda casa, huele como si alguien estuviera cocinando y al final del día las luces se prenden y se escucha una música chill, mientras la misma cierra sus puertas y se asegura para entrar en la quietud de la noche.

resulta que la casa no está embrujada, se trata de una casa que es auto mantenible, ella misma "piensa" y se auto sostiene para que cuando llegan los inquilinos no tengan que preocuparse por nada si no que solo vivir en la casa y disfrutar. el problema es que el sistema que controla la casa está hecho en cobol, se quiere instalar dispositivos más nuevos pero para ello el software controlador debe migrarse a java y ustedes han sido seleccionados para crear el sistema de la casa.

los creadores de la casa han decidido hacer un concurso para que varios fabricantes del software puedan proponerles la mejor casa posible, dando premios sorpresa a los participantes entre mejor quede la casa.

## subsistemas de la casa

la casa está dividida en 4 grandes sistemas que interactúan entre si para darle continuidad al funcionamiento de la misma los cuales se describen a continuación:

### habitaciones

1. corresponde a todas las habitaciones de la casa sala, comedor, cocina, cuartos, baños, cochera, entre otros

2. las habitaciones pueden iluminarse o apagarse, abrir o cerrar sus puertas y ventanas, pueden auto limpiarse.

3. dichas habitaciones tienen un tamaño definido, una cantidad de puertas y ventanas y ciertas luces.

4. el caso particular de los baños pueden abrir o cerrar las llaves de la ducha, innodoro y lava manos

### dispositivos

1. el sistema de dispositivos controla cocina, refrigeradora, tv, wifi, lavadora, secadora y otros electrodomésticos de la casa

2. la casa por medio de dichos dispositivos puede hacer el desayuno, cocinar en general, preparar recetas, lavar, secar y planchar la ropa, poner música, programas de televisión o en línea, mantener el wifi funcionando, iniciar alarmas y sensores

3. cada tipo de dispositivo tiene sus características y forma de funcionar dependiendo del tipo de dispositivo

### patio

1. el patio es el encargado de hacer crecer las plantas, floreen, dan frutos, es el encargado de secarse y regarse de agua cuando es necesario, es capaz de fumigarse para combatir insectos.

2. el patio incluye al suelo, al cesped, a los diferentes tipos de plantas y árboles. todos estos elementos existen en cierta cantidad y cierta extensión del terreno.

### control de respuesta

1. el sistema de control de respuesta pone a prueba los demás sistemas de la casa para garantizar que esta logra solventar debidamente las situaciones. entre las situaciones se destacan:

   - lluvia que satura el suelo del patio y puede hacer que entre agua por las ventanas o las puertas
   - ensuciar las habitaciones
   - taquear las tuberías de desagues
   - hacer que se acaben ingredientes para cocinar
   - suspender temporalmente el agua o la luz
   - hacer que el cesped crezca mucho
   - enviar plagas de insectos a las plantas

dado los requerimientos que deben cumplir los sistemas, organice un equipo de trabajo para diseñar, implementar y lograr que todos los sistemas de integren y operan en forma automática en la casa.

## preliminar #1, 25 de agosto, 20pts

- diseño de clases para el subsistema asignado a cada pareja
- el diseño debe considerar el uso de herencia y encapsulamiento para simplificar la lógica de los objetos
- cada grupo decide los tipos de classes que van a crear para la casa según el subsistema que hayan tenido asignados
- todas classes diseñadas deben tener los atributos y los métodos necesarios no solo para operar si no que también los métodos y necesarios para dar respuesta a los eventos del subsistema de control de respuesta
- el diseño deberá revisarse en formato PDF enviándolo al profesor al correo vsurak@gmail.com para las 8pm

## preliminar #2, 29 de agosto, 20pts

- diseño de clases de toda la casa completo
- para ello deberá integrarse con los otros subsistemas hechos por sus compañeros de tal forma que se integren los 4 necesarios
- el diseño debe considerar el uso de intefaces para facilitar la integración entre múltiples grupos, valiéndose de polimorfismo
- las interfaces que permiten la integración entre sistemas se diseñan en conjunto con todos los miembros pero es el grupo de control de respuesta quien tendrá la última palabra en cuanto a su implementación
- el diseño deberá revisarse en formato PDF enviándolo al profesor al correo vsurak@gmail.com para las 8pm, este diseño debe incluir los integrantes de todos los grupos, por ende es un envío por casa

## entregable final, 5 de setiembre, 60pts

- todos los grupos deben realizar su propia implementación del subsistema asignado
- cada subsistema deberá implementar un Thread el cual deberá leer un archivo json que contenga la configuración que le permita a la casa funcionar 24/7, es decir, dicho json debe decidir que cosas ocurren a qué hora y que día de la semana
- para este hilo se va usar una escala de 1 hora real equivale a 5 segundos en el sistema
- toda la casa opera en forma continua hasta que se detenga el programa
- los 4 grupos deben ponerse de acuerdo para hacer que el sistema se ejecute como uno solo y la casa opere en forma completa, por eso cada subsistema debe tener un único punto de inicio para que este sea llamado desde un main que deberá hacer el grupo de control de respuesta
- cada subsistema abrirá su propio JFrame donde deberá de alguna forma indicar lo que está pasando en la casa según el subsistema
- la revisión será con cita (asistente o profesor), primero una revisión con las parejas de los subsistemas y luego una completa con los 4 grupos integrados y funcionando
- cada grupo debe poder demostrar que el último commit fué hecho para la fecha de entrega máximo media noche.
- a nivel de subsistema se deberá tener un único repositorio donde sea evidente los commits de ambos integrantes a lo largo de los últimos 3 días minimo, de lo contrario la persona que no haya aportado perderá 10 puntos
- aquellas personas que obtengan menos de 70 deberán ir a reunión de consulta con el profesor
- 40 puntos serán para los subsistemas en forma individual y 20 puntos para la integración total de los 4 subsistemas

---

# caso #2, diseño e implementación de sistema a la medida, 20%

_instituto tecnológico de costa rica_, escuela de computación  
_programación orientada a objetos_  
_prof. rodrigo núñez_  
_type:_ individual

## descripción

_asignación de temas para caso #2_

<img src="media/gruposcaso.png" width=65% height=65%>

como estudiante usted a selecciónado un tema de trabajo para el caso #2 el cual ha estudiado para entender como funciona, entre los aspectos más importantes que debe averiguar son:

1. que cosas actualmente existen con respecto a sistemas que se usen en ese tema
2. qué dispositivos, aparatos o tecnologías están asociados al tema
3. cómo están conectados a nivel nacional y como funcionan para el país
4. qué procesos o procedimientos son usuales en esos sistemas humanos
5. qué personas están involucradas, que ingresan y qué reciben
6. que son los productos o cosas que entran o salen de los procesos
7. qué unidades de medidas, cantidades, precios de cosas usualmente se dan en ese contexto
8. existen edificios, localidades o tipos de areas donde sucede estos procesos
9. existe en su tema asuntos de transporte, envío, comercialización
10. busque ejemplos de como se le muestra a los usuarios la información usualmente en estos sistemas

ahora proceda a crear un documento en la nube donde aparezca su nombre completo, el tema asignado y respuesta a todas las preguntas anteriores, puede usar copy paste de internet, usar imágenes, chatgpt, etc. para cuando aplica recuerde contextualizarlo para costa rica.

luego de entender bien el problema, los sistemas y procesos, seleccione una pequeña parte para la cual usted le haría un sistema, luego escriba en el documento:

- resumen de lo que haría el sistema en máximo 3 párrafos
- describa 3 procesos que haría su sistema, los 3 procesos deben estar vinculados entre ellos de alguna forma. deje claro que información va ingresar el usuario en cada proceso y que información debería salir resultado del proceso.

enviarle al profesor por discord el link al documento, el lunes 11 de setiembre. luego de esto el profesor le dará retroalimentación de cambios a la documentación y durante la clase del miércoles se expondrán algunos casos.

---

# entregable #1, diseño del sistema, sábado 16 de setiembre, 30pts

durante la semana va a recibir retroalimentación para terminar de afinar el alcance de lo que va a resolver en el caso #2 basado en el punto anterior. con las correciones claras ahora proceda a fabricar los siguientes insumos de diseño:

1. diagrama de clases del sistema, siguiendo las prácticas de encapsulamiento y modularidad vistas a la fecha. utilice colores diferentes y una etiqueta para marcar claramente los packages de su programa. considere separar UI, configuración, modelo, lógica, controllers y almacenamiento de información. tenga presente que información base de carga puede ser tomada de un json previamente fabricado. además si su sistema requiere almacenamiento de información para uso posterior cuando se vuelva a abrir la aplicación, deberá resolver el problema de almacenamiento externo, para ello queda a criterio del estudiante investigar y aplicar una solución. se recomienda investigar sobre objetos persistentes, o también caches persistentes o bien serialización y deserialización de objetos.

2. diseño de las ventanas del sistema; para ello implemente en java todas las ventanas que va a necesitar su sistema, es importante que tenga claro lo que su sistema va hacer y como va a funcionar para diseñar dichas pantallas. se recomienda buscar en internet pantallas similares. utilice como insumo los procesos que haya concordado a implementar con el profesor. internamente en el código, a modo comentarios, pegue el acuerdo del proceso de dicha pantalla, aprobado en conjunto con el profesor, el cual discutieron en discord como versión final.

entregable: cree un repo para su proyeto y un branch que se llame "acuerdo", suba un pdf con el punto #1, garantice que la calidad de la resolución permita leerlo adecuadamente. suba los .java de su gui al mismo repo y en un folder que se llame "wireframes" suba screenshots de las pantallas hechas. deben haber tantos screnshots como ventanas java implementadas. envíe un correo al profesor con copia al asistente, con el link del repositorio antes de media noche. fvsasistencia@gmail.com, subject: poo - caso #2 - preliminar #1, el correo del profesor vsurak@gmail.com

# entregable #2, primer etapa de implementación, jueves 5 de octubre, 30pts

1. para realizar este preliminar debe contar con un diseño de clases y de ventanas aprobado por el profesor. en el caso de que haya obtenido menos de 20 puntos en el preliminar #1, no se puede considerar que su diseño y ventanas está aprobado. debe tener este visto bueno para más tardar el domingo 1ro de octubre.

2. el profesor le dará una cita de consulta para hacer un chequeo del avance hecho cuando ya haya avanzado en este preliminar

3. usted va a definir el alcance de este entregable, para ello el profesor va a hacer una dinámica en clase para que usted defina cual va a ser su estrategia de abordaje de la programación de este sistema. dicha estrategia deberá escribirsela al profesor en prosa vía discord. usted decide la estrategia que más se adecue a su sistema y lo que quiere resolver en el sistema, de tal forma que pueda atacar inicialmente aquello que considere más importante para el éxito de su programa. aun así a continuar aparecen 3 ejemplos de estrategias que puede usar o basarse en ellas para definir la suya:

   - ejemplo estrategia A: voy a implementar primero las ventanas con sus controllers usando datos de prueba hardcoded, esto porque quiero estar 100% seguro de que cuales son las entradas y salidas que deben estar en todo el sistema, esto para que en el último entregable todas mis clases se ajusten bien a la información de las pantallas.

   - ejemplo estrategia B: tengo muchas dudas del json, voy a implementar la carga del json y los hilos de ejecución de forma que el programa logre extraer esa data y generar información usando los parámetros de los json, imprimiendo todo eso en consola, así dejo para el final todo lo que son pantallas y las otras clases que las puedo implementar más fácilmente pues lo veo más simple.

   - ejemplo estrategia C: voy a implementar los controllers y las clases de mi modelo completas de tal forma que desde el controlador con un main yo pueda verificar que todo funciona correctamente y con sentido. Para ya al final solo hacer pantallas que es más sencillo y así tengo menos riesgo por si me dejan más trabajo en otro curso.

4. una vez con la estrategia establecida, comuníquesela al profesor vía discord y ahora contará hasta el 5 de octubre para hacer commit de la implementación que usted acordó entregar en esta estrategia. en la clase principal donde tenga el main de inicio del programa, copie a modo commentario el acuerdo de lo que hace su sistema al que llegó con el profesor para el preliminar #1 y también la estrategia que acordó con el profesor en este entregable #2.

5. la revisión será con cita, se evaluará completitud de la estrategia definida, diseño de clases, calidad de código, orientación a objetos, modularidad, herencia, polimorfismo, encapsulamiento.

6. nuevamente tendrá hasta la media noche del 5 de octubre para el commit de este preliminar, la revisión será con cita.
