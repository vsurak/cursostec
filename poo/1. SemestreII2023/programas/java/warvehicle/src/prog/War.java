package prog;

import weapons.*;
import vehicles.*;

public class War {

	public static void main(String[] args) {
		Arco arco1 = new Arco();
		Arco arco2 = new Arco();
		
		Canyon can = new Canyon();
		
		System.out.println("arco 1");
		System.out.println(arco1.gettensionLevel());
		arco1.tensar();
		arco1.tensar();
		System.out.println(arco1.gettensionLevel());
		
		System.out.println("arco 2");
		System.out.println(arco2.gettensionLevel());
		arco2.tensar();
		System.out.println(arco2.gettensionLevel());
		
		can.ajustarAngulo(0.14);
		System.out.println(can.getAngle());
		
		arco1.liberar();
		can.liberar();
		
		arco1.disparar();
		System.out.println(arco1.getCantidadAtaques());
		
		arco2.disparar();
		System.out.println(arco2.getCantidadAtaques());
		arco2.liberar();
		arco2.disparar();
		System.out.println(arco2.getCantidadAtaques());
		
		System.out.println("================");
		Arma algunarma = arco2;
		algunarma.disparar();

		System.out.println("================");

		Arma lasarmas[] = {arco2, can, arco1};
		
		for(int i=0; i<3; i++) {
			lasarmas[i].disparar();
		}
		
		
		CombatManager manager = new CombatManager();
		IVehicle mivehicle = manager.crearVehiculo();
		ICombat combate = manager.startCombat();
		
		mivehicle.selectArma(3);
		mivehicle.atacar();
		
		combate.danarVehiculo(mivehicle);
		combate.combatir();
	}
}
