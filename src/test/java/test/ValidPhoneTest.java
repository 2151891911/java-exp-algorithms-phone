package test;

import static org.junit.Assert.*;

import org.junit.Test;
import app.ValidPhone;

public class ValidPhoneTest {
	ValidPhone vp = new ValidPhone();

	@Test
	public void testValidPhonehCheck() {
		String phoneSample = "2109715532";
		assertEquals("Home Phone matched valid criteria", true, vp.check(phoneSample));
	}
	
	@Test
	public void testValidMobileCheck() {
		String phoneSample = "00306973809512";
		assertEquals("Mobile Phone matched valid criteria", true, vp.check(phoneSample));
	}
	
	@Test
	public void testInvalidMobileCheck() {
		String phoneSample = "0030697380951234";
		assertEquals("Mobile Phone too long", false, vp.check(phoneSample));
	}
	
	
	@Test
	public void testInvalidMobile2Check() {
		String phoneSample = "00306738095123";
		assertEquals("Mobile Phone wrong reference code", false, vp.check(phoneSample));
	}
	

}

    