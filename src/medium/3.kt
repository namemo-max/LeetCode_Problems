package medium

import kotlin.math.max

fun main() {
    println(lengthOfLongestSubstring("au"))
}

fun lengthOfLongestSubstring(s: String): Int {
    if (s.length < 2) return s.length
    var res = 0
    val set = mutableSetOf<Char>()

    for (i in s.indices) {
        var pointer = i
        while (pointer <= s.length - 1 && !set.contains(s[pointer])) {
            set.add(s[pointer])
            pointer++
        }
        res = max(res, set.size)
        set.clear()
    }
    return res
}