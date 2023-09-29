package weapons;

public class Arma {
	private int cantidadAtaques;
	private int alcance;
	private Destruccion capacidadDestructiva;
	private String name;
	private boolean locked;
	
	public Arma(int pAtaques, int pAlcance, Destruccion pCapacidad, String pName) {
		locked = true;
		name = pName;
		cantidadAtaques = pAtaques;
		alcance = pAlcance;
		capacidadDestructiva = pCapacidad;
		
		System.out.println("Se inicializa el arma "+this.name+" bloqueda");
	}
	
	public void cargar(int pCarga) {
		cantidadAtaques+=pCarga;
	}
	
	public void disparar() {
		if (cantidadAtaques>0 && !locked) {
			System.out.println("Weapon "+name+" shooting");
			cantidadAtaques--;
		}
		else {
			System.out.println("Weapon "+name+" NO HAY CARGA O ESTA CON SEGURO");
		}
	}

	public void disparar(int pCantidadDeTiros) {
	}

	public void disparar(int pTiros, double pDistancia) {
	}

	public void disparar(double pDistancia, int pTiros) {
	}

	
	public void asegurar()  {
		locked = true;
	}
	
	public void liberar() {
		locked = false;
	}

	public int getCantidadAtaques() {
		return cantidadAtaques;
	}

	public int getAlcance() {
		return alcance;
	}

	public Destruccion getCapacidadDestructiva() {
		return capacidadDestructiva;
	}

	public String getName() {
		return name;
	}

	public boolean isLocked() {
		return locked;
	}
}
