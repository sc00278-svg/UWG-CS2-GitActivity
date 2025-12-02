package viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.contact_manager.viewmodel.MainWindowViewModel;

class testFindContact {

	//test that I can search from name and search from phoneNumber
	
	@Test
	void testWhenSearchCriIsName() {
		MainWindowViewModel vm = new MainWindowViewModel();
		vm.getName().set("Bob");
		vm.getPhoneNumber().set("8675309");
		vm.addContact();
		vm.getSearchCriteria().set("Bob");
		
		String actual = vm.findContact();
		
		assertTrue(actual.equals("Bob, 8675309"));
	}
	
	@Test
	void testWhenSearchCriIsNameAndTwoContacts() {
		MainWindowViewModel vm = new MainWindowViewModel();
		vm.getName().set("Bob");
		vm.getPhoneNumber().set("8675309");
		vm.addContact();
		vm.getName().set("Liv");
		vm.getPhoneNumber().set("1234567");
		vm.addContact();
		vm.getSearchCriteria().set("Liv");
		
		String actual = vm.findContact();
		
		assertTrue(actual.equals("Liv, 1234567"));
	}
	
	@Test
	void testWhenSearchCriIsNumber() {
		MainWindowViewModel vm = new MainWindowViewModel();
		vm.getName().set("Bob");
		vm.getPhoneNumber().set("8675309");
		vm.addContact();
		vm.getSearchCriteria().set("8675309");
		
		String actual = vm.findContact();
		
		assertTrue(actual.equals("Bob, 8675309"));
	}
	
	@Test
	void testWhenSearchCriIsNotInList() {
		MainWindowViewModel vm = new MainWindowViewModel();
		vm.getName().set("Bob");
		vm.getPhoneNumber().set("8675309");
		vm.addContact();
		vm.getSearchCriteria().set("8675308");
		
		String actual = vm.findContact();
		
		assertTrue(actual.equals("No contact found."));
	}
	
	@Test
	void testWhenSearchCriIsNull() {
		MainWindowViewModel vm = new MainWindowViewModel();
		vm.getSearchCriteria().set(null);
		
		assertThrows(IllegalArgumentException.class, () -> {
			vm.findContact();
		});
	}
	
	@Test
	void testWhenSearchCriIsBad() {
		MainWindowViewModel vm = new MainWindowViewModel();
		vm.getSearchCriteria().set("billy B.");
		
		assertThrows(IllegalArgumentException.class, () -> {
			vm.findContact();
		});
	}

}
