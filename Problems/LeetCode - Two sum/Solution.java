class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        for (int firstNumberIndex = 0; firstNumberIndex < nums.length - 1; firstNumberIndex++) {
            int firstNumber = nums[firstNumberIndex];

            for (int secondNumberIndex = firstNumberIndex + 1; secondNumberIndex < nums.length; secondNumberIndex++) {
                int secondNumber = nums[secondNumberIndex];

                if (firstNumber + secondNumber == target) {
                    return new int[]{firstNumberIndex, secondNumberIndex};
                }
            }
        }

        return null;
    }
}
