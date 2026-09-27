/evaluar-estudiantes
<audios>C:\dev\conversatorios\#2\algoritmos</audios>

<tema>
Dynamic Programming and Greedy Algorithms, real business applications

When studying types of algorithms, it is common to find academic examples used to illustrate the concepts: the traveling salesman, the shortest path in a graph, a simple game, the queens problem, Huffman trees, making change, the towers of Hanoi, among others. Commercially, programmers sometimes solve problems using these techniques, knowing and applying them in a planned or unplanned way, with a complete or sometimes partial approach.

The student is expected to identify multiple real problems, either solved in a documented way or potential candidates to be solved by such techniques.

Expected mastery

Fully masters the principles of each algorithmic strategy: what its steps and stages are, its formal requirements and criteria, how it manages the size of the problem, how it attacks, divides, and solves it, and the deterministic path it follows to arrive at a final answer.

Masters and studies multiple business cases for each type of algorithm, so that they can explain the context of the problem, its size, the algorithmic complexity, how the algorithm was designed, the steps it takes, and the result to be obtained; and, very importantly, knows the successes as well as the cases where the algorithm could fail or not be optimal, to the point of even being able to analyze its code.

For business cases that are potential candidates and/or have no detailed documentation, the student studies, analyzes, and develops a theory of application in which all the algorithm's requirements are addressed, can identify the steps to follow, the stages, the optima, the problem size N, the complexity measure, the correct cases and the corner cases that are not well handled, and clearly identifies the limitations and the potential of the proposed algorithm. This is applied to several problems and to both types of algorithms. In such a case, plenty of documentation was study to understand the real business problem.

The student has such command of the material that they do NOT need to read theory during the discussion session in order to explain the multiple facets of both the problems and the solution algorithms.
</tema>

<criterios>
1. El estudiante demostró que estudió más de un ejemplo o caso por cada tipo de algoritmo. 20 shares.

2. Siempre que explicó un caso existente o un candidato para programación dinámica fué claro en como le pasaba resultados de una etapa a otra, también donde y cómo ocurría la memorización de valores previamente calculados, y tuvo claridad en el tamaño n y etapas del algoritmo. 40 shares.

3. Cuando explicó casos existentes o candidatos para algoritmos voráces supo determinar cuál era el criterio de selección, la función de evaluación de la función, los óptimos locales y globales del algoritmo. 40 shares.

4. Pudo explicar código de alguno de los algoritmos estudiados a cabalidad, haciendo énfasis en la estrategia del algoritmo y cómo esta se encuentra y es evidente en el código. 30 shares.

5. Demuestra claro dominio del tamaño N del problema cuando discute y sobre las etapas que debe seguir ese algoritmo con respecto a ese N. 15 shares.
</criterios>

<estudiantes>
AGUILAR SEGURA LUIS ALBERTO,SolBrilla
OBANDO MORALES SANTIAGO LEONEL,LunaBrilla
</estudiantes>

<notas del profesor>
OBANDO MORALES SANTIAGO LEONEL,LunaBrilla
-	Trae dos algoritmos, uno por tipo
-	El primero es gitdiff, en programación dinámica, arma un grafo 2D donde en el eje X es cada eliminación y Y es inserción de una línea y diagonal que las líneas son iguales
-	Toma cambios D donde solo haya una línea diagonal donde no hayan cambios, luego va aumentando hasta tener las diferencias del archivo
-	Es de PD primero porque hay memoization, memoriza cada iteración del grafo, asumiendo N como longitud de cambios
-	Tiene un scenario de n^2, donde todas las líneas cambiaron
-	Detecta cambios de arriba hacia abajo, el subproblema radica en encontrar la menor cantidad de diferencias posibles para todas las líneas, quiero recorrer los dos archivos sin tener que recorrer los dos a la vez, ese paso de una iteración a la otra del grafo, quiere llegar a la mayor cantidad de diagonales posible
-	El algoritmo voraz el enfoque elegí el que usa el kernel de Linux para procesar paquetes de internet, aplicando a rate limitting, este algoritmo tiene un bucket de tokens de cada paquete que le entra, por cada vez que se llama verifica la cantidad de tokens en el bucket, si no hay nada no envía nada, verifica el tamaño de paquete con un calculo con el tiempo, por cada iteración guarda el ts de el paquete, con eso calcula los tokens que había recibido, si es mayor a las que trae el paquete los guarda en el bucket y el bucket envia todo, sin tener el contexto global. Cada paquete es una etapa, y hace una comparación voraz de tamaño. 
-	Cuando vi el algoritmo del kernel y vi que se descartan, pensé porque no implementan un algoritmo de probabilidad, pero es que ese algoritmo fue diseñado pensando en el alcance de la implementación, es un archivo o script que está en el kernel, requerir mucho poder computacional para una operación de segundo plano sería ineficiente, la elección voraz de comparar y decidir, lo veo como una elección de conveniencia en lo que tengo y lo que voy a necesitar. 
-	Dado que TCP tiene control de daños, entonces puedo sacrificar esa decisión. 
-	En el quiz se me ocurrió una solución, estoy sacrificando mi abstracción de programador versus implementar con una solución un buen resultado
-	Posiblemente me daría cuenta cuando llevo la mitad de mi solución hecha, si tengo que recorrer tres veces lo mismo creo que debe haber alguna forma mejor de hacerlo, es cuando veo que otros estilos podrían abaratar esos estilos. 


AGUILAR SEGURA LUIS ALBERTO,SolBrilla
-	Me centré más en voraz, la sentí más aplicabable en general, por ejemplo con el GPS como Google maps, para ir de punto A a punto B, se agarra la ruta más rápida y la más corta, lo vi con el algoritmo Dijkstra, que va con nodos y vértices con menor valor para llegar a un punto A B. Se puede ver en el GPS y también en instalaciones eléctricas donde hay varios caminos para ir de un lado a otro y se puede escoger el camino más cercano.
-	Dijkstra es algoritmo voraz porque si lo vemos con nodos, los vértices de menor distancia tomaría la ruta con menos cantidad de distancia. Las etapas el optimo local sería de A a B, sin llegar a C. 
-	Me costó un poco más entender programación dinámica, lo vió en un algoritmo de comparación de palabras como Google cuando busca palabras similares. Las 3 operaciones son insertar, borrar y reemplazar. Para pasar de casa a asar, son muchas similitudes queda como guardado la transformación de la palabra de una a otra. Las etapas podrían verse como una matriz, como con el código de cada carácter, y ese código se podría repetir para la siguiente palabra que se está formando. 
-	Lo veo más con la forma de vida real, pues un voraz puede optimizar mucho costo, tiempo, si tengo cientos de calles podría tomar cualquiera de las calles y en algún punto voy a llegar al destino, no significa que no vaya a encontrar la mejor ruta si no uso el voraz. Con una red eléctrica de cables pasaría eso y gasto más cable. 
-	Muy similar con lo que dice el compañero, uno se va a dando cuenta en el momento cuando ya está generando código, si realmente el algoritmo que está siguiendo parece óptimo o si buscar otras mejores. 
</notas del profesor>
