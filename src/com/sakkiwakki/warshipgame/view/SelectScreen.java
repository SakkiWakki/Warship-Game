package com.sakkiwakki.warshipgame.view;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.sakkiwakki.warshipgame.equipmentinfo.EquipmentNames;
import com.sakkiwakki.warshipgame.resource.NoteShipsEquipmentPage;
import com.sakkiwakki.warshipgame.resource.NoteShipsLabels;
import com.sakkiwakki.warshipgame.resource.NoteShipsLevelStatsLabel;
import com.sakkiwakki.warshipgame.resource.NoteShipsStatsCalc;
import com.sakkiwakki.warshipgame.resource.NoteShipsToggleButtons;
import com.sakkiwakki.warshipgame.shipinfo.ShipNames;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.text.Font;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class SelectScreen extends Scene {
	
	private final String FONT_PATH = "src/com/sakkiwakki/warshipgame/resource/font/handwritingfont.ttf";
	private final String BACKGROUND_IMAGE_1 = "/com/sakkiwakki/warshipgame/resource/image/subscene/select_subscene1.png";
	private final String BACKGROUND_IMAGE_2 = "/com/sakkiwakki/warshipgame/resource/image/subscene/select_subscene2.png";
	private final String SELECT_START_NORMAL = "-fx-background-color: transparent; -fx-background-image: url('/com/sakkiwakki/warshipgame/resource/image/button/select_screen_start_normal.png')";
	private final String SELECT_START_PRESSED = "-fx-background-color: transparent; -fx-background-image: url('/com/sakkiwakki/warshipgame/resource/image/button/select_screen_start_pressed.png')";

	private SubScene shipSelect;
	private SubScene equipSelect;
	private SubScene levelStats;
	private Button startButton;
	
	//For Ships Selection
	NoteShipsToggleButtons yukikaze;
	NoteShipsToggleButtons tenryuu;
	
	public static ShipNames whichShip = ShipNames.YUKIKAZE;
	
	public static List<EquipmentNames> equipList;
	
	public static boolean gameStart = false;
	
	AnchorPane mainPane;
	
	public static final int HEIGHT = 600;
	public static final int WIDTH = 800;
	
	
	public SelectScreen() {
		super(new AnchorPane(),WIDTH,HEIGHT);
		NoteShipsStatsCalc.refreshNums();
		Label title = new NoteShipsLabels("Ship Select",40,80,0);
		mainPane = (AnchorPane) this.getRoot();
		mainPane.getChildren().add(title);
		createBackground();
		mainPane.getChildren().addAll(shipSubscene(),equipSubscene(),levelStatsSubscene(),startButton());
		
	}
	
	private SubScene shipSubscene() {
		shipSelect = new SubScene(new AnchorPane(), 550, 250);
		shipSelect.setLayoutY(shipSelect.getLayoutY()+80);
		shipSelect.setLayoutX(shipSelect.getLayoutX()+10);
		BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE_1,550,250,false,true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		AnchorPane pane = (AnchorPane) shipSelect.getRoot();
		
		ToggleGroup shipsGroup = new ToggleGroup();
		
		NoteShipsToggleButtons[] shipsList = new NoteShipsToggleButtons[2];
		
		yukikaze = new NoteShipsToggleButtons(ShipNames.YUKIKAZE, shipsList);
		tenryuu = new NoteShipsToggleButtons(ShipNames.TENRYUU, shipsList);
		
		shipsList[0] = yukikaze;
		shipsList[1] = tenryuu;
		
		yukikaze.setToggleGroup(shipsGroup);
		yukikaze.setLayoutY(20);
		yukikaze.setLayoutX(20);
		tenryuu.setToggleGroup(shipsGroup);
		tenryuu.setLayoutY(yukikaze.getLayoutY());
		tenryuu.setLayoutX(yukikaze.getLayoutX() + 160);
		pane.getChildren().addAll(yukikaze,tenryuu);
		pane.setBackground(new Background(image));
		
		return shipSelect;
	}
	
	private SubScene equipSubscene() {
		equipList = new ArrayList<EquipmentNames>();
		equipSelect = new SubScene(new NoteShipsEquipmentPage(whichShip), 550, 250);
		equipSelect.setLayoutY(equipSelect.getLayoutY()+330);
		equipSelect.setLayoutX(equipSelect.getLayoutX()+10);
		
		return equipSelect;
	}
	
	
	public static NoteShipsLevelStatsLabel statsLabel = new NoteShipsLevelStatsLabel();
	
	private SubScene levelStatsSubscene() {
		levelStats = new SubScene(new AnchorPane(), 200, 430);
		levelStats.setLayoutX(levelStats.getLayoutX()+565);
		levelStats.setLayoutY(levelStats.getLayoutY()+80);
		
		BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE_2,200,430,false,true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		AnchorPane pane = (AnchorPane) levelStats.getRoot();
		
		pane.getChildren().add(statsLabel);
		pane.setBackground(new Background(image));
		return levelStats;
	}
	
	private Button startButton() {
		startButton = new Button("Start");
		startButton.setLayoutX(levelStats.getLayoutX());
		startButton.setLayoutY(levelStats.getLayoutY()+440);
		startButton.setPrefSize(200,65);
		startButton.setStyle(SELECT_START_NORMAL);
		try {
			startButton.setFont(Font.loadFont(new FileInputStream(FONT_PATH), 20));
		} catch (FileNotFoundException e) {
			startButton.setFont(Font.font("Arial",20));
		}
		
		startButton.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
			if(event.getButton().equals(MouseButton.PRIMARY))
				startButton.setStyle(SELECT_START_PRESSED);
			}
		});
		
		startButton.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
			if(event.getButton().equals(MouseButton.PRIMARY))
				startButton.setStyle(SELECT_START_NORMAL);
			}
		});
		
		startButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
			if(whichShip == null) {
				return;
			} else {
				ViewManager.mainStage.setScene(new StageOne());
			}
				
			}
		});
		
		return startButton;
	}
	
	private void createBackground() {
		Image backgroundImage = new Image("com/sakkiwakki/warshipgame/resource/image/background/background.png", 850, 600, true, true);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,BackgroundPosition.DEFAULT, null);
		mainPane.setBackground(new Background(background));
	}
}
