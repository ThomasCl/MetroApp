package model.database;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import model.Metrocard;
import model.database.loadSaveStrategies.LoadSaveStrategy;
import model.database.loadSaveStrategies.LoadSaveStrategyFactory;
import observer.Observer;
import observer.Subject;
import view.panels.MetroCardOverviewPane;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MetrocardDatabase implements Subject {
    private TreeMap<Integer, Metrocard> MetrocardList;
    private final File bestand;

    private LoadSaveStrategy lss;
    private int id=0;
    private final List<Observer> observers = new ArrayList<>();


    private static MetrocardDatabase metrocardDatabaseInstance;


    public MetrocardDatabase(String fileType){
        if(fileType.toLowerCase().equals("tekst")){
            bestand = new File("src/bestanden/metrocards.txt");
            lss = LoadSaveStrategyFactory.getInstance().createLoadSaveStrategy("METROCARDTEKST");
            load();
        } else if (fileType.toLowerCase().equals("excel")){
            bestand = new File("src/bestanden/metrocards.xls");
            lss = LoadSaveStrategyFactory.getInstance().createLoadSaveStrategy("METROCARDEXCEL");
            load();
        }
        else{
            throw new IllegalArgumentException("no viable fileType");
        }
    }

    public static MetrocardDatabase getMetrocardDatabase(String filetype){
        if(metrocardDatabaseInstance == null){
            metrocardDatabaseInstance = new MetrocardDatabase(filetype);
        }
        return metrocardDatabaseInstance;
    }
    public void load(){
        try{
            Map<Integer,Metrocard> map = lss.load(bestand);
            MetrocardList = new TreeMap<>();
            for(int i: map.keySet()){
                MetrocardList.put(i,map.get(i));
                id = map.get(i).getId();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (BiffException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(){
        try{
            lss.save(bestand,MetrocardList);
            notifyObservers();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (BiffException e) {
            throw new RuntimeException(e);
        } catch (WriteException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Metrocard> getMetrocardList(){
        ArrayList<Metrocard> m = new ArrayList<>();
        for(int i: MetrocardList.keySet()){
            m.add(MetrocardList.get(i));
        }
        return m;
    }

    public void setLoadSaveStrategy(LoadSaveStrategy lss){
        this.lss = lss;
    }

    public void add(Metrocard mc) {
        mc.setId(id + 1);
        MetrocardList.put(MetrocardList.size() + 1, mc);
    }



    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);

    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);

    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::update);

    }
}
