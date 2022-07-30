package herencia.heroes.juego;

import herencia.heroes.players.*;

import java.util.ArrayList;

import herencia.heroes.library.*;

public class JuegoHeroes 
{
	public static void main(String args[])
	{
		Heroe nuevo0 = new Heroe("Pedro", NivelHeroe.KILLER);
		Heroe nuevo1 = new Heroe();
		Gladiador nuevo2 = new Gladiador();
		Ogro og1 = new Ogro();
		Elfo elf = new Elfo(20);
	
		og1.moverDerecha();
		
		elf.caminar();
		elf.recargarFlechas();
		
		elf.atacar();
		og1.atacar();
		
		Heroe h3 = og1;
		Heroe h4 = elf;
		
		Heroe h5 = new Mago();
		
		//Mago m = nuevo0; de padre a hijo no se puede porque quedaria 
		//Mago m2 = new Heroe();
		
		ArrayList<Heroe> heroes = new ArrayList<Heroe>();
		
		heroes.add(new Mago());
		heroes.add(new Asesino());
		heroes.add(new Elfo(5));
		heroes.add(new Ogro());
		heroes.add(new Ogro());
		heroes.add(new Asesino());
		heroes.add(new Mago());
		heroes.add(new Elfo(10));
		
		for (Heroe heroe : heroes) {
			heroe.atacar();
		}
		
	}
}
