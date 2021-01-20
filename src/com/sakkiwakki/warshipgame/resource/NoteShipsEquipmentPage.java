package com.sakkiwakki.warshipgame.resource;

import com.sakkiwakki.warshipgame.equipmentinfo.EquipmentNames;
import com.sakkiwakki.warshipgame.shipinfo.ShipNames;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;

public class NoteShipsEquipmentPage extends AnchorPane {
	
	private final String BACKGROUND_IMAGE = "/com/sakkiwakki/warshipgame/resource/image/subscene/select_subscene1.png";
	
	private static Label nameOfShip;
	private ShipNames ship;
	
	public NoteShipsEquipmentPage(ShipNames ship) {
		super();
		nameOfShip = new NoteShipsLabels("You have not chosen a ship.", 25, 20, 20);
		this.ship = ship;
		BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE,550,250,false,true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		setBackground(new Background(image));
		
		getChildren().add(setTitle());
		
		NoteShipsCheckboxes[] group = new NoteShipsCheckboxes[3];
		
		NoteShipsCheckboxes OXY = new NoteShipsCheckboxes(EquipmentNames.OXY_TROP, group);
		OXY.setLayoutX(20);
		OXY.setLayoutY(90);
		NoteShipsCheckboxes AP = new NoteShipsCheckboxes(EquipmentNames.AP_AMMO, group);
		AP.setLayoutX(OXY.getLayoutX()+160);
		AP.setLayoutY(90);
		NoteShipsCheckboxes HE = new NoteShipsCheckboxes(EquipmentNames.HE_AMMO, group);
		HE.setLayoutX(AP.getLayoutX()+160);
		HE.setLayoutY(90);
		group[0] = OXY;
		group[1] = AP;
		group[2] = HE;
		
		getChildren().addAll(OXY,AP,HE);
		
	}
	
	private Label setTitle() {
		try {
			nameOfShip = new NoteShipsLabels("You have chosen " + ship.getName() + ".", 25, 20, 20);
		} catch (NullPointerException e) {
			nameOfShip = new NoteShipsLabels("You have chosen no ship.", 25, 20, 20);
		}
		return nameOfShip;
	}
	
	public static Label getNameOfShip() {
		return nameOfShip;
	}
}
