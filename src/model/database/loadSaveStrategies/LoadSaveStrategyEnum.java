package model.database.loadSaveStrategies;

public enum LoadSaveStrategyEnum {
    METROCARDEXCEL("MetrocardsExcelLoadSaveStrategy"),
    METROCARDTEKST("MetrocardsTekstLoadSaveStrategy");
    private final String location;
    LoadSaveStrategyEnum(String location){
        this.location = location;
    }
    public String getLocation(){
        return location;
    }
}


