package model.database.loadSaveStrategies;

import model.Metrocard;
import model.database.utilities.ExcelLoadSaveTemplate;

import java.text.MessageFormat;
import java.util.ArrayList;

public class MetrocarsExcelLoadSaveStrategy extends ExcelLoadSaveTemplate {
//    @Override
//    protected Metrocard maakObject(ArrayList<String> line) {
//        return new Metrocard(Integer.parseInt(line.get(0)), line.get(1), Integer.parseInt(line.get(2)),Integer.parseInt(line.get(3)));
//    }

    @Override
    protected Metrocard maakObject(ArrayList line) {
        ArrayList<String> list = (ArrayList<String>) line;
        return new Metrocard(Integer.parseInt(list.get(0)), list.get(1), Integer.parseInt(list.get(2)),Integer.parseInt(list.get(3)));
    }

    @Override
    protected ArrayList<String> maakToken(Object object) {
        Metrocard card = (Metrocard) object;
        ArrayList<String> token = new ArrayList<>();

        token.add(Integer.toString(card.getId()));
        token.add(card.getDate());
        token.add(Integer.toString(card.getAantalBeschikbareRitten()));
        token.add(Integer.toString(card.getAantalVerbruikteRitten()));
        return token;
    }
    protected Integer getKey(ArrayList line) {
        return Integer.parseInt((String) line.get(0));
    }
}
