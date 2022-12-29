package view;


import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import model.database.MetrocardDatabase;
import view.panels.ControlCenterViewPane;
import view.panels.MetroCardOverviewPane;
import view.panels.SettingsViewPane;

public class AdminMainPane extends BorderPane {
	public AdminMainPane(MetrocardDatabase mcdb){
	    TabPane tabPane = new TabPane();
        MetroCardOverviewPane metroCardOverviewPane = new MetroCardOverviewPane( );
        ControlCenterViewPane controlCenterViewPane = new ControlCenterViewPane();
        SettingsViewPane settingsviewpane = new SettingsViewPane();
        Tab metroCardOverviewTab = new Tab("Metro cards overview",metroCardOverviewPane);
        Tab controlCenterTab = new Tab("Control Center", controlCenterViewPane);
        Tab setupTab = new Tab("Setup", settingsviewpane);
        tabPane.getTabs().add(controlCenterTab);
        tabPane.getTabs().add(metroCardOverviewTab);
        tabPane.getTabs().add(setupTab);

        this.setCenter(tabPane);
	}
}
