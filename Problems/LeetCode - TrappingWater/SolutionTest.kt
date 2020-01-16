import org.junit.Test

import org.junit.Assert.*

class SolutionTest {
    @Test
    fun `test - trap`() {
        // prepare
        val solution = createSolution()

        // perform
        val result = solution.trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1))

        // check
        assertEquals(6, result)
    }

    @Test
    fun `test - big`() {
        // prepare
        val solution = createSolution()

        // perform
        val result = solution.trap(bigArray())

        // check
        assertNotEquals(0, result)
    }

    @Test
    fun `test - trap first part`() {
        // prepare
        val solution = createSolution()

        // perform
        val result = solution.trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3))

        // check
        assertEquals(5, result)
    }

    @Test
    fun `test - countWaterBetweenTwoPicks - empty`() {
        // prepare
        val solution = createSolution()

        // perform
        val result = solution.countWaterBetweenTwoPicks(intArrayOf(), 0, 0)

        // check
        assertEquals(0, result)
    }

    @Test
    fun `test - countWaterBetweenTwoPicks - triple no water`() {
        // prepare
        val solution = createSolution()

        // perform
        val result = solution.countWaterBetweenTwoPicks(intArrayOf(1,1,1), 0, 2)

        // check
        assertEquals(0, result)
    }

    @Test
    fun `test - countWaterBetweenTwoPicks - triple with water`() {
        // prepare
        val solution = createSolution()

        // perform
        val result = solution.countWaterBetweenTwoPicks(intArrayOf(1,0,1), 0, 2)

        // check
        assertEquals(1, result)
    }

    @Test
    fun `test - countWaterBetweenTwoPicks - triple with double water`() {
        // prepare
        val solution = createSolution()

        // perform
        val result = solution.countWaterBetweenTwoPicks(intArrayOf(2,0,2), 0, 2)

        // check
        assertEquals(2, result)
    }

    @Test
    fun `test - countWaterBetweenTwoPicks - 5 and no water`() {
        // prepare
        val solution = createSolution()

        // perform
        val result = solution.countWaterBetweenTwoPicks(intArrayOf(1,1,1,1,1), 0, 4)

        // check
        assertEquals(0, result)
    }

    @Test
    fun `test - countWaterBetweenTwoPicks - 5, all zero, and no water`() {
        // prepare
        val solution = createSolution()

        // perform
        val result = solution.countWaterBetweenTwoPicks(intArrayOf(0,0,0,0,0), 0, 4)

        // check
        assertEquals(0, result)
    }

    @Test
    fun `test - countWaterBetweenTwoPicks - 5 numbers with water`() {
        // prepare
        val solution = createSolution()

        // perform
        val result = solution.countWaterBetweenTwoPicks(intArrayOf(5,0,0,0,1), 0, 4)

        // check
        assertEquals(3, result)
    }

    @Test
    fun `test - countWaterByRange - empty start-end Index`() {
        // prepare
        val solution = createSolution()

        // perform
        val result = solution.countWaterByRange(intArrayOf(), 0, 0)

        // check
        assertEquals(0, result)
    }

    @Test
    fun `test - countWaterByRange - single`() {
        // prepare
        val solution = createSolution()

        // perform
        val result = solution.countWaterByRange(intArrayOf(1), 0, 1)

        // check
        assertEquals(0, result)
    }

    @Test
    fun `test - countWaterByRange - double`() {
        // prepare
        val solution = createSolution()

        // perform
        val result = solution.countWaterByRange(intArrayOf(1, 2), 0, 1)

        // check
        assertEquals(0, result)
    }

    @Test
    fun `test - countWaterByRange - triple, no water`() {
        // prepare
        val solution = createSolution()

        // perform
        val result = solution.countWaterByRange(intArrayOf(1, 2, 3), 0, 2)

        // check
        assertEquals(0, result)
    }

    @Test
    fun `test - countWaterByRange - triple, one water`() {
        // prepare
        val solution = createSolution()

        // perform
        val result = solution.countWaterByRange(intArrayOf(1, 0, 1), 0, 2)

        // check
        assertEquals(1, result)
    }

    @Test
    fun `test - countWaterByRange - triple, two water`() {
        // prepare
        val solution = createSolution()

        // perform
        val result = solution.countWaterByRange(intArrayOf(2, 0, 5), 0, 2)

        // check
        assertEquals(2, result)
    }

    @Test
    fun `test - findMaxNumberIndex - empty start-end Index`() {
        // prepare
        val solution = createSolution()

        // perform
        val result = solution.findMaxNumberIndex(intArrayOf(), 0, 0)

        // check
        assertEquals(0, result)
    }

    @Test
    fun `test - findMaxNumberIndex - max at start`() {
        // prepare
        val solution = createSolution()

        // perform
        val result = solution.findMaxNumberIndex(intArrayOf(2, 1, 0), 0, 2)

        // check
        assertEquals(0, result)
    }

    @Test
    fun `test - findMaxNumberIndex - max at medium`() {
        // prepare
        val solution = createSolution()

        // perform
        val result = solution.findMaxNumberIndex(intArrayOf(1, 2, 2, 0), 0, 3)

        // check
        assertEquals(1, result)
    }

    private fun createSolution() = Solution()

    private fun bigArray() = IntArray(100_000_0) {
        return@IntArray random.nextInt(50_000)
    }
}