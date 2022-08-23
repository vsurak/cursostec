package games.roulette;

import java.util.ArrayList;
import java.util.Random;

public class Roulette {
	private int currentNumber;
	private ArrayList<Integer> history;
	private Random rand;
	
	public Roulette() {
		currentNumber = 0;
		history = new ArrayList<Integer>();
		rand = new Random();
	}
	
	public int spin() {
		int result = 0;
		this.currentNumber = rand.nextInt(38)+1;
		result = this.currentNumber;
		
		if (history.size()>=Constants.MAX_AMOUNT_OF_NUMBERS_IN_HISTORY) {
			history.remove(0);
		}
		
		history.add(this.currentNumber);
		return result;
	}

	public int getCurrentNumber() {
		return currentNumber;
	}

	public ArrayList<Integer> getHistory() {
		return history;
	}		
}