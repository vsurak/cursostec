package modelos.basic;

public class Radio 
{
	private short Volumen;
	private float Frecuencia;
	
	public Radio() // constructor sin parametros
	{
		Volumen = 20;
		Frecuencia = 104.7f;
	}
	
	public Radio(short pVolumen, float pFrecuencia) // :) :) :) 
	{
		setVolumen(pVolumen);
		setFrecuencia(pFrecuencia);
	}
	
	public Radio(float freq, short pVol) // asignar directo los atributos esta bien, pero a futuro puede ser mas estrategico utilizar los getters y setters
	{
		Volumen=pVol;
		Frecuencia = freq;
	}
	
	public short getVolumen() {
		return Volumen;
	}
	
	public void setVolumen(short volumen) 
	{
		Volumen = volumen;
		// lllamar a un objeto que efectivamente le sube le cambia el volumen al speaker
	}
	
	public float getFrecuencia() {
		return Frecuencia;
	}
	
	public void setFrecuencia(float frecuencia) {
		Frecuencia = frecuencia;
	}
	
	public void incrementarVolumen(short pCantidad)
	{
		
	}
	
	public void decrementarVolumen(short pCantidad)
	{
		
	}
	
	public void incrementarFrecuencia()
	{
		
	}
	
	public void decrementarFrecuencia()
	{
		
	}
	
	public void seek()
	{
		
	}
	
}
