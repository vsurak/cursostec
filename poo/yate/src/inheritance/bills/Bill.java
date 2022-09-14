package inheritance.bills;

import java.util.ArrayList;

public class Bill {
	protected String firmagerente;
	protected String serie;
	// otros fields
	
	protected ArrayList<Pair> variableList;
	
	
	public Bill(ArrayList<Pair> pVariables) {
		this.variableList = pVariables;
		
		firmagerente = getValue("firmagerente");
		serie = getValue("serie");
	}
	
	public String getValue(String pKey) {
		String result = "";
		
		for(Pair currentPair : variableList) {
			if (currentPair.getKey().equals(pKey)) {
				result=currentPair.getValue();
			}
		}
		
		return result;
	}
	
	public boolean validate() {
		boolean result = false;
		
		result =	!getValue("firma de gerente").isEmpty() &&
					!getValue("marca de agua").isEmpty() &&
					!getValue("serie").isEmpty();		
		
		return result;
	}
	
	public boolean validateSegundaVersion() {
		return true;
	}
}
