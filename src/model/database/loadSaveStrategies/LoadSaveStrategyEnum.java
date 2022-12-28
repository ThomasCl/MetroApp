package model.database.loadSaveStrategies;

public enum LoadSaveStrategyEnum {
    METROCARDEXCEL("model.database.loadSaveStrategies.MetrocardsExcelLoadSaveStrategy"),
    METROCARDTEKST("model.database.loadSaveStrategies.MetrocardsTekstLoadSaveStrategy");
    private final String className;
    LoadSaveStrategyEnum(String className){
        this.className = className;
    }
    public String getClassName(){
        return className;
    }
}


