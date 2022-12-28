package controller;

import model.MetroFacade;
import view.panels.ControlCenterViewPane;

public class ControlCenterViewController {
    private MetroFacade facade;
    private ControlCenterViewPane pane;
    public void ControlCenterViewController(MetroFacade facade, ControlCenterViewPane pane){
        this.facade = facade;
        this.pane = pane;
    }

    public void openMetroStation() {
        facade.openMetroStation();
    }
}
