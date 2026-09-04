package profesiones;

import personas.Persona;

public class Dealer extends Persona {
    private int cantidadDrogas;
    private final int PRECIO_DROGA = 2000;  // final indica que esa variable puede ser escrita únicamente una vez
    private final double IMP_VENTAS = 0.13;
    private int dinero;
    private String nombresNarcos[] = {"Macho Coca", "Alejandro de los Cielos", "Gato"};

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

    public int getDinero() {
        return this.dinero;
    }

    public void setNombreFalse() {  
        this.nombre = nombresNarcos[(int)(Math.random()*3)];
        //this.edad = (byte)34; esto no se puede hacer porque edad es private en el padre
    }

    @Override
    public void reducirDeudaConIngreso(double pIngreso) {
        pIngreso -= pIngreso*IMP_VENTAS;
        super.reducirDeudaConIngreso(pIngreso);
    }

    public void escapar() {
        System.out.println("Voy jalando....porque tengo "+this.getEdad()+" años");
    }
}