package herencia.heroes.players;

public class Elfo extends Heroe  
{
	private int CantidadFlechas;
	
	public Elfo(int pCantidadFlechas)
	{
		CantidadFlechas = pCantidadFlechas;
	}
	
	public void recargarFlechas()
	{
		CantidadFlechas+=10;
		System.out.println("recargarFlechas , codigo en "+this.getClass().toString());
	}
	
	public void atacar()
	{
		super.atacar(); // mando a ejecutar este mismo metodo pero usando el codigo de la classe padre
		System.out.println("Ahora el elfo ataca , codigo en "+this.getClass().toString());
		this.Puntos+=5; // puedo acceder al atributo del padre porque fue declarado Protected
	}
}
