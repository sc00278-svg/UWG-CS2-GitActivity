package edu.westga.cs1302.bill.test.model.BillCalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.BillCalculator;
import edu.westga.cs1302.bill.model.BillItem;

class TestGetTotal {

	@Test
	void testWhenBillArrayHasOneNull() {
		BillItem[] bill = new BillItem[2];
		bill[0] = new BillItem("yarn", 5.78);
		assertThrows(IllegalArgumentException.class, () -> {
			BillCalculator.getTotal(bill);
		});
	}
	
	@Test
	void testWhenBillArryIsFull() {
		//arrange
		BillItem[] bill = new BillItem[2];
		bill[0] = new BillItem("yarn", 5.78);
		bill[1] = new BillItem("hook", 7.99);
		//act
		double actual = BillCalculator.getTotal(bill);
		//assert
		assertEquals(actual, 17.901, "checks that the total is calculated correctly");
	}
	
	@Test
	void testWhenBillArrayIsEmpty() {
		BillItem[] bill = new BillItem[2];
		assertThrows(IllegalArgumentException.class, () -> {
			BillCalculator.getTotal(bill);
		});
	}
}
