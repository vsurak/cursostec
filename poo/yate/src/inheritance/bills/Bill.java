package inheritance.bills;

import java.util.ArrayList;

public class Bill {
	protected String firmagerente;
	protected String serie;
	protected int denominacion;
	// otros fields
	
	protected ArrayList<Pair> variableList;
	
	
	public Bill(int pDenominacion) {
		denominacion = pDenominacion;
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
	
	public boolean validate(ArrayList<Pair> pVariables) {
		boolean result = false;

		this.variableList = pVariables;
		
		firmagerente = getValue("firmagerente");
		serie = getValue("serie");
		
		result =	!getValue("firma de gerente").isEmpty() &&
					!getValue("marca de agua").isEmpty() &&
					!getValue("serie").isEmpty();		
		
		return result;
	}
	
	public boolean validateSegundaVersion() {
		return true;
	}
	
	public int getDenominacion() {
		return this.denominacion;
	}
}
