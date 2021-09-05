package modelaje;

public class Semaforo 
{
	// constantes 
	private final String COLOR_VERDE = "Verde";
	private final String COLOR_AMARILLO = "Amarillo";
	private final String COLOR_ROJO = "Rojo";
	
	private boolean Encendido;
	private String Estado;
	private short TiempoVerde;
	private short TiempoRojo;
	private short TiempoAmarillo;
	
	public String getEstado() {
		return Estado;
	}	
	
	public void setEstado(String estado) {
		Estado = estado;
	}

	public void setTiempoVerde(short tiempoVerde) {
		TiempoVerde = tiempoVerde;
	}

	public void setTiempoRojo(short tiempoRojo) {
		TiempoRojo = tiempoRojo;
	}

	public void setTiempoAmarillo(short tiempoAmarillo) {
		TiempoAmarillo = tiempoAmarillo;
	}
	
	public Semaforo()
	{
		setEstado(COLOR_ROJO);
		encender();
	}
	
	public Semaforo(String pEstadoActual)
	{
		Estado = pEstadoActual;
	}
		
	public void cambiarColor()
	{
		switch(Estado)
		{
			case COLOR_VERDE: {
				setEstado(COLOR_AMARILLO);
				// esperar TiempoAmarillo
				break;
			}
			case COLOR_AMARILLO: {
				setEstado(COLOR_ROJO);
				// esperar TiempoRojo
				break;
			}
			case COLOR_ROJO: {
				setEstado(COLOR_VERDE);
				// esperar tiempoVerde
				break;
			}
			default:
				setEstado(COLOR_ROJO);
				// esperar TiempoRojo
		}
	}
	
	public void encender() 
	{
		Encendido = true;
	}
	
	public void apagar()
	{
		Encendido = false;
	}
	
	
}
