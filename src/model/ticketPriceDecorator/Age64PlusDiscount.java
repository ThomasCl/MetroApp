package model.ticketPriceDecorator;

public class Age64PlusDiscount extends TicketPrice {

    public double getPrice() {
        return 0.15;
    }

    public String getPriceText() {
        return "Een ticket kost " + getPrice() + " euro";
    }
}
