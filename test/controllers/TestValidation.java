package controllers;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author LappoPolina
 *
 */
public class TestValidation {


	@Test
	public void testIsValidDate() {
		Validation valid = new Validation();
		boolean result = true;
		if (!(valid.isValidDate("12.12.2012") && result))
				fail("Wrong validation");
	}
	
	@Test
	public void testIsValidName() {
		Validation valid = new Validation();
		boolean result = true;
		if (!(valid.isValidName("Ivanov") && result))
				fail("Wrong validation");
	}
	
	@Test
	public void testIsValidMark() {
		Validation valid = new Validation();
		boolean result = true;
		if (!(valid.isValidMark(2) && result))
				fail("Wrong validation");
	}
	
	@Test
	public void testIsValidType() {
		Validation valid = new Validation();
		boolean result = true;
		if (!(valid.isValidType(0) && result))
				fail("Wrong validation");
	}
	
	@Test
	public void testIsValidColor() {
		Validation valid = new Validation();
		boolean result = true;
		if (!(valid.isValidColor(4) & result))
				fail("Wrong validation");
	}
	
	@Test
	public void testIsValidCost() {
		Validation valid = new Validation();
		boolean result = true;
		if (!(valid.isValidCost("154.34") & result))
				fail("Wrong validation");
	}
}
