package game;

import player.Carro;
import player.Player;
import track.Pista;

public class Juego {
	private Pista pistaActual;
	private Carro carroActual;
	
	// <visibilidad> <tipo de dato de retorno> <nombre del metodo>([<parameters>]) { }
	public void seleccionarCarroyPista(Carro pCarroSeleccionado, Pista pPistaDeCarrera) {
		this.pistaActual = pPistaDeCarrera;
		this.carroActual  = pCarroSeleccionado;
		System.out.println("El jugador ha seleccionado la pista "+pistaActual.getLocation()+" con el carro "+carroActual.getNombre());
	}
	
	public void start() {
		System.out.println("La carrera ha iniciado");
		pistaActual.start();
	}

	public void evaluarPosicion() {
		System.out.println("evaluo la posicion del carro en la pista");
	}
	
	public void terminar() {
		System.out.println("El jugador ha llegado a la meta...FIN!!");
	}
	
	// es el punto de entrada de un programa en java, el main
	public static void main(String args[]) {
		System.out.println("Iniciando juego");
		
		Carro ferrari = new Carro("El ferrari");		
		Carro lambo = new Carro("el lambo");
		Carro bmw = new Carro("el bmw");
		
		Pista track1 = new Pista("Costa Rica");
		Pista track2 = new Pista("Philiphines");
		
		// 1. Juego.seleccionarCarroyPista(Carro, Pista);
		// 1.1. Carro.asignarPista(Pista);
		// 2. Juego.start();
		// 2.1 Pista.start();

		Juego miGame = new Juego();
		miGame.seleccionarCarroyPista(ferrari, track2);
		ferrari.asignarPista(track2);		
		miGame.start();
		
		// 3.Player.acelerar();
		// 3.1 Carro.acelerar();
		Player profe = new Player("rodrigo", ferrari);
		profe.acelerar();
		
		// 4. Juego.evaluarPosicion(Carro, Pista);
		miGame.evaluarPosicion();
		
		// 5. Carro.left() or Carro.right();		ferrari.moveLeft();
		ferrari.moveRight();

		// 6. Juego.evaluarPosicion(Carro, Pista);
		miGame.evaluarPosicion();
		
		// 7. Juego.terminar();
		miGame.terminar();
	}
}
