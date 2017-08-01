package com.shop.basket.checkout;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.MathContext;

import org.junit.Before;
import org.junit.Test;

import com.shop.basket.EligibleItem;
import com.shop.basket.Item;
import com.shop.basket.ItemImpl;

public class BasketPriceCalculatorTest {
    private static final MathContext MATH_CONTEXT = new MathContext(2);
    
    private BasketPriceCalculator priceCalculator;

    @Before
    public void setUp() throws Exception {
        priceCalculator = new BasketPriceCalculator();
    }

    @Test
    public void getPriceWithNoItems() throws Exception {
        Basket basket = new Basket();
        BigDecimal actual = priceCalculator.getTotalPrice(basket);
        BigDecimal expected = new BigDecimal(0,MATH_CONTEXT);
        assertTrue("Price should be 0",actual.compareTo(expected) == 0 );
    }

    @Test(expected = IllegalArgumentException.class)
    public void getPriceWithNullItems() throws Exception {
        BigDecimal price = priceCalculator.getTotalPrice(null);
    }

    @Test
    public void getPriceWith1Item() throws Exception {
        Basket basket = new Basket();
        Item item = new ItemImpl(EligibleItem.BANANA,0.20);
        basket.addItem(item);

        BigDecimal actual = priceCalculator.getTotalPrice(basket);
        BigDecimal expected = new BigDecimal(0.20,MATH_CONTEXT);
        assertTrue("Expected Price - 0.20",actual.compareTo(expected) == 0 );
    }

    @Test
    public void getPriceWith1ItemMultipleTimes() throws Exception {
        Basket basket = new Basket();
        EligibleItem name = EligibleItem.BANANA;
        double price = 0.20;
        basket.addAllItems(new ItemImpl(name,price),
        		           new ItemImpl(name,price),
        		           new ItemImpl(name,price));

        BigDecimal expected = new BigDecimal(0.60,MATH_CONTEXT);
        BigDecimal actual = priceCalculator.getTotalPrice(basket);

        assertTrue("Expected Price - 0.60", actual.compareTo(expected) == 0 );
    }

    @Test
    public void getTotalPriceWith3ItemQuanity1each() throws Exception {
        Basket basket = new Basket();
        Item item1 = new ItemImpl(EligibleItem.BANANA,0.20);
        Item item2 = new ItemImpl(EligibleItem.APPLE,0.50);
        Item item3 = new ItemImpl(EligibleItem.ORANGE,0.30);
        basket.addItem(item1);
        basket.addItem(item2);
        basket.addItem(item3);

        BigDecimal actual = priceCalculator.getTotalPrice(basket);
        BigDecimal expected = new BigDecimal(1.00,MATH_CONTEXT);
        assertTrue("Expected Price - 1.00", actual.compareTo(expected) == 0 );

    }

    @Test
    public void getTotalPriceWithMultiItemMultiQuanity() throws Exception {
        Basket basket = new Basket();
        basket.addAllItems(new ItemImpl(EligibleItem.BANANA,0.20),
        		           new ItemImpl(EligibleItem.APPLE,0.50),
        		           new ItemImpl(EligibleItem.ORANGE,0.30),
        		           new ItemImpl(EligibleItem.BANANA,0.20),
        		           new ItemImpl(EligibleItem.ORANGE,0.30),
        		           new ItemImpl(EligibleItem.ORANGE,0.30));
        
        BigDecimal actual = priceCalculator.getTotalPrice(basket);
        BigDecimal expected = new BigDecimal(1.80,MATH_CONTEXT);
        assertTrue("Expected Price - 1.80", actual.compareTo(expected) == 0 );
    }
}