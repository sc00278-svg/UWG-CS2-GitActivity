package edu.westga.cs1302.password_generator.viewmodel.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;

class TestAddCollection {

	@Test
	void testWhenGivenAValidName() {
		ViewModel vm = new ViewModel();
		vm.getNewCollectionName().set("SpiderMan");
		
		vm.addCollection();
		
		assertTrue(vm.getCollectionList().size() == 1);
	}
	
	@Test
	void testWhenEmptyName() {
		ViewModel vm = new ViewModel();
		vm.getNewCollectionName().set("");
		
		assertThrows(IllegalArgumentException.class, () -> {
			vm.addCollection();
		});
	}
	
	//TODO: should I allow duplicate collection names? also add more tests

}
