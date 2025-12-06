package edu.westga.cs1302.password_generator.viewmodel.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.model.ComicCollection;
import edu.westga.cs1302.password_generator.viewmodel.ViewModel;

class TestRemoveSelectedCollection {

	@Test
	void testCollectionIsInTheList() {
		ViewModel vm = new ViewModel();
		ComicCollection comic = new ComicCollection("SpiderMan");
		vm.getNewCollectionName().set(comic.getComicCollectionName());
		vm.addCollection();
		assertTrue(vm.getCollectionList().size() == 1);
		vm.getSelectedCollection().set(comic);
		
		vm.removeSelectedCollection();
		
		assertFalse(vm.getCollectionList().contains(comic));
	}

}
