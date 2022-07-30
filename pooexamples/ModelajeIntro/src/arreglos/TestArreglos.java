package arreglos;

import java.util.Random;

public class TestArreglos {

	public static void main(String[] args) 
	{
		int[] numeros = new int[10];
		int[] lista;
		
		boolean[] banderas = new boolean[7];
		float[] residuos = new float[4];
		String[] nombres = new String[5];
		String[] animales = {"Perro", "Cabra", "Gato"};
		Casa[] propiedades = new Casa[4];
		String[] colores = {"Verde","Azul","Amarillo","Rojo","CEleste","Blanca","Negra","Morada","Anaranjado","Cafe","Gris","Magenta"};
		
		
		numeros[2] = 35;
		numeros[6] = 40;
		numeros[1] = numeros[2] + numeros[6];
		
		for(int i=0; i<numeros.length; i++)
		{
			numeros[i]-=1;
		}
		
		banderas[1]=true;
		banderas[3]=false;
		
		if (banderas[1] && banderas[3])
		{
			banderas[0] = banderas[1] || banderas[3];
		} else {
			banderas[0] = banderas[1] || banderas[3] && true;
		}
		
		
		nombres[0] = "Ana";
		nombres[1] = "Maria";
		nombres[2] = "Juan";
		nombres[3] = "Pedro";
		nombres[4] = "Jorge";

		int cuentaNombres = nombres.length-1;
		while (cuentaNombres>=0)
		{
			System.out.println(nombres[cuentaNombres]);
			cuentaNombres--;
		}
		
		Random rand = new Random();
		cuentaNombres = 0;
		for(;cuentaNombres<animales.length;cuentaNombres++)
		{
			animales[cuentaNombres]+=" "+rand.nextInt();
		}
		
		
		for(cuentaNombres = 0; cuentaNombres<animales.length;cuentaNombres++)
		{
			System.out.println(animales[cuentaNombres]);
		}
	
		
		for(int j = 0; j<propiedades.length;j++)
		{
			System.out.println(propiedades[j]);
		}		

		// String s = propiedades[3].toString(); daria error porque no se ha inicializado
		
		Casa nueva = new Casa();
		nueva.setColor("Verde");
		
		for(int j = 0; j<propiedades.length;j++)
		{
			propiedades[j]=nueva;
		}		

		for(int j = 0; j<propiedades.length;j++)
		{
			System.out.println(propiedades[j].getColor());
		}		
		
		propiedades[2].setColor("Azul");

		for(int j = 0; j<propiedades.length;j++)
		{
			System.out.println(propiedades[j].getColor());
		}		

		for(int j = 0; j<propiedades.length;j++)
		{
			propiedades[j]=new Casa();
			propiedades[j].setColor(colores[rand.nextInt(colores.length)]);
		}		
		
		for(int j = 0; j<propiedades.length;j++)
		{
			System.out.println(propiedades[j].getColor());
		}		
		
	}

}
