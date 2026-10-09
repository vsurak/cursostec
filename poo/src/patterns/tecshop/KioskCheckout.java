package tecshop;

// In-store kiosk checkout. Copied from WebCheckout and adjusted.
public class KioskCheckout {
    public void buy(Cart cart, String customer, String city) {
        Inventory inventory = new Inventory();
        inventory.reserve(cart);

        TaxCalculator taxCalculator = new TaxCalculator();
        double subtotal = cart.getSubtotal();
        double tax = taxCalculator.tax(subtotal);

        ShippingService shipping = new ShippingService();
        double shippingCost = shipping.quote("local", cart.getWeightKg(), city);

        double total = subtotal + tax + shippingCost;
        PaymentGateway gateway = new PaymentGateway();
        gateway.charge("SINPE Movil", total);

        InvoicePrinter printer = new InvoicePrinter();
        printer.print(customer, cart, tax, shippingCost, total);
    }
}
