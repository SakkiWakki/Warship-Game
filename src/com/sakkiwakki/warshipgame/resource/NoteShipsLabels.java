package com.sakkiwakki.warshipgame.resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class NoteShipsLabels extends Label {
	private final String FONT_PATH = "src/com/sakkiwakki/warshipgame/resource/font/handwritingfont.ttf";
	
	public NoteShipsLabels(String text, int n, double x, double y) {
		super(text);
		setFontSize(n);
		setLayoutX(x);
		setLayoutY(y);
	}
	
	public NoteShipsLabels(int n, double x, double y) {
		setFontSize(n);
		setLayoutX(x);
		setLayoutY(y);
	}
	
	public void setFontSize(int n) {
		try {
			setFont(Font.loadFont(new FileInputStream(FONT_PATH), n));
		} catch (FileNotFoundException e) {
			setFont(Font.font("Arial",n));
		}
	}
	
	

}
