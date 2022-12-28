package model;

import model.metroGateStates.Closed;
import model.metroGateStates.MetroGateState;

import java.util.ArrayList;

public class MetroStation {
    private ArrayList<MetroGate> metroGates;

    public MetroStation(MetroStation m) {
        metroGates = new ArrayList<>();
    }

    public void addMetroGate(){

        metroGates.add(new MetroGate(metroGates.get(metroGates.size()-1).getId() + 1));
    }


}
