package model.database.loadSaveStrategies;

import java.io.*;
import java.util.Properties;

public class SettingsLoadSave {

    public Properties load(){
        Properties properties = new Properties();
        try{
            InputStream is = new FileInputStream("src/bestanden/settings.properties");
            properties.load(is);
            is.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
    public void save(Properties properties){
        try{
            OutputStream stream = new FileOutputStream("src/bestanden/settings.properties");
            properties.store(stream, "settings");
            stream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//    public void use(Properties properties){
//        Object dbType = properties.getProperty(“format”);
//        String dbTypeName = (String) dbType;
//        properties.setProperty(“format”, “excel”);
//    }
}
