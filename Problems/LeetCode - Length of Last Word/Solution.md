# Description

Length of Last Word
https://leetcode.com/problems/length-of-last-word/

# Code
```
class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 1) {
            return s.charAt(0) == ' ' ? 0 : 1;
        }
        int result = 0;
        for (int i = s.length() - 1; i >= 0 ; i--) {
            if (s.charAt(i) != ' ') {
                result++;
            } else if (result != 0) {
                break;
            }
        }
        return result;
    }
}
```

# Tests
```
    @Test
    fun `test empty String`() {
        assertEquals(1, test("a "))
    }
    
    private fun test(s: String): Int {
        return LengthOfLastWord().lengthOfLastWord(s)
    }
```
