package slot.library;

import java.util.Random;

public class Reel 
{
	private Simbolo[] Figuras = null;
	private int CurrentVacia = 0;
	
	/*
	 * Constructor que define la cantidad de figuras del Reel
	 */
	public Reel(int pCantidadFigurasPorReel)
	{
		Figuras = new Simbolo[pCantidadFigurasPorReel];
	}
	
	/*
	 * Metodos
	 */
	
	public Simbolo girar() 
	{
		Simbolo result = null;
		
		Random rand = new Random();
		
		result = Figuras[rand.nextInt(Figuras.length)];
		
		return result;
			
	}
	
	public boolean agregarSimbolo(Simbolo pSimb)
	{
		boolean result = false;
		if (CurrentVacia<Figuras.length)
		{
			Figuras[CurrentVacia++] = pSimb;
			result = true;
		}
		return result;
	}
}
