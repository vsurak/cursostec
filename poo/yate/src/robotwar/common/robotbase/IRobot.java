package robotwar.common.robotbase;

import java.awt.Graphics;
import java.time.LocalTime;

import robotwar.common.IConstants;

public class IRobot implements IConstants {
	private int energy;
	private int posX;
	private int posY;
	private DamageLevel weaponsdamage[];
	private DamageLevel strikesdamage[];
	private DamageLevel directionsdamage[];
	
	public IRobot() {
		directionsdamage = new DamageLevel[MOVEMENT.values().length];
		weaponsdamage = new DamageLevel[WEAPONS_PER_ROBOT];
		strikesdamage = new DamageLevel[STRIKES_PER_ROBOT];
	}
	
	/*
	 * el move es la dirección que el jugador está presionando, con eso y la hora del accion
	 * versus la hora actual se sabe cuanto tiempo ha transcurrido por ende
	 * dada la velocidad del robot, se puede saber cuanto hay que desplazarlo, 
	 * a que velocidad lo desplazo, actualizo el X, Y
	 * reduzco la energía
	 * refresco la pantalla con el graphics
	 */
	public void move(MOVEMENT pMove, LocalTime pActionTime, Graphics g) {
		// put your code here
	}
	
	public void hit(int pStrikeId, LocalTime pActionTime, Graphics g ) {
		
	}
	
	public void fire(int pWeaponId, LocalTime pActionTime, Graphics g) {
		
	}
	
	/*
	 * @pLevel, número del nivel del arma que le acertó
	 * este es el nivel del arma o golpe que le acertó a este robot
	 * entonces ahora hay que dado el nivel escoger la regla que aplica
	 * actualizar el damage respectivo
	 */
	public void damage(int pLevel) {
		
	}
}
