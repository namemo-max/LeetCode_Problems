package easy

/*884. Uncommon Words from Two Sentences*/

fun uncommonFromSentences(s1: String, s2: String): Array<String> {
    val map = HashMap<String, Int>()
    val strs = s1.split(" ") + s2.split(" ")
    val result = arrayListOf<String>()

    for (str in strs) {
        map.merge(str, 1, Int::plus)
    }

    for ((key, value) in map) {
        if (value < 2) {
            result.add(key)
        }
    }

    return result.toTypedArray()
}