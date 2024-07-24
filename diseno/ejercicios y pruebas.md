# Ejercicios teóricos, prácticos, sprints y pruebas de conceptos cortas



## Ejercicio #1

El profesor va armar grupos de trabajo de forma aleatoria y a cada grupo se le va a asignar uno de los siguientes problemas. Realice el diseño de un esquema de las classes principales que se requieren para resolver el problema en cuestión, tomando en cuenta que debe utilizar al menos uno y máximo dos patrones de diseño de objetos de los ofrecidos en cada problema. 

Lectura de soporte y ejemplo: https://refactoring.guru/design-patterns/catalog

### Problema: ThinkTogether
El software de reuniones virtuales ThinkTogether actualmente solo soporta video llamadas con uso de cámara y micrófono. Sin embargo los dueños han hecho una fuerte inversión de capital para habilitarle funcionalidades nuevas:
- un bot va a generar las notas de la reunión completas
- se le va agregar un chat
- otro proceso se va encargar de resumir los puntos más importantes y las acciones por participante de la reunión 
- según como se configure la plataforma en la organización dichas anotaciones podrían estarse enviando por mail, o slack o el chat de la herramienta o alguna otra herramienta custom por medio de un hook en Rest
- se sabe que podrían existir multiples tipos de senders y multiples APIs de AI para implementar las nuevas funcionalidades

_patrones disponibles:_ command, mediator, chain of responsability
 

### Problema: 
El software de ilustración SalmaDraw se ha extendido en su uso en multiples dispositivos como apple computers, ipad, android tables, pc y algunos smartphones de pantalla grande. Sin embargo no todas las funcionalidades pueden operar de la misma manera dependiendo del hardware y el sistema operativo. Por ejemplo texturizar se podría hacer pixel perfect o algunas veces aplicarle algoritmos para hacer ajustes. Texturas generativas algunas veces las genera de cierto tamaño de resolución en otras ocaciones usa técnicas basados en texturas ya existentes. Según los puntos de presión del pen, las herramientas de dibujo podrían requerir correr algoritmos adicionales para hacer las líneas , contornos, rellenos y similares. Si cuenta con GPU o no, los filtros podrían ser básicos o usar nuevos con AI.  

_patrones disponibles:_ visitor, decorator, chain of responsability
