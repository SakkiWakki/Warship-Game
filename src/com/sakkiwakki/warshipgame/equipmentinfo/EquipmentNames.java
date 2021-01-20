package com.sakkiwakki.warshipgame.equipmentinfo;

public enum EquipmentNames {
	OXY_TROP(null,
			"-fx-background-color: transparent; -fx-background-image: url('/com/sakkiwakki/warshipgame/resource/image/button/oxy_trop_normal.png')",
			"-fx-background-color: transparent; -fx-background-image: url('/com/sakkiwakki/warshipgame/resource/image/button/oxy_trop_pressed.png')",
			"Type 93 Oxygen Torpedo",
			0, 0, 20),
	HE_AMMO(null,
			"-fx-background-color: transparent; -fx-background-image: url('/com/sakkiwakki/warshipgame/resource/image/button/HE_normal.png')",
			"-fx-background-color: transparent; -fx-background-image: url('/com/sakkiwakki/warshipgame/resource/image/button/HE_pressed.png')",
			"HE Ammo",
			10, 5, 0),
	AP_AMMO(null, 
			"-fx-background-color: transparent; -fx-background-image: url('/com/sakkiwakki/warshipgame/resource/image/button/AP_normal.png')",
			"-fx-background-color: transparent; -fx-background-image: url('/com/sakkiwakki/warshipgame/resource/image/button/AP_pressed.png')",
			"AP Ammo",
			5,10,0);
	
	String picture;
	String normal;
	String pressed;
	String name;
	int FP, AA, TRP;
	/** */
	private EquipmentNames(String picture, String normalStyle, String pressedStyle, String name, int FP, int AA, int TRP) {
		this.FP = FP;
		this.AA = AA;
		this.TRP = TRP;
		this.picture = picture;
		this.normal = normalStyle;
		this.pressed = pressedStyle;
		this.name = name;
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

}
