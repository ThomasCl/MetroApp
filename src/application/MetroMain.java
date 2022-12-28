package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import model.database.MetrocardDatabase;
import view.AdminView;
import view.MetroStationView;
import view.MetroTicketView;
import view.panels.ControlCenterViewPane;


public class MetroMain extends Application {
	@Override
	public void start(Stage primaryStage) {
		MetrocardDatabase mcDB = new MetrocardDatabase("excel");
		AdminView adminView = new AdminView(mcDB);
		MetroTicketView metroTicketView = new MetroTicketView(mcDB);
		MetroStationView metroStationView = new MetroStationView(mcDB);
//		ControlCenterViewPane controlCenterViewPane = new ControlCenterViewPane();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
