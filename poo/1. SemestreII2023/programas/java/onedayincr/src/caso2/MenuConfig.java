package caso2;

import java.util.Vector;

public class MenuConfig {
	private Vector<String> comidas;
	private Vector<String> refrescos;
	private Vector<String> postres;
	
	public MenuConfig() {
		comidas = new Vector<String>();
		refrescos = new Vector<String>();
		refrescos = new Vector<String>();
	}

	public Vector<String> getComidas() {
		return comidas;
	}

	public Vector<String> getRefrescos() {
		return refrescos;
	}

	public Vector<String> getPostres() {
		return postres;
	}
	
	
}
