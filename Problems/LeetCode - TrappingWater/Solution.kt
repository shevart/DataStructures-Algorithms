class Solution {
    fun trap(height: IntArray): Int {
        return countWaterByRange(height, 0, height.size - 1)
    }

    fun countWaterByRange(height: IntArray, startIndex: Int, endIndex: Int): Int {
        if (startIndex == endIndex || height.size <= 2) {
            return 0
        }

        val rangeSize = endIndex - startIndex
        if (rangeSize <= 2) {
            return if (rangeSize == 2) {
                return countWaterInTripleRange(height, startIndex, endIndex)
            } else {
                0
            }
        }

        val maxNumberIndex = findMaxNumberIndex(height, startIndex + 1, endIndex - 1)
        return if (maxNumberIndex != startIndex && maxNumberIndex != endIndex
            && (height[maxNumberIndex] > height[startIndex] || height[maxNumberIndex] > height[endIndex])) {
            countWaterByRange(height, startIndex, maxNumberIndex) + countWaterByRange(height, maxNumberIndex, endIndex)
        } else {
            countWaterBetweenTwoPicks(height, startIndex, endIndex)
        }
    }

    private fun countWaterInTripleRange(height: IntArray, startIndex: Int, endIndex: Int): Int {
        return if (height[startIndex + 1] < height[startIndex] && height[startIndex + 1] < height[endIndex]) {
            return min(height[startIndex], height[endIndex]) - height[startIndex + 1]
        } else {
            0
        }
    }

    fun countWaterBetweenTwoPicks(height: IntArray, startIndex: Int, endIndex: Int): Int {
        if (height.size <= 2) {
            return 0
        }

        var water = min(height[startIndex], height[endIndex]) * (endIndex - startIndex - 1)
        if (water == 0) {
            return 0
        }
        for (i in (startIndex + 1) until endIndex) {
            water -= height[i]
        }
        return water
    }

    private fun min(first: Int, second: Int): Int =
        if (first < second) first else second

    fun findMaxNumberIndex(height: IntArray, startIndex: Int, endIndex: Int): Int {
        var maxNumberIndex = startIndex
        for (i in startIndex..endIndex) {
            if (i != maxNumberIndex && height[i] > height[maxNumberIndex]) {
                maxNumberIndex = i
            }
        }
        return maxNumberIndex
    }
}