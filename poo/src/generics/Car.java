package generics;

import personas.Persona;

/*
    Clase genérica: T es un parámetro de tipo, se define cuando se crea el objeto.
    Ej. Car<String> hace que T sea String, entonces model es un String.
*/
public class Car<T> {
    private T model;

    public Car(T pModel) {
        this.model = pModel;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T pModel) {
        this.model = pModel;
    }

    @Override
    public String toString() {
        return "Car[" + model + "]";
    }

    public static void main(String[] args) {
        Car<String> car = new Car<String>("Toyota Corolla");
        System.out.println(car);

        car.setModel("Honda Civic");
        String model = car.getModel(); // no se necesita cast, el compilador sabe que es String
        System.out.println(model);

        Car<Persona> c2 = new Car<Persona>(new Persona());

    }
}
