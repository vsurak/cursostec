/*
Nombres de clase: La primer letra en mayúscula, esto por lo general son sustantivos o entidades, 
cosas reales, su nombre en Singular. 
Ej. Arbol, Casa, Carro, Persona. 

Atributos: La primer letra minúscula, y si son varias palabras juntas, la primer letra de las 
segunda palabra en adelante, en mayúscula. son adjetivos, características de la clase. 
Ej. impuestoDeVenta, fechaIngreso, cantidadSeleccionada, cantidad, tamaño

Métodos: mismo estandard de nombres que los atributos, pero inicia con un verbo, porque esto es comportamiento, es acción.
Ej. cantar(), extraerDatosFinancieros(), obtenerEdad(), animarMovimiento()

Parámetros de los métodos: los nombres de los parámetros van a iniciar con p minúscula, y la siguiente letra en 
mayuscula, siguiendo camelCase
*/

/*
    public: esto es un modificador de visibilidad, quiere decir que este método puede ser invocado desde cualquier otra clase
    
    void: lo que retorna el método, por ejemplo int, boolean, float, en el caso de void significa que no retorna nada
    ejemplo: 
    // estoy declarando que el método debe retornar un número int
    // en los métodos, los parámetros se separan por comas
    // los braces { }, enmarcan lo que llamamos un scope, los scopes son espacios de memoria donde
    // viven los objetos y delimitan su acceso, es decir por ejemplo:
    {
        int x = 10; -- x se crea y existe dentro de este contexto
        {
            int y = 11;  -- y se crea y existe dentro de este contexto 
            y = y + x; -- se puede acceder a x, porque este contexto interno está dentro del contexto de más afuera donde fué declarado x
        } -- una vez que se termina el contexto, los objetos y variables creadas adentro desaparecen
        x = x * y; -- esto sería un error, porque y solo existía en el contexto de adentro
    }

    public int sumar(int valor1, int valor2) {
        return valor1+valor2;
    }

    cantar() : el nombre del método y los parámetros que recibe, dado que es (), significa que no recibe parámetros. 
    Los parámetros se pasan igual como declarar atributos  <tipoDeDato> etiqueta, y se separan por coma, por ejemplo, el 
    código del método sumar de arriba. 

    // quiere decir que el método, no retorna nada porque es void y no recibe parámetros. 
    public void cantar() {
    }
*/

public class Persona {
    byte edad;
    String nombre;

    // constructor no tiene valor de retorno, y debe llamarse igual que la clase
    public Persona() { // los constructores primero reservan memoria y luego se ejecutan
        // inicializar persona con sus datos, edad y nombre. 
        edad = 48;
        nombre = "rodrigo nunez";
    }

    // Un segundo constructor que si recibe parámetros
    public Persona(byte pEdad, String pNombre) {
        this.edad = pEdad;
        this.nombre = pNombre;
    }

    // java y en general los lenguajes de programción orientados a objetos 
    // distinguen las firmas de los métodos por el nombre del método
    // y el orden de los tipos de datos, NO DE LOS NOMBRES DE LOS PARÁMETROS; si no del DataType

    public Persona(String pNombre, byte pEdad) {
        this.edad = pEdad;
        this.nombre = pNombre;
    }

    public Persona(String nombre) {
        this.edad = 0; // asigna un valor por default
        this.nombre = nombre;  // a pesar de que el parámetro se llama igual al atributo, 
        // java no sufre de ambiguedad, porque el puntero this, se refiere a estrictamente
        // esta instancia, por lo que accede al atributo de la instancia.
    }

    public String getNombre() {
        return this.nombre;
    }

    // a esto se le va a llamar getters and setters
    // métodos get para leer los valores de los atributos de la instancia
    // métodos set para escribir los valores de los atributos de la instancia
    public byte getEdad() {
        return this.edad;
    }

    public void setEdad(byte pEdad) {
        this.edad = pEdad;
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