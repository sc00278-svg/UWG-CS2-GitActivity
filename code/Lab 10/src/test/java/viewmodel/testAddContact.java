package viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.contact_manager.viewmodel.MainWindowViewModel;

class testAddContact {
	
	@Test
	void testWhenValidContact() {
		MainWindowViewModel vm = new MainWindowViewModel();
		vm.getName().set("Bob");
		vm.getPhoneNumber().set("8675309");
		
		vm.addContact();
		
		assertEquals(vm.getContacts().size(), 1);
	}
	
	@Test
	void testWhenValidContacts() {
		MainWindowViewModel vm = new MainWindowViewModel();
		vm.getName().set("Bob");
		vm.getPhoneNumber().set("8675309");
		vm.addContact();
		
		vm.getName().set("Lilly");
		vm.getPhoneNumber().set("111-0000");
		vm.addContact();
		
		assertEquals(vm.getContacts().size(), 2);
	}
	
	@Test
	void testWhenContactNameAlreadyExists() {
		MainWindowViewModel vm = new MainWindowViewModel();
		vm.getName().set("Bob");
		vm.getPhoneNumber().set("8675309");
		vm.addContact();
		vm.getPhoneNumber().set("1110000");
		
		assertThrows(IllegalArgumentException.class, () -> {
			vm.addContact();
		});
	}
	
	@Test
	void testWhenContactPhoneNumAlreadyExists() {
		MainWindowViewModel vm = new MainWindowViewModel();
		vm.getName().set("Bob");
		vm.getPhoneNumber().set("8675309");
		vm.addContact();
		vm.getName().set("Lilly");
		
		assertThrows(IllegalArgumentException.class, () -> {
			vm.addContact();
		});
	}
	
	@Test
	void testWhenContactNameBad() {
		MainWindowViewModel vm = new MainWindowViewModel();
		vm.getName().set("Bobby B");
		vm.getPhoneNumber().set("8675309");
	
		assertThrows(IllegalArgumentException.class, () -> {
			vm.addContact();
		});
	}
	
	@Test
	void testWhenContactPhoneNumBad() {
		MainWindowViewModel vm = new MainWindowViewModel();
		vm.getName().set("Bobby");
		vm.getPhoneNumber().set("800-867-5309");
	
		assertThrows(IllegalArgumentException.class, () -> {
			vm.addContact();
		});
	}
	
}
