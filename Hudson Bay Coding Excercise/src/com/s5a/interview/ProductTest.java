package com.s5a.interview;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Dennis Fung
 *
 */

public class ProductTest {

	@Test
	public void testProductString() {
		String testString = "test";
		Product p = new Product(testString);
		assertEquals(testString, p.getBrandName());
	}

	@Test
	public void testNull() {
		Product p = new Product(null);
		assertNull(p.getBrandName());
	}
	
	@Test
	public void testEmptyString() {
		Product p = new Product("");
		assertEquals("", p.getBrandName());
	}
	
}
