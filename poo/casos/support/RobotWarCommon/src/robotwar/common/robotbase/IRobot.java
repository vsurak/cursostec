package robotwar.common.robotbase;

import java.awt.Graphics;
import java.time.LocalTime;

import robotwar.common.IConstants;

public class IRobot implements IConstants {
	protected int energy;
	protected int posX;
	protected int posY;
	protected int strikeIndex;
	protected int weaponIndex;
	protected Weapon weapons[];
	protected Weapon strikes[];
	protected DamageLevel directionsdamage[];
	protected ORIENTATION currentOrientation;

	public IRobot() {
		this(ORIENTATION.EAST);
	}
	
	public IRobot(ORIENTATION pOrientation) {
		directionsdamage = new DamageLevel[MOVEMENT.values().length];
		weapons = new Weapon[WEAPONS_PER_ROBOT];
		strikes = new Weapon[STRIKES_PER_ROBOT];
		
		this.currentOrientation = pOrientation;
		
		strikeIndex = 0;
		weaponIndex = 0;
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
		this.weapons[pWeaponId].fire(this.posX, this.posY, this.currentOrientation);
	}
	
	/*
	 * @pLevel, número del nivel del arma que le acertó
	 * este es el nivel del arma o golpe que le acertó a este robot
	 * entonces ahora hay que dado el nivel escoger la regla que aplica
	 * actualizar el damage respectivo
	 */
	public void damage(int pLevel) {
		
	}
	
	public void addStrike(Weapon pStrike) {
		strikes[strikeIndex] = pStrike;
		strikeIndex=++strikeIndex%STRIKES_PER_ROBOT;
	}
	
	public void addWeapon(Weapon pStrike) {
		weapons[weaponIndex] = pStrike;
		weaponIndex=++weaponIndex%WEAPONS_PER_ROBOT;
	}
	
}
