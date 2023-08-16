package track;

public class Pista {
	// en java como standard de programacion
	// los atributos son normalmente private
	// y se acceder por métodos públicos que llamamos getters and setters
	// gets para leer y sets para escribir
	
	private String location;
	
	public Pista(String pLocation) {
		this.location = pLocation;
	}
	
	public String getLocation() {
		return this.location;
	}
	
	public void start() {
		System.out.println("Start pista "+this.location);
	}
}
