package herencia.heroes.players;

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
}
