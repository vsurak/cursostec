package vehicles;

import java.util.ArrayList;

import weapons.*;

public class Tanque implements IVehicle {
	private ArrayList<Arma> armas;
	private int currentWeapon;
	private int energy;
	
	public Tanque() {
		armas = new ArrayList<Arma>();
		
		armas.add(new Arco());
		armas.add(new Arco());
		armas.add(new Canyon());
		armas.add(new Laser());
		armas.add(new Canyon());
		armas.add(new Laser());
		
		energy = 100;
	}

	@Override
	public void selectArma(int pIndice) {
		currentWeapon = pIndice;
		armas.get(currentWeapon).liberar();
	}

	@Override
	public void atacar() {
		armas.get(currentWeapon).disparar();
	}

	@Override
	public void damage(int pValue) {
		energy-=pValue;
	}

}
