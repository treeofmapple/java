package ExampleTest;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.Test;

class TestExamples {

	static Object a = 1, b = 1, c = 2;
	static Iterable <String> ad, dc;
	static List <String> bc, bd;

    @Test
    void testBasicAssertions() {
        assertEquals(4, 2 + 2);
        assertNotEquals(4, 2 + 2);
        assertTrue(5 > 3);
        assertFalse(3 > 5);
        assertNull(null);
        assertNotNull("not null");
        assertSame(a , b);
        assertNotSame(a , c);
        assertIterableEquals(ad, dc);
        assertLinesMatch(bc, bd);
    }

    @Test
    void testArrayAssertions() {
        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 3};
        assertArrayEquals(expected, actual);
        
    }

    @Test
    void testExceptionAssertions() {
        assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("one");
        });

        assertDoesNotThrow(() -> {
            Integer.parseInt("1");
        });
    }

    @Test
    void testTimeoutAssertions() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(50);
        });

        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(50);
        });
    }

    @Test
    void testGroupedAssertions() {
        assertAll("Grouped Assertions",
            () -> assertEquals(2, 1 + 1),
            () -> assertTrue(3 > 1),
            () -> assertNotNull("not null")
        );
    }
}
