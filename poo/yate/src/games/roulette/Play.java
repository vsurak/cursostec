package games.roulette;

import java.util.ArrayList;

public class Play {
	private ArrayList<Bet> bets;
	private float totalBet;
	private float balance;
	private Roulette roulette;
	
	public Play() {
		totalBet = 0.0f;
		balance = Constants.INITIAL_AMOUNT;
		bets = new ArrayList<Bet>();
		roulette = new Roulette();
	}
	
	@Override
	protected void finalize() {
		bets.clear();
		roulette = null;
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
	
	public int spin() {
		int wonNumber = roulette.spin();
		this.evaluate(wonNumber);
		return wonNumber;
	}

	public float getTotalBet() {
		return totalBet;
	}

	public float getBalance() {
		return balance;
	}
	
	private void evaluate(int pWonNumber) {
		for(int betIndex=0; betIndex<bets.size(); betIndex++) {
			Bet currentBet = bets.get(betIndex); 
			
			if (currentBet.getNumbers().contains(pWonNumber)) {
				
				currentBet.setResult(BetResult.WIN);
				currentBet.setWon(currentBet.getAmount());
				
				this.balance += currentBet.getAmount() + currentBet.getWon();
				
			} else {
				currentBet.setResult(BetResult.LOSE);
				currentBet.setWon(0.0f);
			}
		}
	}
	
	public void imprimirApuestasGanadoras() {
		for(Bet currentBet :  this.bets) {
			if (currentBet.getResult()==BetResult.WIN) {
				System.out.println("Apostado: "+currentBet.getAmount()+" Ganado: "+currentBet.getWon());
			}
		}
		
		//for(int i=0; i<this.bets.size(); i++) {
		//	Bet currentBet = this.bets.get(i);
		//}
	}
}
