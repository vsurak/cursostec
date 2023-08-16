package player;

public class Player {
	private String nombre;
	private int puntos;
	private Carro currentCarro;
	
	public Player(String pNombre, Carro pCarro) {
		this.nombre = pNombre;
		this.puntos = 0;
		this.currentCarro = pCarro;
	}
	
	public void acelerar() {
		System.out.println("Jugador "+this.nombre+" esta acelerando");
		this.currentCarro.acelerar();
	}
}
