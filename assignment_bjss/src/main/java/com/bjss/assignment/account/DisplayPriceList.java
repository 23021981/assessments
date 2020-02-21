package com.bjss.assignment.account;

import java.text.DecimalFormat;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import com.bjss.assignment.model.Goods;


/**
 * @author atulkumar
 * This class used to display the price list on console
 */
public class DisplayPriceList {

	// Helper method to format discount information before display to console
	public static String formatDiscountOutput(List<Goods> basketList) {
		String discountOutput="";
		
		boolean discountsApply=false;
		
		Predicate<Double> isDiscount = discountPercent->discountPercent>0.0;
		
		Function<Double,String> formatter = value->{
			return new DecimalFormat("##.00").format(value); 
		};
		// Create display text for any discounts
		for (Goods item : basketList) {
			
			if (isDiscount.test(item.getdiscountPercent())) {
				
				discountsApply=true;
				
				discountOutput = discountOutput + item.getClass().getSimpleName()+" "+
						item.getdiscountPercent()*100.0+"%"+
						" off: -�"+formatter.apply(item.getDiscount())+"\n";
			}
		}
		
		if (discountsApply == false) {
			discountOutput = "(no offers available)\n";
		}
		
		return discountOutput;
	}
	
}
