package tecshop;

public class TaxCalculator {
    private static final double IVA = 0.13;

    public double tax(double subtotal) {
        return Math.round(subtotal * IVA * 100) / 100.0;
    }
}
