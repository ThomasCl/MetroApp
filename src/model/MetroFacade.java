package model;

import model.database.MetrocardDatabase;
import model.database.SettingsDatabase;
import model.database.loadSaveStrategies.LoadSaveStrategy;
import model.database.loadSaveStrategies.LoadSaveStrategyFactory;
import observer.Observer;
import observer.Subject;

import java.util.ArrayList;
import java.util.HashMap;

public class MetroFacade implements Subject {
    private MetrocardDatabase metroDB;
    private LoadSaveStrategyFactory lssf;
    private MetroGate metroGate;
    HashMap<MetroEventsEnum,ArrayList<Observer>> events =new HashMap<>();
    private String loadSaveStrategy;
    private static MetroFacade instance;

    private MetroFacade(String filetype) {
        metroDB = MetrocardDatabase.getMetrocardDatabase(filetype);
        lssf = LoadSaveStrategyFactory.getInstance();
       // observers = new ArrayList<>();
    }

    public static MetroFacade getMetroFacade(String filetype) {
        if (instance == null) {
            instance = new MetroFacade(filetype);
        }
        return instance;
    }
    public ArrayList<Metrocard> getMetrocardDB(){
        return metroDB.getMetrocardList();
    }

    public void loadMCDB(){
        metroDB.load();
    }
    public void saveMCDB(){
        metroDB.save();
    }
    public void addMC(Metrocard mc){
        metroDB.add(mc);
    }

    public void chargeMetrocard(int id, int addritten){
        metroDB.chargeMetrocard(id,addritten);
    }

    public void openMetroStation() {
        String format = SettingsDatabase.getSettingsDatabase().getProperty("format");
        LoadSaveStrategy lss = lssf.createLoadSaveStrategy(format);
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

    public void notifyObservers(MetroEventsEnum metroEventsEnum) throws Exception {
        if(events!=null || events.size() != 0){
            for (Observer o : events.get(metroEventsEnum)){
                o.update();
            }
        }

    }

    public void setLoadSaveStrategy() {
        // this.loadSaveStrategy = (String) LoadSaveStrategyFactory.createLoadSaveStrategy()
    }

    public String getLoadSaveStrategy() {
        return loadSaveStrategy;
    }

    public void setProperty(String key, String value) {
        SettingsDatabase.getSettingsDatabase().setProperties(key, value);
        SettingsDatabase.getSettingsDatabase().saveProperties();
    }

    public void scanMetroGate(int metroCardID, int gateID) {

    }


}
