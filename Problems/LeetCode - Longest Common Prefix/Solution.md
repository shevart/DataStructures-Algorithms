# Description

https://leetcode.com/problems/longest-common-prefix/

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

# Solution

```
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0 || strs[0].isEmpty()) {
            return "";
        }

        int subStringEnd = -1;
        final String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            final char currentChar = first.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != currentChar) {
                    return subStringEnd >= 0 ? first.substring(0, subStringEnd + 1) : "";
                }
            }

            subStringEnd = i;
        }

        return first.substring(0, subStringEnd+1);
    }
}
```

# Tests
```
    @Test
    fun `test empty param`() {
        assertEquals("", test(arrayOf()))
    }

    @Test
    fun `case 1`() {
        assertEquals("fl", test(arrayOf("flower","flow","flight")))
    }

    @Test
    fun `case 2`() {
        assertEquals("", test(arrayOf("dog","racecar","car")))
    }

    @Test
    fun `case 3`() {
        assertEquals("d", test(arrayOf("d","d","d")))
    }

    @Test
    fun `case 4`() {
        assertEquals("dc", test(arrayOf("dc","dcc","dccc")))
    }

    @Test
    fun `case 5`() {
        assertEquals("", test(arrayOf("","d","dccc")))
    }

    @Test
    fun `case 6`() {
        assertEquals("a", test(arrayOf("ab", "a")))
    }

    private fun test(s: Array<String>): String {
        return LongestCommonPrefixProblem().longestCommonPrefix(s)
    }
```
