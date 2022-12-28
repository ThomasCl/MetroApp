package model;

import model.database.MetrocardDatabase;
import model.database.SettingsDatabase;
import model.database.loadSaveStrategies.LoadSaveStrategyFactory;
import observer.Observer;
import observer.Subject;

import java.util.ArrayList;

public class MetroFacade implements Subject {
    private MetrocardDatabase metroDB;
    private LoadSaveStrategyFactory lssf;
    private ArrayList<Observer> observers;
    private String loadSaveStrategy;

    public MetroFacade(String filetype) {
        metroDB = MetrocardDatabase.getMetrocardDatabase(filetype);
        lssf = LoadSaveStrategyFactory.getInstance();
        observers = new ArrayList<>();
    }

    public void openMetroStation(){
        SettingsDatabase.getSettingsDatabase().getProperty();

//        lssf.createLoadSaveStrategy();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {

    }

    public void setLoadSaveStrategy() {
        
    }

    public String getLoadSaveStrategy() {
        return loadSaveStrategy;
    }
}
