package model.database.loadSaveStrategies;

import model.Metrocard;
import model.database.utilities.TekstLoadSaveTemplate;

import java.text.MessageFormat;

public class MetrocardsTekstLoadSaveStrategy extends TekstLoadSaveTemplate {
@Override
    protected Metrocard maakObject(String[] tokens) {
    Metrocard metrocard = new Metrocard(Integer.parseInt(tokens[0]),tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
    return metrocard;

    }
@Override
    protected String maakToken(Object object) {
        Metrocard card = (Metrocard) object;
        return MessageFormat.format("%s;%s;%s;%s;",card.getId(),card.getDate(),card.getAantalBeschikbareRitten(),card.getAantalVerbruikteRitten());
    }
    protected Integer getKey(String[] tokens) {
        return Integer.parseInt(tokens[0]);
    }


}
