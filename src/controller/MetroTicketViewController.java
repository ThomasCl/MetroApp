package controller;

import model.MetroFacade;
import model.Metrocard;
import model.database.MetrocardDatabase;
import model.database.SettingsDatabase;

import java.util.ArrayList;

public class MetroTicketViewController {
    private String format = SettingsDatabase.getSettingsDatabase().getProperty("format");
    private MetroFacade facade = MetroFacade.getMetroFacade(format);

    public void MetroTicketViewController(){}


    public ArrayList<Metrocard> getMetrocardDB(){
        return facade.getMetrocardDB();
    }

    public void loadMCDB(){
        facade.loadMCDB();
    }
    public void saveMCDB(){
        facade.saveMCDB();
    }

    public void addMC(Metrocard mc){
        facade.addMC(mc);
    }
    public void chargeMetrocard(int id, int addritten){
        facade.chargeMetrocard(id, addritten);
    }
}
