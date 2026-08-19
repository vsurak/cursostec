/*
Nombres de clase: La primer letra en mayúscula, esto por lo general son sustantivos o entidades, 
cosas reales, su nombre en Singular. 
Ej. Arbol, Casa, Carro, Persona. 

Atributos: La primer letra minúscula, y si son varias palabras juntas, la primer letra de las 
segunda palabra en adelante, en mayúscula. son adjetivos, características de la clase. 
Ej. impuestoDeVenta, fechaIngreso, cantidadSeleccionada

Métodos: mismo estandard de nombres que los atributos, pero inicia con un verbo, porque esto es comportamiento, es acción.
Ej. cantar(), extraerDatos(), obtenerEdad(), animarMovimiento()
*/

/*
    public: esto es un modificador de visibilidad, quiere decir que este método puede ser invocado desde cualquier otra clase
    
    void: lo que retorna el método, por ejemplo int, boolean, float, en el caso de void significa que no retorna nada
    ejemplo: 
    // estoy declarando que el método debe retornar un número int
    public int sumar(int valor1, int valor2) {
        return valor1+valor2;
    }

    cantar() : el nombre del método y los parámetros que recibe, dado que es (), significa que no recibe parámetros. 
    Los parámetros se pasan igual como declarar atributos  <tipoDeDato> etiqueta, y se separan por coma, por ejemplo, el 
    código del método sumar de arriba. 
*/

public class Persona {
    byte edad;
    String nombre;

    // constructor no tiene valor de retorno, y debe llamarse igual que la clase
    public Persona() {
        // inicializar persona con sus datos, edad y nombre. 
        edad = 48;
        nombre = "rodrigo nunez";
    }

    public void cantar() {
        // impriman un verso de no más de 4 líneas, de una canción que les guste y el autor. 
        System.out.println("Ya me siento un niño de papel que vive con miedo de olvidar" + "\n" +
            "Cuando sonrojabas esas mejillas con sentimientos de cristal" + "\n" +
            "Por la noche, exploto y pienso en terminar con todo y volver a mí" + "\n" +
            "Hoy la vida llora porque perdió otra hermosa flor de su jardín."  + "\n" + 
            "Milo J");
    }
}