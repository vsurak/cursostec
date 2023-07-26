package robotwar.common.robotbase;

public abstract class Weapon extends DamageLevel {
	protected int posX;
	protected int posY;
	protected int speed;
	protected int level;
	protected int attackDistance;
	
	public Weapon(int pSpeed, int pLevel, int pAttackDistance) {
		this.speed = pSpeed;
		this.level = pLevel;
		this.attackDistance = pAttackDistance;
	}
	
	public void fire(int pPosX, int pPosY, ORIENTATION pDirection) {
		if (this.isEnabled()) {
			triggerWeapon(pPosX, pPosY, pDirection);
		}
	}
		
	protected abstract void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection);

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
