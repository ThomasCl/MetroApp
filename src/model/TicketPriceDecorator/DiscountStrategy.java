package model.TicketPriceDecorator;

import model.Metrocard;

public interface DiscountStrategy {
    double discountPrice(Metrocard mc);
}
