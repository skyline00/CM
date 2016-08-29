package com.skyline.panes.main;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class AppFrame {
	
	@FXML
    private BorderPane mainBorderPane;

	@FXML
    private MenuBar menuBar;

    @FXML
    private VBox vBoxRight;
	
	@FXML
    private VBox vBoxLeft;
    
    @FXML
    void initialize() {
    	setCenter("/fxml/MainPane.fxml");
    }

	private void setCenter(String resource) {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource(resource));
    	Node node = null;
    	try {
			node = loader.load();
    	} catch(IOException e) {
			System.out.println("Cannot load TestPane");
			e.printStackTrace();
		}
    	mainBorderPane.setCenter(node);
	}
    
    @FXML
    void actionUsers(ActionEvent event) {
    	
    }
    
    @FXML
    void actionExit(ActionEvent event) {
    	Platform.exit();
    }

    @FXML
    void actionInfo(ActionEvent event) {
    	
    }
}
