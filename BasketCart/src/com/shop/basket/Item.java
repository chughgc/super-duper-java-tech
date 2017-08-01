package com.shop.basket;

import java.math.BigDecimal;

public interface Item {
	/**
	 * Name of Item
	 * @return Name of Item as {@link EligibleItem}
	 */
    EligibleItem getName();

    /**
     * Price of Item
     * @return Price as {@link BigDecimal}
     */
    BigDecimal getPrice();
}
