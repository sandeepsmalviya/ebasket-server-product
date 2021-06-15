package com.ecommerce.catalog.server.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MathUtilsTest {

	@Test
	void testAdd() {
		MathUtils utils = new MathUtils();
		int actual = utils.add(2, 3);
		int expected = 5;
		assertEquals(expected, actual, "The add method should add two numbers");
	}
	
	
	@Test
	void testComputeCircleArea() {
		MathUtils utils = new MathUtils();
		double actual = utils.computeCircleArea(10);
		double expected =Math.PI*10*10;
		assertEquals(expected, actual, "Should calculate correct circle area");
	}
	
	@Test
	void testDivide() {	
		MathUtils utils = new MathUtils();
		assertThrows(ArithmeticException.class, ()-> {
			utils.divide(1, 0);	
		}, "divide by zero should be thrown");
	}

}
