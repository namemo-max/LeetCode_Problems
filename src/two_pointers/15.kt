package two_pointers

import java.util.*

fun threeSum(nums: IntArray): List<List<Int>> {
    val res = mutableSetOf<List<Int>>()
    Arrays.sort(nums)

    for (i in 0..nums.size - 3) {
        if (i == 0 || nums[i] != nums[i - 1]) {
            var left = i + 1
            var right = nums.size - 1

            while (left < right) {
                val sum = nums[left] + nums[right] + nums[i]

                when {
                    sum < 0 -> ++left
                    sum > 0 -> --right
                    else -> res.add(listOf(nums[left++], nums[right--], nums[i]))
                }
            }
        }
    }
    return res.toList()
}