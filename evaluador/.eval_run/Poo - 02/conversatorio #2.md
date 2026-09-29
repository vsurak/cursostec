/evaluar-estudiantes
<audios>C:\dev\conversatorios\#2\poo</audios>

<tema>
There are concepts that are pillars for mastering the object-oriented paradigm in any programming language: abstraction, encapsulation, inheritance, and polymorphism. The student not only comes to master these concepts in theory and in Java, but also masters them in practice and extrapolates them to other programming languages.

Expected mastery

The student can explain real situations in class design where the principles of encapsulation are met or not met, knowing and mastering the scenarios in which the use of public, private, and protected is appropriate. They understand the effect of those modifiers on classes, constructors, methods, and instance variables.

Given example problems, they can mentally design in seconds the classes needed to solve a variety of problems, applying a correct separation of concerns.

Fully masters how inheritance is done not only in Java but also in some other language; thoroughly understands aspects associated with inheritance, such as the use of abstract classes, abstract methods, and the use of this and super when there is inheritance, in both methods and constructors. Knows how to build multi-level inheritance, how to override inherited methods, and also how to extend them when both the functionality programmed in the parent and the additional code written in the child are required in a given order; and applies those skills to real-life examples in different languages.

Is able to imagine and create new possibilities and worlds supported by polymorphism; knows and fully masters how to achieve polymorphic classes and methods by means of concrete classes, abstract classes, and interfaces. Combines polymorphism and inheritance skillfully and recognizes their particularities in Java and in some other language.

The student masters all of the above without reading documentation, and can explain it to other people fluently, with real examples and situations that could arise in programs they have built or could be building in the future.

The 4 pillars are identifiable not only in code and in theory, but also graphically using UML.
</tema>

<criterios>
1. El estudiante en su explicación logra extraer capacidades al poder de la herencia, más allá de solo la herencia de carácterístias como atributos, si no más bien, asociados a encapsulamiento y polimorfismo. 30 shares.

2. Deja claro los momentos en los que es conveniente usar herencia de clases versus interfaces, dejando claro las ventajas y momentos donde es mejor una técnica que otra. 35 shares.

3. El estudiante tiene claro las limitaciones de las interfaces pero también la flexibilidad de sus ventajas, incluso al punto que abstrae el porque el java api o alguno de los paquetes de java posee Interfaces que podemos implementar. 25 shares.

4. El estudiante logra detectar los problemas en el diseño presentado y puede proponer un mejor diseño que arregle el presentado. 25 shares.

Diseño presentado:
```
@startuml

class TransaccionDinero {
    - monto : double
    - fecha : Date
    - tipoTransaccion : String
    - descripcion : String
    - tipoCambio : double
}

class Persona {
    - nombre : String
    - cedula : String
    - direccion : String
    - invoice : Invoice   // ❌ Error: debería ser una colección (muchos invoices)
}

class Invoice {
    - numero : String
    - monto : double
    - fecha : Date
    - transaccion : String
    - moneda : String
    - saldo : double
    - dirigidoA : String
}

Persona -- Invoice : tiene 1
Persona --|> TransaccionDinero : ❌ Error de herencia

@enduml
```
</criterios>

<estudiantes>
ZUNIGA ARROYO PATRICK SEBASTIAN,MartePerla
ZUNIGA PICADO DAVID,NeptunoJade
MADRIGAL CAMPOS ANDRES,PoseidonNaranja
FERNANDEZ CASTRO ANTHONY,HeraNegro
COREA HERRERA STEVEN FERNANDO,OdinVerde
HERNANDEZ CAMACHO IGNACIO,AteneaBlanco
VARGAS VARGAS GABRIEL,VulcanoBronce
SANCHEZ POVEDA DANIEL,IsisBeige
</estudiantes>

<notas del profesor>
ZUNIGA PICADO DAVID,NeptunoJade
-	Adaptación de cambios por medio de override donde se incluyen los métodos por el extend y a partir de ahí usando los métodos del padre en el hijo

MADRIGAL CAMPOS ANDRES,PoseidonNaranja
-	Uno de los principales usos del polimorfismo si tenemos una cuenta bancaria abstracta, tiene info base de una cuenta, monto, identificación, etc pero pueden haber tipos de cuentas, que cambian el como se usan los intereses, si hay herencia, en fechas de corte puedo actualizar las cuentas por un método de actualizar, y la principal si suma un interés. 
-	En el caso especifico dnd una clase debe utilizar múltiples comportamientos, puede ser que esos comportamientos sean de un linaje de herencia, en el caso de que son iguales o similares, si son cosas diferentes, podría usar una interface, si tengo una clase de transporte que viajan de A a B, etos métodos de moverse pueden ser métodos de la interface de transporte, incluso aunque no sean iguales. Y puedo agregar más de una interface en una sola clase. 

ZUNIGA ARROYO PATRICK SEBASTIAN,MartePerla
-	Si cobra sentido cuando se trabaja con listas o arreglos porque en una colección puede tener referencias  a tipo padre, pero las referencias son a objetos específicos como tener lista de objetos Animal pero gracias a la sobreescritura y dinamismo resuelve cual implementación se va invocar 
-	Si sigo agregando más clases entonces solo implemento lo nuevo
-	Hace otro ejemplo adicional sobre los instrumentos de una orquesta
-	También puedo usar composición para agregar comportamientos específicos de otros objetos hace que no requiera de una jerarquía rígida. 
-	Uber un usuario quiere pedir un servicio, no le interesa los componentes del vehículo, solo la generalidad, la abstracción es fundamental en eso, en el sentido importa más el comportamiento y no tanto lo que pasa por abajo, eso hace que se conviertan en programas más amigables con el usuario. Se puede llegar a abstraer demasiado es cuando no es necesario, hay que tener un balance que sean más generalizadas y otras más abstractas. 

FERNANDEZ CASTRO ANTHONY,HeraNegro
-	Siento que la mejor parte del polimorfismo en listas y estructuras de datos, por la naturaleza de java no puedo hacer listas de varios tipos de datos, sin embargo con el polimorfismo puedo poner cosas mezcladas que se adaptan a lo que la clase padre puede hacer, haciendo mucho más fácil hacer una lista con todas las cuentas de un banco sin importar el tipo de cuenta que es. 
-	En interfaces se pueden standarizar nombres de la serie de funciones, es en plan de no estar viendo si pusiste en la clase compu abrir o reparar, no tengo que revisar y evito errores, es más fácil expandir un inventario por ejemplo de una tienda. Si puedo terminar con varias cosas que no tienen relación directa de herencia, pero si ocupan que tenga cosas que sean iguales, como aplicar una garantía o reparar, no es lo mismo pero puedo tener el mismo nombre , reduciendo cantidad de sets. 
-	Las clases abstractas una vez que haces una hija tenes la obligación de implementar los métodos de la clase abstracta no puedes no tenerla. Siempre hay que implementar cuando se va  utilizar. 

HERNANDEZ CAMACHO IGNACIO,AteneaBlanco
-	En el caso de clases abstractas funcionan como esqueletos para las demás, no puede instanciarse , están hechas para que otras puedan heredarlas e implementarles. 
-	No hay herencia múltiples, entonces hay que usar intefaces o clases para tener comportamiento diferente. Como por ejemplo el uso de Thread y Runnable , es un buen ejemplo de eso.
-	Destaco heredar demasiado grande puede ser peligroso , si altero el Padre sin intención alterar el comportamiento de clases hijas, a veces se prefiere crear un objeto nuevo dentro de una clase en lugar de heredar de una clase demasiado grande.
-	El abstract puede usarse cuando no se quiere que una clase sea instanciada, le dice al código que no puede hacerla con new, básicamente se crea solo para ser padre.  Muchas veces se combina ese abstract con el polimorfismo, por ejemplo tener una clase figura y tener un método calcularArea, de esa forma los hijos pueden definir el método. 

COREA HERRERA STEVEN FERNANDO,OdinVerde
-	En ese caso dado que son facturas, debería ser transacción de dinero ser Padre y Persona es la hija, donde la clase padre tendría solo los datos para reemplazarlos por la Persona, en lugar de hacer una Perona nueva en cada factura. 
-	Declarar en las clases hijas A,B, C, D podría poner como por ejemplo lo del carro, pongo solo las cosas superficiales y lo demás que está por detrás sería como el motor y las piezas, solo se modifica la clase padre en lugar de modificar las clases hijas donde solo tenemos la info necesaria. 
-	Usar encapsulamiento en la clase padre las piezas que ya ese carro lleva en el motor y tipo de tornillos. 

Martin Rojas
-	Debería ser un collection de invoices un vector de invoices 
-	Transacción de dinero Heredia de persona, pero la persona no hace la transacción de dinero 
-	Martin rojas sugiere usar una interface para modificar A,B,C,D classes para todas se accedan desde un mismo punto. Efectivamente es indicio de facade.

VARGAS VARGAS GABRIEL,VulcanoBronce
-	Tal vez el tipo de cambio podría ser un final static puesto en persona de forma que no podría cambiarse.
-	Creo que Persona debería ser el padre de la transacción y no al revés, que podría heredar cédula o nombre de la persona en lugar de ponerla para cada transacción
-	Tal vez algún tipo de abstracción donde se use una clase abstracta como molde para formar A,B,C,D entonces seguro solo cambio el molde y no la que está llamando la clase en si. Solo habría problema si se cambia el nombre de un método. 

SANCHEZ POVEDA DANIEL,IsisBeige
-	Uno de los principales aspectos es que se tiene el tipo de cambio de transacción dinero, pero ese tipo de cambio podría ser modificado por Persona, podría aplicarse un encapsulamiento para que no se modifique por fuera. Mediante el código podría cambiar tipo de campo, fechas, si fueran cuentas bancarias, visualmente podría revelar datos que afectan al consumidor. 
-	Transaccion y Dinero podrían ser sobre escritos podrían modificar los datos y crear inconsistencias.
-	Lo primero es aplicar algún encapsulamiento dependiendo de los datos que se puedan usar, al cambiar una clase le tipo de datos se va alterar el comportamiento de las otras. Hacer un encapsulamiento para proteger los datos como privado para que solo se pueda modificar a la relación principal, y así no tener que cambiarlas en todas las relaciones.
</notas del profesor>
