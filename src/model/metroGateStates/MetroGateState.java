package model.metroGateStates;

import model.MetroGate;
import model.Metrocard;

public abstract class MetroGateState {
    private MetroGate metroGate;

    public MetroGateState(MetroGate metroGate) {
        this.metroGate = metroGate;
    }

    public MetroGate getMetroGate() {
        return metroGate;
    }

    public void activate() {
        throw new IllegalStateException();
    }

    public void deActivate() {
        throw new IllegalStateException();
    }

    public void walkThroughGate() {
        throw new IllegalStateException();
    }

    public void scan(Metrocard metrocard) {
        throw new IllegalStateException();
    }

    public void increaseNumberOfScannedCards() {
        throw new IllegalStateException();
    }
}




