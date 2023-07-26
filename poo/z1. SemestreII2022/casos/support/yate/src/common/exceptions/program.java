package common.exceptions;

public class program {

	public static int sumarSinError(int pValues[]) {
		int result = 0;
		
		for(int i=0; i<pValues.length; i++) {
			result +=pValues[i];
		}
		
		return result;
	}

	public static int sumar(int pValues[]) {
		int result = 0;
		
		for(int i=0; i<=pValues.length; i++) {
			result +=pValues[i];
		}
		
		return result;
	}

	public static int sumarPeligrosa(int pValues[]) throws Exception {
		int result = 0;
		
		for(int i=0; i<=pValues.length; i++) {
			result +=pValues[i];
		}
		
		return result;
	}

	public static int sumarConExcepcionControlada(int pValues[]) throws Exception {
		int result = 0;
		
		if (pValues==null) {
			Exception miEx = new Exception("El objeto array viene null");
			throw miEx;
		}
		
		System.out.println("Voy por aqui");
		
		for(int i=0; i<=pValues.length; i++) {
			if (i>=pValues.length) {
				Exception miEx = new Exception("Esta accediendo a un elemento que no existe");
				throw miEx;				
			}
			result +=pValues[i];
		}
		
		return result;
	}

	public static int sumarMasControlada(int pValues[]) throws IncorrectSumException {
		int result = 0;
		try {
			for(int i=0; i<=pValues.length; i++) {
				result +=pValues[i];
			}			
		} catch (Exception ex) {
			//throw new IncorrectSumException();
		}
		finally {
			result = 10000;
		}
	
		return result;
	}
	
	public static void main(String[] args) {
		int test[] = {4, 7, 8, 10, 13, 14};
		
		int suma = 0;
		int errorCode = 0; // 0= succeed
		
		///// PRIMERO VOY A CONTROLAR LAS EXCEPCIONES desde el CALLER
		
		// version 1. tengo un pequeño control o manejo de las excepciones
		try {
			suma = program.sumar(test); // estoy metiendo codigo propenso a fallar
		} catch (Exception ex) {
			suma = -1; // si se cae, controlo la situación y busco que el programa siga corriendo
		}

		System.out.println(suma);
		
		// version 2. esperar efectivamente una excepcion en particular

		suma = 0;
		errorCode = 0;
		try {
			suma = program.sumar(test); // estoy metiendo codigo propenso a fallar
		} catch (ArithmeticException ex) {
			errorCode = -1; // si se cae, controlo la situación y busco que el programa siga corriendo
		} catch (ClassCastException ex) {
			errorCode = -2;
		}
		catch (ArrayIndexOutOfBoundsException ex) {
			errorCode = -3;
		}
		System.out.println(suma);
		System.out.println("Error " + errorCode);
		
		// version 3. es que no esté interesado en procesar la excepción pero si en mantener el programa 
		// funcionando
		
		suma = 0;
		errorCode = 0;
		try {
			suma = program.sumar(test); // estoy metiendo codigo propenso a fallar
			suma = program.sumarSinError(test);
		} catch (Exception ex) {
			errorCode = -1; // si se cae, controlo la situación y busco que el programa siga corriendo
			System.out.println("entro al catch");
		} finally { // el finally se hace incluso si no hay error
			errorCode = -100;
			suma = 100; // darle un valor default a la suma en caso de fallo
		}
		System.out.println(suma);
		System.out.println("Error " + errorCode);
		
		// no lo puedo llamar sin control de exception porque ya tiene una advertencia
		//System.out.println(program.sumarPeligrosa(test));
		
		try {
			System.out.println(program.sumarPeligrosa(test));
		} catch (Exception ex){
			ex.printStackTrace();
		}
		
		try {
			int otroArreglo[] = null;
			System.out.println(program.sumarConExcepcionControlada(otroArreglo));
		} catch (Exception ex){
			ex.printStackTrace();
		} 

		try {
			System.out.println(program.sumarConExcepcionControlada(test));
		} catch (Exception ex){
			ex.printStackTrace();
		} 

		try {
			System.out.println(program.sumarMasControlada(test));
		} catch (IncorrectSumException ex){
			System.out.println(ex.getMessage()+ " "+ex.getCode());
		} 
		
		// ALLA AFUERA EN EL MUNDO REAL DE LOS ING EN SISTEMAS
		// EXISTE RAZA QUE LE ENCANTA CONTROLAR EL FLUJO DE LOS PROGRAMAS CON EXCEPTIONS CUSTOM
		// POR EJEMPLO VOY HACER UNA COMPRA Y NO ME ALCANZA LA PLATA, PRODUCEN UN NOTENOUGHTMONEYEXCEPTION
		// SOLICITO QUE ME LISTEN EL TOP 10 DE LAS PELICULAS MAS RECIENTES Y COMO NO HAY RECIENTES PRODUCZCO UN EMPTYMOVIESLISTEXCEPTION
		// HACEN CATCH, CON EL TYPE DEL EXCEPTION DETERMINAN QUE FUE LO QUE FALLO Y TOMAN MEDIDAS
		// EXISTEN MUCHAS CRIATURAS DE ESTA RAZA
		
		// RECOMENDACION PERSONAL DEL PROFE
		try {
			// codigo propenso a errores
			// este contexto debe ser pequeño
		} catch (Exception ex) {
			// logear el error, para eso usar plataformas, servicios o librerias de log
			// dejar una bitácora del error: ex. events del OS. 
			// usar un servicio de logs
			
			// dejar log con info suficiente, stacktrace, los valores que habian, el app, el user, la computadora, la fecha
			
			// generar un código de error para el log y para retornar
			// retornar algun valor default para que el sistema siga funcionando
		} finally {
			// retornar algun valor default para que el sistema siga funcionando
			// cerrar files, cerrar bases de datos, cerrar sockets, cerrar recursos, buffers, limpiar cosas
		}
	}

}
