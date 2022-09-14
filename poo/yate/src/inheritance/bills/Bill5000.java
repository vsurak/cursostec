package inheritance.bills;

import java.util.ArrayList;

public class Bill5000 extends Bill {

	public Bill5000() {
		super(5000);
	}
	
	// lo que se busca es modelar comportamientos específicos de los hijos
	public boolean validate(ArrayList<Pair> pVariables) {
		boolean result = super.validate(pVariables);
		
		result =result && false;
		
		System.out.println("validacion de billete de 5000");
				
		return result;
	}	
}
