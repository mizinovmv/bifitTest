package task1;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class FactorialTest {

	@Test
	public void testCalculate() {
		int input = 4;
		int output = 24;
		assertEquals(Factorial.calculate(input), output);
	}

}
