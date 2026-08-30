/evaluar-estudiantes
<audios>C:\dev\conversatorios\#1\algoritmos</audios>

<tema>
a.	Después de esto estudiado, cuáles podrían ser estrategias o estructuras de datos que normalmente llevan a un detrimento del rendimiento, y de la misma forma cuáles son técnicas o estructuras que normalmente van asociadas a la mejora?

b.	Qué tan usual los problemas de rendimiento parecen venir de los vendors, productos de software como plataformas, drivers, librerías cuya programación está hecha de cierta forma que el usarla ha llevado a los problemas?

c.	Qué tan común los ingenieros de software se enfrentan a problemas de optimización de algoritmos, donde de eso pueda depender si es un buen ingeniero o no?
</tema>

<criterios>
El estudiante en su exposición denota que estudió múltiples artículos, varias fuentes y las cruzó organzidamente para sostener sus afirmaciones, siempre dejó claro de donde estaba sacando sus hipotesis, sobre cuales casos de estudio? 25 shares.

El estudiante domina, extiende, explica y analiza de forma clara la complejidad algoritmica de los problemas que está exponiendo, del como sucedieron y el cómo los aborda. 30 shares.

Hubo verificación de veracidad de los casos estudiados, de tal forma que se comprobó que en varios medios oficiales, la narrativa del caso es la misma consolidando como un evento real documentado. 20 shares.

En análisis del o los problemas abordados por el estudiante, tienen más de una dimensión, entre ellas: complejidad algoritmica, tamaño, formas de monitoreo o detección, mediciones anteriores y posteriores a la mejora. 20 shares.

El estudiante hizo pruebas programadas o medición analítica, que simulaban parcialmente el problema en estudio para verificar los rendimientos esperados y obtenidos. Es evidente ese ejercicio en su exposición. 20 shares.
</criterios>

<estudiantes>
AGUILAR SEGURA LUIS ALBERTO,SolBrilla
AGUILAR SOTO MARIANNE SOFIA,LoboCorre
ALFARO GARCIA ISAAC GERMAN,TigreSalta
ARAYA MAYORGA JOSE DAMIAN,SolAmarillo
ARROYO ORIAS PABLO JESUS,CerroCanta
BARRANTES VILLALOBOS GABRIEL,AlaVuela
CARBALLO MARTINEZ JOSE ADRIAN,RioFluye
FAJARDO DIAZ GENESIS VALERIA,FuegoArde
GUZMAN PORTUGUEZ BIANCA DE LOS ANGELES,VientoVa
MEZA MARIN DYLAN JOSE,MarNada
OBANDO MORALES SANTIAGO LEONEL,LunaBrilla
</estudiantes>

<notas del profesor>
ALFARO GARCIA ISAAC GERMAN	TigreSalta
-	Patrones para que se equivoque, estudio casos de empresas grandes como amazon, Facebook. Primero procesaban los datos y con los datos sacaban recomendaciones pero subestimaron la cantidad de usuarios.
-	Si hay 100000 usuarios y un montón de series se movían ineficientes
-	Una persona famosa mete un tweet famosa y tiene 10000000 de personas, rationale es la subestimación del tamaño
-	No especificó tantos casos específicos, pero en uno de amazon, en el aspecto no hubo un fallo tanto de plataforma, si no del como procesaban la información. Analizaban todos los usuarios similares a otro usuario de comparación, y basados en usuarios parecidos, buscaban productos parecidos, haciendo un NxM. Luego se pasaron a productos parecidos. 

BARRANTES VILLALOBOS GABRIEL	AlaVuela
-	Lo que mas vio recurrente, algo que vuelve a pasar hacen algún tipo de ciclo donde se va aumentando un intento de algo innecesariamente, principalmente no parace negativo pero puede volverse cuadrático
-	En Facebook hace casi 10 años hacían búsquedas para ver si el tema que estoy buscando no estuviese ya en la base de datos, y de esa forma decidían hacerle un append, porque cada vez que hacían la búsqueda era hacerlo varias veces
-	Luego la solución fue no hacer la búsqueda, en su lugar trabajar las copias
-	A veces pareciera ser algo correcto, pero luego con el tamaño ya no se vuelve tan correcto
-	Viendo de las soluciones de las compañías, encontró un claso de cloudfare, tuvieron un problema en el 2020 con la actualización donde se cayó el sistema por media hora, viendo la razón parecía una solución ingeniosa, usaban una regex para una verificación, pusieron mal un carácter y generaba que la forma de verificación, hacía un árbol demasiado grande con muchos rollbacks , el procesamiento era regular para la mayoría pero para otros era mucho. 
-	Uso de librerías externas, para Facebook usaron jupyter para hacer pruebas, en un caso de copilot, estaban diciendo que tenían mejor resultado a la hora de hacer operaciones usando tokens que usar librerías de otros. 

OBANDO MORALES SANTIAGO LEONEL	LunaBrilla
-	En lo personal no estudié tantos casos pero me enfoqué en dos, GTA online, pareció simple, un problema de lectura archivo json
-	En el caso de discord, tuvieron un problema con la concurrencia primero, el tamaño del problema aumentaba demasiado, soluciones parcialmente correctas para un gran volumen de usuario se volvía lenta, ellos usaban mongo para base de datos de mensajes
-	Cuando llegaron al billon de mensajes históricos tuvieron problemas con mongo, y se pasaron a cassandra, que es un motor non sql basado en java, varios años como 5, con cassandra. Posteriormente tuvieron problemas, en el trillon de mensajes cassandra empezó a fallar, notaron grandes latencias en el quartil p99, el 1% de los usuarios experimentan hasta 10 segundos para leer un mensaje causando congelamente complejo
-	En el caso de discord, ellos cambiaron el motor de base de datos de cassandra a ccyle , que reescritura de cassandra para C++. En el caso de discord terminó siendo un problema de la arquitectura. Tuvieron que escribir un middleware  en Rust para mejorar. 
-	Hizo la investigación de los blogs de discord, en lo personal ellos no tuvieron un problema específico de plataforma si no que tuvieron que cambiar. 

AGUILAR SOTO MARIANNE SOFIA	LoboCorre
-	Siento que el hecho de optimizar el algoritmo no viene propiamente de trabajar en el algoritmo, decirle mas bien una optimización de conocimientos, el ingeniero llega a un estado de obsolencia con nuevas amenazas y neuvos sistemas
-	En el outrage de cloudfare en 2019 fue un error de escritura en WAF web app firewall, se encargaba de cross site scripting, que protege que no roben tu página desde un ingreso externo
-	Este error de escritura hizo un bracktracking que llenó el CPU, ese error pasó varios testing, si era con usuarios reales, en ese caso el big-o subió exponencial a 2^n, subiendo a un 100% de carga
-	Luego pasaron al sistema R2 de Google, donde el programador no tenga que typear todas las expresiones a usar si no que sean standard
-	El problema se pudo prevenir si el ingeniero hubiese estabado más paparado
-	Otro caso que encontré fue en amazón, no fue un error en la estructura del dato, si no que hubo un problema de un programa automatizado que redireccionado , donde según los datos enrutó a la información que se necesitaba retornaba un null.
-	Cayeron más clientes que usaban el mismo servicio de auth de datos, se cayó dinamo, S3, lambda al ejecutarse no retornaba la información
-	No es solo usar sistemas automatizados, si no mantener la revisión de los ingenieros que se ayude. 
-	Cloudfare tiene 3 sistemas de testeo con usuarios reales. Usuarios internos, usuarios no pagos y posteriormente con usuarios de tráfico alto, como estados unidos. Pero no propiamente con sus usuarios pagos, lo cual era hasta el final. 

ARROYO ORIAS PABLO JESUS	CerroCanta
-	Siento que sucede muy seguido, dado que siempre se esta relacionado a usuarios, y esto puede escalar
-	Estudie 3 casos amazon linkedin tweter
-	En un par de años subieron de 5 millones a 40 millones, eso los obligó a cambiar la infraestructura
-	Mi papá esta haciendo un desarrollo para mep, cuando fue agregando mas profesores tuvo que cambiar infraestructura
-	En linkedin pasaron a 45 millones en dos años lo cual fue rápido
-	Software de medición no vió, pero vió que usaron DOS attack donde bots hacen prueba de stress, para hacer pruebas de millones de bots. 

AGUILAR SEGURA LUIS ALBERTO	SolBrilla
-	Me centré mucho en Netflix que usaba un algoritmo llamado cinematch, donde un usuario a y b, con las recomendaciones sacaban que esas personas les iba a gustar la película C, probablemente a esas personas no le iba a gustar esa película
-	Eso fue entre el 2000 y 2006, luego nexflix en lugar de contratar ingenieros, lo que hicieron fue hacer un concurso, para mejorar ese cinematch, y tres grupos que hicieron varios algoritmos juntos, pasaron de bigO O(nxm) que eran millones de usuarios por películas a un K*n+M, con eso se tuvieron un O manejable. 
-	Como eso fue un problema creciendo por la cantidad de usuarios, aplicaron sistemas más sofisticados, como por ejemplo con reinforment learning, para mantenernos atraídos lo que les gusta. Y también redes neuronales para procesar patrones más complejos y masivos. 

</notas del profesor>
