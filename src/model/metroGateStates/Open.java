package model.metroGateStates;

import model.MetroGate;
import model.Metrocard;

public class Open extends MetroGateState{

    public Open(MetroGate metroGate) {
        super(metroGate);
    }

    public void walkThroughGate() {
        getMetroGate().setState(new Closed(getMetroGate()));
    }

    public void scan(Metrocard metrocard) {
        throw new IllegalArgumentException("Warning, gate is already open");
    }
}
