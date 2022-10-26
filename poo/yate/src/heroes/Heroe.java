package heroes;

import java.util.ArrayList;
import java.util.Random;

import heroes.factory.PowersFactory;


public class Heroe {
	private String nombre;
	private ArrayList<AbstractPower> powers;
	private boolean fighting;
	
	public Heroe(String pNombre) {
		this.nombre = pNombre;
		fighting = false;
		powers = new ArrayList<AbstractPower>();
	}
	
	public String GetNameHeroe() {
		return nombre;
	}
	
	public void addPower(AbstractPower pPower) {
		powers.add(pPower);
	}
	
	public void fight() {
		fighting = true;
		Random rand = new Random();
		while (fighting) {
			try {
				
				int powerToUse = rand.nextInt(powers.size());
				
				AbstractPower currentPower = powers.get(powerToUse);
				
				currentPower.attack();
				Thread.sleep(1000);
				currentPower.stop();
				
			} catch (Exception ex) {
				
			}
		}
	}
	
	public void stopFight() {
		fighting = false;
	}
	
	public static void main(String args[]) {
		/*Heroe superPoo = new Heroe("poo super");
		
		//AbtractPower power = new AbstractPower(); esto no es posible porque no se peude implementar una clase abstracta
		
		SuperFuerza fuerza = new SuperFuerza();
		superPoo.addPower(fuerza);
		
		AbstractPower trueno = new Trueno();
		superPoo.addPower(trueno);
		
		fuerza.getDamage(); // es un metodo heredado de la clase abstracta y tiene implementacion
		trueno.getDamage(); // porque getDamage es un metodo de el AbstractPower
		
		//trueno.sonidoTrueno(); aunque trueno sea una instancia de Trueno, ahorita la estoy enmascarando con AbstractPower
		// entonces solo puedo ver lo que ofrece abstract power, pero por dentro si es trueno
		// por eso le llamamos polimorfismo, la misma instancia puedo verla como AbstractPower o puedo verla como Trueno
		
		Trueno otroPower = (Trueno)trueno;
		otroPower.sonidoTrueno();
		
		AbstractPower masTrueno = otroPower;
		superPoo.addPower(masTrueno);
		
		superPoo.fight();*/
		
		System.out.println("Probado el factory pattern con IFs");
		
		AbstractPower unPoder = PowersFactory.create("Trueno");
		//unPoder.attack();
		
		AbstractPower otro = PowersFactory.createDinamico("Magnetismo");
		otro.attack();
		
	}
}
