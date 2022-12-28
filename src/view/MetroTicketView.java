package view;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import model.Metrocard;
import model.TicketPriceDecorator.TicketPrice;
import model.TicketPriceDecorator.TicketPriceFactory;
import model.database.MetrocardDatabase;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;


public class MetroTicketView {
	private Stage stage = new Stage();
	private Button button;
	private Metrocard mc;
	MetrocardDatabase metrocardDatabase;
	TicketPrice ticketPrice;

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

		mc = new Metrocard(LocalDate.now().plusMonths(1).plusYears(1), 2,0);
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
		add.setOnAction(e -> {
			try {
				calculatePrice(button,mc_id, input_select_metro_card, rides, input_number_of_rides, student,rb1,rb2,rb3,age, add);
			} catch (NoSuchMethodException ex) {
				ex.printStackTrace();
			} catch (InvocationTargetException ex) {
				ex.printStackTrace();
			} catch (InstantiationException ex) {
				ex.printStackTrace();
			} catch (IllegalAccessException ex) {
				ex.printStackTrace();
			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}
		});






		VBox root = new VBox();
		root.getChildren().addAll(button,mc_id,rides,student,age,add);


		Scene scene = new Scene(root, 650, 350);
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
	}

	private void calculatePrice(Button button, HBox mc_id, TextField select_metro_card, HBox rides , TextField input_rides, CheckBox student, RadioButton r1, RadioButton r2, RadioButton r3, HBox age, Button add) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		TicketPrice ticketPrice = TicketPriceFactory.createTicketPrice(r1.isSelected(),r2.isSelected(),r3.isSelected());

		System.out.println(ticketPrice.discountPrice(mc));

		Label totalPrice = new Label("Total price: "+ticketPrice.calculatePrice(Integer.parseInt(input_rides.getText())));
		HBox totalPriceBox = new HBox(totalPrice);

		Button betaal = new Button("Betaal");
		betaal.setOnAction(e-> addRides(Integer.parseInt(input_rides.getText()), select_metro_card));

		VBox root = new VBox();
		root.getChildren().addAll(button, mc_id,  rides,  student, age, add ,totalPriceBox, betaal);


		Scene scene = new Scene(root, 650, 350);
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
	}

	private void addRides(int i, TextField select_metro_card) {
		Metrocard metrocard = metrocardDatabase.getMetrocardList().get(Integer.parseInt(select_metro_card.getText()));
		System.out.println(metrocard.getAantalBeschikbareRitten());
		metrocard.setAantalBeschikbareRitten(metrocard.getAantalBeschikbareRitten()+i);
		System.out.println(metrocard.getAantalBeschikbareRitten());
		System.out.println(ticketPrice.discountPrice(metrocard));
		metrocardDatabase.save();
	}


}
