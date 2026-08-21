
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

    }
}
