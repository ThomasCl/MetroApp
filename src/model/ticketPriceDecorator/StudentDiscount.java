package model.ticketPriceDecorator;

public class StudentDiscount extends TicketPrice {

    public double getPrice() {
        return 1.85;
    }

    public String getPriceText() {
        return "Een ticket kost " + getPrice() + " euro";
    }
}
