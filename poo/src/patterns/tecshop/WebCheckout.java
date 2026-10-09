package tecshop;

// Online store checkout.
public class WebCheckout {
    public void buy(Cart cart, String customer, String city) {
        Inventory inventory = new Inventory();
        inventory.reserve(cart);

        TaxCalculator taxCalculator = new TaxCalculator();
        double subtotal = cart.getSubtotal();
        double tax = taxCalculator.tax(subtotal);

        ShippingService shipping = new ShippingService();
        double shippingCost = shipping.quote("correos", cart.getWeightKg(), city);

        double total = subtotal + tax + shippingCost;
        PaymentGateway gateway = new PaymentGateway();
        gateway.charge("credit card", total);

        InvoicePrinter printer = new InvoicePrinter();
        printer.print(customer, cart, tax, shippingCost, total);
    }
}
