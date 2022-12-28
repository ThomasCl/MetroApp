package view.panels;

import controller.SettingsViewController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SettingsViewPane extends GridPane{

    private SettingsViewController controller;

    private ChoiceBox<String> loadSaveSetting;

    private Button buttonSave;

    public  SettingsViewPane(){

        this.controller = new SettingsViewController();
        this.setPadding(new Insets(5,5,5,5));
        this.setVgap(5);
        this.setHgap(5);

        VBox p1 = new VBox(0);
        p1.setAlignment(Pos.TOP_CENTER);
        p1.setPadding(new Insets(0));
        p1.setMinSize(520, 200);
        HBox p1c1 = new HBox(0);
        p1c1.setPadding(new Insets(0));
        p1c1.setAlignment(Pos.TOP_CENTER);
        p1.setMinSize(500, 200);
        p1.setMargin(p1c1, new Insets(100, 0, 0, 0));

        loadSaveSetting = new ChoiceBox<>();
        loadSaveSetting.getItems().add("Tekst");
        loadSaveSetting.getItems().add("excel");
        loadSaveSetting.setValue(controller.getLoadSaveStrategy());

        loadSaveSetting.setStyle("-fx-border-color: black;-fx-min-width: 70px;-fx-border-radius: 8px;-fx-background-radius: 8px;");

        buttonSave = new Button("Save");
        loadSaveSetting.setStyle("-fx-border-color: black;-fx-min-width: 70px;-fx-border-radius: 8px;-fx-background-radius: 8px;");

        this.getChildren().addAll(loadSaveSetting, buttonSave);

        buttonSave.setOnAction(a -> {
            controller.setProperty("format", loadSaveSetting.getValue());
        });
    }

}


