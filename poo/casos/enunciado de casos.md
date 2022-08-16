# caso #1, 7%

*instituto tecnológico de costa rica*, escuela de computación  
*programación orientada a objetos*  
_prof. rodrigo núñez_  
*tipo:* grupal  

## descripción
El yate silent 60 es un navío de tipo catamaran que funciona con energía solar, representa un ícono del futuro de la navegación con cero emisiones. posee sistemas de paneles solares, sensores, optimización para el uso de energía, baterías de litio entre muchos otros avances tecnológicos. 

En general el silent 60 es todo un sistema integrado donde muchas partes interactúan y se relacionan entre sí con el fín de proveer:

- energía a toda la nave
- propulsión
- comunicación
- sistema de aguas y baños
- refrigeración para alimentos y aire acondicionado
- televisión
- entretenimientos
- iluminación
- sistemas de navegación

### parte 1
ahora se presenta el reto de hacer un diseño del funcionamiento de este yate en forma digital. para ello se van a conformar subgrupos que van a diseñar una parte de la funcionalidad de los sistemas del yate, para posteriormente crear todo el diseño completo. dicho diseño inicial es conceptual, es decir, son cajas con los nombres de los objetos, los atributos y las acciones del mismo cuando así sea necesario. para realizar dicho modelo se recomienda usar miro para montar dicho diseño en forma colaborativa. https://miro.com/

links relacionados 
- https://www.youtube.com/watch?v=P9ftIasJSfc
- https://www.youtube.com/watch?v=NQS__N4eXGc
- https://www.youtube.com/watch?v=kLHEuz3rsmk
- https://www.silent-yachts.com/silent60/

*grupos y asignación*

sistemas de refrigeración  
---------------------------------------------  
ALFARO CHAVERRI FEDERICO ALBERTO  
ALFARO GARCIA ISAAC GERMAN  
CUBILLO JARQUIN HELBERTH FABRICIO  
SEQUEIRA VARGAS ANTHONY STEVE  

entretenimiento, luces y cocina  
---------------------------------------------  
BARQUERO DIAZ JOSE PABLO  
CALVO HERNANDEZ SEBASTIAN  
ACUÑA CAMPOS CRISTOPHER ANTONIO  
UGALDE RIVAS YEINER ALONSO  

energía solar y baterías  
---------------------------------------------  
ALVARADO ANDRADE DANIELA  
CAMPOS ARGUEDAS OSCAR ANDRES  
AGUERO MATA MIGUEL EDUARDO  
KAUFFMANN PORCAR ERICK  

propulsión y motores  
---------------------------------------------  
BARQUERO BARRANTES BRYAN DANIEL  
MENDOZA MATA FIORELLA LUCIA  
FERNANDEZ SALAS JOSE DAVID  
UGALDE JIMENEZ DAVID FRANCISCO  

tratamiento de aguas  
---------------------------------------------  
MALLMA ZAMORA JUAN ERNESTO  
MONTERO ZUÑIGA AMANDA JESUS  
BRENES GARRO JOSE JULIAN  
RODRIGUEZ BRENES SEBASTIAN  
RODRIGUEZ CRUZ JORGE LUIS  

comunicaciones y navegación  
---------------------------------------------  
QUESADA CHAVES SARAH PRISCILLA  
ROBLES MATA JOSE ANDRES  
MADRIGAL CHINCHILLA JULIAN ANDRES  
VALVERDE ARGUEDAS SAMUEL  
XIE LI DAYANA  

### parte #2

una vez que tenga el diseño preliminar hecho proceda a leer las particularidades del lenguage java con respecto a tipos de datos y los arreglos en estos links https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html , https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html 

ahora usando una copia del diseño preliminar agregue a los atributos el tipo de dato respectivo a su diseño para que así empiece a parecerse a un diseño de objetos para un lenguaje determinado, en este caso java.

- fecha de revisión de las asignaciones: 10 y 12 de agosto
- fecha de entrega: jueves 18 de agosto antes de medio día
- entrega al asistente al correo: kevinqj.2002@gmail.com
- subject: poo - caso #1
- contenido: lista de los integrantes del grupo, un pdf con el diseño preliminar y otro pdf con el diseño con los atributos ajustados a los tipos de datos en java, un entregable por grupo.



# caso #2, 5%

*instituto tecnológico de costa rica*, escuela de computación  
*programación orientada a objetos*  
_prof. rodrigo núñez_  
*tipo:* individual  

## descripción
retomando el tema del yatch silent 60, el yate de energía solar, se quiere hacer una demostración de la eficiencia del consumo y carga energética del yate. para ello es necesario parametrizar valores de configuración como capacidad de carga de las baterías, velocidad de carga desde los paneles dependiendo de los niveles de sol a los que estén expuestos los páneles, velocidad en nudos del navío y el consumo de energía según la velocidad. 

cómo sería el diseño y la implementación de classes en java para el programa de demo que usted haría si debe cumplir lo siguiente: 

1. Los parámetros de carga energética y su consumo son configurables, se sabe que hay dos baterías y tres páneles pero dicha configuración se puede cambiar también, todo esto antes de correr el programa

2. La simulación debe durar entre 1.00 a 1.5 minutos máximo

3. Durante el periodo de simulación los paneles deberán estar expuestos a diferentes niveles de sol para que sea posible apreciar la velocidad de carga de las baterías

4. Durante el periodo de simulación el navío estará entre detenido hasta probar múltiples velocidades para poder corrobar el consumo energético de las baterías según la velocidad

5. El usuario podrá ver en la pantalla en todo momento el tiempo transcurrido de simulación, el nivel de energia de todas las baterías, el nivel de luz solar sobre los páneles y la velocidad del navío

6. Demuestre finalmente que es posible agregar varios otros elementos del yate que consuman energía dentro de la simulación y que esto no afecte el código realizado entre el punto #1 al #5, es decir, que puedo agregar y quitar componentes del Yate a antojo de quien configura la simulación, no importa si esto se hace desde el main, una classe con constantes o un archivo de configuración separado. 

Preliminares: 
Cómo crear un UI para el simulador en Java. Investigue y cree código ejemplo para crear una pantalla que pueda funcionar para visualizar dicho simulador en java. Deberá para ello seguir el patrón de diseño MVC.
Miércoles 24 de agosto, 1 ejemplo entre los dos 
ALFARO GARCIA ISAAC GERMAN 
BARQUERO BARRANTES BRYAN DANIEL 

Cómo funcionan los hilos y el sleep en java. Investigue y cree código ejemplo para explicar el funcionamiento de los hilos de ejecución en java esto con el fin de que dicha tecnología nos permita construir el simulador que que requiere para el demo del consumo del yate. 
Miércoles 24 de agosto, ejemplos hechos entre los dos 
QUESADA CHAVES SARAH PRISCILLA 
SEQUEIRA VARGAS ANTHONY STEVE 


En forma individual las siguientes personas presentarán un diseño borrador en dibujo de como podrían modelar dicho simulador y sus reglas de comportamiento sin considerar el punto #6.
Viernes 26 de agosto 
MADRIGAL CHINCHILLA JULIAN ANDRES 
MONTERO ZUÑIGA AMANDA JESUS 

- fecha de entrega: miércoles 31 antes de media noche
- entrega al asistente al correo: kevinqj.2002@gmail.com
- subject: poo - caso #2
- contenido: url en github con el código fuente del programa en el branch principal, en el mismo repositorio debe haber un readme.md con el modelo gráfico de objetos inicial que se hizo antes de iniciar la programación del simulador, además de las indicaciones de como se hace en su programa para configurar las reglas de carga y consumo de energía del simulador. 
