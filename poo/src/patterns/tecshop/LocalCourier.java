package tecshop;

// Our in-house courier. It already follows our interface.
public class LocalCourier implements ShippingProvider {
    @Override
    public double quote(double kg, String city) {
        return 1500 + 600 * kg;
    }
}
