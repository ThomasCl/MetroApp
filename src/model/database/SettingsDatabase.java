package model.database;

import model.database.loadSaveStrategies.SettingsLoadSave;

import java.util.Properties;

public class SettingsDatabase {
    private final SettingsLoadSave settingsLoadSave = new SettingsLoadSave();
    private Properties properties;

    public SettingsDatabase(){
        this.properties = settingsLoadSave.load();
    }

    public String getProperty(String property){
        return properties.getProperty(property);
    }
    public void setProperties(String key, String value){
        properties.setProperty(key,value);
    }

    public void saveProperties(){
        settingsLoadSave.save(properties);
    }
}
