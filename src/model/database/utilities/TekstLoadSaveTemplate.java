package model.database.utilities;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public abstract class TekstLoadSaveTemplate <K,V>{

    public final Map<K,V> load(File file) throws IOException {
        Map<K,V> returnMap = new HashMap<K,V>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = reader.readLine();
            while (line != null && !line.trim().equals("")) {
                String[] tokens = line.split(";");
                V element = maakObject(tokens);
                K key = getKey(tokens);
                returnMap.put(key,element);
                line = reader.readLine();
            }
        }
        return returnMap;
    }

    public void save(File file, Map<K,V> writeMap) throws IOException {
        String text = "";
        for(K k: writeMap.keySet()){
            text += maakToken(writeMap.get(k));
            text += "\n";
        }

        try(BufferedWriter writer= new BufferedWriter(new FileWriter(file))) {
            writer.write(text);
        }
    }

    protected abstract V maakObject(String[] tokens);
    protected abstract String maakToken(V object);
    protected abstract K getKey(String[] tokens);
}
