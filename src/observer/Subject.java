package observer;

import model.MetroEventsEnum;
import java.util.ArrayList;

public interface Subject {

    ArrayList<Observer> observers = new ArrayList<>();

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();



}
