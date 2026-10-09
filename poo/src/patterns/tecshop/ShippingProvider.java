package tecshop;

// Our own interface: every shipping option in TecShop is quoted in kilograms and colones.
public interface ShippingProvider {
    double quote(double kg, String city);
}
