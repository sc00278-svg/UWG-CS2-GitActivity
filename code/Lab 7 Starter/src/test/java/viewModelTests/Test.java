package viewModelTests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;


import edu.westga.cs1302.password_generator.viewmodel.MainWindowViewModel;

/**tests for MainWindowViewModel makePassword method
 *
 * @author samco
 */
class Test {
	
	/*I do not understand it but the tests would not compile if I just put @Test for the 
	 * annotations so I just left it the way eclipse set it up when I made the test case
	 */
	
	
	@org.junit.jupiter.api.Test
	void testLength() {
		MainWindowViewModel viewModel = new MainWindowViewModel();
		viewModel.minLength().set(3);
		
		viewModel.makePassword();
		String result = viewModel.getPassword().get();
		
		assertTrue(3 <= result.length());
	}
	
	@org.junit.jupiter.api.Test
	void testWhenContainsInt() {
		MainWindowViewModel viewModel = new MainWindowViewModel();
		viewModel.hasNum().set(true);
		
		viewModel.makePassword();
		String result = viewModel.getPassword().get();
		boolean match = result.matches(".*\\d.*");
		
		assertTrue(match);
	}
	
	@org.junit.jupiter.api. Test
	void testWhenMinLengthIsNegative() {
		MainWindowViewModel viewModel = new MainWindowViewModel();
		viewModel.minLength().set(-3);
		
		assertThrows(IllegalArgumentEcxeption.class, () -> {
			viewModel.makePassword();
		});
	}

}
