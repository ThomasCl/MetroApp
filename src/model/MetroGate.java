package model;

import model.metroGateStates.Closed;
import model.metroGateStates.Inactive;
import model.metroGateStates.MetroGateState;
import model.metroGateStates.Open;

public class MetroGate {
    private MetroGateState Closed;
    private MetroGateState Inactive;
    private MetroGateState Open;
    private MetroGateState state;
    private int id;
    private int numberOfScannedCards;

    public MetroGate(int id) {
        Closed = new Closed(this);
        Inactive = new Inactive(this);
        Open = new Open(this);
        this.state = Inactive;
        this.id = id;
    }

    public void setState(MetroGateState state) {
        this.state = state;
    }

    public void increaseNumberOfScannedCards() {
        this.numberOfScannedCards++;
    }

    public int getId() {
        return id;
    }
}
