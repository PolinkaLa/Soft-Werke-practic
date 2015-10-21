package controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

/**
 * @author LappoPolina
 *
 */
public class TestValidation {

	Validation valid;
	
	@Before
	public void init(){
	valid = new Validation();
	}
	
	@After
	public void end() {
		System.out.println("Test ended");
	}

	@Test
	public void testIsValidDate() {
		if (!valid.isValidDate("12.12.2012"))
				fail("Wrong validation");
	}
	
	@Test
	public void testIsValidName() {
		if (!valid.isValidName("Ivanov"))
				fail("Wrong validation");
	}
	
	@Test
	public void testIsValidMark() {
		if (!valid.isValidMark("ASUS"))
				fail("Wrong validation");
	}
	
	@Test
	public void testIsValidType() {
		if (!valid.isValidType("TABLET"))
				fail("Wrong validation");
	}
	
	@Test
	public void testIsValidCost() {
		if (!valid.isValidCost("154.34"))
				fail("Wrong validation");
	}
}
