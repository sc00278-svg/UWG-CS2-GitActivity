package edu.westga.cs1302.bill.model;

/**calculates the subTotal and total for a Bill
 * 
 * @author samco
 * @version 1.0
 */
public class BillCalculator {
	
	/**calculates the subTotal for an array of BillItems
	 * 
	 * @precondition BillItem[] has no null values
	 * @param items the items in an array of BIllItems
	 * @return the subTotal of a bill
	 */
	public static double subtotalCalculation(BillItem[] items) {
		double sT = 0.0;
		boolean isItFull = true;
		//check for null values in the BillItem array
		for (BillItem currItem : items) {
			if (currItem == null) {
				isItFull = false;
			}
		}
		if (isItFull == false) {
			throw new IllegalArgumentException("Bill array is not full");
        } else {
          //calculates the tax for the bill
          for (BillItem currItem : items) {
		    sT += currItem.getAmount();
		  }
		}
		return sT;
	}
	
	/**calculates the tax of an array of BillItems
	 * 
	 * @param items the items in the Bill
	 * @return the tax for the bill
	 */
	public static double getTax(BillItem[] items) {
  //		double tax = BillCalculator.subtotalCalculation(items) * Bill.TAX_RATE;
  //		return tax;
		return 0;
	}
	
	/**calculates the tip for an array of BillItems
	 * 
	 * @return the tip for the bill
	 */
	public static double getTip() {
		return 0;
	}
	
	/**calculates the total for the array of BillITems
	 * 
	 * @return total of the bill
	 */
	public double getTotal() {
		//read the instructions for lab 4
		//Due on Monday
		return 0;
	}
}
