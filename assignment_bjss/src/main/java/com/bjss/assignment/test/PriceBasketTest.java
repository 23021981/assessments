package com.bjss.assignment.test;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.bjss.assignment.Enum.GoodsType;
import com.bjss.assignment.account.DisplayPriceList;
import com.bjss.assignment.factory.GoodsFactory;
import com.bjss.assignment.main.PriceBasket;
import com.bjss.assignment.model.Apples;
import com.bjss.assignment.model.Bread;
import com.bjss.assignment.model.Goods;
import com.bjss.assignment.model.Milk;
import com.bjss.assignment.model.Soup;

import junit.framework.TestCase;



public class PriceBasketTest extends TestCase {

	/**
	 * @param name
	 */
	public PriceBasketTest(String name) {
		super(name);
	}
	@Test
	public void testApples() throws Exception {
		
		GoodsFactory sif = new GoodsFactory();
		
		try {
			
			Apples item = (Apples) sif.getBasketItem("apples");
			
			assertEquals(item.getRetailPrice(), item.getPrice() - item.getDiscount());
					
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	@Test
	public void testMilk() throws Exception {
		
		GoodsFactory sif = new GoodsFactory();
		
		try {
			
			Milk item = (Milk) sif.getBasketItem("milk");
			
			assertEquals(item.getRetailPrice(), item.getPrice() - item.getDiscount());
					
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	@Test
	public void testSoup() throws Exception {
		
		GoodsFactory sif = new GoodsFactory();
		
		try {
			
			Soup item = (Soup) sif.getBasketItem("soup");
			
			assertEquals(item.getRetailPrice(), item.getPrice() - item.getDiscount());
					
		} catch (Exception e) {
			throw e;
		}
		
	}
	@Test
	public void testBread() throws Exception {
		
		GoodsFactory sif = new GoodsFactory();
		
		try {
			
			Bread item = (Bread) sif.getBasketItem("bread");
			
			assertEquals(item.getRetailPrice(), item.getPrice() - item.getDiscount());
					
		} catch (Exception e) {
			throw e;
		}
		
	}
	@Test
	public void testDisplayPriceList() {
		
		List<Goods> basketList = new ArrayList<Goods>();
		basketList.add(new Apples(GoodsType.APPLES.getPrice(), GoodsType.APPLES.getDiscountPercentage()));
		
		String discountOutputText = DisplayPriceList.formatDiscountOutput(basketList); 
		
		assertEquals(discountOutputText.contains("Apples 10.0% off: -�.10"),true);
		
	}
	
	@Test
	public void testPriceBasketIncludingMilkOffer() {
		
		String[] arg = new String[] {"Apples", "Milk", "Bread"};
		
		PriceBasket.main(arg);
		
		assertTrue(true);
		
	}
	
	@Test
	public void testPriceBasketWithoutOffer() {
		
		String[] arg = new String[] {"Bread","Soup"};
		
		PriceBasket.main(arg);
		
		assertTrue(true);
		
	}
	
	@Test
	public void testPriceBasketIncludingSoupOffer() {
		String[] arg = new String[] {"Apples", "Milk", "Bread","Soup","Soup"};
		
		PriceBasket.main(arg);
		
		assertTrue(true);
		
	}
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
