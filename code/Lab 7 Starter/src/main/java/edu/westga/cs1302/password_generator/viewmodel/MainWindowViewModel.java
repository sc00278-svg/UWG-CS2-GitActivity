package edu.westga.cs1302.password_generator.viewmodel;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Random;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**the ViewModel for the MianWindow code behind class
 *
 * @author samco
 * @version 1.0
 */
public class MainWindowViewModel {

	private IntegerProperty minLength;
	private StringProperty password;
	private BooleanProperty hasLowerCase;
	private BooleanProperty hasUpperCase;
	private BooleanProperty hasNumber;
	private PasswordGenerator passGenerator;
	
	/**initializes the variables in this class.
	 * 
	 */
	public MainWindowViewModel() {
		this.minLength = new SimpleIntegerProperty(1);
		this.password = new SimpleStringProperty("");
		this.hasLowerCase = new SimpleBooleanProperty(false);
		this.hasUpperCase = new SimpleBooleanProperty(false);
		this.hasNumber = new SimpleBooleanProperty(false);
		Random genRandom = new Random();
		this.passGenerator = new PasswordGenerator(genRandom.nextLong());
	}
	
	/**gets the minimum length of the password.
	 * 
	 * @return minLength
	 */
	public IntegerProperty minLength() {
		return this.minLength;
	}
	
	/**gets the generated password.
	 * 
	 * @return password
	 */
	public StringProperty getPassword() {
		return this.password;
	}
	
	/**gets if the password needs a number.
	 * 
	 * @return hasNumber
	 */
	public BooleanProperty hasNum() {
		return this.hasNumber;
	}
	
	/**gets if the password needs an upper case letter.
	 * 
	 * @return hasUpperCase
	 */
	public BooleanProperty hasUpperCase() {
		return this.hasUpperCase;
	}
	
	/**gets if the password needs an lower case letter.
	 * 
	 * @return hasLowerCase
	 */
	public BooleanProperty hasLowerCase() {
		return this.hasLowerCase;
	}
	
	/** takes the input and makes a password based on the requirements from the input.
	 * 
	 */
	public void makePassword() {
		int min = this.minLength.getValue();
		
		if (min > 0) {
			this.passGenerator.setMinimumLength(min);
			this.passGenerator.setMustHaveAtLeastOneDigit(this.hasNumber.get());
	    	this.passGenerator.setMustHaveAtLeastOneLowerCaseLetter(this.hasLowerCase.get());
	    	this.passGenerator.setMustHaveAtLeastOneUpperCaseLetter(this.hasUpperCase.get());
	    	
	    	String pass = this.passGenerator.generatePassword();
	    	this.password.setValue(pass);

		} else {
			throw new IllegalArgumentException("not a valid minimum length");
		}
	}
}
