package model.database.loadSaveStrategies;

import model.Metrocard;

import java.util.TreeMap;

public interface LoadSaveStrategy {
    public TreeMap<Integer, Metrocard> load();
    public void save();
}
