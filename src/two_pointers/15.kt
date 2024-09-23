package two_pointers

import java.util.*

fun threeSum(nums: IntArray): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    Arrays.sort(nums)

    for (i in 0..nums.size) {
        if (i < nums.size && nums[i] <= 0) {
            var left = i + 1
            var right = nums.size - 1

            while (left < right) {
                val sum = nums[left] + nums[right] + nums[i]

                when {
                    sum < 0 -> ++left
                    sum > 0 -> --right
                    else -> {
                        val list = listOf(nums[left++], nums[right--], nums[i])
                        if (!res.contains(list)) {
                            res.add(list)
                        }
                    }
                }
            }
        }
    }
    return res
}