package model.ticketPriceDecorator;

public class FrequentTravellerDiscount extends TicketPrice {

    public double getPrice() {
        return 1.90;
    }

    public String getPriceText() {
        return "Een ticket kost " + getPrice() + " euro";
    }


}
