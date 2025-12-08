package edu.westga.cs1302.password_generator.viewmodel.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;

class TestAddNewComic {

	@Test
	void testWhenAddingOneComic() {
		ViewModel vm = new ViewModel();
		vm.getComicName().set("SpiderMan");
		vm.getIssue().set(1);
		
		vm.addNewComic();
		
		assertTrue(vm.getComicsInCollection().get().size() == 1);
	}
	
	@Test
	void testWhenNameIsEmpty() {
		ViewModel vm = new ViewModel();
		vm.getComicName().set("");
		vm.getIssue().set(1);
		
		assertThrows(IllegalArgumentException.class, () -> {
			vm.addNewComic();
		});
	}
	
	@Test
	void testWhenIssueIsBad() {
		ViewModel vm = new ViewModel();
		vm.getComicName().set("name");
		
		assertThrows(IllegalArgumentException.class, () -> {
			vm.addNewComic();
		});
	}
	
	@Test
	void testWhenMultipleComicsAdded() {
		ViewModel vm = new ViewModel();
		vm.getComicName().set("SpiderMan");
		vm.getIssue().set(1);
		
		vm.addNewComic();
		
		assertTrue(vm.getComicsInCollection().get().size() == 1);
		
		vm.getComicName().set("Batman");
		vm.getIssue().set(12);
		
		vm.addNewComic();
		
		assertTrue(vm.getComicsInCollection().get().size() == 2);
	}

}
