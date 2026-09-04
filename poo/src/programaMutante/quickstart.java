package programaMutante;

import personas.*;
import poderes.*;
import profesiones.*;

public class quickstart {
    public static void main(String[] args) {
        System.out.println("Hello clase de Poo");

        Persona rodri = new Persona();
        Persona p1 = new Persona("Juliana Lopez", (byte)22); // transformando o casteando cast, ese 22 de int a byte

        System.out.println(rodri.getNombre());
        rodri.cantar();

        System.out.println("-----------------------------");

        String nombreResultado = p1.getNombre();
        System.out.println(nombreResultado);
        p1.cantar();

        System.out.println("-----------------------------");

        System.out.println("Edad de "+rodri.getNombre()+ " " +rodri.getEdad());
        rodri.setEdad((byte)18);
        System.out.println("Edad de "+rodri.getNombre()+ " "+rodri.getEdad());

        System.out.println("-----------------------------");

        // aquí no hubo new, solo es un apuntador a la misma instancia a la que apunta p1
        Persona xyz = p1;
        System.out.println("Edad de "+p1.getNombre()+ " " +p1.getEdad());
        System.out.println("Edad de "+xyz.getNombre()+ " "+xyz.getEdad());

        xyz.setEdad((byte)27);
        System.out.println("Edad de "+p1.getNombre()+ " " +p1.getEdad());

        rodri = xyz; // si se hace esto, entonces los 3 punteros (nombres de variable), apuntarían
        // a la misma instancia. Y la instancia (fragmento de memoria), quedaría innaccesible. 
        //rodri == xyz == p1 ?? es true

        Dealer dani = new Dealer("Daniel Escobar", 200);

        dani.vender(30);
        System.out.println("Ahora "+dani.getNombre()+ " tiene "+dani.getDinero());

        dani.cantar();
        //dani.nombre = "Pedro Escobar"; esto no se puede porque es protected

        System.out.println("Ahora "+dani.getNombre()+ " tiene "+dani.getDinero());
        dani.setNombreFalse();
        System.out.println("Ahora "+dani.getNombre()+ " tiene "+dani.getDinero());

        dani.reducirDeudaConIngreso(1500);

        // probando el poder de la herencia en Persona y el polimorfismo de IPower y de Persona

        Persona profesionales[] = new Persona[10];
        IPower poderesDisponibles[] = {new PoderTiraCorazones(), new PoderTiraDinero()};

        for (int i = 0; i < 10; i++) {
            int tipoProfesion = (int)(Math.random()*3);
            System.out.println(tipoProfesion);
            switch (tipoProfesion) {
                case 0:
                    profesionales[i] = new Dealer("Gato "+i, 40*i);
                    break;
                case 1:
                    profesionales[i] = new Lavador("Baruch "+i, 55);
                    break;
                case 2:
                    profesionales[i] = new Narco("Pedro Oscobar "+i, i+10);
                    break;
                default:
                    profesionales[i] = new Dealer("Gato "+i, 40*i);
            }
            profesionales[i].setPower(poderesDisponibles[(int)(Math.random()*2)]);
        }

        for(Persona p : profesionales) {
            System.out.println("Ataca "+p.getNombre());
            p.atacar();
        }
    }
}
