package FirstPartTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import OperUsers.Colors;
import OperUsers.ComplexNumber;
import OperUsers.Others;

public class TestRunner {
	static ComplexNumber cx;
	static Others othz;
	
	public void runTest(Runnable assertion, Object expected, Object result, String testName) {
		if (testName == null || testName.isEmpty()) {
			testName = getCurrentMethodName();
		}
		try {
			assertion.run();
			System.out.println(Colors.ANSI_GREEN + testName + " : {Test passed}" + Colors.ANSI_RESET);
			System.out.println("Result: " + result + " || Expected: " + expected + "\n");
		} catch (AssertionError | NullPointerException e) {
			System.out.println(Colors.ANSI_RED + testName + " : {Test failed}" + Colors.ANSI_RESET);
			System.out.println("Result: " + result + " || Expected: " + expected + "\n");
			throw e;
		}
	}
	
	public void runTestArrayEquals(int[] expected, int[] result, String testName) {
		runTest(() -> assertArrayEquals(expected, result), java.util.Arrays.toString(expected), java.util.Arrays.toString(result), testName);
	}
	
	public void runTestEquals(int expected, int result, String testName) {
		runTest(() -> assertEquals(expected, result), expected, result, testName);
	}
	
	public void runTestComplexRunner(ComplexNumber expected, ComplexNumber result, String testName) {
		runTest(() -> assertEquals(expected, result), expected.showC(), result.showC(), testName);
	}
	
	public void runTestStringEquals(String expected, String result, String testName) {
		runTest(() -> assertEquals(expected, result), expected, result, testName);
	}

    public void runTestStringArrayEquals(String[] expected, String[] result, String testName) {
    	runTest(() -> assertArrayEquals(expected, result), java.util.Arrays.toString(expected), java.util.Arrays.toString(result), testName);
    }
	
	public void runTestMatrixEquals(int[][] expected, int[][] result, String testName) {
		runTest(() -> assertArrayEquals(expected, result), othz.setArray(expected), othz.setArray(result), testName);
	}
	
	private String getCurrentMethodName() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		return stackTrace[4].getMethodName();
		// [0] is getStackTrace, [1] is getCurrentMethodName, [2] is runTestXXX, [3] is
		// the calling test method
	}
}
