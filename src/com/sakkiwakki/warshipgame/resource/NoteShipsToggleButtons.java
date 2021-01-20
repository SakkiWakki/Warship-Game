package com.sakkiwakki.warshipgame.resource;

import com.sakkiwakki.warshipgame.shipinfo.ShipNames;
import com.sakkiwakki.warshipgame.view.SelectScreen;

import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class NoteShipsToggleButtons extends ToggleButton {
	private String NORMAL;
	private String PRESSED;
	
	public NoteShipsToggleButtons(ShipNames ship, NoteShipsToggleButtons[] group) {
		super();
		NORMAL = ship.getNormal();
		PRESSED = ship.getPressed();
		setPrefSize(150,90);
		setStyle(NORMAL);
		if (ship.equals(ShipNames.YUKIKAZE)) setStyle(PRESSED);
		
		setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				NoteShipsStatsCalc.refreshNums();
				if(event.getButton().equals(MouseButton.PRIMARY)) 
					if (!isSelected()) {
						setStyle(NORMAL);
						NoteShipsEquipmentPage.getNameOfShip().setText("You have not chosen a ship");
						SelectScreen.whichShip = null;
						NoteShipsStatsCalc.refreshNums();

					} else {
						for (NoteShipsToggleButtons i: group) 
							i.setStyle(i.getNormal());
						setStyle(PRESSED);
						SelectScreen.whichShip = ship;
						NoteShipsEquipmentPage.getNameOfShip().setText("You have chosen " + ship.getName() + ".");
						NoteShipsStatsCalc.refreshNums();
					}
				NoteShipsStatsCalc.refreshNums();
				SelectScreen.statsLabel.createStats();
			}
		});
		
		
	}
	
	public String getNormal() {
		return NORMAL;
	}
	
	public String getPressed() {
		return PRESSED;
	}
	
}
