package model;

import java.time.LocalDate;

public class Metrocard {
    private int id;
    private String date;
    private int aantalBeschikbareRitten;
    private int aantalVerbruikteRitten;
    private double price;


    public Metrocard(int id, LocalDate date, int beschikbaar, int verbruikt){
        setId(id);
        setDate(date);
        setAantalBeschikbareRitten(beschikbaar);
        setAantalVerbruikteRitten(verbruikt);
    }
    public Metrocard(int id, String date, int beschikbaar, int verbruikt){
        setId(id);
        setDate(date);
        setAantalBeschikbareRitten(beschikbaar);
        setAantalVerbruikteRitten(verbruikt);
    }
    public Metrocard(LocalDate date, int beschikbaar, int verbruikt){
        setDate(date);
        setAantalBeschikbareRitten(beschikbaar);
        setAantalVerbruikteRitten(verbruikt);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {

        this.date = date;
    }

    public void setDate (LocalDate date){
        String month = String.valueOf(date.getMonthValue());
        String year = String.valueOf(date.getYear());
        this.date= String.format("%s#%s",month,year);
    }

    public int getAantalBeschikbareRitten() {
        return aantalBeschikbareRitten;
    }

    public void setAantalBeschikbareRitten(int aantalBeschikbareRitten) {
        this.aantalBeschikbareRitten = aantalBeschikbareRitten;
    }

    public int getAantalVerbruikteRitten() {
        return aantalVerbruikteRitten;
    }

    public void setAantalVerbruikteRitten(int aantalVerbruikteRitten) {
        this.aantalVerbruikteRitten = aantalVerbruikteRitten;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
