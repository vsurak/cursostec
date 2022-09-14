package inheritance.bills;

import java.util.ArrayList;

public class Bill1000 extends Bill {

	public Bill1000() {
		super(1000);
	}
	
	// lo que se busca es modelar comportamientos específicos de los hijos
	public boolean validate(ArrayList<Pair> pVariables) {
		boolean result = super.validate(pVariables);
		
		result =result && true;
		
		System.out.println("validacion de billete de 1000");
				
		return result;
	}	
}
