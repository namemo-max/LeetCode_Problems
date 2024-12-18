package easy


fun removeDuplicatesII(nums: IntArray): Int {
    if (nums.size <= 2) {
        return nums.size
    }

    var slowPointer = 2
    for (fastPointer in 2..<nums.size) {
        if (nums[fastPointer] != nums[slowPointer - 2]) {
            nums[slowPointer++] = nums[fastPointer]
        }
    }
    return slowPointer
}