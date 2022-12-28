package controller;

import model.MetroFacade;
import observer.Observer;

public class SettingsViewController implements Observer {

    private MetroFacade facade;

    public SettingsViewController(MetroFacade facade) {
        this.facade = facade;
        this.facade.registerObserver(this);
    }

    public String getLoadSaveStrategy() {
        return facade.getLoadSaveStrategy();
    }

    @Override
    public void update() {

    }
}
