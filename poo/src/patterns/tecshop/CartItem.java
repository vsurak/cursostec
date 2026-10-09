package tecshop;

public class CartItem {
    private final String name;
    private final double basePrice;
    private final boolean giftWrap;
    private final boolean insurance;
    private final boolean express;

    // TODO: marketing wants 4 more extras next sprint:
    //       engraving, eco-packaging, extended warranty, priority support...
    public CartItem(String name, double basePrice, boolean giftWrap, boolean insurance, boolean express) {
        this.name = name;
        this.basePrice = basePrice;
        this.giftWrap = giftWrap;
        this.insurance = insurance;
        this.express = express;
    }

    public double getPrice() {
        double price = basePrice;
        if (giftWrap) {
            price += 1500;
        }
        if (insurance) {
            price += price * 0.05;
        }
        if (express) {
            price += 2500;
        }
        return price;
    }

    public String describe() {
        String text = name;
        if (giftWrap) {
            text += " + gift wrap";
        }
        if (insurance) {
            text += " + insurance";
        }
        if (express) {
            text += " + express";
        }
        return text;
    }
}
