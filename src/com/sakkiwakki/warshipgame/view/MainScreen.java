package com.sakkiwakki.warshipgame.view;

import java.util.ArrayList;
import java.util.List;

import com.sakkiwakki.warshipgame.Main;
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

public class MainScreen extends Scene{
	
	public static final int HEIGHT = 600;
	public static final int WIDTH = 800;
	private AnchorPane mainPane;
	
	List<NoteShipsButtons> menuButtons;
	
	private NoteShipsSubscene infoSubscene;
	

	public MainScreen() {
		super(new AnchorPane(),WIDTH,HEIGHT);
		menuButtons = new ArrayList<>();
		mainPane = (AnchorPane) this.getRoot();
		createBackground();
		createButtons();
		createTitle();
		createSubscene();

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
		
		startButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Main.manager.getMainStage().setScene(new SelectScreen());
			}
		});
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
		infoSubscene = new NoteShipsSubscene("Yukikaze\nYukikaze was a Kagerou-class destroyer part of the IJN \n She was known as the lucky ship because\nof her extraordinary abilities to survive battles without a scratch.\nHowever, those around her viewed her as bad luck because\nit seemed as if she absorbed all their luck.\nShe was one of the only surviving IJN destroyers\nafter WWII, and ended up getting damaged by a Tycoon\n70 years later in Taiwan.");
		mainPane.getChildren().add(infoSubscene);
	}
	
	private void endButton() {
		NoteShipsButtons endButton = new NoteShipsButtons("Quit");
		addMenuButtons(endButton);
		
		endButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Main.manager.getMainStage().close();
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
