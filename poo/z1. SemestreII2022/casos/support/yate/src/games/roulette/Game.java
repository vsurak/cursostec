package games.roulette;

import games.roulette.controllers.RouletteMainFrameController;
import games.roulette.gui.RouletteMainFrame;

public class Game {

	public static void main(String args[]) {
		Play juego = new Play();
		
		int bet1[] = {1,4};
		juego.addBet(10.0f, bet1);
		
		int bet2[] = {2,3,5,6};
		juego.addBet(15.0f, bet2);

		int bet3[] = {19,20,22,23};
		juego.addBet(15.0f, bet3);
		
		int bet4[] = {24};
		juego.addBet(5.0f, bet4);
		
		juego.addBet(17.0f, Constants.oneToTwelve);
		
		juego.addBet(50.0f, Constants.red);
			
		System.out.println(juego.getTotalBet()+" "+juego.getBalance());
		
		juego.spin();
		
		juego.imprimirApuestasGanadoras();
		
		System.out.println(juego.getTotalBet()+" "+juego.getBalance());
		
		juego.clear();
		
		
		RouletteMainFrameController controller = new RouletteMainFrameController(juego);
		
		// asignarle al controller que cosas el debe ver del model
		
		RouletteMainFrame myroulettewindow = new RouletteMainFrame("Roulette game sample", controller);
		
		
	}
}
