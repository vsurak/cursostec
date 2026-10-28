# Caso #3 - Power Band - 20%

## Descripción general

Power Band es un programa de creación e interacción musical que permite crear, guardar y reproducir música generada mediante la invocación, desde Java, de sintetizadores hechos en SuperCollider.

El programa se compone de tres partes:

1. **Los sintetizadores**, que viven en SuperCollider y generan el sonido.
2. **Los instrumentos**, dispositivos físicos conectados a Java que controlan los sintetizadores.
3. **El editor musical**, que monitorea, graba, almacena y reproduce la música.

## Los sintetizadores

El profesor le proporciona 3 sintetizadores en el archivo [myband.sc](src/caso%203/myband.sc), junto con un programa de prueba. Para usarlos debe:

1. Instalar SuperCollider desde https://supercollider.github.io/downloads.html
2. Iniciar el servidor.
3. Cargar los synths.

SuperCollider funciona como servidor y es el encargado de generar el sonido sintetizado.

Los synths ya están hechos, pero usted tiene la libertad de modificarlos o crear nuevos a su gusto musical.

## Los instrumentos

- Debe crear un programa en Java al cual se conecten los instrumentos musicales.
- Los instrumentos deben ser dispositivos que emitan valores que usted pueda transformar adecuadamente en los parámetros que requieren los synths.
- El profesor le proporciona el archivo [BandClient.java](src/caso%203/BandClient.java), que puede usar como guía para conectarse e invocar los synths una vez cargados en el servidor de SuperCollider.
- Los dispositivos **no pueden ser teclado ni mouse**. Sí pueden ser, por ejemplo: superficies táctiles, joysticks, sensores, termómetros, etc. Pueden conectarse por USB, Wifi/red, Bluetooth, o ser dispositivos ya integrados en la computadora.
- También puede considerar el acelerómetro, el giroscopio y la cámara de su teléfono. Tenga en cuenta que en ese caso debe crear el instrumento como una aplicación Android. No se recomienda este enfoque en iOS.
- No debe comprar hardware. Primero consulte con el profesor para ver qué posibilidades tiene; de lo contrario, el profesor buscará cómo facilitarle algún hardware para usarlo como instrumento.
- Debe integrar **un dispositivo diferente por sintetizador**, de forma que pueda controlar y disparar los 3 synths en cualquier momento usando los instrumentos conectados a su programa.
- Cuando el programa se inicia, los instrumentos se activan, se establece la conexión con SuperCollider y también se accede al módulo del editor musical.

## Editor musical

- Este módulo puede ser parte del mismo programa de los instrumentos. Sin embargo, si al menos un instrumento es externo a este programa (por ejemplo, una aplicación Android), el módulo también debe poder recibir mensajes, actuando como un servidor adicional para ese instrumento.
- El editor conoce en todo momento los comandos que los instrumentos envían a SuperCollider.
- Además de monitorear lo que hacen los instrumentos, el módulo puede grabar, reproducir y cargar música hecha previamente.

### Grabar

- Cuando el usuario activa el modo de grabación, todos los comandos y sus tiempos se guardan en un archivo en tiempo real, registrando así todos los instrumentos que se estén tocando, en tiempo y forma.
- Cuando el usuario termina la grabación desactivando el modo de grabación, se le asigna un nombre a la música creada. Ese nombre permitirá recuperarla y reproducirla posteriormente.
- Cada grabación debe tener un encabezado que indique el nombre, el punto de inicio de la grabación y el punto de terminación dentro del archivo `recordings.music`.

### Archivos

| Archivo | Contenido |
|---|---|
| `recordings.music` | Todas las grabaciones, una tras otra, cada una con su encabezado. |
| `recordings.index` | Índice de las músicas grabadas, ordenado por nombre. |
| `recordings.list` | Únicamente el nombre de cada grabación y la fecha y hora en que se grabó. |

- La búsqueda en `recordings.index` se hace mediante **búsqueda binaria en disco**, por lo que es importante que los registros, tanto en `recordings.music` como en `recordings.index`, sean **del mismo tamaño**. Utilice escritura binaria para mantener el tamaño exacto de los registros. (Serialization)
- Para indexar las músicas se usa el método de ordenación externa **Balanced Merge Sort**.
- No se permiten ordenamientos ni recorridos sobre arreglos en memoria para los recordings indexados. Todo debe suceder en almacenamiento físico.

### Cargar y reproducir

1. Cuando el usuario quiere escuchar una música grabada anteriormente, usa la opción de **cargar**. Esta le muestra las canciones disponibles en orden cronológico; la información se extrae del archivo `recordings.list`.
2. Una vez que el usuario selecciona la grabación, se usa su nombre para hacer la búsqueda binaria en disco y obtener la información del encabezado.
3. Con la grabación ubicada, la función de **play** inicia el proceso de buffering, transfiriendo al reproductor de instrumentos los comandos en tiempo y forma, para que SuperCollider reproduzca la música. Debe sonar idéntica a como se grabó.

## Otros aspectos

Esta sección no agrega requisitos nuevos; precisa puntos que la descripción deja abiertos. Si usted interpreta alguno de otra forma, justifíquelo en su especificación y valídelo con el profesor.

- **Registros de `recordings.music`:** el archivo contiene el encabezado de cada grabación seguido de los comandos que la componen. Cada comando registra, como mínimo, el instante en que ocurrió (relativo al inicio de la grabación), el synth invocado y sus parámetros. Todos los registros tienen el mismo tamaño fijo.
- **Registros de `recordings.index`:** cada registro contiene el nombre (de longitud fija) y la posición del encabezado de esa grabación en `recordings.music`. El índice se ordena por nombre.
- **Nombres:** el nombre de una grabación es único. Si el usuario escoge uno ya existente, el programa debe rechazarlo y pedir otro.
- **Momento de indexación:** al terminar cada grabación se actualiza el índice aplicando el Balanced Merge Sort sobre archivos en disco.
- **Orden cronológico:** `recordings.list` conserva el orden en que se grabaron las músicas.
- **Fidelidad de la reproducción:** los tiempos de los comandos se reproducen respetando los intervalos grabados entre ellos, sin depender de cuándo se cargó la música.
- **Bridge pattern:** la jerarquía de los instrumentos (abstracción) debe estar separada de la jerarquía de los comandos que invocan a los synths (implementación), de modo que puedan evolucionar de forma independiente.

## Otros aspectos

- Todas las clases deben cumplir con buenas prácticas de programación: encapsulamiento, separación de responsabilidades, ningún valor quemado en el código (use una biblioteca de constantes) y uso intensivo de herencia y polimorfismo.
- El trabajo se puede realizar de forma individual o en parejas.
- El programa debe estar escrito en Java.
- El estudiante puede usar cualquier asistencia de IA. Sin embargo, si no logra entender, explicar y defender el código, el diseño de las clases y los algoritmos, o no puede dar cuenta de cualquier línea de código, puede perder entre 30 y 70 puntos en la revisión, según la gravedad de la brecha de conocimiento.
- Se evaluarán los patrones de diseño, especialmente el uso del patrón **Bridge** para interactuar con los instrumentos y los comandos de los synths.
- Dado que habrá muchas operaciones de entrada/salida, se espera un dominio sólido del control de excepciones, de `InputStream`, `OutputStream` y sus clases descendientes y padres, así como del manejo de excepciones personalizadas.
- Se espera que cuente con un ambiente de desarrollo configurado para IA y con la versión resumida de *spec driven development*.
- Se revisarán las modificaciones que haya hecho manualmente a las reglas y specs después de que la IA las generó, así como los commands y specs generados por IA.
- La revisión se realiza en una cita programada con el profesor, y todo el trabajo debe estar registrado en GitHub. Se verificará que los estudiantes hayan contribuido al código durante el desarrollo; de lo contrario, el estudiante puede perder hasta 25 puntos en la revisión.
- No demostrar dominio de GitHub y de la línea de comandos puede costar hasta 15 puntos en la revisión.
- Último commit: miércoles 18 de noviembre de 2026.
- Revisión con el profesor mediante cita previa.
