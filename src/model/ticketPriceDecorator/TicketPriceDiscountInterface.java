package model.ticketPriceDecorator;


import model.Metrocard;

public interface TicketPriceDiscountInterface {
    double CreateDiscount(Metrocard metrocard);
}
