package slot.logic;

import java.util.Random;
import slot.library.*;

public class SlotMachine 
{
	/*
	 * Constantes para la clase SlotMachine
	 */
	private final int MAX_AMOUNT_OF_CREDITS = 2000;
	private final int CANTIDAD_DE_REELS = 3;
	private final int CANTIDAD_FIGURAS_POR_REEL = 20;
	private final int MAX_CREDITS_TO_PLAY = 3;
	
	private int Creditos;
	private int CreditosPaid;
	private int CreditosPlayed;
	private Simbolo[] Payline;
	private Reel[] Reels;
	private PayTable TablaPagos = new PayTable();
	
	// lista de figuras disponibles para mi juego
	private String[] ListaFiguras = 
		{
			"Wild",
			"7 Rojo",
			"7 Blanco",
			"7 Azul",
			"3 Bar Blue",
			"2 Bar White",
			"1 Bar Red",
			"Blank"
		};
	
	/*
	 * Constructor
	 */
	public SlotMachine()
	{
		this.Creditos = MAX_AMOUNT_OF_CREDITS;
		this.CreditosPaid=0;
		this.CreditosPlayed=0;
		Payline = new Simbolo[CANTIDAD_DE_REELS];
		Reels = new Reel[CANTIDAD_DE_REELS];
		
		crearReels();
	}
	
	/*
	 * Metodos publicos
	 */
	
	public void spin()
	{
		System.out.println("Haciendo spin...girando");
		for(int reelGirando=0; reelGirando<CANTIDAD_DE_REELS; reelGirando++)
		{
			Payline[reelGirando] = Reels[reelGirando].girar();
		}
		System.out.println(Payline[0].getFigura()+" "+Payline[1].getFigura()+" "+Payline[2].getFigura());
	}
	
	public void calcularCreditos()
	{
		CreditosPaid = TablaPagos.calcularPago(Payline, (short)CreditosPlayed);
		Creditos = Creditos - CreditosPlayed;
		Creditos = Creditos + CreditosPaid;
		
		System.out.println("Creditos: "+Creditos + 
						   " Creditos Jugados: "+ CreditosPlayed+
						   " Ganado: "+	CreditosPaid);
	}
	
	public void setCreditosToPlay(int pAmout)
	{
		CreditosPlayed=pAmout;
	}
	
	/*
	 * Metodos privados
	 */
	
	private void crearReels()
	{
		Random rand = new Random();
		
		// recorro el arreglo de Reels
		for (int indexReels=0; indexReels<CANTIDAD_DE_REELS; indexReels++)
		{
			Reels[indexReels] = new Reel(CANTIDAD_FIGURAS_POR_REEL);
			
			// Agrego a cada Reel del arreglo la cantidad de figuras que se ocupe para llenarlo
			for(int cuentaFiguras=0; cuentaFiguras<CANTIDAD_FIGURAS_POR_REEL; cuentaFiguras++)
			{
				// escojo una figura aleatoria de la lista, uso la posicion del arreglo como el Id
				int id = rand.nextInt(ListaFiguras.length); // sumo 1 para no seleccionar el primer elemento de la lista de figuras
				
				// creo el simbolo
				Simbolo nuevo = new Simbolo(id,ListaFiguras[id]);
				// le digo al objeto Reel que esta en el arreglo Reels en la posicion indicada que agregue
				// el nuevo simbolo creado
				Reels[indexReels].agregarSimbolo(nuevo);
			}
		}
	}
		
	
}
