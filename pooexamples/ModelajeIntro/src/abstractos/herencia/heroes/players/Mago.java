package abstractos.herencia.heroes.players;

public class Mago  extends Heroe {
	private int cantidadPosion;
	
	public void tirarPosion()
	{
		System.out.println("tirarPosion , codigo en "+this.getClass().toString());
	}
	
	public void atacar() 
	{
		System.out.println("Ataca el mago");
	}
	
	public void volar() 
	{
		System.out.println("Mago vuela...oh si");
	}	
}
