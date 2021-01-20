package com.sakkiwakki.warshipgame.resource;

import com.sakkiwakki.warshipgame.view.SelectScreen;

public class NoteShipsLevelStatsLabel extends NoteShipsLabels {
	public NoteShipsLevelStatsLabel() {
		super(20,25,20);
		
		createStats();
	}
	
	public void createStats() {
		if (NoteShipsStatsCalc.calculateTotalLCK() == 0) {
			this.setText("Stats:\nFP = 0\nAA = 0\nTRP = 0\nLCK = 0");
		} else {
		try {
			this.setText("Stats:\nFP = " + NoteShipsStatsCalc.calculateTotalFP() + "\nAA = " + NoteShipsStatsCalc.calculateTotalAA() + "\nTRP = " + NoteShipsStatsCalc.calculateTotalTRP() + "\nLCK = " + NoteShipsStatsCalc.calculateTotalLCK());
		} catch (Exception e){
			this.setText("Stats:\nFP = 0\nAA = 0\nTRP = 0\nLCK = 0");
		}
		}
	}
}
