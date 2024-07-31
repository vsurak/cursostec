# Ejercicios teóricos, prácticos, sprints y pruebas de conceptos cortas



## Ejercicio #1 - patrones de diseño orientado a objetos parte I

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
 

### Problema: SalmaDraw
El software de ilustración SalmaDraw se ha extendido en su uso en multiples dispositivos como apple computers, ipad, android tables, pc y algunos smartphones de pantalla grande. Sin embargo no todas las funcionalidades pueden operar de la misma manera dependiendo del hardware y el sistema operativo. Por ejemplo texturizar se podría hacer pixel perfect o algunas veces aplicarle algoritmos para hacer ajustes. Texturas generativas algunas veces las genera de cierto tamaño de resolución en otras ocaciones usa técnicas basados en texturas ya existentes. Según los puntos de presión del pen, las herramientas de dibujo podrían requerir correr algoritmos adicionales para hacer las líneas , contornos, rellenos y similares. Si cuenta con GPU o no, los filtros podrían ser básicos o usar nuevos con AI.  

_patrones disponibles:_ visitor, decorator, chain of responsability


## ejercicio #2 - dependency injection

Ellivhsan es una plataforma web de shopping en línea que vende productos para el cuidado facial y corporal, actualmente lleva 2 años en el mercado con mucho éxito. Desde que se creó, su arquitecta y product owner, la ingeniera Julieth, decidió que se iba a realizar bajo el modelo de server side rendering. Con el paso de los años, Julieth ha tenido que enfrentar los ajustes de CSS y JS para poder ofrecer una plataforma que sea totalmente responsive. Cuando llegan los request http al servidor con el respectivo path, llegan especificaciones del dispositivo cliente para que así los CSS y JS hagan los ajustes de responsive. Este approach ha funcionado muy bien, sin embargo ahora Julieth quiere llevar esto un poco más allá y no está satisfecha con solo entregar responsive a los frontend que buscan acomodar cosa por tamaño y reacomodar contenido, por el contrario, ahora quiere que dependiendo del dispositivo del cliente pueda ofrecer experiencias únicas según el device, como movimiento con giroscopio, 360, manipulación de video, generar instructivos de uso de los productos, dotar de espacios para hacer consultas a bots con AI y muchas otras funcionalidades. Dado que ahora no se trata únicamente de responsive si no de hacer render de las páginas en forma más especializada, Julieth ha optado por transformar el handling de los request http a un approach de dependency injection, de tal forma que la información proveniente del cliente respectivo, permita establecer cuál render sea más efectivo para generar la respuesta de formato ideal y se pueda crear una experiencia mucho más enriquecida en el sitio de Ellivhsan. Usted estuvo en la reunión con Julieth y le ha pedido que prepare en código un ejemplo abstracto general de como podría quedar la estructura del handler y la lógica de server side rendering utilizando dependency injection; para en la próxima reunión mostrarlo a todo el equipo de desarrollo.

- el ejercicio es individual
- puede utilizar cualquier lenguaje de programación para el ejemplo
- realice esto en papel o en un editor de texto 
- no es necesario que el código funcione, no se revisa sintáxis
- los métodos pueden ser dummies y usar comentarios para enriquecer
- enfóquese en la estructura del patrón, similar al ejemplo desarrollado por el profesor 
- entrega 31 de Julio, 9pm, correo: vsurak@gmail.com, subject: diseno - ejercicio #2
- en caso de que lo haga en papel enviar las fotografías legibles del código

