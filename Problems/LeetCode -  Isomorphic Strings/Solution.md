# Description

 Isomorphic Strings
 
 https://leetcode.com/problems/isomorphic-strings/
 
 Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

# Solution
```
class Solution {
    public boolean isIsomorphic(String s, String t) {
      final HashMap<Character, Character> charsPairs = new HashMap<>();
      final Set<Character> knownTChars = new HashSet<>();

      for (int i = 0; i < s.length(); i++) {
         final Character sCurrent = s.charAt(i);
         if (charsPairs.containsKey(sCurrent)) {
            if (charsPairs.get(sCurrent) != t.charAt(i)) {
               return false;
            }
         } else if (knownTChars.contains(t.charAt(i))) {
           return false; 
         } else {
            charsPairs.put(sCurrent, t.charAt(i));
            knownTChars.add(t.charAt(i));
         }
      }

      return true;
    }
}
```
