package controller;

import model.MetroFacade;
import model.database.SettingsDatabase;
import view.panels.ControlCenterViewPane;

public class ControlCenterViewController {
    private MetroFacade facade;
    private String format;

    public void ControlCenterViewController(MetroFacade facade){
        String format = SettingsDatabase.getSettingsDatabase().getProperty("format");
        this.facade = MetroFacade.getMetroFacade(format);
    }

    public void openMetroStation() {
        facade.openMetroStation();
    }
}
