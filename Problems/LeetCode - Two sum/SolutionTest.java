import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void testNullArray() {
        // perform
        int[] result = createSolution().twoSum(null, 0);

        // check
        assertEquals(0, result.length);
    }

    @Test
    public void testEmptyArray() {
        // perform
        int[] result = createSolution().twoSum(new int[0], 0);

        // check
        assertEquals(0, result.length);
    }

    @Test
    public void testArrayWithOneElement() {
        // perform
        int[] result = createSolution().twoSum(new int[1], 0);

        // check
        assertEquals(0, result.length);
    }

    @Test
    public void testArrayNumber1() {
        // perform
        int[] result = createSolution().twoSum(new int[]{2, 7, 11, 15}, 9);

        // check
        assertEquals(0, result[0]);
        assertEquals(1, result[1]);
    }

    private Solution createSolution() {
        return new Solution();
    }
}
