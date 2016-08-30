package com.skyline.panes.login;

import java.io.IOException;

import com.skyline.database.entity.Owner;
import com.skyline.database.query.Queries;
import com.skyline.utils.Global;
import com.skyline.utils.Messages;
import com.skyline.utils.Utils;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginPane {
	
	@FXML
    private TextField txtFieldLogin;

    @FXML
    private PasswordField passFieldPassword;
    
    @FXML
    private Button btnLogin;
    
    private Stage stage;
    
    private Owner owner;
	
	public LoginPane() {
		
	}
    
    @FXML
    void initialize() {
    }

    @FXML
    void actionLogin(ActionEvent event) {
    	login();
    }

    @FXML
    void keyPressed(KeyEvent event) {
    	if (event.getCode() == KeyCode.ENTER) {
    		login();
    	}
    }

	private void login() {
		if (verify()) {
    		owner = Queries.getOwnerByLogin(txtFieldLogin.getText());
    		if (owner != null) {
    			Global.getInstance().setOwner(owner);
	    		if (matchPasswords(passFieldPassword.getText())) {
	    			FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/AppFrame.fxml"));
		    		try {
						BorderPane borderPane = loader.load();
						Scene scene = new Scene(borderPane);
						stage.setScene(scene);
						stage.setMaximized(true);
						stage.show();
					} catch (IOException e) {
						System.out.println("Cannot load main pane.");
						e.printStackTrace();
					}
	    		} else {
	    			Utils.showAlert(Messages.warning, Messages.incorrectLoginOrPass, Messages.incorrectLoginOrPass, AlertType.WARNING);
	    		}
    		} else {
    			Utils.showAlert(Messages.warning, Messages.noSuchLogin, Messages.noSuchLogin + txtFieldLogin.getText(), AlertType.WARNING);
    		}
    	} else {
    		Utils.showAlert(Messages.warning, Messages.incompleteFields, Messages.noLoginOrPass, AlertType.WARNING);
    	}
	}

	@FXML
    void actionCancel(ActionEvent event) {
    	Platform.exit();
    }
    
    private boolean verify() {
    	return !txtFieldLogin.getText().trim().isEmpty() && !passFieldPassword.getText().trim().isEmpty();
    }

    private boolean matchPasswords(String pass) {
    	String p = Utils.hashMD5(pass);
		if (p.equals(owner.getPassword())) {
			return true;
		}
		return false;
	}
    
	public void setStage(Stage stage) {
		this.stage = stage;
	}

}
