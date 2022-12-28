package model.database;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import model.Metrocard;
import model.database.loadSaveStrategies.LoadSaveStrategy;
import model.database.loadSaveStrategies.LoadSaveStrategyFactory;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class MetrocardDatabase {
    private TreeMap<Integer, Metrocard> MetrocardList;

    private final File bestand;
    private final LoadSaveStrategy lss;

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
}
