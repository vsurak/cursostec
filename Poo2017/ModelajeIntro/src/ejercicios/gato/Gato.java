package ejercicios.gato;

import java.util.Random;

public class Gato 
{
	
	public void limpiarAreaJuego()
	{
		System.out.println(this.getClass().toString()+ " Se limpia el area de juego");
	}
	
	public void setMovida(int x, int y, Jugador pPlayer)
	{
		System.out.println(this.getClass().toString()+ 
							" Registro cual fue la jugada del jugador "+pPlayer.getNombre());
	}
	
	public GatoResultado evaluarJuego()
	{
		System.out.println(this.getClass().toString()+ " Evaluando si hay ganador");
		
		Random rand = new Random();
		return rand.nextInt(100)>85?GatoResultado.CIRCULO:GatoResultado.NONE;
	}
	
}
