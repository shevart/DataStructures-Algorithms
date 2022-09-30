# Description

https://leetcode.com/problems/valid-parentheses/

Given a string s containing just the characters `'(', ')', '{', '}', '[' and ']'`, determine if the input string is valid.

An input string is valid if:

- Open brackets must be closed by the same type of brackets.
- Open brackets must be closed in the correct order.
- Every close bracket has a corresponding open bracket of the same type.



# Solution
```
class Solution {
    public boolean isValid(String s) {
        if (s.isEmpty() || s.length() % 2 != 0) {
            return false;
        }

        final char[] queue = new char[s.length()];
        int currentIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            final char currChar = s.charAt(i);

            if (currChar == '(' || currChar == '{' || currChar == '[') {
                queue[++currentIndex] = currChar;
                continue;
            }

            if (currentIndex == -1) {
                return false;
            }
            final char currentOpenSymbol = queue[currentIndex];
            if (currentOpenSymbol == '(' && currChar == ')') {
                currentIndex--;
            } else if (currentOpenSymbol == '{' && currChar == '}') {
                currentIndex--;
            } else if (currentOpenSymbol == '[' && currChar == ']') {
                currentIndex--;
            } else  {
                return false;
            }
        }

        return currentIndex == -1;
    }
}
```


## Tests
```
    @Test
    fun `test empty String`() {
        assertEquals(false, test(""))
    }

    @Test
    fun `sample 1`() {
        assertEquals(true, test("()"))
    }

    @Test
    fun `sample 2`() {
        assertEquals(true, test("()[]{}"))
    }

    @Test
    fun `sample 3`() {
        assertEquals(false, test("(]"))
    }

    @Test
    fun `sample 4`() {
        assertEquals(false, test("([)]"))
    }

    @Test
    fun `sample 5`() {
        assertEquals(false, test("(("))
    }

    @Test
    fun `sample 6`() {
        assertEquals(false, test("){"))
    }

    @Test
    fun `sample 7`() {
        assertEquals(false, test("))))"))
    }

    @Test
    fun `sample 8`() {
        assertEquals(false, test("{{))))"))
    }

    @Test
    fun `sample 9`() {
        assertEquals(false, test("{{{{{{{{{{{{{{{{{{{))"))
    }

    private fun test(s: String): Boolean {
        return ValidParenthesesProblem().isValid(s)
    }
```
