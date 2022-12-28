package model.TicketPriceDecorator;

public class TicketPriceFactory {

    public static TicketPrice createTicketPrice(boolean is24min, boolean is64plus, boolean isStudent) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        TicketPrice ticketPrice = null;
        Class <?> c = Class.forName("model.TicketPriceDecorator.TicketPrice");
        Object o = c.newInstance();
        ticketPrice = (TicketPrice) o;

//        TicketPrice price;
//        price.setIs24min(is24min);
//        price.setIs64plus(is64plus);
//        price.setStudent(isStudent);
//        price.setAttribute(attribute);
//        return price;
        return ticketPrice;
    }



}
