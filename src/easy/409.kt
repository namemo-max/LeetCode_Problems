package easy

/*
 * https://leetcode.com/problems/longest-palindrome/description/
 */

fun longestPalindrome(s: String): Int {

    val map = HashMap<Char, Int>()

    for (char in s) {
        map.merge(char, 1, Int::plus)
    }

    var res = 0
    var firstOdd = true
    for ((_, count) in map) {
        if (count % 2 != 0) {
            res += if (firstOdd) count else count - 1
            firstOdd = false
        } else {
            res += count
        }
    }
    return res
}