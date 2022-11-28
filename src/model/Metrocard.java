package model;

public class Metrocard {
    private int id;
    private String date;
    private int aantalBeschikbareRitten;
    private int aantalVerbruikteRitten;


    public Metrocard(int id, String date, int beschikbaar, int verbruikt){
        setId(id);
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
}
