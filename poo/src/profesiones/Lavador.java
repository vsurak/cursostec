package profesiones;

import java.util.Vector;
import personas.Persona;

public class Lavador extends Persona {
    private Vector<String> propiedades;
    private double dineroInvertido;

    public Lavador(String pNombre, int pEdad) {
        super(pNombre, (byte) pEdad);
        propiedades = new Vector<String>();
        dineroInvertido = 0;
    }

    public void comprarPropiedad(String pPropiedad, double pMonto) {
        propiedades.add(pPropiedad);
        dineroInvertido += pMonto;
        System.out.println(this.getNombre()+" compró "+pPropiedad+" por "+pMonto);
    }

    public void venderPropiedad(String pPropiedad, double pMonto) {
        if (propiedades.remove(pPropiedad)) {
            dineroInvertido -= pMonto;
            System.out.println(this.getNombre()+" vendió "+pPropiedad+" por "+pMonto);
        } else {
            System.out.println(this.getNombre()+" no tiene la propiedad "+pPropiedad);
        }
    }

    public double getDineroInvertido() {
        return dineroInvertido;
    }

    public int getCantidadPropiedades() {
        return propiedades.size();
    }
}
