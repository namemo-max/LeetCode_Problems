package medium

fun search(nums: IntArray, target: Int): Int {
    if (nums.size == 1 && nums[0] == target) return 0
    val minNumIndex = nums.findMinNumberIndex(nums)
    return if (nums[minNumIndex] == target) {
        minNumIndex
    } else if (minNumIndex == 0) {
        binSearch(nums, 0, nums.size - 1, target)
    } else if (target >= nums[0]) {
        binSearch(nums, 0, minNumIndex - 1, target)
    } else {
        binSearch(nums, minNumIndex, nums.size - 1, target)
    }
}

private fun binSearch(nums: IntArray, startIndex: Int, endIndex: Int, target: Int): Int {
    var l = startIndex
    var r = endIndex
    while (l <= r) {
        val m = l + (r - l) / 2
        if (nums[m] == target) {
            return m
        } else if (nums[m] < target) {
            l = m + 1
        } else if (nums[m] > target) {
            r = m - 1
        }
    }
    return -1
}

private fun IntArray.findMinNumberIndex(nums: IntArray): Int {
    var l = 0
    var r = this.size - 1
    while (l < r) {
        val m = l + (r - l) / 2
        if (this[m] < this[r]) {
            r = m
        } else {
            l = m + 1
        }
    }
    return l
}