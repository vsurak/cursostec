package listas.generic;

public class Nodo<T> 
{
	private T Valor;
	private Nodo<T> Siguiente;
	
	public Nodo()
	{
		this.Siguiente=null;
	}
	
	
	public Nodo(T pValue)
	{
		setValue(pValue);
		this.Siguiente=null;
	}
	
	public T getValue() {
		return Valor;
	}

	public void setValue(T pValue) {
		Valor = pValue;
	}

	public Nodo<T> getSiguiente() {
		return Siguiente;
	}

	public void setSiguiente(Nodo<T> siguiente) {
		Siguiente = siguiente;
	}
}
