package ejercicios.gato;

import java.util.Random;

public class ControladorDeJuego 
{
	private VentanaJuego Ventana;
	private Jugador Jugador1;
	private Jugador Jugador2;
	private Gato JuegoGato;
	
	public ControladorDeJuego()
	{
		JuegoGato = new Gato();
		Ventana = new VentanaJuego(JuegoGato);
	}
	
	public void iniciarJuegoNuevo() 
	{
		System.out.println(this.getClass().toString()+ " Iniciar un juego nuevo");
		JuegoGato.limpiarAreaJuego();
		Ventana.limpiarAreaJuego();
		
		Jugador1 = solicitarJugador();
		Jugador2 = solicitarJugador();
		
		empezarPartida();
	}
	
	private Jugador solicitarJugador()
	{
		Random rand = new Random();
		System.out.println(this.getClass().toString()+ " Solicitando datos de un jugador");
		Jugador player = new Jugador();
		player.setNombre("Pedro"+rand.nextInt());
		player.setFicha(TipoFicha.CIRCULO);
		return player;
	}
	
	private void empezarPartida()
	{
		System.out.println(this.getClass().toString()+ " Inicia la partida de juego");
		
		while(ejecutarTurno(Jugador1)==GatoResultado.NONE);
		
		terminarPartida();	
	}
	
	private GatoResultado ejecutarTurno(Jugador pPlayer)
	{
		System.out.println(this.getClass().toString()+ " Se ejecuta el turno del jugador "+pPlayer.getNombre());
		Ventana.ejecutarTurno(pPlayer);
		
		return JuegoGato.evaluarJuego(); 

	}
	
	private void terminarPartida()
	{
		System.out.println(this.getClass().toString()+ " Ya hay que terminar la partida");
		Ventana.anunciarResultado(Jugador1);
		Ventana.preguntarContinuar();
	}
}
