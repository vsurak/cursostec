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

2. Se le van asignar 1 patrón de diseño, y otro lo escoje libremente de la lista anterior, y consulte al menos 3 aplicaciones posibles de cada patrón dentro del problema y el flujo que definió. Asegúrese que la aplicación del patrón incluya, una explicación de como podría usarse el patrón, la jerarquía de objetos o diseño sugerido.

3. Luego de esto, seleccione cual flujo versus aplicación versus implementación de las generadas considera usted que es la más poderosa, aquella que genera más valor para el sistema, al suave ese patrón de esa forma y con esa implementación. Para valorar eso considere:

a. Si está logrando solucionar un problema complejo con un esquema simple.

b. Si el programa dado ese patrón se va a poder adaptar a cambios o imprevistos del futuro.

c. Si reduce sustancialmente el esfuerzo de desarrollo.

d. Que dicha solución es capaz de usarse en otros escenarios dentro de la misma solución. 