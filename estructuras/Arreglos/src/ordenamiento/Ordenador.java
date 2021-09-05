package ordenamiento;

import java.util.Random;

public class Ordenador 
{	
	public static int[] bubbleSort(int[] pValores)
	{
		boolean terminar = false;
		for(int pasadas=0; (pasadas<pValores.length && !terminar); pasadas++)
		{
			int swapValue;
			terminar = true;
			for(int indiceComparaciones=pValores.length-1; indiceComparaciones>0; indiceComparaciones--)
			{
				if (pValores[indiceComparaciones]<pValores[indiceComparaciones-1]){
					swapValue = pValores[indiceComparaciones];
					pValores[indiceComparaciones] = pValores[indiceComparaciones-1];
					pValores[indiceComparaciones-1] = swapValue;
					terminar = false;
				}
			}
		}
		return pValores;
	}
	
	public static int[] selectionSort(int[] pValores)
	{
		int indiceComparacion = 0;
		int currentPos = 0;
		int currentMin = 0;
		int swapValue;
		
		for (;indiceComparacion<pValores.length-1;indiceComparacion++)
		{
			currentMin = indiceComparacion;
			for(currentPos=indiceComparacion+1; currentPos<pValores.length; currentPos++)
			{
				if (pValores[currentMin]>pValores[currentPos]) 
				{
					currentMin = currentPos;
				}
			}
			swapValue = pValores[indiceComparacion];
			pValores[indiceComparacion] = pValores[currentMin];
			pValores[currentMin] = swapValue;
			
		}
		
		return pValores;
	}
	
	
	public static void main(String args[])
	{
		int[] numerosAOrdenar = {65, 3, 9678, 25, 85, 28, 564, 26, 86, 95, 12, 6, 1, 736, 958484, 26383, 8494, 918298};
		
		Ordenador.bubbleSort(numerosAOrdenar);
		
		for(int i=0; i<numerosAOrdenar.length; i++)
		{
			System.out.println(numerosAOrdenar[i]);
		}
		
		int[] numerosAOrdenar2 = {65, 3, 9678, 25, 85, 28, 564, 26, 86, 95, 12, 6, 1, 736, 958484, 26383, 8494, 918298};
		
		Ordenador.selectionSort(numerosAOrdenar2);
		
		for(int i=0; i<numerosAOrdenar2.length; i++)
		{
			System.out.println(numerosAOrdenar2[i]);
		}
		
		int sizeToTest = 10000;
		int[] arreglo1 = new int[sizeToTest];
		int[] arreglo2 = new int[sizeToTest];
		
		Random rand = new Random();
			
		for(int i=0; i<sizeToTest; i++)
		{
			arreglo1[i] = rand.nextInt();
			arreglo2[i] = rand.nextInt();
		}

		long start, end = 0;
		start = System.currentTimeMillis();
		Ordenador.bubbleSort(arreglo1);
		end = System.currentTimeMillis();
		
		System.out.println("Bubble duro: "+(end-start)+" Milisegundos");

		start = System.currentTimeMillis();
		Ordenador.selectionSort(arreglo2);
		end = System.currentTimeMillis();
		
		System.out.println("Selection duro: "+(end-start)+" Milisegundos");
		
	}
	
}
