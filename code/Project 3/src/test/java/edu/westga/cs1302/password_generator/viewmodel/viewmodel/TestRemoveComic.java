package edu.westga.cs1302.password_generator.viewmodel.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.model.Comic;
import edu.westga.cs1302.password_generator.viewmodel.ViewModel;

class TestRemoveComic {

	@Test
	void test() {
		ViewModel vm = new ViewModel();
		Comic comic = new Comic("spiderMan", 1);
		vm.getComicName().set(comic.getName());
		vm.getIssue().set(comic.getIssueNum());
		vm.addNewComic();
		
		vm.removeComic();
		
		assertFalse(vm.getComicsInCollection().contains(comic));
	}

}
