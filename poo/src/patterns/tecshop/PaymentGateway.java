package tecshop;

public class PaymentGateway {
    public void charge(String method, double amount) {
        System.out.println("Payment: charged " + Money.format(amount) + " via " + method);
    }
}
