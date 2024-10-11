package easy

import kotlin.math.max

fun largestUniqueNumber(nums: IntArray): Int {
    val map = HashMap<Int, Int>()

    for (num in nums) {
        map.merge(num, 1, Int::plus)
    }

    var res = 0
    for ((key, value) in map) {
        if (value < 2) {
            res = max(res, key)
        }
    }
    return if (res == 0) -1 else res
}