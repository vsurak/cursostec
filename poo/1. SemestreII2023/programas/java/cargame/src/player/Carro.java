package player;

import track.Pista;

public class Carro {
	private String nombre;
	private Pista currentTrack;

	
	public Carro(String pNombre) {
		this.nombre = pNombre;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void asignarPista(Pista pPista) {
		this.currentTrack = pPista;
		System.out.println("Al carro "+this.getNombre()+" se le asigno la pista: "+pPista.getLocation());
	}
	
	public void acelerar() {
		System.out.println("El carro "+this.getNombre()+" esta acelerando");
	}
	
	public void moveLeft() {
		System.out.println("el carro esquiva hacia la izquierda");
	}

	public void moveRight() {
		System.out.println("el carro esquiva hacia la derecha");
	}

}
