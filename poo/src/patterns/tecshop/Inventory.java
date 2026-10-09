package tecshop;

public class Inventory {
    public void reserve(Cart cart) {
        System.out.println("Inventory: reserved " + cart.getItems().size() + " items");
    }
}
