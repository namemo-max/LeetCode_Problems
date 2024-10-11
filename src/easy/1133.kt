package easy

import kotlin.math.max

fun largestUniqueNumber(nums: IntArray): Int {
    val map = HashMap<Int, Int>()

    for (num in nums) {
        map.merge(num, 1, Int::plus)
    }

    var res = 0
    // for ((key, value) in map) {
    //     if (value == 1) {
    //         res = max(res, key)
    //     }
    // }
    for (num in nums) {
        val occurrence = map[num] ?: 0
        if (occurrence == 1) {
            res = max(res, num)
        }
    }
    return if (res == 0) - 1 else res
}