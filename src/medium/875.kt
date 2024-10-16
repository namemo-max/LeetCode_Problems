package medium

import kotlin.math.ceil

/*
875. Koko Eating Bananas
Problem link: https://leetcode.com/problems/koko-eating-bananas/description/
 */

fun minEatingSpeed(piles: IntArray, h: Int): Int {
    var min = 1
    var max = piles.maxOrNull() ?: 0

    while (min < max) {
        val mid = min + (max - min) / 2
        if (canEatAll(piles, mid, h)) {
            max = mid
        } else {
            min = mid + 1
        }
    }
    return min
}

private fun canEatAll(piles: IntArray, m: Int, h: Int): Boolean {
    var hours = 0.0
    for (pile in piles) {
        hours += ceil(pile.toDouble() / m)
        if (hours > h) {
            return false
        }
    }
    return hours <= h
}