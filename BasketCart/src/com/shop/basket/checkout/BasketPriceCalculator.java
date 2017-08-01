package com.shop.basket.checkout;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Map;

import com.shop.basket.EligibleItem;
import com.shop.basket.Item;
import com.shop.basket.ItemImpl;

public class BasketPriceCalculator {

    private static final MathContext MATH_CONTEXT = new MathContext(2);
	/**
	 * Input Basket contains different Items, Traverse basket to multiply price with item quantity
	 * and find addition of total price
	 * @param basket
	 * @return
	 */
    public BigDecimal getTotalPrice(Basket basket){
        if(basket == null){
            throw new IllegalArgumentException("Shopping basket can not be null");
        }

        final Map<Item,Integer> items = basket.getItems();
        //Sum of quantity * price for all items
        return basket.getItems().keySet().stream()
        		                .map( item -> item.getPrice().multiply(new BigDecimal(items.get(item),MATH_CONTEXT)))
        		                .reduce(BigDecimal.ZERO,BigDecimal::add);
    }
    
    public static void main(String[] args) {
		Basket basket = new Basket();
		BasketPriceCalculator calc = new BasketPriceCalculator();
		calc.addItemToBasket(basket, new ItemImpl(EligibleItem.LEMON, 5.5), 
				                     new ItemImpl(EligibleItem.BANANA, 12.5), 
				                     new ItemImpl(EligibleItem.BANANA, 12.5),
				                     new ItemImpl(EligibleItem.PEACHE, 10.50));
		System.out.println(calc.getTotalPrice(basket));
	}
    
    private void addItemToBasket(Basket basket, Item ...items) {
    	basket.addAllItems(items);
	}
}