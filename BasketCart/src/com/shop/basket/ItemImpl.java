package com.shop.basket;

import java.math.BigDecimal;
import java.math.MathContext;
/**
 * This is implementation of Item class which will handle creation of Item in Basket
 * @author chughgc
 *
 */
public class ItemImpl implements Item {
    private static final MathContext MATH_CONTEXT = new MathContext(2);
	private EligibleItem name;
    private BigDecimal price;
    
    /**
     * We check validations for input parameters while constructing items
     * @param item
     * @param price
     */
    public ItemImpl(EligibleItem item, Double price) {
        if(item == null){
            throw new IllegalArgumentException("Item name can not be null or empty");
        }
        if(price == null || price < 0.0){
            throw new IllegalArgumentException("Item price can not be null or less than 0.0");
        }

        this.name = item;
        this.price = new BigDecimal(price, MATH_CONTEXT);    	
	}
    /**
     * Get Eligible Item
     */
	public EligibleItem getName() {
		return name;
	}
	/**
	 * Get price of Item
	 */
	@Override
	public BigDecimal getPrice() {
		return this.price;
	}
	
	@Override
	public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ItemImpl that = (ItemImpl) o;
        return name.equals(that.name);
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
