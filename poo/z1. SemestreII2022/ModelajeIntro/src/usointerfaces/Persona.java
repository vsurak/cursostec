package usointerfaces;
import java.util.ArrayList;

public class Persona 
{
	private String Nombre;
	private double MontoActivos;
	
	private ArrayList<ISellable> ArticulosParaVender;
	
	public Persona()
	{
		ArticulosParaVender = new ArrayList<ISellable>();
	}
	
	public void agregarArticulo(ISellable pArticulo)
	{
		ArticulosParaVender.add(pArticulo);
	}
	
	public ISellable getArticulo(int pIndex)
	{
		ISellable result = null;
		
		if (ArticulosParaVender.size()>pIndex)
		{
			return ArticulosParaVender.get(pIndex);
		}
		
		return result;
	}
}
