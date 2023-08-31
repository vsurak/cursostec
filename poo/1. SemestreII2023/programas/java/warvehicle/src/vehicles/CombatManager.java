package vehicles;

public class CombatManager implements ICombat {
	private IVehicle vehiculo;
	
	public CombatManager() {
	
	}
	
	public void crearVehiculo() {
		vehiculo = new Tanque();
	}
	
	@Override
	public void prepararVehiculo() {
		vehiculo.selectArma(1);
	}

	@Override
	public void combatir() {
		vehiculo.atacar();
	}

	@Override
	public void danarVehiculo() {
		vehiculo.damage(10);
	}

	@Override
	public void dejarVehiculoSinEnergia() {
		vehiculo.damage(100);
		
	}
	
}
