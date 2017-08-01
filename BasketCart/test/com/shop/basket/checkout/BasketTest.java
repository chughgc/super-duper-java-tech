package com.shop.basket.checkout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.shop.basket.EligibleItem;
import com.shop.basket.Item;
import com.shop.basket.ItemImpl;

public class BasketTest {
	
	private Basket basket;
	
    @Before
    public void setUp() throws Exception {
        basket = new Basket();
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNullItem() {
        basket.addItem(null);
    }


    @Test(expected = IllegalArgumentException.class)
    public void addItemWithEmptyName() {
        Item item  = new ItemImpl(null,0.20);
        basket.addItem(item);

    }

    @Test
    public void clearsAllItemsFromTheBasket() {
        Item item  = new ItemImpl(EligibleItem.BANANA,0.20);
        basket.addItem(item);
        assertTrue(basket.getItems().size()>0);
        basket.clear();
        assertEquals("Basket must be empty",0,basket.getItems().size());
    }

    @Test
    public void addOneItem() {
        Item item  = new ItemImpl(EligibleItem.BANANA,0.20);
        basket.addItem(item);
        assertEquals("Should have 1 item",1,basket.getItems().size());
    }

    @Test
    public void addTwoDifferentItems() {
        Item item1  = new ItemImpl(EligibleItem.APPLE,0.50);
        Item item2  = new ItemImpl(EligibleItem.BANANA,0.20);
        basket.addItem(item1);
        basket.addItem(item2);

        assertEquals("Should have 1 item",2,basket.getItems().size());
    }

    @Test
    public void addTwoSameItems() {
        Item item1  = new ItemImpl(EligibleItem.APPLE,0.50);
        Item item2  = new ItemImpl(EligibleItem.APPLE,0.50);
        basket.addItem(item1);
        basket.addItem(item2);

        assertEquals("Should have 1 item with qty as 2",1,basket.getItems().size());
        assertEquals("Should have 1 item with qty as 2",new Integer(2),basket.getItems().get(item1));
    }
}
