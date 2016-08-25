package com.skyline;

import javax.persistence.EntityManager;

import com.skyline.database.EntityManagerUtil;
import com.skyline.database.entity.Owner;
import com.skyline.panes.login.LoginPane;
import com.skyline.utils.Messages;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static EntityManager em = EntityManagerUtil.getEntityManager();

	public static void main(String[] args) {
		
		Owner owner = new Owner();
		owner.setLogin("aaaa");
		owner.setPassword("aaaa");
		owner.setActive(true);
		
		em.getTransaction().begin();
		owner = em.merge(owner);
	    em.getTransaction().commit();
		
		//launch(args);
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
