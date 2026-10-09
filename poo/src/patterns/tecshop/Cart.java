package tecshop;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<CartItem> items = new ArrayList<>();
    private final double weightKg;

    public Cart(double weightKg) {
        this.weightKg = weightKg;
    }

    public void add(CartItem item) {
        items.add(item);
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public double getSubtotal() {
        double subtotal = 0;
        for (CartItem item : items) {
            subtotal += item.getPrice();
        }
        return subtotal;
    }
}
