package games.roulette.controllers;

import games.roulette.Play;
import games.roulette.gui.RouletteMainFrame;

public class RouletteMainFrameController extends Thread {
	private RouletteMainFrame controlledFrame;
	private Play play;
	
	/*
	 * Constructor to link this controller to its window frame
	 */
	public RouletteMainFrameController(Play pPlay) {
		this.play = pPlay;
	}
	
	public void setWindow(RouletteMainFrame pFrame) {
		controlledFrame = pFrame;
	}
	
	public void spin() {
		controlledFrame.setLastNumber(this.play.spin());
		System.out.println(this.play.getBalance());
	}
	
	public void addBet(String pAmountText, String pNumbersText) {
		String numbersInText[] = pNumbersText.split(" ");
		int numbersToBet[] = new int[numbersInText.length];
		int counter = 0;
		
		for(String numberText : numbersInText) {
			numbersToBet[counter++] = Integer.parseInt(numberText);
		}
		
		this.play.addBet(Float.parseFloat(pAmountText), numbersToBet);
	}
}
