package com.ecommerce.catalog.server.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class MathUtils2Test {

	private MathUtils mathUtils;

//	@BeforeAll
//	static void beforeAll() {
//		System.out.println("Before All is called  ... ");
//	}
//
//	@AfterAll
//	static void afterAll() {
//		System.out.println("After All is called  ... ");
//	}

	@BeforeEach
	void init() {
		mathUtils = new MathUtils();
	}

//	@AfterEach
//	void cleanup() {
//		System.out.println("Cleaning up ...");
//	}

	@Test
	void testAdd() {

		int actual = mathUtils.add(2, 3);
		int expected = 5;
		assertEquals(expected, actual, "The add method should add two numbers");
	}

	@Test
	@DisplayName("Testing compute circle area method")
	void testComputeCircleArea() {

		double actual = mathUtils.computeCircleArea(10);
		double expected = Math.PI * 10 * 10;
		assertEquals(expected, actual, "Should calculate correct circle area");
	}

	@Test
	void testDivide() {

		assertThrows(ArithmeticException.class, () -> {
			mathUtils.divide(1, 0);
		}, "divide by zero should be thrown");
	}
	
	@Test
	@Disabled
	void testDivideException() {

		assertThrows(NullPointerException.class, () -> {
			mathUtils.divide(1, 0);
		}, "divide by zero should be thrown");
	}
	

}
