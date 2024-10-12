package medium

fun search(nums: IntArray, target: Int): Int {
    var res = 0
    val minIndex = getMinIndex(nums)
    if (nums[minIndex] == target) {
        return minIndex
    }

    if (minIndex == 0) {
        res = binSearch(nums, 0, nums.size - 1, target)
    } else if (target >= nums[0]) {
        res = binSearch(nums, 0, minIndex - 1, target)
    } else {
        res = binSearch(nums, minIndex, nums.size - 1, target)
    }
    return res
}

private fun binSearch(nums: IntArray, start: Int, end: Int, target: Int): Int {
    var l = start
    var r = end
    while (l <= r) {
        val m = l + (r - l) / 2
        when {
            nums[m] < target -> l = m + 1
            nums[m] > target -> r = m - 1
            else -> return m
        }
    }
    return - 1
}

private fun getMinIndex(nums: IntArray): Int {
    var l = 0
    var r = nums.size - 1
    while(l < r) {
        val m = l + (r - l) / 2
        when {
            nums[m] < nums[r] -> r = m
            else -> l = m + 1
        }
    }
    return l
}