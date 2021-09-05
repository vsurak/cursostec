package temasproyecto.poli;

import java.util.*;

public class Lista implements IQueue
{
	private ArrayList<String> lista = new ArrayList<String>();

	@Override
	public void Enqueue(String pValor) {
		lista.add(pValor);
	}

	@Override
	public String Dequeue() {
		String result = "";
		if (lista.size()>0) 
		{
			result = lista.remove(0);
		}
		return result;
	}
}
