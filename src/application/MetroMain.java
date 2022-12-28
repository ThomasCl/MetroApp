package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import model.Metrocard;
import model.database.MetrocardDatabase;
import view.AdminView;
import view.MetroStationView;
import view.MetroTicketView;
import view.panels.ControlCenterViewPane;

import java.util.ArrayList;


public class MetroMain extends Application {
	@Override
	public void start(Stage primaryStage) {
<<<<<<< HEAD

		MetrocardDatabase mcdb = MetrocardDatabase.getMetrocardDatabase("excel");
		AdminView adminView = new AdminView(mcdb);
		MetroTicketView metroTicketView = new MetroTicketView(mcdb);
		MetroStationView metroStationView = new MetroStationView(mcdb);
=======
		MetrocardDatabase mcDB = new MetrocardDatabase("excel");
		AdminView adminView = new AdminView(mcDB);
		MetroTicketView metroTicketView = new MetroTicketView(mcDB);
		MetroStationView metroStationView = new MetroStationView(mcDB);
//		ControlCenterViewPane controlCenterViewPane = new ControlCenterViewPane();
>>>>>>> 8a6da47d549c5924f9a3867276e190be86f7aecd
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
