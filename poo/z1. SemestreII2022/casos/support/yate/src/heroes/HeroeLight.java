package heroes;

import java.util.ArrayList;

public class HeroeLight {
	private String name;
	private ArrayList<IPower> powers;
	
	public HeroeLight(String pNombre) {
		this.name = pNombre;
	}
	
	public String getSuperName() {
		return name;
	}
}
