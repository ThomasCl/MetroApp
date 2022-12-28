package model.metroGateStates;

import model.MetroGate;
import model.Metrocard;

public class Inactive extends MetroGateState{
    public Inactive(MetroGate metroGate) {
        super(metroGate);
    }

    public void activate() {
        getMetroGate().setState(new Closed(getMetroGate()));
    }
}
