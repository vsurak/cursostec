package herencia.heroes.players;

import herencia.heroes.library.NivelHeroe;
import herencia.heroes.library.Constantes;

public class Heroe {
	
	private int Vida;
	protected int Puntos; // lo declaro protected para que los hijos de la clase puedan acceder directamente al atributo
	private String Nombre;
	private NivelHeroe Nivel;
	private int PosX;
	private int PosY;
	
	public Heroe()
	{
		this("NoName",NivelHeroe.NOVATO);
	}
	
	public Heroe(String pNombre, NivelHeroe pLevel)
	{
		setNombre(pNombre);
		setNivel(pLevel);
		setVida(100);
		Puntos=0;
		this.PosX = Constantes.ANCHO_JUEGO/2;
		this.PosY = Constantes.LARGO_JUEGO;
		
		System.out.println("Constructor "+this.getClass().toString());
	}
	
	// Methods
	
	public void moverIzquierda()
	{
		this.PosX = this.PosX>0 ? this.PosX-1 : 0;
		System.out.println("Mover izquierda, codigo en "+this.getClass().toString());
	}
	
	public void moverDerecha()
	{
		this.PosX=this.PosX<Constantes.ANCHO_JUEGO ? this.PosX+1 : Constantes.ANCHO_JUEGO;
		System.out.println("Mover derecha, codigo en "+this.getClass().toString());
	}
	
	public void caminar()
	{
		caminar(Constantes.PIXELS_WALK_SPEED);
		System.out.println("Caminar, codigo en "+this.getClass().toString());
	}
	
	public void saltar()
	{
		System.out.println("Saltar, codigo en "+this.getClass().toString());
		caminar(Constantes.PIXELS_PER_JUMP);
	}
	
	public void atacar()
	{
		System.out.println("Atacar, codigo en "+this.getClass().toString());
	}
		
	private void caminar(int pCantidadPixeles)
	{
		this.PosY = this.PosY-pCantidadPixeles>0 ? this.PosY-pCantidadPixeles : 0;
	}
	
	// Getters and setters
	public int getVida() {
		return Vida;
	}
	
	public void setVida(int vida) {
		Vida = vida;
	}
	
	public String getNombre() {
		return Nombre;
	}
	
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	public NivelHeroe getNivel() {
		return Nivel;
	}
	
	public void setNivel(NivelHeroe nivel) {
		Nivel = nivel;
	}
}
