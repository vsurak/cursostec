import java.util.Vector;

public class Narco extends Persona {
    private Vector<Dealer> dealers;
    private Vector<Lavador> lavadores;

    public Narco(String pName, int pEdad) {
        super(pName,(byte)pEdad); // cuando se desea llamar al constructor del padre, se debe hacer solo dentro de otro constructor y debe ser la primer línea de código
        dealers = new Vector<Dealer>();
        lavadores = new Vector<Lavador>();
    }

    public void contratarDealer(Dealer pDealer) {
        dealers.add(pDealer);
        System.out.println(pDealer.getNombre()+" ahora trabaja con "+this.getNombre());
    }

    public void contratarLavador(Lavador pLavador) {
        lavadores.add(pLavador);
        System.out.println(pLavador.getNombre()+" ahora lava para "+this.getNombre());
    }

    // estoy encapsulando al no exponer la lista de dealers, solo retorno la cantidad
    public int getCantidadLavadores() {
        return lavadores.size();
    }

    public int getCantidadDealders() {
        return dealers.size();
    }

    //un sabor del polimorfismo
    public void despedir(Persona pPersona) {
        if (pPersona!=null) {
            if (pPersona instanceof Dealer dealer) {
                dealers.remove(dealer);
            } else if (pPersona instanceof Lavador lavador) {
                lavadores.remove(lavador);
            }
        }
    }
}