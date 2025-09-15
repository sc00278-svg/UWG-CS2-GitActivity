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
	 * 
	 * @param items the items in an array of BIllItems
	 * 
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
		if (!isItFull) {
			throw new IllegalArgumentException("Bill array is not full");
        } else {
          //calculates the tax for the bill
          for (BillItem currItem : items) {
		    sT += currItem.getAmount();
		  }
          return sT;
		}
	}
	
	/**calculates the tax of an array of BillItems
	 * 
	 * @precondition BillItem[] has no null values
	 * 
	 * @param items the items in the Bill
	 * 
	 * @return the tax for the bill
	 */
	public static double getTax(BillItem[] items) {
		boolean isItFull = true;
		//check for null values in the BillItem array
		for (BillItem currItem : items) {
			if (currItem == null) {
				isItFull = false;
			}
		}
		if (!isItFull) {
			throw new IllegalArgumentException("Bill array is not full");
        } else {
  		  double tax = BillCalculator.subtotalCalculation(items) * Bill.TAX_RATE;
  		  return tax;
        }
	}
	
	/**calculates the tip for an array of BillItems
	 * 
	 * @precondition BillItem[] has no null values
	 * 
	 * @param items the items in an array of BIllItems
	 * 
	 * @return the tip for the bill
	 */
	public static double getTip(BillItem[] items) {
		boolean isItFull = true;
		for (BillItem currItem : items) {
			if (currItem == null) {
				isItFull = false;
			}
		}
		if (!isItFull) {
			throw new IllegalArgumentException("Bill array is not full");
        } else {
  		  double tip = BillCalculator.subtotalCalculation(items) * Bill.TIP_RATE;
  		  return tip;
        }
	}
	
	/**calculates the total for the array of BillITems
	 * 
	 * @precondition BillItem[] has no null values
	 * 
	 * @param items the items in an array of BIllItems
	 * 
	 * @return total of the bill
	 */
	public static double getTotal(BillItem[] items) {
		boolean isItFull = true;
		for (BillItem currItem : items) {
			if (currItem == null) {
				isItFull = false;
			}
		}
		if (!isItFull) {
			throw new IllegalArgumentException("Bill array is not full");
        } else {
		  double total = BillCalculator.subtotalCalculation(items) + BillCalculator.getTax(items) + BillCalculator.getTip(items);
		  return total;
        }
	}
}
