package ejercicios.gato;

public class VentanaJuego 
{
	private Gato GatoRules;
	
	public VentanaJuego(Gato pGato)
	{
		GatoRules = pGato;
	}
	
	public void limpiarAreaJuego() {
		System.out.println(this.getClass().toString()+ " Se limpia el area de juego en la ventana");
	}
	
	public void ejecutarTurno(Jugador pPlayer)
	{
		System.out.println(this.getClass().toString()+ " Le toca jugar a "+pPlayer.getNombre());
		GatoRules.setMovida(3, 2, pPlayer);
	}
	
	public void anunciarResultado(Jugador pPlayer)
	{
		System.out.println(this.getClass().toString()+ " El ganador es "+pPlayer.getNombre());
	}
	
	public void preguntarContinuar() 
	{
		System.out.println(this.getClass().toString()+ " Desea volver a jugar? S/N?");
	}
}
