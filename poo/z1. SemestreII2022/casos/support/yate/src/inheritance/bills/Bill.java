package inheritance.bills;

import java.util.ArrayList;
import java.util.Hashtable;

public class Bill {
	protected String firmagerente;
	protected String serie;
	protected int denominacion;
	// otros fields
	
	protected Hashtable<String, Pair> variableList;
	
	
	public Bill(int pDenominacion) {
		denominacion = pDenominacion;
	}
	
	public String getValue(String pKey) {
		String result = "";
		
		if (variableList.contains(pKey)) {
			result = variableList.get(pKey).getValue();
		}
		
		return result;
	}
	
	public boolean validate(Hashtable<String, Pair> pVariables) {
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
