package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

import app.Ambig;

public class AmbigTest {

	@Test
	public void testDelZeros() {
		String sample = "210";
		String result ="21";
		assertEquals("Sample returned with no zero chars", result, Ambig.delZeros(sample));
	}

	@Test
	public void testOneZero() {
		String sample = "210";
		ArrayList<String> result = new ArrayList<String>(Arrays.asList("20010"));
		assertEquals("Sample with only one zero got proper format", result, Ambig.oneZero(sample));
	}

}
    