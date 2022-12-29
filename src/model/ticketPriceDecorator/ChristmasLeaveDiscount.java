package model.ticketPriceDecorator;

public class ChristmasLeaveDiscount extends TicketPrice {

    public double getPrice() {
        return 2.0;
    }

    public String getPriceText() {
        return "Een ticket kost " + getPrice() + " euro";
    }
}
