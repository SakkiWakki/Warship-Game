package com.sakkiwakki.warshipgame;
	
import com.sakkiwakki.warshipgame.view.ViewManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	public static ViewManager manager = new ViewManager();
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		primaryStage = manager.getMainStage();
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
