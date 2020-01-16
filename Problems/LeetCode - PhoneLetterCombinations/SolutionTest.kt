import org.junit.Test
import org.junit.Assert.*

class SolutionTest {
    @Test
    fun letterCombinations() {
        // prepare
        val solution = createSolution()

        // perform
        val result = solution.letterCombinations("23")

        // check
        val resultShouldBe = listOf("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")
        assertEquals(true, resultShouldBe.toSortedSet() == result.toSortedSet())
    }

    private fun createSolution() = Solution()
}