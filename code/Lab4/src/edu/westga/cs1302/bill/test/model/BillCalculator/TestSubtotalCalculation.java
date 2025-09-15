package edu.westga.cs1302.bill.test.model.BillCalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.BillItem;

import edu.westga.cs1302.bill.model.BillCalculator;

class TestSubtotalCalculation {

	@Test
	void testWhenBillArrayHasOneNull() {
		BillItem[] bill = new BillItem[2];
		bill[0] = new BillItem("yarn", 5.78);
		assertThrows(IllegalArgumentException.class, () -> {
			BillCalculator.subtotalCalculation(bill);
		});
	}
	
	@Test
	void testWhenBillArrayIsCompletelyEmpty() {
		BillItem[] bill = new BillItem[2];
		assertThrows(IllegalArgumentException.class, () -> {
			BillCalculator.subtotalCalculation(bill);
		});
	}
	
	@Test
	void testWhenBillArrayIsFull() {
		//arrange
		BillItem[] bill = new BillItem[2];
		bill[0] = new BillItem("yarn", 5.78);
		bill[1] = new BillItem("hook", 7.99);
		//act
		double actual = BillCalculator.subtotalCalculation(bill);
		//assert
		assertEquals(actual, 13.77, "checks that the subtotal is calculated correctly");
	}

}
