package com.sakkiwakki.warshipgame.view;

import javafx.stage.Stage;

public class ViewManager {
	public static Stage mainStage;
	
	public ViewManager() {
		mainStage = new Stage();
		mainStage.setTitle("NoteShips");
		mainStage.setResizable(false);
		mainStage.setScene(new MainScreen());
		
	}
	
	public Stage getMainStage() {
		return mainStage;
	}
	
}
