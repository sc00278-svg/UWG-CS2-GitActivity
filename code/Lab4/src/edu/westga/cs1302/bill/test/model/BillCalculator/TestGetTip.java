package edu.westga.cs1302.bill.test.model.BillCalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.BillCalculator;
import edu.westga.cs1302.bill.model.BillItem;

class TestGetTip {

	@Test
	void testWhenBillArrayHasOneNull() {
		BillItem[] bill = new BillItem[2];
		bill[0] = new BillItem("yarn", 5.78);
		assertThrows(IllegalArgumentException.class, () -> {
			BillCalculator.getTip(bill);
		});
	}
	
	@Test
	void testWhenBillArryIsFull() {
		//arrange
		BillItem[] bill = new BillItem[2];
		bill[0] = new BillItem("yarn", 5.78);
		bill[1] = new BillItem("hook", 7.99);
		//act
		double actual = BillCalculator.getTip(bill);
		//assert
		assertEquals(actual, 2.754, "checks that the tip is calculated correctly");
	}
	
	@Test
	void testWhenBillArrayIsEmpty() {
		BillItem[] bill = new BillItem[2];
		assertThrows(IllegalArgumentException.class, () -> {
			BillCalculator.getTip(bill);
		});
	}
}
