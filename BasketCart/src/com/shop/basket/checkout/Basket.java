package com.shop.basket.checkout;

import java.util.HashMap;

import com.shop.basket.Item;

/**
 * Class which manages all items
 * @author chughgc
 *
 */
public class Basket {
	
    // Map to handle number of items and their corresponding quantity
    private HashMap<Item, Integer> items;

    public HashMap<Item, Integer> getItems() {
        return items;
    }

    public Basket(){
        items = new HashMap<>();
    }

    /**
     * Add item to basket and if item already exists it will increase the count
     * @param item
     */
    public void addItem(Item item){
        if(item == null){
            throw new IllegalArgumentException("Basket item can not be null");
        }
        if(item.getName() == null) {
        	throw new IllegalArgumentException("Basket item is not an eligible item");
        }
        if (items.containsKey(item)) {
            items.replace(item, items.get(item) + 1);
        } else {
            items.put(item,1);
        }
    }
    /**
     * Add all items to Basket
     * @param item
     */    
    public void addAllItems(Item ...items) {
    	for (Item item : items) {
			addItem(item);
		}
	}

    /**
     * Clears all items in the basket
     */
    public void clear(){
        items.clear();
    }

}