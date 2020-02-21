package com.bjss.assignment.factory;

import com.bjss.assignment.Enum.GoodsType;
import com.bjss.assignment.error.BasketItemException;
import com.bjss.assignment.model.Apples;
import com.bjss.assignment.model.Bread;
import com.bjss.assignment.model.Milk;
import com.bjss.assignment.model.Goods;
import com.bjss.assignment.model.Soup;

/*
 * @author atulkumar
 *
 * Factory class to create basket items. Amend this class to add more basket items, 
 * or amend prices or discounts.
 */
public class GoodsFactory {


	// Factory method for Basket items
	public Goods getBasketItem(String itemName) throws BasketItemException {
		
		if(itemName.equalsIgnoreCase(GoodsType.APPLES.getName())) {
            return new Apples(GoodsType.APPLES.getPrice(), GoodsType.APPLES.getDiscountPercentage());
        }
		else if(itemName.equalsIgnoreCase(GoodsType.MILK.getName())) {
            return new Milk(GoodsType.MILK.getPrice(), GoodsType.MILK.getDiscountPercentage());
        }
		else if(itemName.equalsIgnoreCase(GoodsType.SOUP.getName())) {
            return new Soup(GoodsType.SOUP.getPrice(), GoodsType.SOUP.getDiscountPercentage());
        }
		else if(itemName.equalsIgnoreCase(GoodsType.BREAD.getName())) {
            return new Bread(GoodsType.BREAD.getPrice(), GoodsType.BREAD.getDiscountPercentage());
        }
		else {
			throw new BasketItemException("Bakset Item name: "+itemName+" not recognised");
		}
	}

}
