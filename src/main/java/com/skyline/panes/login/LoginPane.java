package com.skyline.panes.login;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginPane {
	
	@FXML
    private TextField txtFieldLogin;

    @FXML
    private PasswordField passFieldPassword;
    
    private Stage stage;
	
	public LoginPane() {
		
	}
    
    @FXML
    void initialize() {
        assert txtFieldLogin != null : "fx:id=\"txtFieldLogin\" was not injected: check your FXML file 'LoginPane.fxml'.";
        assert passFieldPassword != null : "fx:id=\"passFieldPassword\" was not injected: check your FXML file 'LoginPane.fxml'.";
    }

    @FXML
    void actionLogin(ActionEvent event) {
    	if ("test".equals(txtFieldLogin.getText()) && "test".equals(passFieldPassword.getText())) {
    		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/AppFrame.fxml"));
    		try {
				BorderPane borderPane = loader.load();
				Scene scene = new Scene(borderPane);
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				System.out.println("Cannot load main pane.");
				e.printStackTrace();
			}
    	}
    }

    @FXML
    void actionCancel(ActionEvent event) {
    	Platform.exit();
    }

	public void setStage(Stage stage) {
		this.stage = stage;
	}

}
