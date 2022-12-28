package model.TicketPriceDecorator;

import model.Metrocard;

public class Age64PlusDiscount implements DiscountStrategy{

    @Override
    public double discountPrice(Metrocard mc) {
        mc.setPrice(mc.getPrice()-0.15);
        return mc.getPrice();

    }
}
