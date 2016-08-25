package com.skyline;

import com.skyline.panes.login.LoginPane;
import com.skyline.utils.Messages;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("/fxml/LoginPane.fxml"));
		BorderPane borderPane = loader.load();
		
		LoginPane loginPane = loader.getController();
		loginPane.setStage(primaryStage);
		
		Scene scene = new Scene(borderPane);
		
		primaryStage.setScene(scene);
		//primaryStage.setMaximized(true);
		//primaryStage.setFullScreen(true);
		primaryStage.setTitle(Messages.title);
		primaryStage.show();
	}

}
