package com.skyline.panes.owner;

import com.skyline.database.entity.Owner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;

public class OwnerPane extends StackPane {
	
	@FXML
    private ListView<Owner> listViewOwners;
    
    public OwnerPane() {
    	
    }
    
    @FXML
    void initialize() {
    	
    }

    @FXML
    void actionAdd(ActionEvent event) {

    }

    @FXML
    void actionEdit(ActionEvent event) {

    }

    @FXML
    void actionRemove(ActionEvent event) {

    }
}
