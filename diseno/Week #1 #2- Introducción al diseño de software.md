# Introducción al diseño de software 

Cómo seleccionar y usar patrones de diseño de objetos:
- singleton, observer, factory, builder, adapter, bridge, decorator, proxy, chain of responsibility, command, iterator, mediator, visitor 


## Situación - Generador de reporte final

Se propone el desarrollo de una aplicación capaz de procesar múltiples archivos fuente en formatos **Word y Excel**, cada uno con estructuras, estilos y esquemas de organización diferentes. Estos archivos pueden variar significativamente en su disposición interna, nomenclatura de secciones, encabezados, tablas y formatos, lo que impide depender únicamente de reglas rígidas de extracción basadas en posición o formato fijo.

De manera paralela, la aplicación recibe como insumo una **plantilla en Word**, que define la estructura y las secciones del documento final que se desea generar. Esta plantilla actúa como modelo de salida y contiene los apartados que deben ser completados automáticamente con información relevante proveniente de los archivos fuente.

La misión principal del sistema es:

1. Analizar cada archivo fuente de forma individual. 

2. Identificar y extraer información específica únicamente de las secciones relevantes, descartando el contenido no pertinente. 

3. Comprender semánticamente tanto las secciones de la plantilla como el contenido de los archivos fuente. 

4. Mapear la información extraída hacia las secciones correspondientes de la plantilla. 

5. Generar como resultado un documento final completamente estructurado y rellenado conforme al formato definido. 

Uno de los principales retos del sistema radica en que los archivos fuente no comparten una estructura homogénea. Por tanto, la aplicación no puede depender exclusivamente de patrones estructurales estáticos (como posiciones fijas, nombres idénticos de encabezados o formatos uniformes). En su lugar, debe incorporar un mecanismo de interpretación semántica que le permita:

* Reconocer el significado de las secciones dentro de la plantilla (por ejemplo, antecedentes, objetivos, resultados, conclusiones, datos financieros, métricas, etc.). 

* Identificar contenido equivalente o relacionado dentro de los archivos fuente, aunque esté expresado con terminología distinta, distribuido en diferentes formatos o ubicado en posiciones variables. 

* Determinar la correspondencia lógica entre el contenido encontrado y la sección específica que debe completarse. 

1. Describa cual podría ser el flujo de trabajo de su sistema, paso a paso como se comporta y que tipo de operaciones hace secuencialmente para lograr el objetivo. 

Suponga un algoritmo que resuelve este problema por puro conteo de palabras y comparaciones exhaustivas, sin usar ninguna AI, o vectores o algoritmos semánticos o de proximidad. 

```
1. Se cuenta con un archivo de sinónimos de sustantivos
2. Se abre el archivo word plantilla y se recorre sección por sección del documento sacando sus sustantivos, en conjunto con sus sinónimos del diccionario. 
3. Se cuentan la cantidad de apariciones de esos sinónimos por sección, contando los sinónimos como una ocurrencia, ordenando esos resultados de mayor a menor numero de ocurrencias por sección. 
4. Se guarda en una estructura en memoria la lista de secciones con las palabras encontradas y sus respectivos conteos y el número de página donde está la sección.
5. Ahora se recorre uno a uno los archivos fuentes de datos.
6. Si el archivo es un excel, se recorre cada sheet del excel y se pasa a texto el contenido del rango más amplio de celdas existentes con información en el sheet, y se le pone el título a ese texto con el "nombre del archivo - nombre del sheet"
7. Si es un documento de word se extrae el texto.
8. Una vez con el texto sin importante si venía de word o excel se procede a sacar los sustantivos, en conjunto con sus sinónimos del diccionario. 
9. Se cuentan la cantidad de apariciones de esos sinónimos de ese documento, contando los sinónimos como una ocurrencia. Ordenando de mayor a menor ocurrencias las palabras.
10. Se procede ahora hacer un recorrido en la estructura de secciones de la planilla y para cada una de las palabras de la sección, y para todas las palabras del documento procesado, buscando encontrar coincidencias entre las palabras. Cuando hay una coincidencia se suman el total de apariciones y se guarda en la estructura de esa sección, una entrada que dice el texto que se leyó, y la cantidad de apariciones que hicieron match. 
11. Al seguir este proceso por todos los documentos, cada sección tendrá los contenidos que debe usar.
12. Se hace un recorrido por la estructura de secciones, se ordenan el ranking de las apariciones de documentos, se toman el top 3, y por medio de una AI se le pide que redacte la sección usando el contenido del top 3 como contexto. 
13. Con dicha redacción, se procede a reemplazar la sección en el documento de word. 

```

## Patrones de diseño orientado a objetos 

2. Se le van asignar 1 patrón de diseño, y otro lo escoje libremente de la lista anterior, y consulte al menos 3 aplicaciones posibles de cada patrón dentro del problema y el flujo que definió. Asegúrese que la aplicación del patrón incluya, una explicación de como podría usarse el patrón, la jerarquía de objetos o diseño sugerido.

3. Luego de esto, seleccione cual flujo versus aplicación versus implementación de las generadas considera usted que es la más poderosa, aquella que genera más valor para el sistema, al usar ese patrón de esa forma y con esa implementación. Para valorar eso considere:

a. Si está logrando solucionar un problema complejo con un esquema simple.

b. Si el programa dado ese patrón se va a poder adaptar a cambios o imprevistos del futuro.

c. Si reduce sustancialmente el esfuerzo de desarrollo.

d. Que dicha solución es capaz de usarse en otros escenarios dentro de la misma solución. 


4. Ahora someta el patrón y las classes diseñadas a evaluación:

Principles: 

* Does any class gain more than one reason to change?
* Does the pattern introduce logic that mixes concerns?
* Can I extend behavior without modifying existing classes?
* Does the pattern reduce conditionals?
* Can subclasses fully replace base classes without breaking behavior?
* Are interfaces too broad?
* Are clients forced to depend on methods they don’t use?
* Are high-level modules depending on abstractions?
* Did the pattern introduce new concrete dependencies?

Decoupling Test: 

- Simule un escenario donde una class A importante cambia internamente, evalúe, cuales otras classes se ven afectadas? esto especialmente cuando se altera un método que es accesible o público. 

You're looking for:
* Reduced direct references
* Fewer imports
* Reduced knowledge of concrete implementations
* Dependency on abstractions instead of concretions

Scalability Simulation Test: 

- Evalúe como cambian las clases y que se debe agregar si aparecen nuevos elementos de algo, 5, 10, 100, etc. 
- Se busca que el crecimiento de classes se mantenga lineal y aislado


Reusability Test: 

- Cuáles de las clases se pueden usar en otro sistema o proceso con modificaciones mínimas?
- Qué partes del diseño son independientes de frameworks o librerías 

Anti-Pattern Detection Test:

- Será posible resolver lo que hace este patrón de forma más simple?


Mutation Test:

- Seleccione una abstracción, y pregunte que parte del diseño se degrada?

Si nada importante se degrada entonces el patrón está de adorno. 


## Dependency Injection - architectural pattern

Dependency Injection (DI) es un patrón de diseño que consiste en proveer a una clase sus dependencias desde afuera, en lugar de que la clase las cree por sí misma. En otras palabras, una clase no debe construir lo que necesita; debe recibirlo.

ejemplo https://github.com/vsurak/cursostec/tree/master/diseno/src/dependencyinjection 

- Cómo aplicar dependency injection en frotend
    - ReactJS
    - Python con Flask o Django
    - AngularJS
    - En Asp.net

- Cómo aplicar dependency injection en el backend
    - En NodeJs + TypeScript
    - En Asp.net + webservices
    - En Python + FastApi o Django
    - En Supabase
