# Description

Is Subsequence 
https://leetcode.com/problems/is-subsequence/submissions/

Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

# Solution
```
class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int tPointer = 0;
        int sPointer = 0;
        while (tPointer != t.length() && sPointer != s.length()) {
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;
            }
            tPointer++;
        }

        return sPointer == s.length();
    }
}
```
