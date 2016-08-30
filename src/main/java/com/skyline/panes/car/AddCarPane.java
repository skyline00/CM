package com.skyline.panes.car;

import javax.persistence.EntityManager;

import com.skyline.database.EntityManagerUtil;
import com.skyline.database.entity.Car;
import com.skyline.database.entity.Owner;
import com.skyline.panes.templates.AddPane;
import com.skyline.utils.Global;
import com.skyline.utils.Utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddCarPane extends AddPane {
	
	@FXML
    private TextField txtFieldBrand;

    @FXML
    private TextField txtFieldModel;

    @FXML
    private TextField txtFieldCapacity;

    @FXML
    private DatePicker datePickerProductionDate;

    @FXML
    private ChoiceBox<String> choiceBoxFuel;

    @FXML
    private TextField txtFieldPaint;
    
    private Stage stage;
    private Owner owner = Global.getInstance().getOwner();
    
    public AddCarPane() {
    	
    }
    
    @FXML
	public void initialize() {
		choiceBoxFuel.getItems().add("B");
		choiceBoxFuel.getItems().add("D");
		choiceBoxFuel.getItems().add("LPG");
		choiceBoxFuel.getItems().add("E");
		choiceBoxFuel.getItems().add("B+LPG");
		choiceBoxFuel.setValue(choiceBoxFuel.getItems().get(0));;
	}

    @FXML
	public void actionSave(ActionEvent event) {
    	if (verifyFields()) {
        	Car car = new Car();
        	car.setActive(true);
        	car.setOwner(owner);
        	car.setBrand(txtFieldBrand.getText());
    		car.setModel(txtFieldModel.getText());
    		car.setCapacity(Utils.stringToDouble(txtFieldCapacity.getText()));
    		car.setFuel(choiceBoxFuel.getSelectionModel().getSelectedItem());
    		car.setPaint(txtFieldPaint.getText());
    		car.setType(txtFieldPaint.getText());
    		
    		EntityManager em = EntityManagerUtil.getEntityManager();
    		em.getTransaction().begin();
    		car = em.merge(car);
    	    em.getTransaction().commit();
    	    em.close();
    	    
    	    stage.close();
    	}
    }

    @FXML
    public void actionCancel(ActionEvent event) {

    }
    
    public boolean verifyFields() {
    	if (!txtFieldBrand.getText().trim().isEmpty() && !txtFieldModel.getText().trim().isEmpty()) {
    		//if (!txtFieldCapacity.getText().trim().isEmpty()) {
    			//Utils.stringToDouble(txtFieldCapacity.getText());
    		//}
    		return true;
    	}
    	return false;
    }

    public void setStage(Stage stage) {
    	this.stage = stage;
    }
}
