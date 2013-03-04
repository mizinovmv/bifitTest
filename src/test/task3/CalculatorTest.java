package task3;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testCalculate() {
		String value1 = Calculator.calculate("4+7");
		assertEquals(value1, "11");
		String value2 = Calculator.calculate("4.3-0.3");
		assertEquals(value2, "4");
		String value3 = Calculator.calculate("4*0.3");
		assertEquals(value3, "1.2");
		String value4 = Calculator.calculate("16/2");
		assertEquals(value4, "8");
	}

}
