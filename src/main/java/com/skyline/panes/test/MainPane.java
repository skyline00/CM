package com.skyline.panes.test;

import com.skyline.utils.CenterPane;
import com.skyline.utils.Utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;

public class MainPane extends GridPane implements CenterPane {
	
	public MainPane() {
		
	}
	
	@FXML
	void initialize() {
		
	}
	
	@FXML
    void actionAlert(ActionEvent event) {
		Utils.showAlert("aa", "aa", "aa", AlertType.INFORMATION);
    }
}
