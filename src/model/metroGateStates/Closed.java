package model.metroGateStates;

import model.MetroGate;
import model.Metrocard;

import java.time.LocalDate;

public class Closed extends MetroGateState{

    public Closed(MetroGate metroGate) {
        super(metroGate);
    }

    @Override
    public void deActivate() {
        getMetroGate().setState(new Inactive(getMetroGate()));
    }

    @Override
    public void walkThroughGate() {
        throw new IllegalArgumentException("Can't walk through gate, state is closed");
    }

    @Override
    public void scan(Metrocard metrocard) {
        if (LocalDate.now().isBefore(metrocard.getDate()) && metrocard.getAantalBeschikbareRitten() > 0) {
            getMetroGate().increaseNumberOfScannedCards();
            metrocard.setAantalBeschikbareRitten(metrocard.getAantalBeschikbareRitten()-1);
            metrocard.setAantalVerbruikteRitten(metrocard.getAantalVerbruikteRitten()+1);
            getMetroGate().setState(new Open(getMetroGate()));
        }
        throw new IllegalArgumentException("Card is expired or you have no available rides");
    }
}
