package edu.westga.cs1302.lab2.tests.model;

import static org.junit.jupiter.api.Assertions.*;

import edu.westga.cs1302.lab2.model.BillItem;

import org.junit.jupiter.api.Test;

class TestBillItem {
	
	@Test
	public void testWhenBillItemNameIsNull() {
		//arrange	 
		assertThrows(IllegalArgumentException.class, () -> {
			new BillItem(null, 1.1); 
		});
	}
	
	@Test
	public void testWhenBillItemAmountIsZero() {
		assertThrows(IllegalArgumentException.class, () -> {
			new BillItem("cat food", 0);
		});
	}
	
	@Test
	public void testWhenBillItemAmountIsNegative() {
		assertThrows(IllegalArgumentException.class, () -> {
			new BillItem("cat food", -1.1);
		});
	}
	
	@Test
	public void testWhenBillItemAmountIsPositiveAndNameHasAValue() {
		//arrange
		BillItem bItem = new BillItem("cat food", 15.34);
		//act
		String actualName = bItem.getName();
		double actualAmount = bItem.getAmount();
		//assert
		assertEquals("cat food", actualName, "checking the name.");
		assertEquals(15.34, actualAmount, "Checking the amount.");
		
	}

}
