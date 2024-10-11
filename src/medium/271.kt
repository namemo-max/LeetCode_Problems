package medium

// Encodes a list of strings to a single string.
fun encode(strs: List<String>): String {
    val encodedString = StringBuilder()
    for (str in strs) {
        encodedString.append(str.length)
        encodedString.append("/")
        encodedString.append(":")
        encodedString.append(str)
    }
    println(encodedString)
    return encodedString.toString()
}

// Decodes a single string to a list of strings.
fun decode(s: String): List<String> {
    val decodedStrings = mutableListOf<String>()
    var index = 0

    while (index < s.length) {
        val delimiter = s.indexOf(string = "/:", startIndex = index)
        val wordSize = s.substring(startIndex = index, endIndex = delimiter).toInt()
        val word = s.substring(delimiter + 2, wordSize + delimiter + 2)
        decodedStrings.add(word)
        index = wordSize + delimiter + 2
    }
    return decodedStrings.toList()
}