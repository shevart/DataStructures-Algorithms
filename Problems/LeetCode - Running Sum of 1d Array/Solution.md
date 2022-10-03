# Description

Running Sum of 1d Array

Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.

# Solution

```
class Solution {
    public int[] runningSum(int[] nums) {
      if (nums.length == 1) {
         return nums;
      }
      int prevNumber = nums[0];
      int[] result = new int[nums.length];
      result[0] = prevNumber;
      for (int i = 1; i < nums.length; i++) {
         prevNumber += nums[i];
         result[i] = prevNumber;
      }
      return result;
    }
}
```
