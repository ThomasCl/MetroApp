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

		MetrocardDatabase mcdb = MetrocardDatabase.getMetrocardDatabase("excel");
		AdminView adminView = new AdminView(mcdb);
		MetroTicketView metroTicketView = new MetroTicketView(mcdb);
		MetroStationView metroStationView = new MetroStationView(mcdb);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
