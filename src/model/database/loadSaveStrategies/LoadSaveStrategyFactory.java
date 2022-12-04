package model.database.loadSaveStrategies;

public class LoadSaveStrategyFactory {

    private static LoadSaveStrategyFactory only = new LoadSaveStrategyFactory();

    private LoadSaveStrategyFactory(){}
    public static LoadSaveStrategyFactory getInstance(){return only;}

    public LoadSaveStrategy createLoadSaveStrategy(String command){
        LoadSaveStrategy lss = null;
        LoadSaveStrategyEnum lssenum = LoadSaveStrategyEnum.valueOf(command);
        String location = lssenum.getLocation();
        try {
            Class lssClass = Class.forName("model.database.loadSaveStrategies." + location);
            Object objectHandler = lssClass.getConstructor().newInstance();
            lss = (LoadSaveStrategy) objectHandler;
        } catch (Exception e) {
            throw new RuntimeException("Deze pagina bestaat niet!");
        }
        return lss;
    }
}
