package model.ticketPriceDecorator;

public class Age64PlusDiscount extends TicketPrice {

    public double getPrice() {
    }

    public String getPriceText() {
        return "Een ticket kost " + getPrice() + " euro";
    }
}
