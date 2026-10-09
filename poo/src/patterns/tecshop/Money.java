package tecshop;

import java.util.Locale;

public class Money {
    public static String format(double amount) {
        return String.format(Locale.ROOT, "CRC %,.2f", amount);
    }
}
