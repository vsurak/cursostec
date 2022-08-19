package games.roulette;

import java.util.ArrayList;

public class Play {
	private ArrayList<Bet> bets;
	private float totalBet;
	private float balance;
	
	public Play() {
		totalBet = 0.0f;
		balance = Constants.INITIAL_AMOUNT;
		bets = new ArrayList<Bet>();
	}
	
	public void clear() {
		totalBet = 0.0f;
		bets.clear();
	}
	
	public void addBet(float pAmount, int pNumbers[]) {
		Bet newBet = new Bet(pAmount, pNumbers);
		this.totalBet+=pAmount;
		this.balance-=pAmount;
		this.bets.add(newBet);
	}

	public float getTotalBet() {
		return totalBet;
	}

	public float getBalance() {
		return balance;
	}
}
