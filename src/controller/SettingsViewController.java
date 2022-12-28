package controller;

import model.MetroFacade;
import model.database.SettingsDatabase;
import observer.Observer;

public class SettingsViewController implements Observer {

    private MetroFacade facade;



    public SettingsViewController() {
        String format = SettingsDatabase.getSettingsDatabase().getProperty("format");
        this.facade = MetroFacade.getMetroFacade(format);
        this.facade.registerObserver(this);
    }

    public String getLoadSaveStrategy() {
        return facade.getLoadSaveStrategy();
    }
    public void setProperty(String key, String value){
        facade.setProperty(key, value);
    }

    @Override
    public void update() {
    }
}
