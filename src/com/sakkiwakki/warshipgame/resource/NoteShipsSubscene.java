package com.sakkiwakki.warshipgame.resource;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	
	private NoteShipsLabels pageText;
	
	AnchorPane pane;
	
	private final static String BACKGROUND_IMAGE = "/com/sakkiwakki/warshipgame/resource/image/subscene/subscene.png";
	private final String CLOSE_BUTTON_NORMAL = "-fx-background-color: transparent; -fx-background-image: url('com/sakkiwakki/warshipgame/resource/image/button/close_button_normal.png')";
	private final String CLOSE_BUTTON_HIGHLIGHTED = "-fx-background-color: transparent; -fx-background-image: url('com/sakkiwakki/warshipgame/resource/image/button/close_button_highlighted.png')";
	
	public NoteShipsSubscene(String pageText) {
		super(new AnchorPane(), 600, 400);
		isHidden = true;
		prefWidth(600);
		prefHeight(400);
		
		BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE,600,400,false,true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		
		pane = (AnchorPane) this.getRoot();
		pane.setBackground(new Background(image));
		
		pane.getChildren().add(createCloseButton());
		
		
		ImageView yukikaze = new ImageView("/com/sakkiwakki/warshipgame/resource/image/ship/yukikaze.png");
		yukikaze.setPreserveRatio(true);
		yukikaze.setFitHeight(70);
		yukikaze.setFitWidth(150); 
		yukikaze.setLayoutX(400);
		yukikaze.setLayoutY(230);
		this.pageText = new NoteShipsLabels(15, 30, 60);
		this.pageText.setText(pageText);
		pane.getChildren().addAll(this.pageText,yukikaze);
		
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
