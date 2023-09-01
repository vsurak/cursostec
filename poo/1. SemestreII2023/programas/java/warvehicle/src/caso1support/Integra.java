package caso1support;

public class Integra {
	int altura = 0;
	int cantidadFrutos = 0;
	// 1. adelantar un poco la conexion de printlns al UI
	// 2. darle sentido operativo a las classes
	// 3. cada subequipo debe habilitar el medio para que control proceda
	// 4. que hace la gente de control mmientras el resto termina
	
	
	public void crecer() {
		altura+=2;
		Util.report("la planta crecio 2 centimetros");
	}
	
	public void darFrutos() {
		cantidadFrutos +=3;
		Util.report("el arbol xyz ya tiene frutos "+cantidadFrutos);
	}
}
