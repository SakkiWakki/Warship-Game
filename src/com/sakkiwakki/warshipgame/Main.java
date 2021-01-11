package com.sakkiwakki.warshipgame;
	
import com.sakkiwakki.warshipgame.view.ViewManager;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception{
		ViewManager manager = new ViewManager();
		primaryStage = manager.getMainStage();
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
