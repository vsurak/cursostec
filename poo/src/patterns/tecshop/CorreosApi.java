package tecshop;

// THIRD-PARTY LIBRARY (Correos de Costa Rica SDK). DO NOT MODIFY THIS FILE.
public class CorreosApi {
    public String calcularTarifa(int gramos, String codigoPostal) {
        int bloques = (int) Math.ceil(gramos / 500.0);
        int tarifa = 2000 + bloques * 350;
        if (codigoPostal.startsWith("7")) {
            tarifa += 1200;               // recargo zona Limon
        }
        return "₡" + tarifa;          // e.g. "₡3750"
    }
}
