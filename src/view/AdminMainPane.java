package view;


import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import model.database.MetrocardDatabase;
import view.panels.ControlCenterViewPane;
import view.panels.MetroCardOverviewPane;

public class AdminMainPane extends BorderPane {
	public AdminMainPane(){
	    TabPane tabPane = new TabPane();
        MetrocardDatabase mcdb = new MetrocardDatabase("excel");
        MetroCardOverviewPane metroCardOverviewPane = new MetroCardOverviewPane(mcdb);
        ControlCenterViewPane controlCenterViewPane = new ControlCenterViewPane();
	//maak een controlCenterPane aan
	//maak een setupPane aan
        Tab metroCardOverviewTab = new Tab("Metro cards overview",metroCardOverviewPane);
        Tab controlCenterTab = new Tab("Control Center", controlCenterViewPane);
        Tab setupTab = new Tab("Setup");
        tabPane.getTabs().add(controlCenterTab);
        tabPane.getTabs().add(metroCardOverviewTab);
        tabPane.getTabs().add(setupTab);

        this.setCenter(tabPane);
	}
}
