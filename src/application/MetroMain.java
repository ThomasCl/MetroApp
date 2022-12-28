package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import model.database.MetrocardDatabase;
import view.AdminView;
import view.MetroStationView;
import view.MetroTicketView;


public class MetroMain extends Application {
	@Override
	public void start(Stage primaryStage) {
		MetrocardDatabase mcdb = new MetrocardDatabase("excel");
		AdminView adminView = new AdminView(mcdb);
		MetroTicketView metroTicketView = new MetroTicketView(mcdb);
		MetroStationView metroStationView = new MetroStationView(mcdb);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
