package view.panels;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Metrocard;
import model.database.MetrocardDatabase;
import model.database.Observer;


public class MetroCardOverviewPane extends GridPane implements Observer {
	private MetrocardDatabase mcDB;
	private TableView<Metrocard> table ;
	private ObservableList<Metrocard> metrocards;
	
	public MetroCardOverviewPane(MetrocardDatabase metrocardDatabase) {
		this.mcDB = metrocardDatabase;
		mcDB.addObserver(this);
		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
//		this.add(new Label("List of Metro cards:"), 0, 0, 1, 1);



		table = new TableView<Metrocard>();
		extracted();
	}

	private void extracted() {
		refresh();
		TableColumn<Metrocard, Integer> colId = new TableColumn<Metrocard, Integer>("ID");
		colId.setMinWidth(100);
		colId.setCellValueFactory(new PropertyValueFactory<Metrocard, Integer>("id"));

		TableColumn<Metrocard, String> colDate = new TableColumn<Metrocard, String>("Purchasing date");
		colDate.setMinWidth(100);
		colDate.setCellValueFactory(new PropertyValueFactory<Metrocard, String>("date"));

		TableColumn<Metrocard, Integer> colAvail = new TableColumn<Metrocard, Integer>("Available rides");
		colAvail.setMinWidth(100);
		colAvail.setCellValueFactory(new PropertyValueFactory<Metrocard, Integer>("aantalBeschikbareRitten"));

		TableColumn<Metrocard, Integer> colUsed = new TableColumn<Metrocard, Integer>("Used rides");
		colUsed.setMinWidth(100);
		colUsed.setCellValueFactory(new PropertyValueFactory<Metrocard, Integer>("aantalVerbruikteRitten"));

		table.getColumns().addAll(colId, colDate, colAvail, colUsed);


		this.getChildren().clear();

		this.getChildren().addAll(table);
	}


	@Override
	public void update() {
		extracted();

	}
	public void refresh(){
		metrocards = FXCollections.observableArrayList(mcDB.getMetrocardList());
		table.getColumns().clear();
		table.getItems().clear();
		table.setItems(metrocards);
		table.refresh();
	}
}
