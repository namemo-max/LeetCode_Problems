package medium

fun main() {
    println(repeatLimitedString("cczazcc", 3))
}

fun repeatLimitedString(s: String, repeatLimit: Int): String {
    val freq = IntArray(26)
    for (char in s) {
        freq[char - 'a']++
    }

    val res = StringBuilder()
    var left = 24
    var right = 25

    while (right >= 0) {
        while (left >= 0 && freq[left] == 0) {
            left--
        }
        if (freq[right] > repeatLimit) {
            res.append(CharArray(repeatLimit) { 'a' + right })
            freq[right] -= repeatLimit
            if (left < 0) {
                break
            }
            res.append('a' + left)
            freq[left]--
        } else {
            res.append(CharArray(freq[right]) { 'a' + right })
            right = left
            left--
        }
    }
    return res.toString()
}