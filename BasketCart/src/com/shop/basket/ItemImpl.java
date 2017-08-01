package com.shop.basket;

import java.math.BigDecimal;
import java.math.MathContext;

public class ItemImpl implements Item {
    private static final MathContext MATH_CONTEXT = new MathContext(2);
	private EligibleItem name;
    private BigDecimal price;
    
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
    
	public EligibleItem getName() {
		return name;
	}

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
