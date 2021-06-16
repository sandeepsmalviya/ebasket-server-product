package com.ecommerce.catalog.server.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("When testing MathUtils")
class MathUtilsTest {

	@Nested
	@Tag("Math")
	@DisplayName("add method")
	class AddMethod {

		@Test
		@Tag("Math")
		@DisplayName("when adding two positive number")
		void testAddPositive() {
			MathUtils utils = new MathUtils();
			int actual = utils.add(2, 3);
			int expected = 5;
			assertEquals(expected, actual, "should return right sum");
		}

		@RepeatedTest(3)
		@Tag("Math")
		@DisplayName("when adding two negative number")
		void testAddNegative() {
			MathUtils utils = new MathUtils();
			int actual = utils.add(-2, -3);
			int expected = -5;
			assertEquals(expected, actual, "should return right sum");
		}

		@RepeatedTest(3)
		@Tag("Math")
		@DisplayName("when adding one positive and one negative number")
		void testAddNegative(RepetitionInfo repetitionInfo) {
			MathUtils utils = new MathUtils();
			int actual = utils.add(2, -3);
			int expected = -1;
			assertEquals(expected, actual, ()-> "should return right sum with repetition info : "+ repetitionInfo.getCurrentRepetition()+ "/"+ repetitionInfo.getTotalRepetitions());
		}

	}

	@Test
	@Tag("Circle")
	@DisplayName("Testing compute circle area method")
	void testComputeCircleArea() {
		MathUtils utils = new MathUtils();
		double actual = utils.computeCircleArea(10);
		double expected = Math.PI * 10 * 10;
		assertEquals(expected, actual, "Should calculate correct circle area");
	}

	@Test
	@Tag("Math")
	void testDivide() {
		MathUtils utils = new MathUtils();
		assertThrows(ArithmeticException.class, () -> {
			utils.divide(1, 0);
		}, "divide by zero should be thrown");
	}

}
