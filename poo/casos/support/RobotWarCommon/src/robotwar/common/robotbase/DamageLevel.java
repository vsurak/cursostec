package robotwar.common.robotbase;

import java.util.Arrays;

public class DamageLevel {
	private double damageLevel;
	private boolean enabled;
	
	public DamageLevel() {
		this.damageLevel = 100.0;
		this.enabled = true;
	}

	public double getDamageLevel() {
		return damageLevel;
	}

	/*
	 * código cortesía de jose andres
	 */
	public void hitDamage(int pLevel) {
		int[][] array = {{1,2},{3,4,5,6,7,8,9,10}};
		float [] percent = {1.0f,1.0f,2.0f,0.4f,0.6f,0.3f,0.6f,0.9f,1.0f,1.0f};
		Arrays.stream(array[0]).filter(x->x==pLevel).forEach(x->this.damageLevel-=percent[pLevel-1]);
		Arrays.stream(array[1]).filter(x->x==pLevel).forEach(x->this.damageLevel-=this.getDamageLevel()*percent[pLevel-1]);
		
		if (this.damageLevel<=0.0) {
			this.damageLevel = 0.0;
			this.enabled = false;
		}
	}

	public boolean isEnabled() {
		return enabled;
	}
	
}
