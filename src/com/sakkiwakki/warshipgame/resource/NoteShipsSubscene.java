package com.sakkiwakki.warshipgame.resource;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.util.Duration;

public class NoteShipsSubscene extends SubScene{
	
	private Button closeButton;
	
	private boolean isHidden;
	
	private final static String BACKGROUND_IMAGE = "/com/sakkiwakki/warshipgame/resource/image/subscene/subscene.png";
	private final String CLOSE_BUTTON_NORMAL = "-fx-background-color: transparent; -fx-background-image: url('com/sakkiwakki/warshipgame/resource/image/button/close_button_normal.png')";
	private final String CLOSE_BUTTON_HIGHLIGHTED = "-fx-background-color: transparent; -fx-background-image: url('com/sakkiwakki/warshipgame/resource/image/button/close_button_highlighted.png')";
	
	public NoteShipsSubscene() {
		super(new AnchorPane(), 600, 400);
		isHidden = true;
		prefWidth(600);
		prefHeight(400);
		
		BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE,600,400,false,true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		
		AnchorPane pane = (AnchorPane) this.getRoot();
		pane.setBackground(new Background(image));
		
		pane.getChildren().add(createCloseButton());
		
		
		setLayoutX(1024);
		setLayoutY(180);
	}
	
	public Button createCloseButton() {
		closeButton = new Button();
		closeButton.setLayoutX(515);
		closeButton.setLayoutY(30);
		closeButton.setPrefSize(50,50);
		closeButton.setStyle(CLOSE_BUTTON_NORMAL);
		closeButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				closeButton.setStyle(CLOSE_BUTTON_HIGHLIGHTED);
			}
		});
		closeButton.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				closeButton.setStyle(CLOSE_BUTTON_NORMAL);
			}
		});
		closeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				subsceneExit();
			}
		});
		return closeButton;
	}
	
	public void subsceneEnter() {
		if (isHidden) {
			TranslateTransition transition = new TranslateTransition();
			transition.setDuration(Duration.seconds(0.25));
			transition.setNode(this);
			transition.setFromX(0);
			transition.setFromY(0);
			transition.setToX(-925);
			transition.play();
			isHidden = false;
		}
	}
	
	public void subsceneExit() {
		if (!isHidden) {
			TranslateTransition transition = new TranslateTransition();
			transition.setDuration(Duration.seconds(0.25));
			transition.setNode(this);
			transition.setToY(800);
			transition.play();
			isHidden = true;
		}
	}
}
