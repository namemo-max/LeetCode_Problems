package easy

private val map = HashMap<Char, Int>()
fun main() {
    println(checkInclusion("ab", "eidbaooo"))

    val monsterAndReward = mutableListOf<Pair<Int, Int>>()
    monsterAndReward.add(4 to 1)
    monsterAndReward.add(1 to 1)
    monsterAndReward.add(2 to 1)
    monsterAndReward.add(1 to 1)
    println(monsterAndReward.sortedBy { it.first }.toString())
}

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

//fun checkInclusion(s1: String, s2: String): Boolean {
//    for (i in s2.indices) {
//        resetMap(s1)
//        var streak = i
//        while (streak < s2.length && map.containsKey(s2[i])) {
//            if (!map.containsKey(s2[streak]) || (map[s2[streak]] ?: 0) < 1) {
//                break
//            }
//            map.merge(s2[streak], -1, Int::plus)
//            streak++
//        }
//        if (map.values.sum() == 0) {
//            return true
//        }
//    }
//    return false
//}

fun resetMap(s1: String) {
    map.clear()
    for (char in s1) {
        if (map.containsKey(char)) {
            map.merge(char, 1, Int::plus)
        } else {
            map[char] = 1
        }
    }
}