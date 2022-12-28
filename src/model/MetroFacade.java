package model;

import model.database.MetrocardDatabase;
import model.database.SettingsDatabase;
import model.database.loadSaveStrategies.LoadSaveStrategy;
import model.database.loadSaveStrategies.LoadSaveStrategyFactory;
import observer.Observer;
import observer.Subject;

import java.util.ArrayList;

public class MetroFacade implements Subject {
    private MetrocardDatabase metroDB;
    private LoadSaveStrategyFactory lssf;
    private ArrayList<Observer> observers;
    private String loadSaveStrategy;
    private static MetroFacade instance;

    private MetroFacade(String filetype) {
        metroDB = MetrocardDatabase.getMetrocardDatabase(filetype);
        lssf = LoadSaveStrategyFactory.getInstance();
        observers = new ArrayList<>();
    }

    public static MetroFacade getMetroFacade(String filetype){
        if( instance == null){
            instance = new MetroFacade(filetype);
        }
        return instance;
    }

    public void openMetroStation(){
        String format = SettingsDatabase.getSettingsDatabase().getProperty("format");
        LoadSaveStrategy lss =  lssf.createLoadSaveStrategy(format);
        metroDB.setLoadSaveStrategy(lss);
        metroDB.load();
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
//        metroDB.setLoadSaveStrategy();
    }

    public String getLoadSaveStrategy() {
        return loadSaveStrategy;
    }
}
