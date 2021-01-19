package com.sakkiwakki.warshipgame.view;

import java.util.ArrayList;
import java.util.List;

import com.sakkiwakki.warshipgame.resource.NoteShipsButtons;
import com.sakkiwakki.warshipgame.resource.NoteShipsSubscene;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.stage.Stage;

public class ViewManager {
	
	public static final int HEIGHT = 600;
	public static final int WIDTH = 800;
	private AnchorPane mainPane;
	private Scene mainScene; 
	private Stage mainStage;
	
	List<NoteShipsButtons> menuButtons;
	
	private NoteShipsSubscene infoSubscene;
	
	public ViewManager() {
		menuButtons = new ArrayList<>();
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane,WIDTH,HEIGHT);
		mainStage = new Stage();
		createBackground();
		createButtons();
		createTitle();
		createSubscene();
		mainStage.setTitle("NoteShips");
		mainStage.setResizable(false);
		mainStage.setScene(mainScene);
		
	}
	
	public Stage getMainStage() {
		return mainStage;
	}
	
	private void createButtons() {
		startButton();
		informationButton();
		endButton();
	}
	
	private void addMenuButtons(NoteShipsButtons button) {
		button.setLayoutX((WIDTH/2) - 100);
		button.setLayoutY((HEIGHT/2 - 50) + menuButtons.size()*100);
		menuButtons.add(button);
		mainPane.getChildren().add(button);
	}
	
	private void startButton() {
		NoteShipsButtons startButton = new NoteShipsButtons("Start Game");
		addMenuButtons(startButton);
	}
	
	private void informationButton() {
		NoteShipsButtons infoButton = new NoteShipsButtons("Information");
		addMenuButtons(infoButton);
		
		infoButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				infoSubscene.subsceneEnter();
			}
		});
	}
	
	private void createSubscene() {
		infoSubscene = new NoteShipsSubscene();
		mainPane.getChildren().add(infoSubscene);
	}
	
	private void endButton() {
		NoteShipsButtons endButton = new NoteShipsButtons("Quit");
		addMenuButtons(endButton);
		
		endButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mainStage.close();
			}
		});
	}
	
	private void createBackground() {
		Image backgroundImage = new Image("com/sakkiwakki/warshipgame/resource/image/background/background.png", 850, 600, true, true);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,BackgroundPosition.DEFAULT, null);
		mainPane.setBackground(new Background(background));
	}
	
	private void createTitle() {
		ImageView title = new ImageView("com/sakkiwakki/warshipgame/resource/image/title/title.png");
		title.setLayoutY(HEIGHT/2 - 200);
		title.setLayoutX(WIDTH/2 - 200);
		mainPane.getChildren().add(title);
	}
}
