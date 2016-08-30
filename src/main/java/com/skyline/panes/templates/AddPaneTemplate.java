package com.skyline.panes.templates;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public interface AddPaneTemplate {
	
	@FXML
	void initialize();

	@FXML
    void actionCancel(ActionEvent event);
	
	@FXML
    void actionSave(ActionEvent event);
	
	boolean verifyFields();
	
}
