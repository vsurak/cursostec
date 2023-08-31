package vehicles;

// son contratos que me dicen que métodos puedo encontrar en una clase
// al ser un contrato, hace que cualquier classe que implemente un Interface
// este obligada a implementar los métodos
// las interfaces no son instanceables porque son vacías
// no tienen contenido, no tienen body
// sirven de mascara para que los objetos se exhiban de una o de otra forma
// segun el interface  ==> polimorfismo
public interface IVehicle {

	void selectArma(int pIndice);
	void atacar();
	void damage(int pValue);
}
