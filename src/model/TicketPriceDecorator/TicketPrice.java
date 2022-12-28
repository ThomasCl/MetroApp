package model.TicketPriceDecorator;

import model.Metrocard;

public class TicketPrice{
    
    private boolean is24min, is64plus, isStudent;
    private String attribute;
    private int price;
    public DiscountStrategy discountStrategy;



    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public boolean isIs24min() {
        return is24min;
    }

    public boolean isIs64plus() {
        return is64plus;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setIs24min(boolean is24min) {
        this.is24min = is24min;
    }

    public void setIs64plus(boolean is64plus) {
        this.is64plus = is64plus;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public double calculatePrice(int ritten){
        System.out.println("x");
        return 2.1*ritten;
    }


    public double discountPrice(Metrocard mc) {
        return discountStrategy.discountPrice(mc);
    }

//    public abstract String getPriceText(){
//        return "0";
//    }
}
