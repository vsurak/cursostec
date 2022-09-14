package inheritance.bills;

import java.util.ArrayList;

public class Bill2000 extends Bill {
	private String microLetra;
	private String hilo;

	public Bill2000(ArrayList<Pair> pVariables) {
		super(pVariables);
		
		microLetra = getValue("micro letra");
		hilo = getValue("hilo");
	}
	
	// lo que se busca es modelar comportamientos específicos de los hijos
	public boolean validate() {
		boolean result = super.validate();
		
		// las reglas propias del billete de 2000
		result =result && (!getValue("").isEmpty() && !getValue("").isEmpty());
				
		return result;
	}
	
	public boolean validateSegundaVersion() {
		boolean result = super.validateSegundaVersion();
		
		// las reglas propias del billete de 2000
		result =result && (microLetra=="10" && hilo=="presente");
				
		return result;
	}
	
}
