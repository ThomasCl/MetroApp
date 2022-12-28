package model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

public class Metrocard {
    private int id;
    private LocalDate date;
    private int aantalBeschikbareRitten;
    private int aantalVerbruikteRitten;


    public Metrocard(int id, String date, int beschikbaar, int verbruikt){
        setId(id);
        setDate(date);
        setAantalBeschikbareRitten(beschikbaar);
        setAantalVerbruikteRitten(verbruikt);
    }

    public Metrocard(int id, LocalDate date, int beschikbaar, int verbruikt){
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

    public LocalDate getDate() {
        return date;
    }

    public String getDateAsString() {
        String[] dat = date.format(DateTimeFormatter.ofPattern("d/M/yyyy")).split("/");
        return(dat[1] + "#" + dat[2]);
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDate(String date) {
        date = date.replace("#", "/");
        date = "1/" + date;

        DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendOptional(DateTimeFormatter.ofPattern("d/M/yyyy")).toFormatter();
        this.date = LocalDate.parse(date, formatter);
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
