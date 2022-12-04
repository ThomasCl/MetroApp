package model.database.utilities;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import model.Metrocard;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public abstract class ExcelLoadSaveTemplate<K,V> {
    public final Map<K,V> load(File file) throws IOException, BiffException {
        Map<K,V> returnmap = new HashMap<K,V>();
        ArrayList<ArrayList<String>> total = ExcelPlugin.read(file);
        for(ArrayList<String> line: total){
            V element = maakObject(line);
            K key = getKey(line);
            returnmap.put(key,element);
        }
        return returnmap;
    }
    public void save(File file, Map<K,V> writeMap) throws BiffException, WriteException, IOException {
        ArrayList<ArrayList<String>> total = new ArrayList<>();
        for(K k: writeMap.keySet()){
            total.add(maakToken(writeMap.get(k)));
        }
        ExcelPlugin.write(file,total);
    }

    protected abstract V maakObject(ArrayList<String> line);
    protected abstract ArrayList<String> maakToken(V object);
    protected abstract K getKey(ArrayList<String> line);
}
