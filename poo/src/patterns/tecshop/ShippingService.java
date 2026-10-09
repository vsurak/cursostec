package tecshop;

public class ShippingService {
    private final LocalCourier local = new LocalCourier();
    private final CorreosApi correos = new CorreosApi();

    public double quote(String provider, double kg, String city) {
        if (provider.equals("local")) {
            return local.quote(kg, city);
        } else if (provider.equals("correos")) {
            int gramos = (int) Math.round(kg * 1000);
            String codigoPostal;
            switch (city) {
                case "San Jose": codigoPostal = "10101"; break;
                case "Alajuela": codigoPostal = "20101"; break;
                case "Cartago":  codigoPostal = "30101"; break;
                case "Limon":    codigoPostal = "70101"; break;
                default: throw new IllegalArgumentException("Unknown city: " + city);
            }
            String raw = correos.calcularTarifa(gramos, codigoPostal);
            return Double.parseDouble(raw.replace("₡", ""));
        }
        throw new IllegalArgumentException("Unknown provider: " + provider);
    }
}
