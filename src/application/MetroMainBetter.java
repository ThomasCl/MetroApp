package application;

import javafx.application.Application;
import javafx.stage.Stage;
import model.database.MetrocardDatabase;
import model.database.SettingsDatabase;
import view.AdminView;
import view.MetroStationView;
import view.MetroTicketView;


public class MetroMainBetter extends Application {

	@Override
	public void start(Stage primaryStage) {
		String format = SettingsDatabase.getSettingsDatabase().getProperty("format");
		if (format == null) {
			format = "excel";
		}

		MetrocardDatabase mcdb = MetrocardDatabase.getMetrocardDatabase(format);
		AdminView adminView = new AdminView(mcdb);
		MetroTicketView metroTicketView = new MetroTicketView(mcdb);
		MetroStationView metroStationView = new MetroStationView(mcdb);
		}

	public static void main(String[] args) {
		launch(args);
	}
}
