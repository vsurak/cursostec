# caso #1, the news seeker, 10%

_instituto tecnológico de costa rica_, escuela de computación  
_estructuras de datos_  
_prof. rodrigo núñez_  
_type:_ individual

## descripción

un ejecutivo le ha pedido que le facilite una forma rápida de poder leer los titulares de noticias que le interesan únicamente, y solo aquellas que son más relevantes.

para ello, esa persona quiere un programa en C++ donde le pueda dar una única palabra que sea el tópico de su interés y la fecha a partir del cual quiere saber acerca del tema. con esa información el programa obtiene un conjunto de titulares que tienen que ver con el tema seleccionado.

una vez que el programa obtiene todos los titulares de las noticias, le muestra únicamente los 5 más relevantes, en orden de relevancia siempre.

seguidamente el ejecutivo le ha pedido que poder realizar las siguientes acciones:

a) mostrar todas las noticias ordenadas por relevancia

b) mostrar solo aquellos titulares que contengan al menos una vez una palabra de una lista proporcionada como input del usuario, donde cada palabra es separada por coma ,

c) eliminar de la lista de noticias, todas aquellas que tengan al menos una vez una palabra de una lista proporcionada como input del usuario, donde cada palabra es separada por coma ,

d) subir o bajar un titular de relevancia, es decir, indicando la posición actual del titular, puede indicarle ya sea un +Y o -Y, de tal forma que el titular sube o baja de posición de relevancia según el desplazamiento indicado por Y, por ejemplo si una noticia está en la posición 16, si el usuario indica reubicar(16, +7), pasaría a la posición 9.

cuando muestra los titulares, debe mostrar el número de posición de relevancia donde se encuentra el titular 1, 2, 3...N, y el titular respectivo.

## preliminar #1, 25 de agosto, 20pts

- determine que tipo de lista va a requerir para implementar el programa, ya sea lista simple, doblemente enlazada, circular, o doblemente enlazada circular

- determine cuáles métodos del TAD lista seleccionado necesita tener implementados y escribalos en un archivo .h, no hace falta que tengan body, pero si agregue comentarios indicando lo que supuestamente haría el método

- determine que métodos de operación para agregar, buscar, eliminar y reordenar titulares se van a necesitar y a cuáles métodos de la lista seleccionada va a ser necesario llamarlos, escriba esos métodos en un archivo .h, no hace falta que tengan body, pero si agregue comentarios indicando lo que supuestamente haría el método

- deberá enviar esto listo al profesor vía discord, usando un mensaje directo, a más tardar a las 10pm, indique su nombre completo y el link de github donde hizo commit del código

## preliminar #2, 3 de setiembre, 50pts

- usando las bases de listas hechas en clase, proceda a implementar la lista que usted seleccionó en el entregable #1

- proceda a implementar las funciones de titulares que seleccionó en el entregable #1

- haga un main de pruebas que le permita agregar varios titulares, mostrarlos, buscar, eliminar y reorganizar, probando que efectivamente funciona

- deberá enviar esto listo al asistente a más tardar a las 10pm, fvsasistencia@gmail.com, subject: estructuras - caso #1 - preliminar #2 y agregar el link del repositorio de github, indique el nombre del branch donde dicho commit final está acorde con la hora de entrega

## final, 6 de setiembre, 30pts

- con las clases helper proporcionadas con el profesor, agregue una capa más a su programa para que usando el api de https://newsapi.org, obtener las noticias en formato json

- dichas noticias son las que va a "parser" para extraer de ahí los titulares y así cargarlas a su sistema previamente hecho

- el programa final será revisado con cita a partir del 6 de setiembre

- REST url a utilizar, https://newsapi.org/v2/everything?q=election&from=2023-08-18&sortBy=popularity&apiKey=xxxxxxx

- a considerar para la revisión, si el estudiante no es capaz de explicar el código, se le rebajará 15 puntos

- los estudiantes que obtegan menos de 70 en la nota final del caso deberán tener una reunión de consulta con el profesor
