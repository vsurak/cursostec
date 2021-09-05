package slot.library;

public class Simbolo 
{
	private int Id;
	private String Figura;
	
	/*
	 * Constructor de simbolo para asignar una figura a un ID numerico
	 */
	public Simbolo(int pId, String pFigura)
	{
		setId(pId);
		setFigura(pFigura);
	}
	
	public int getId() {
		return Id;
	}
	
	public void setId(int id) {
		Id = id;
	}
	
	public String getFigura() {
		return Figura;
	}
	
	public void setFigura(String figura) {
		Figura = figura;
	}
}
