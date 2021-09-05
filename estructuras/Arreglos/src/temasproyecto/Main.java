package temasproyecto;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		UsoArchivo archivo = new UsoArchivo("pruebaSerializacion.se");
		
		//objeto a serializar
		Objeto objetillo = new Objeto();
		objetillo.setTexto("Hola, esto se enviará a otro objeto");
		objetillo.setNumero(12);
		
		Objeto objeto3 = new Objeto();
		objeto3.setNumero(25);
		objeto3.setTexto("Hola");
		
		//se serializa el objeto
		Serializacion<Objeto> se = new Serializacion<Objeto>();
		archivo.escribirArchivo(se.serializar(objetillo));
		
		//Deserializa el objeto
		Objeto objeto2 = se.deserializar(archivo.leerArchivo());
		
		//Print del segundo objeto
		System.out.println(objeto2.getNumero() + " " + objeto2.getTexto());
		
		archivo.escribirArchivo(se.serializar(objeto3));
		objeto2 = se.deserializar(archivo.leerArchivo());
		
		System.out.println(objeto2.getNumero() + " " + objeto2.getTexto());
	}

}
