package com.sakkiwakki.warshipgame.shipinfo;

public enum ShipNames implements ShipType {
	YUKIKAZE("/com/sakkiwakki/warshipgame/resource/image/ship/yukikaze.png",
			"-fx-background-color: transparent; -fx-background-image: url('/com/sakkiwakki/warshipgame/resource/image/button/yukikaze_select_normal.png')",
			"-fx-background-color: transparent; -fx-background-image: url('/com/sakkiwakki/warshipgame/resource/image/button/yukikaze_select_pressed.png')",
			"Yukikaze", 
			50, 40, 80, 80), 
	TENRYUU("/com/sakkiwakki/warshipgame/resource/image/ship/tenryuu.png",
			"-fx-background-color: transparent; -fx-background-image: url('/com/sakkiwakki/warshipgame/resource/image/button/tenryuu_select_normal.png')",
			"-fx-background-color: transparent; -fx-background-image: url('/com/sakkiwakki/warshipgame/resource/image/button/tenryuu_select_pressed.png')",
			"Tenryuu", 
			50, 70, 60, 20);
	
	String picture;
	String normal;
	String pressed;
	String name;
	int FP, AA, TRP, LCK;
	
	private ShipNames(String picture, String normalStyle, String pressedStyle, String name, int FP, int AA, int TRP, int LCK) {
		this.picture = picture;
		normal = normalStyle;
		pressed = pressedStyle;
		this.name = name;
		this.FP = FP;
		this.AA = AA;
		this.TRP = TRP;
		this.LCK = LCK;
	}
	
	public String getPicture() {
		return picture;
	}
	
	public String getNormal() {
		return normal;
	}
	
	public String getPressed() {
		return pressed;
	}
	
	public String getName() {
		return name;
	}
	
	public int getFP() {
		return FP;
	}
	
	public int getAA() {
		return AA;
	}
	
	public int getTRP() {
		return TRP;
	}
	
	public int getLCK() {
		return LCK;
	}
}
