package FirstPartTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import FirstPart.Operate;
import OperUsers.ComplexNumber;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FirstPartTest {

	static Operate op = new Operate();
	static TestRunner tester = new TestRunner();

	@Test
	@Order(1)
	void NumberSwapTest() {
		int a = 5, b = 10;
		int[] expected = { 10, 5 }, result = op.NumberSwap(a, b);

		tester.runTestArrayEquals(expected, result, "");
	}

	@Test
	@Order(2)
	void BinaryTransformTest() {
		int input = 9, expected = 1001;
		int result = op.BinaryTransform(input);

		tester.runTestEquals(expected, result, "");
	}

	@Test
	@Order(3)
	void FactorialNumberTest() {
		int input = 5, expected = 120;
		int result = op.FatorialNumber(input);

		tester.runTestEquals(expected, result, "");
	}

	@Test
	@Order(4)
	void ComplexNumberTest() {
		ComplexNumber result = op.add(new ComplexNumber(1, 2), new ComplexNumber(4, 5));
		ComplexNumber expected = new ComplexNumber(5, 7);

		tester.runTestComplexRunner(expected, result, "");
	}

	@Test
	@Order(5)
	void SimpleInterestTest() {
		int p = 10000, r = 5, t = 5, expected = 2500;
		int result = op.SimpleInterest(p, r, t);

		tester.runTestEquals(expected, result, "");
	}

	@Test
	@Order(6)
	void PascalTriangleTest() {
		int input = 6, expected[] = { 1, 1, 1, 1, 2, 1, 1, 3, 3, 1, 1, 4, 6, 4, 1, 1, 5, 10, 10, 5, 1 };
		int[] result = op.PascalTriangle(input);

		tester.runTestArrayEquals(expected, result, "");
	}

	@Test
	@Order(7)
	void Fibonacci() {
		int input = 4, expected = 33;
		int result = op.Fibonacci(input);

		tester.runTestEquals(expected, result, "");
	}

	@Test
	@Order(8)
	void PyramidPattern() {
		int input = 4;
		String[] expected = {"   *   ","  ***  "," ***** ","*******"}, 
				result = op.PyramidPattern(input);
		
		tester.runTestStringArrayEquals(expected, result, "");
		
	}

	@Test
	@Order(9)
	void PrintPattern() {
		int input = 6;
		String[] expected = {"******","*    *","*    *","*    *","*    *","******"}, 
				result = op.PrintPattern(input);
		
		tester.runTestStringArrayEquals(expected, result, "");
	}
	
	
}
