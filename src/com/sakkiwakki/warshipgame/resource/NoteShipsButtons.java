package com.sakkiwakki.warshipgame.resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class NoteShipsButtons extends Button {

	private final String FONT_PATH = "src/com/sakkiwakki/warshipgame/resource/font/handwritingfont.ttf";
	private final String BUTTON_NORMAL = "-fx-background-color: transparent; -fx-background-image: url('com/sakkiwakki/warshipgame/resource/image/button/button.png')";
	private final String BUTTON_ONHOLD = "-fx-background-color: transparent; -fx-background-image: url('com/sakkiwakki/warshipgame/resource/image/button/button_pressed.png')";
	
	public NoteShipsButtons(String str) {
		setText(str);
		setButtonFont();
		setPrefWidth(200);
		setPrefHeight(60);
		setStyle(BUTTON_NORMAL);
		buttonListeners();
	}
	
	private void setButtonFont() {
		try {
			setFont(Font.loadFont(new FileInputStream(FONT_PATH), 20));
		} catch (FileNotFoundException e) {
			setFont(Font.font("Arial",20));
		}
	}
	
	private void setButtonPressedStyle() {
		setStyle(BUTTON_ONHOLD);
	}
	
	private void setButtonReleaseStyle() {
		setStyle(BUTTON_NORMAL);
	}
	
	private void buttonListeners() {
		setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
			if(event.getButton().equals(MouseButton.PRIMARY))
				setButtonPressedStyle();
			}
		});
		
		setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
			if(event.getButton().equals(MouseButton.PRIMARY))
				setButtonReleaseStyle();
			}
		});
	}
}
