public class TestAntipatterns {
    public static void main(String args) {
        // si lo hago con statics todo el contenido de la clase se sostiene en segmento de código
        MuyMalaClass.doSomething();
        MuyMalaClass.doSomethingElse();

        // Si requiero tener este mismo efecto pero con una instancia controlada usamos singleton
        // el singleton me permite acceder y usar atributos y métodos de instancia sin usar static
        // y asegurando la existencia de una sola instancia
    }
}
