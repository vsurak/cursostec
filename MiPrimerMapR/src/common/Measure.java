package common;

import java.io.Serializable;

public class Measure implements Serializable {
	private int coins;
	private int minutes;
	
	public Measure() {
		coins = 0;
		minutes = 0;
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
}
