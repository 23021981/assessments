package com.bjss.assignment.main;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import com.bjss.assignment.account.DisplayPriceList;
import com.bjss.assignment.account.SpecialOffers;
import com.bjss.assignment.factory.GoodsFactory;
import com.bjss.assignment.model.Goods;


/**
 * @author atulkumar
 *
 * Read in the input argument parameters
 * Arguments can be entered as follows e.g.:
   >PriceBasket Apples Milk Bread Soup
   or:
   >PriceBasket Apples Milk Bread Apples Soup Bread Milk Apples etc.
   Separate discounts will appear on the output for each item that has a discount.
   To modify prices or discounts or to add discounts to items other than Apples, 
   modify the GoodsFactory class in the "utils" sub-folder.	
 */
public class PriceBasket {

	static int DEFAULT_NUM_BASKET_ITEMS = 100;
	
	public static void main(String[] args) {
		
		try {
			
			// Create a new basket list
			List<Goods> basketList = new ArrayList<Goods>(DEFAULT_NUM_BASKET_ITEMS);
			Predicate<String[]> arguments = str->args.length > 0;
			if (arguments.test(args)) {
				// Create the Goods factory
				GoodsFactory sif = new GoodsFactory();
				
				int itemCount=0;
				while (itemCount < args.length) {
					
					String basketItem = args[itemCount];
					if (basketItem != null) {
				
						Goods goods = sif.getBasketItem(basketItem.toLowerCase());
						if (goods != null) {
							
							// Add a basket item to the shopping basket list
							basketList.add(goods);
						}
					}
					
					itemCount++;
				}
			}	

			// Apply any cross-item special offers here
			SpecialOffers.applyCrossItemSpecialOffers(basketList);
			
			// Once item list is compiled and any special offers are applied, calculate the price totals
			double subTotalPrice = 0.0;
			double totalPrice = 0.0;
			
			subTotalPrice  = getTotalPrice(basketList);
			totalPrice = getTotalRetailPrice(basketList);
			// Compute and format any discount items text
			
			String discountOutputText = DisplayPriceList.formatDiscountOutput(basketList); 
			
			Function<Double,String> output = value->{	
				return new DecimalFormat("##.00").format(value); 
			};
			
			// Output summary to console
			
			// Display sub-total before any discounts are applied
			System.out.println("Subtotal: �" + output.apply(subTotalPrice));

			// Display any discount information
			System.out.println(discountOutputText);
			
			// Display total after all discounts are applied
			System.out.println("Total: �" + output.apply(totalPrice));
			
			
		} catch (Exception e) {
			
			System.err.println("Error: "+e.getMessage());
	        System.exit(1);
		}
		
	}	
	
	private static double getTotalPrice(List<Goods> baksetList) {
		
		return baksetList.stream().mapToDouble(Goods::getPrice).sum();
	}
	
	private static double getTotalRetailPrice(List<Goods> baksetList) {
		return baksetList.stream().mapToDouble(Goods::getRetailPrice).sum();
	}
}
