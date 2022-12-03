package model.database;

import model.Metrocard;
import model.database.loadSaveStrategies.LoadSaveStrategy;
import model.database.loadSaveStrategies.LoadSaveStrategyFactory;
import sun.reflect.generics.tree.Tree;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

public class MetrocardDatabase {
    private TreeMap<Integer, Metrocard> MetrocardList;

    private final File bestand;
    private final LoadSaveStrategy lss;


    MetrocardDatabase(String fileType){
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
    public void load(){
        try{
            MetrocardList = (TreeMap<Integer, Metrocard>) lss.load(bestand);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(){
        try{
            lss.save(bestand,MetrocardList);
        } catch (IOException e) {
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
}
