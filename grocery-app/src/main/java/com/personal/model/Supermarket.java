package com.personal.model;

public enum Supermarket {
	
	TESCO ("Tesco"),
	SAINSBURY ("SAINSBURY"),
	LIDL ("Lidl"),
	ICELAND ("Iceland"),
	HOME_BARGAINS ("Home Bargains"),
	ASDA ("Asda"),
	MORRISSONS ("Morrissons"),
	ALDI ("Aldi");

	private final String name;

	private Supermarket(String name) {
		this.name = name;
	}
	
	@Override
    public String toString() {
        return name;
    }
	
}
