package view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import jdk.internal.util.xml.impl.Input;
import model.Metrocard;
import model.database.MetrocardDatabase;
import model.database.loadSaveStrategies.LoadSaveStrategyFactory;
import view.panels.MetroCardOverviewPane;

import java.time.LocalDate;


public class MetroTicketView {
	private Stage stage = new Stage();
	private Button button;
	MetrocardDatabase metrocardDatabase;

	public MetroTicketView(MetrocardDatabase mcdb){
		stage.setTitle("METROTICKET VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(5);
		stage.setY(5);
		metrocardDatabase = mcdb;




		button = new Button("New Metro Card");
		button.setOnAction(e->new_mc());




		VBox root = new VBox();
		root.getChildren().addAll(button);


		Scene scene = new Scene(root, 650, 350);
		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();		
	}


	public void new_mc(){
		metrocardDatabase.load();



		Metrocard mc = new Metrocard(LocalDate.now().plusMonths(1).plusYears(1), 2,0);

		metrocardDatabase.add(mc);
		metrocardDatabase.save();



		Label select_metro_card = new Label("Select metro card");
		TextField input_select_metro_card = new TextField();
		HBox mc_id = new HBox(select_metro_card, input_select_metro_card);

		Label number_of_rides = new Label("Number of rides");
		TextField input_number_of_rides = new TextField();
		HBox rides = new HBox(number_of_rides,input_number_of_rides);

		CheckBox student = new CheckBox();
		student.setText("student?");

		ToggleGroup tg = new ToggleGroup();
		RadioButton rb1 = new RadioButton("Younger than 26 years");
		RadioButton rb2 = new RadioButton("Older than 64 years");
		RadioButton rb3 = new RadioButton("Between 26-64 years old");
		HBox age = new HBox(rb1,rb2,rb3);

		rb1.setToggleGroup(tg);
		rb2.setToggleGroup(tg);
		rb3.setToggleGroup(tg);


		Button add = new Button("Add extra rides to card");
		add.setOnAction(e-> {
//			String help = "";
//			Metrocard metrocard = metrocardDatabase.getMetrocardList().get();
		});

		Label totalPrice = new Label("Total price");
		TextField txt = new TextField();
		HBox totalPriceBox = new HBox(totalPrice,txt);




		VBox root = new VBox();
		root.getChildren().addAll(button,mc_id,rides,student,age,add, totalPriceBox);

		Scene scene = new Scene(root, 650, 350);
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
	}
}
