package easy

fun main() {
    removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4))
}

fun removeDuplicates(nums: IntArray): Int {
    var slowPointer = 1
    for (fastPointer in 1..<nums.size) {
        if (nums[fastPointer] != nums[slowPointer - 1]) {
            nums[slowPointer++] = nums[fastPointer]
        }
    }
    return slowPointer
}