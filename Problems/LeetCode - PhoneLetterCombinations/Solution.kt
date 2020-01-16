class Solution {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) {
            return emptyList()
        }

        val preparedDigitsList = digits.toCharArray()
            .map { it.toString() }
            .map { it.toInt() }
        val listWithDigitsToLetters: List<List<String>> = preparedDigitsList
            .map { letters[it] }
            .map { it.toStringsList() }

        if (listWithDigitsToLetters.size == 1) {
            return listWithDigitsToLetters.first()
        }

        return performLists(listWithDigitsToLetters.first(),
            listWithDigitsToLetters.subList(1, listWithDigitsToLetters.size))
    }

    private fun performLists(list: List<String>, rest: List<List<String>>): List<String> {
        val result = ArrayList<String>()
        val strings = if (rest.size > 1) {
            performLists(rest.first(), rest.subList(1, rest.size))
        } else {
            rest.first()
        }

        list.forEach { currentLetter ->
            strings.forEach { string  ->
                result += (currentLetter + string)
            }
        }
        return result
    }

    private val letters = Array(10) {
        when (it) {
            0, 1 -> ""
            2 -> "abc"
            3 -> "def"
            4 -> "ghi"
            5 -> "jkl"
            6 -> "mno"
            7 -> "pqrs"
            8 -> "tuv"
            9 -> "wxyz"
            else -> throw RuntimeException()
        }
    }

    private fun String.toStringsList(): List<String> {
        return this.toCharArray().map { it.toString() }
    }
}