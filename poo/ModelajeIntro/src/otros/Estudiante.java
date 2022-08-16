package otros;

import java.util.Random;

public class Estudiante 
{
	private String Nombre;
	private int Carne;
	private float Nota;
	
	public Estudiante(int pCarne, String pNombre)
	{
		Random rand = new Random();
		Nombre = pNombre;
		Carne = pCarne;
		Nota = 40+rand.nextInt()*61;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getCarne() {
		return Carne;
	}
	
	public String getCarneStr() {
		return Carne+"";
	}	

	public void setCarne(int carne) {
		Carne = carne;
	}

	public float getNota() {
		return Nota;
	}

	public void setNota(float nota) {
		Nota = nota;
	}
	
	
}
