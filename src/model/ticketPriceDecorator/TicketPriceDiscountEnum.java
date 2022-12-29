package model.ticketPriceDecorator;

public enum TicketPriceDiscountEnum {
    AGEPLUS64DISCOUNT("Age plus 64 discount","model.ticketPriceDecorator.Age64PlusDiscount"),
    CHRISTMASLEAVEDISCOUNT("Christmas discount","model.ticketPriceDecorator.ChristmasLeaveDiscount"),
    STUDENTDISCOUNT("Student discount","model.ticketPriceDecorator.StudentDiscount"),
    FREQUENTTRAVLERDISCOUNT("Frequent traveler discount","model.ticketPriceDecorator.FrequentTravellerDiscount");

    private final String name;
    private final String propName;

    TicketPriceDiscountEnum(String name, String propName){
        this.name = name;
        this.propName = propName;
    }

    public String getName() {
        return name;
    }

    public String getPropName() {
        return propName;
    }
}
