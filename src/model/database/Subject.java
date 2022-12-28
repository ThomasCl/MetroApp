package model.database;

import model.Metrocard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public interface Subject {

    default void addObserver(Observer o) {

    }

    default void removeObserver(Observer o) {

    }

    default void notifyObservers() {
    }
}
