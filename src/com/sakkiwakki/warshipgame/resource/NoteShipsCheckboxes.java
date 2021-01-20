package com.sakkiwakki.warshipgame.resource;

import com.sakkiwakki.warshipgame.equipmentinfo.EquipmentNames;
import com.sakkiwakki.warshipgame.view.SelectScreen;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class NoteShipsCheckboxes extends CheckBox{
	
	private String NORMAL;
	private String PRESSED;
	private EquipmentNames equip;
	
	public NoteShipsCheckboxes(EquipmentNames equipment, NoteShipsCheckboxes[] group) {
		super();
		NORMAL = equipment.getNormal();
		PRESSED = equipment.getPressed();
		equip = equipment;
		setPrefSize(150,90);
		setStyle(NORMAL);
		
		setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				NoteShipsStatsCalc.refreshNums();
				if(event.getButton().equals(MouseButton.PRIMARY))
					if (!isSelected()) {
						setStyle(NORMAL);
					} else if (equipment.getName().contains("Ammo")) {
						for (NoteShipsCheckboxes i: group) 
							if (i.getEquipment().getName().contains("Ammo")) {
								i.setStyle(i.getNormal());
								i.setSelected(false);
							}
						setSelected(true);
						setStyle(PRESSED);
					} else {
						setStyle(PRESSED);
					}
				for (NoteShipsCheckboxes i: group) {
					if (i.isSelected() && !SelectScreen.equipList.contains(i.getEquipment())) {
						SelectScreen.equipList.add(i.getEquipment());
						NoteShipsStatsCalc.refreshNums();
					}
					if (!i.isSelected() && SelectScreen.equipList.contains(i.getEquipment())) {
						SelectScreen.equipList.remove(SelectScreen.equipList.indexOf(i.getEquipment()));
						NoteShipsStatsCalc.refreshNums();
					}
				}
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
	
	public EquipmentNames getEquipment() {
		return equip;
	}
	
}
