package model.database.loadSaveStrategies;

import model.Metrocard;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public interface LoadSaveStrategy<K,V> {
    Map<K,V> load(File file) throws IOException;
    void save(File file, Map<K, V> list) throws IOException;
}
