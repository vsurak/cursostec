package modelaje;

public class Semaforo2 
{	
	private boolean Encendido;
	private ColorSemaforos Estado;
	private ColorSemaforos[] EstadosSemaforo = {ColorSemaforos.VERDE, ColorSemaforos.AMARILLO, ColorSemaforos.ROJO};
	private short[] TiemposPorColor = new short[EstadosSemaforo.length];
	private int CurrentState;
	
	public Semaforo2()
	{
		setEstado(ColorSemaforos.ROJO);
		encender();
	}
	
	public Semaforo2(ColorSemaforos pEstadoActual)
	{
		Estado = pEstadoActual;
	}	
	
	public ColorSemaforos getEstado() {
		return Estado;
	}	
	
	public void setEstado(ColorSemaforos estado) {
		Estado = estado;
		CurrentState = estado.getValue();
	}
	
	public void setTiempoColor(ColorSemaforos pEstado, short pTime)
	{
		TiemposPorColor[pEstado.getValue()] = pTime;
	}
		
	public void cambiarColor()
	{
		CurrentState++;
		CurrentState = CurrentState % EstadosSemaforo.length;
		Estado = EstadosSemaforo[CurrentState];
		// esperar TiemposPorColor[CurrentState];
		System.out.println("Esperando: "+TiemposPorColor[CurrentState]+ " segundos");
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
