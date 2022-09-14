package inheritance.bills;

import java.util.ArrayList;

public class Bill2000 extends Bill {
	private String microLetra;
	private String hilo;

	public Bill2000() {
		super(2000);		
	}
	
	// lo que se busca es modelar comportamientos específicos de los hijos
	public boolean validate(ArrayList<Pair> pVariables) {
		boolean result = super.validate(pVariables);
		
		// las reglas propias del billete de 2000
		result =result && true;
		
		System.out.println("esta es la validacion de los billetes de 2000");
		return result;
	}
	
	public boolean validateSegundaVersion() {
		boolean result = super.validateSegundaVersion();

		microLetra = getValue("micro letra");
		hilo = getValue("hilo");
		
		// las reglas propias del billete de 2000
		result =result && (microLetra=="10" && hilo=="presente");
				
		return result;
	}
	
	public void esteMetodoEsParaBill2000() {
		//
	}
	
}
