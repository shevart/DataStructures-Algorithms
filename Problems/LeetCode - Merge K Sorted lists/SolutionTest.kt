import org.junit.Assert.*
import org.junit.Test

class SolutionTest {
    @Test
    fun `test empty input`() {
        // prepare
        val solution = Solution()

        // perform
        val result = solution.mergeKLists(emptyArray())

        // check
        assertEquals(null, result)
    }

    @Test
    fun `test single input`() {
        // prepare
        val solution = Solution()
        val single = ListNode(1)

        // perform
        val result = solution.mergeKLists(arrayOf(single))

        // check
        assertEquals(single, result)
    }

    @Test
    fun `test insert - single`() {
        // prepare
        val solution = Solution()
        val single = ListNode(1)

        // perform
        val result = solution.insert(2, single)

        // check
        assertEquals(1, result.`val`)
        assertEquals(2, result.next?.`val`)
        assertEquals(null, result.next?.next)
    }

    @Test
    fun `test insert - single, number less than val`() {
        // prepare
        val solution = Solution()
        val single = ListNode(2)

        // perform
        val result = solution.insert(1, single)

        // check
        assertEquals(1, result.`val`)
        assertEquals(2, result.next?.`val`)
        assertEquals(null, result.next?.next)
    }

    @Test
    fun `test insert - double, number bigger than val`() {
        // prepare
        val solution = Solution()
        val single = ListNode(1).apply { next = ListNode(2) }

        // perform
        val result = solution.insert(3, single)

        // check
        assertEquals(1, result.`val`)
        assertEquals(2, result.next?.`val`)
        assertEquals(3, result.next?.next?.`val`)
    }

    @Test
    fun `test insert - 31`() {
        // prepare
        val solution = Solution()
        // 1 1 3 4
        val listNode = ListNode(1)
        listNode.next = ListNode(1)
        listNode.next?.next = ListNode(3)
        listNode.next?.next?.next = ListNode(4)

        // perform
        val result = solution.insert(5, listNode)

        // check
        assertEquals(1, result.`val`)
        assertEquals(1, result.next?.`val`)
        assertEquals(3, result.next?.next?.`val`)
        assertEquals(4, result.next?.next?.next?.`val`)
    }

    @Test
    fun `test insert - double`() {
        // prepare
        val solution = Solution()
        val doubleNode = ListNode(1).apply {
            next = ListNode(2)
        }

        // perform
        val result = solution.insert(3, doubleNode)

        // check
        assertEquals(1, result.`val`)
        assertEquals(2, result.next?.`val`)
        assertEquals(3, result.next?.next?.`val`)
        assertEquals(null, result.next?.next?.next)
    }

    @Test
    fun `test merge - empty`() {
        // prepare
        val solution = Solution()

        // perform
        val result = solution.merge(ListNode(1), ListNode(2))

        // check
        assertEquals(1, result.`val`)
        assertEquals(2, result.next?.`val`)
        assertEquals(null, result.next?.next)
    }

    @Test
    fun `test merge - double`() {
        // prepare
        val solution = Solution()
        val first = ListNode(1).apply { next = ListNode(2) }
        val second = ListNode(3).apply { next = ListNode(4) }

        // perform
        val result = solution.merge(first, second)

        // check
        assertEquals(1, result.`val`)
        assertEquals(2, result.next?.`val`)
        assertEquals(3, result.next?.next?.`val`)
        assertEquals(4, result.next?.next?.next?.`val`)
        assertEquals(null, result.next?.next?.next?.next)
    }

    @Test
    fun `test mergeKList - with first null`() {
        // prepare
        val solution = Solution()
        val single = ListNode(1)

        // perform
        val result = solution.mergeKLists(arrayOf(null, single))

        // check
        assertEquals(1, result?.`val`)
        assertEquals(null, result?.next)
    }

    @Test
    fun `test mergeKList - 31 test from leetCode`() {
        // prepare
        val solution = Solution()
        // [[1,4,5],[1,3,4],[2,6]]
        val first = ListNode(1).apply { next = ListNode(4).apply { next = ListNode(5) } }
        val second = ListNode(1).apply { next = ListNode(3).apply { next = ListNode(4) } }
        val third = ListNode(2).apply { next = ListNode(6) }

        // perform
        val result = solution.mergeKLists(arrayOf(first, second, third))

        // check
        assertEquals(1, result?.`val`)
        assertEquals(1, result?.next?.`val`)
    }
}