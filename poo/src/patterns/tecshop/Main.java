package tecshop;

public class Main {
    public static void main(String[] args) {
        Cart webCart = new Cart(2.3);
        webCart.add(new CartItem("Laptop stand", 25000, true, false, true));
        webCart.add(new CartItem("USB-C hub", 18000, false, true, false));
        webCart.add(new CartItem("Notebook", 3500, false, false, false));
        new WebCheckout().buy(webCart, "Ana", "Cartago");

        System.out.println();

        Cart kioskCart = new Cart(0.8);
        kioskCart.add(new CartItem("Mechanical keyboard", 42000, true, true, false));
        new KioskCheckout().buy(kioskCart, "Luis", "San Jose");
    }
}
