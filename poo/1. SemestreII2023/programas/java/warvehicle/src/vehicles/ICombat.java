package vehicles;

public interface ICombat {
	void prepararVehiculo(IVehicle pCar);
	void combatir();
	void danarVehiculo(IVehicle pCar);
	void dejarVehiculoSinEnergia();
}
