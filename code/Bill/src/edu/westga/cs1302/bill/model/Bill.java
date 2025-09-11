package edu.westga.cs1302.bill.model;

import java.util.ArrayList;

/** Stores information for a bill.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class Bill {
	public static final double TIP_RATE = 0.2;
	public static final double TAX_RATE = 0.1;
	
	//private ArrayList<BillItem> items;
	
	private BillItem[] items; 
	private int size;
	
	/** Create a new empty Bill
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 */
	public Bill() {
		//an array of BillItems
		this.items = new BillItem[5]; 
		this.size = 0;
	}
	
	/** Adds the item to the bill
	 * 
	 * @precondition item != null
	 * @postcondition item is added to the list of items in the bill
	 * 
	 * @param item the item to be added to the bill
	 * 
	 * @throws IndexOutOfBoundsException if adding new item when array is full
	 */
	public void addItem(BillItem item) throws IndexOutOfBoundsException {
		//propagating the exception to whoever calls the method. instead of propagating we could use a try catch block to handle the exception 
		if (item == null) {
			throw new IllegalArgumentException("item must not be null.");
		}
		//this.items.add(item);
		
		this.items[this.size] = item;
		this.size++;
		
		/*creates a new Array to create more space and copies the items from the old Array into the new one 
		 * 
		 * try {
		 *    this.items[this.size] = items;
		 *    this.size++;
		 * } catch (IndexOutOfBoundsException error) {
		 *    BillItem[] newItems = new BillItem[this.size*2];
		 *    int newSize = 0;
		 *    for (BillItem currItem : this.items) {
		 *       newItem[newSize] = currItem;
		 *       newSize++;
		 *    }
		 *    newItems[newSize] = Item;
		 *    newSize++;
		 *    this.items = newItems;
		 *    this.size = newSize;
		 * }
		 */
		
	}

	/** Returns the list of items in the bill
	 * 
	 * @precondition none
	 * @postconition none
	 * 
	 * @return the list of items in the bill
	 */
	public BillItem[] getItems() {
		return this.items;
	}

}
