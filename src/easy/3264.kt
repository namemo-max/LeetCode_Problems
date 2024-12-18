package easy

fun getFinalState(nums: IntArray, k: Int, multiplier: Int): IntArray {
    for (i in 0..<k) {
        val pair = findMin(nums)
        nums[pair.first] = pair.second * multiplier
    }
    return nums
}

private fun findMin(nums: IntArray): Pair<Int, Int> {
    var min = nums.first()
    var res = 0 to min
    for (i in 1..<nums.size) {
        if (min > nums[i]) {
            min = nums[i]
            res = i to min
        }
    }
    return res
}