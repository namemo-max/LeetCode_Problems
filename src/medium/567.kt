package medium

fun checkInclusion(s1: String, s2: String): Boolean {
    if (s1.length > s2.length) return false

    val s1Freq = IntArray(26)
    val s2Freq = IntArray(26)

    for (i in s1.indices) {
        s1Freq['z' - s1[i]]++
        s2Freq['z' - s2[i]]++
    }

    for (i in 0..<s2.length - s1.length) {
        if (s1Freq.contentEquals(s2Freq)) return true
        s2Freq['z' - s2[i]]--
        s2Freq['z' - s2[i+s1.length]]++
    }

    return s1Freq.contentEquals(s2Freq)
}

