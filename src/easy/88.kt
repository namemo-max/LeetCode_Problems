package easy

fun main() {
    println(merge(intArrayOf(1, 2, 3, 0, 0, 0), 3, intArrayOf(2, 5, 6), 3))
}

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var p1 = m - 1
    var p2 = n - 1
    var index = nums1.size - 1

    while (p2 >= 0) {
        if (p1 < 0 || nums1[p1] < nums2[p2]) {
            nums1[index] = nums2[p2]
            p2--
        } else {
            nums1[index] = nums1[p1]
            p1--
        }
        index--
    }
}