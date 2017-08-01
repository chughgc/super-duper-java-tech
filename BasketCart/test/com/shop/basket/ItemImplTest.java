package com.shop.basket;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ItemImplTest {
	
    @Test(expected = IllegalArgumentException.class)
    public void createItemWithNullNameAndPrice() {
        Item item = new ItemImpl(null,null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createItemWithNullNameAndValidPrice() {
        Item item = new ItemImpl(null,0.10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createItemWithValidNameAndNullPrice() {
        Item item = new ItemImpl(EligibleItem.BANANA,null);
    }
    
    @Test
    public void testEqualsAndHashCode() throws Exception {
        Item item1 = new ItemImpl(EligibleItem.APPLE,0.10);
        Item item2 = new ItemImpl(EligibleItem.APPLE,0.10);

        assertEquals("Items should be equal",item1,item2);
    }
}
