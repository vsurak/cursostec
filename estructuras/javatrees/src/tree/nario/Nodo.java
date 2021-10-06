package tree.nario;

import java.util.ArrayList;

public class Nodo<T> 
{
	private ArrayList<Nodo<T>> Ramas;
	
	public Nodo() 
	{
		Ramas = new ArrayList<Nodo<T>>();
	}
	
	
	public void addChild(T pValue)
	{
		
	}
	
	public void addChild(Nodo<T> pNodo)
	{
	
	}
	
	public Nodo<T> getNodeChild(int pIndex)
	{
		return null;
	}
	
	public T getNodeValue(int pIndex)
	{
		return null;
	}
	
}
