package controller;

import model.MetroFacade;
import model.Metrocard;
import model.database.SettingsDatabase;
import view.panels.MetroCardOverviewPane;

import java.util.ArrayList;

public class MetroCardOverviewPaneController {
    private String format = SettingsDatabase.getSettingsDatabase().getProperty("format");
    private MetroFacade facade = MetroFacade.getMetroFacade(format);

    public void MetroTicketViewController(){}

    public void registerObserver(MetroCardOverviewPane metroCardOverviewPane) {
        facade.registerObserver(metroCardOverviewPane);
    }

    public ArrayList<Metrocard> getMetrocardList() {
        return facade.getMetrocardDB();
    }
}
