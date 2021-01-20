package com.sakkiwakki.warshipgame.resource;

import com.sakkiwakki.warshipgame.view.SelectScreen;

public class NoteShipsStatsCalc {

	public static int[] FP = {SelectScreen.whichShip.getFP(), 0, 0, 0};
	public static int[] AA = {SelectScreen.whichShip.getAA(), 0, 0, 0};
	public static int[] TRP = {SelectScreen.whichShip.getTRP(), 0, 0, 0};
	public static int[] LCK = {SelectScreen.whichShip.getLCK(), 0, 0, 0};
	
	public static void refreshNums() {
		try {
			FP[0] = SelectScreen.whichShip.getFP();
			AA[0] = SelectScreen.whichShip.getAA();
			TRP[0] = SelectScreen.whichShip.getTRP();
			LCK[0] = SelectScreen.whichShip.getLCK();
		for (int i = 1; i-1 < 3; i++) {
			try {
			FP[i] = SelectScreen.equipList.get(i-1).getFP();
			AA[i] = SelectScreen.equipList.get(i-1).getAA();
			TRP[i] = SelectScreen.equipList.get(i-1).getTRP();
			} catch (Exception e) {
				FP[i] = 0;
				AA[i] = 0;
				TRP[i] = 0;
			}
		}
		} catch (NullPointerException e) {
			FP[0] = 0;
			AA[0] = 0;
			TRP[0] = 0;
			LCK[0] = 0;
			for (int i = 1; i-1 < 0; i++) {
				FP[i] = SelectScreen.equipList.get(i-1).getFP();
				AA[i] = SelectScreen.equipList.get(i-1).getAA();
				TRP[i] = SelectScreen.equipList.get(i-1).getTRP();
				System.out.println(FP[i]);
			}
		}

	}
	
	public static int calculateTotalFP() {
		int total = 0;
		for (int i: FP) {
			total += i;
		}
		return total;
	}
	
	public static int calculateTotalAA() {
		int total = 0;
		for (int i: AA) {
			total += i;
		}
		return total;
	}
	
	public static int calculateTotalTRP() {
		int total = 0;
		for (int i: TRP) {
			total += i;
		}
		return total;
	}
	
	public static int calculateTotalLCK() {
		int total = 0;
		for (int i: LCK) {
			total += i;
		}
		return total;
	}
}
