package medium

fun findMin(nums: IntArray): Int {
    var l = 0
    var r = nums.size - 1
    while (l < r) {
        val m = l + (r - l) / 2
        if (nums[m] < nums[r]) {
            r = m
        } else {
            l = m + 1
        }
    }
    return nums[l]
}