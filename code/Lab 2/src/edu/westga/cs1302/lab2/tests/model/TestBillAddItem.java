package edu.westga.cs1302.lab2.tests.model;

import static org.junit.jupiter.api.Assertions.*;

import edu.westga.cs1302.lab2.model.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class TestBillAddItem {
	
	@Test
	public void tesstWhenBillItemIsNull() {
		BillItem item = null;
		Bill bill = new Bill();
		assertThrows(IllegalArgumentException.class, () -> {
			bill.addItem(item);
		});
	}
	
	@Test
	public void tesstWhenBillItemIsNotNull() {
		//arrange
		BillItem item = new BillItem("yarn", 10.89);
		Bill bill = new Bill();
		ArrayList<BillItem> list = new ArrayList<BillItem>();
		list.add(item);
		//act
		bill.addItem(item);
		//assert
		assertEquals(bill.getItems(), list, "checking to see if item got added to bill.");
	}

}
