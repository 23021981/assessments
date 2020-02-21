package com.bjss.assignment.account;

import java.util.List;

import com.bjss.assignment.model.Bread;
import com.bjss.assignment.model.Goods;
import com.bjss.assignment.model.Soup;

/**
 * @author atulkumar
 *
 */
public class SpecialOffers {
	
	// Apply any cross-item special offers here
	public static void applyCrossItemSpecialOffers(List<Goods> basketList) {
		
		// Iterate through the item list looking for any special offer rules
		
		if (isSpecialOfferAvailable(basketList) == true) {
			
			// Iterate through the item list looking for any bread to apply special offer to
			
			applyOffer(basketList);
		}
		
	}
	private static boolean isSpecialOfferAvailable(List<Goods> basketList) {
		
		long soupCount = basketList.stream().filter(goods -> goods instanceof Soup).count();
		return soupCount > 1 ? true : false;
	}
	private static void applyOffer(List<Goods> basketList) {
		basketList.stream().filter(item -> item instanceof Bread).forEach(item -> {
			double price = item.getPrice();
			item.setPrice(price/2);
		});
	}

}
