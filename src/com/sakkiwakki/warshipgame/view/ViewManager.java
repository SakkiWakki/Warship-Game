package com.sakkiwakki.warshipgame.view;

import com.sakkiwakki.warshipgame.resource.WarshipGameButtons;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.stage.Stage;

public class ViewManager {
	
	private static final int HEIGHT = 600;
	private static final int WIDTH = 800;
	private AnchorPane mainPane;
	private Scene mainScene; 
	private Stage mainStage;
	
	public ViewManager() {
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane,WIDTH,HEIGHT);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		background();
		mainScreenButtons();
	}
	
	public Stage getMainStage() {
		return mainStage;
	}
	
	private void mainScreenButtons() {
		WarshipGameButtons start = new WarshipGameButtons("Game Start");
		mainPane.getChildren().add(start);
	}
	
	private void background() {
		Image backgroundImage = new Image("com/sakkiwakki/warshipgame/resource/image/background/background.png", 850, 600, true, true);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,BackgroundPosition.DEFAULT, null);
		mainPane.setBackground(new Background(background));
	}
}
