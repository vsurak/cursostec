public class Dealer extends Persona {
    private int cantidadDrogas;
    private final int PRECIO_DROGA = 2000;  // final indica que esa variable puede ser escrita únicamente una vez
    private int dinero;

    public Dealer(String pName, int pCantidadDrogas) {
        this.nombre = pName;
        this.cantidadDrogas = pCantidadDrogas;
        this.dinero = 0;
    }

    public int vender(int pCantidad) {
        int vendido = 0;
        if (pCantidad<=this.cantidadDrogas) {
            vendido = pCantidad;
        } else {
            vendido = this.cantidadDrogas;
        }

        //this.dinero = this.dinero + (pCantidad * PRECIO_DROGA);
        this.dinero += vendido * PRECIO_DROGA;  // esto hace lo mismo que arriba es operar una variable sobre si misma, por ejemplo  x=x+2 -->   x+=2;  -=, *=, /=, %=
        this.cantidadDrogas -= vendido;

        System.out.println("Otro cliente feliz con "+vendido+" de producto.");
        return vendido;
    }

    public void escapar() {
        System.out.println("Voy jalando....");
    }

}