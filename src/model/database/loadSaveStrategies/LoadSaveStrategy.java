package model.database.loadSaveStrategies;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import model.Metrocard;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public interface LoadSaveStrategy<K,V> {
    Map<K,V> load(File file) throws IOException, BiffException;
        void save(File file, Map<K,V> list) throws BiffException, WriteException, IOException;
}
