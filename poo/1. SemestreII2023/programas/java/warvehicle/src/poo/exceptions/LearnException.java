package poo.exceptions;

public class LearnException {

	
	/*
	 * Esta funcion retorna la division acumulada de pRoot por los valores en pValues
	 * Si pValues se hace cero vacío retorna -1
	 */
	public static long calcularDivisionAcumulada(int[] pValues, long pRoot) {
		long result = -1;
		try {
			// este fragmento de código es propenso a producir exceptions			
			for(int value : pValues) {
				result = pRoot / value;
				pRoot = result;
			}			
		} catch (Exception ex) {
			result = -1;
			ex.printStackTrace();
		}
		
		return result;
	}

	public static long calcularDivisionAcumuladaV2(int[] pValues, long pRoot) {
		long result = 0;
		
		// este fragmento de código es propenso a producir exceptions			
		for(int value : pValues) {
			try {
				result = pRoot / value;
			} catch (ArithmeticException ex) {
				
			}
			pRoot = result;
		}			
		return result;
	}

	public static long calcularDivisionAcumuladaV3(int[] pValues, long pRoot) {
		long result = 0;
		try { 
			// este fragmento de código es propenso a producir exceptions			
			for(int i=0; i<pValues.length; i++) {
				if (pValues[i]==0) {
					throw new RodrigoException("hey weey se cayó porque le mandaste un cero", i);
				}
				result = pRoot / pValues[i];
				pRoot = result;
			}
		} catch (RodrigoException ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public static long calcularDivisionAcumuladaV4(int[] pValues, long pRoot) throws RodrigoException {
		long result = 0;
			// este fragmento de código es propenso a producir exceptions			
		for(int i=0; i<pValues.length; i++) {
			if (pValues[i]==0) {
				// a criterio personal del profesor, esto es un anti patron y una mala práctica de programación
				// no el hecho de hacer y tirar exception custom, si no que 
				// si eso lo podía controlar normal a punta de validaciones
				// entonces no amerita un exception
				// los exception son más atinados cuando no tengo forma de estar seguro
				// si va a fallar o no, es para situaciones fuera de control
				throw new RodrigoException("hey weey se cayó porque le mandaste un cero", i);
			}
			result = pRoot / pValues[i];
			pRoot = result;
		}
		return result;
	}

	
	public static void main(String args[]) {
		int valores[] = {4, 5, 0, 2};
		
		long result = LearnException.calcularDivisionAcumulada(valores, 900);
		System.out.println(result);

		result = LearnException.calcularDivisionAcumuladaV2(valores, 900);
		System.out.println(result);
	
		result = LearnException.calcularDivisionAcumuladaV3(valores, 900);
		System.out.println(result);

		try {
			result = LearnException.calcularDivisionAcumuladaV4(valores, 900);
		} catch (RodrigoException ex) {
			System.out.println("Oye, pusiste en la posicion "+ex.getpositionOfFailed()+" un cero");
		}
		System.out.println(result);

	}
}
