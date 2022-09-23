package plants.statuses;

public enum PlantStatus {
	ALMACIGO(0), MEDIANA(1), GRANDE(2), MUERTA(3);
	private int id;
	
	PlantStatus(int pId) {
		id = pId;
	}
	
	public int getId() {
		return id;
	}
}
