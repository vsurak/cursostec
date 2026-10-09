package tecshop;

public class InvoicePrinter {
    public void print(String customer, Cart cart, double tax, double shipping, double total) {
        System.out.println("----- INVOICE: " + customer + " -----");
        for (CartItem item : cart.getItems()) {
            System.out.println("  " + item.describe() + "  " + Money.format(item.getPrice()));
        }
        System.out.println("  Subtotal: " + Money.format(cart.getSubtotal()));
        System.out.println("  Tax:      " + Money.format(tax));
        System.out.println("  Shipping: " + Money.format(shipping));
        System.out.println("  TOTAL:    " + Money.format(total));
    }
}
