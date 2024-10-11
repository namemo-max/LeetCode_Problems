package medium

import kotlin.math.ceil

fun minEatingSpeed(piles: IntArray, h: Int): Int {
    var left = 1
    var right = piles.maxOrNull() ?: 0

    while (left < right) {
        val mid = left + (right - left) / 2
        var hours = 0

        for (pile in piles) {
            hours += ceil(pile.toDouble() / mid).toInt()
        }

        when {
            hours <= h -> {
                right = mid
            }
            else -> {
                left = mid + 1
            }
        }
    }
    return right
}