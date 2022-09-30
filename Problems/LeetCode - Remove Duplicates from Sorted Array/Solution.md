# Description

Remove Duplicates from Sorted Array
https://leetcode.com/problems/remove-duplicates-from-sorted-array/

# Solution
```
        if (nums.length == 1) {
            return 1;
        }

        int currentNumberIndex = 0;
        int pointerIndex = 1;
        while (pointerIndex < nums.length) {
            if (nums[currentNumberIndex] == nums[pointerIndex]) {
                pointerIndex++;
                continue;
            }

            if (currentNumberIndex != pointerIndex) {
                nums[currentNumberIndex + 1] = nums[pointerIndex];
                currentNumberIndex++;
            }
        }

        return currentNumberIndex + 1;
```

# Tests
```
    @Test
    fun `test single item array`() {
        val source = intArrayOf(1)
        val expected = intArrayOf(1)
        val result = test(source)
        assertEquals(1, result)
        assertTrue(expected.contentEquals(source))
    }

    @Test
    fun `case 1`() {
        val source = intArrayOf(1,1,2)
        val expected = intArrayOf(1,2,2)
        val result = test(source)
        assertEquals(2, result)
        assertTrue(expected.contentEquals(source))
    }

    @Test
    fun `case 2`() {
        val source = intArrayOf(0,0,1,1,1,2,2,3,3,4)
        val expected = intArrayOf(0,1,2,3,4,2,2,3,3,4)
        val result = test(source)
        assertEquals(5, result)
        assertTrue(expected.contentEquals(source))
    }

    @Test
    fun `case 3`() {
        val source = intArrayOf(1,1,1,1,1,1,1,1,1,2)
        val expected = intArrayOf(1,2,1,1,1,1,1,1,1,2)
        val result = test(source)
        assertEquals(2, result)
        assertTrue(expected.contentEquals(source))
    }

    private fun test(nums: IntArray): Int {
        return RemoveDuplicatesFromSortedArray().removeDuplicates(nums)
    }
```
