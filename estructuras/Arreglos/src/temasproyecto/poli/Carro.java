package temasproyecto.poli;

import java.awt.Color;

public class Carro extends Vehiculo
{
	private boolean Automatico;
	private Color Color;
	private int CantidadPuertas;
	private boolean LucesEncendidas;
	
	public Carro(boolean isAutomatic, Color pColor, int pCantPuertas)
	{
		Automatico = isAutomatic;
		Color = pColor;
		CantidadPuertas = pCantPuertas;
		LucesEncendidas = false;
	}
	
	public void encenderLuces()
	{
		LucesEncendidas=!LucesEncendidas;
	}
	
	public void acelerar(int pVelocidad)
	{
		System.out.println("Metodo acelerar en carro");
	}
}
