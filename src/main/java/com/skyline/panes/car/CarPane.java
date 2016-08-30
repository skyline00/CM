package com.skyline.panes.car;

import java.io.IOException;
import java.util.List;

import com.skyline.database.entity.Car;
import com.skyline.database.entity.Owner;
import com.skyline.database.query.Queries;
import com.skyline.panes.Panes;
import com.skyline.utils.Global;
import com.skyline.utils.Messages;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class CarPane extends GridPane {
	
	@FXML
    private ListView<Car> listViewCars;
	
	private Owner owner = Global.getInstance().getOwner();
	
	public CarPane() {
		
	}

	@FXML
	void initialize() {
		fillList();
	}
	
	private void fillList() {
		List<Car> listCar = Queries.getCarsByOwner(owner);
		listViewCars.getItems().clear();
		listViewCars.getItems().addAll(listCar);
	}

    @FXML
    void actionAdd(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader(this.getClass().getResource(Panes.getAddCarPane()));
    	GridPane gp = new GridPane();
    	try {
			gp = loader.load();
			
			Scene scene = new Scene(gp);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle(Messages.addCarPane);
			stage.setOnHiding(new EventHandler<WindowEvent>() {

				public void handle(WindowEvent event) {
					fillList();
				}
				
			});
			AddCarPane addCarPane = loader.getController();
			addCarPane.setStage(stage);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void actionEdit(ActionEvent event) {

    }

    @FXML
    void actionRemove(ActionEvent event) {

    }
}
