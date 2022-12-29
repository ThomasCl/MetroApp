package model.ticketPriceDecorator;

public class BasicTicketPrice extends TicketPrice {

    public double getPrice() {
        return 2.10;
    }

    public String getPriceText() {
        return "Een ticket kost " + getPrice() + " euro";
    }
}
