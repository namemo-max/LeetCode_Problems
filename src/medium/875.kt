package medium

import kotlin.math.ceil

fun minEatingSpeed(piles: IntArray, h: Int): Int {
    for (i in 1..Int.MAX_VALUE) {
        var spent = 0
        for (pile in piles) {
            spent += ceil(pile.toDouble() / i).toInt()
            if (spent > h) {
                break
            }
        }
        if (spent <= h) {
            return i
        }
    }
    return -1
}

//fun minEatingSpeed(piles: IntArray, h: Int): Int {
//    var left = 1
//    var right = piles.maxOrNull() ?: 0
//
//    while (left < right) {
//        val mid = left + (right - left) / 2
//        var hours = 0
//
//        for (pile in piles) {
//            hours += ceil(pile.toDouble() / mid).toInt()
//        }
//
//        when {
//            hours <= h -> {
//                right = mid
//            }
//            else -> {
//                left = mid + 1
//            }
//        }
//    }
//    return right
//}