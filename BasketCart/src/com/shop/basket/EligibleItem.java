package com.shop.basket;

public enum EligibleItem {
	BANANA("Banana"), ORANGE("Orange"), APPLE("Apple"), LEMON("Lemon"), PEACHE("Peache");

	private String name;

	private EligibleItem(String value) {
		name = value;
	}

	public String getValue(String code) {
		for (EligibleItem item : EligibleItem.values()) {
			if (item.name == code) {
				return item.name();
			}
		}
		return null;
	}
}
