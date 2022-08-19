package games.roulette;

import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;

public class Bet {
	private float amount;
	private LinkedList<Integer> numbers;
	private BetResult result;
	private float won;
	
	public Bet() {
		this.result = BetResult.NONE;
		this.amount = 0.0f;
		this.won = 0.0f;
		this.numbers = new LinkedList<Integer>();
	}
	
	public Bet(float pAmount, int pNumbers[]) {
		this();
		this.amount = pAmount;
		List listofnumbers = Arrays.asList(pNumbers);
		this.numbers = new LinkedList<Integer>(listofnumbers);
	}

	public BetResult getResult() {
		return result;
	}

	public void setResult(BetResult result) {
		this.result = result;
	}

	public float getWon() {
		return won;
	}

	public void setWon(float won) {
		this.won = won;
	}

	public float getAmount() {
		return amount;
	}

	public LinkedList<Integer> getNumbers() {
		return numbers;
	}
	
	
}
