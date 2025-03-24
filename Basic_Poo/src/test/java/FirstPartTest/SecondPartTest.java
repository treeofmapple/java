package FirstPartTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import FirstPart.Operate2;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SecondPartTest {
	
	static Operate2 op = new Operate2();
	static TestRunner tester = new TestRunner();
	
	@Test
	@Order(1)
	void ArraySum () {
		int[] input = {2,4,6,7,9};
		int expected = 28, result = op.ArraySum(input);
		
		tester.runTestEquals(expected, result, "");
	}
	
	@Test
	@Order(2)
	void LargestElement () {
		int[] input = {7,2,5,1,4};
		int expected = 7, result = op.LargestElement(input);
		
		tester.runTestEquals(expected, result, "");
	}
	
	@Test
	@Order(3)
	void TransposeMatrix () {
		int size = 3;
		int[][] input = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] expected = {{1,4,7},{2,5,8},{3,6,9}};
		int[][] result = op.TransposeMatrix(input, size);
		
		tester.runTestMatrixEquals(expected, result, "");
	}
	
	@Test
	@Order(4)
	void ArrayRotation () {
		int[] input = {1,2,3,4,5,6,7}, expected = {3,4,5,6,7,1,2};
		int d = 2;
		int[] result = op.ArrayRotation(input, d);
		
		tester.runTestArrayEquals(expected, result, "");
		
	}
	
	@Test
	@Order(5)
	void RemoveDuplicated () {
		int[] input = {1,2,2,3,3,3,4,5}, expected = {1,2,3,4,5};
		int[] result = op.RemoveDuplicated(input);
		
		tester.runTestArrayEquals(expected, result, "");
	}
	
	@Test
	@Order(6)
	void RemoveOccurencies () {
		int[] input = {1,2,1,3,5,1}, expected = {2,3,5};
		int b = 1;
		int[] result = op.RemoveOccurencies(input, b);
	
		tester.runTestArrayEquals(expected, result, "");
	}
	
}
