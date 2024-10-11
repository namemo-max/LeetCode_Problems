package easy

fun maximumCoins(heroes: IntArray, monsters: IntArray, coins: IntArray): LongArray {
    val sortedHeroes = heroes.withIndex().sortedBy { it.value }
    val sortedMonsters = monsters.zip(coins).sortedBy { it.first }

    val prefixSum = LongArray(monsters.size)
    prefixSum[0] = sortedMonsters[0].second.toLong()
    for (i in 1..<sortedMonsters.size) {
        prefixSum[i] = prefixSum[i - 1] + sortedMonsters[i].second
    }
    println(prefixSum.joinToString())

    val res = LongArray(heroes.size)
    var monsterIndex = 0
    for ((i, hero) in sortedHeroes) {
        while (monsterIndex < monsters.size && sortedMonsters[monsterIndex].first <= hero) {
            monsterIndex++
        }
        res[i] = if (monsterIndex > 0) prefixSum[monsterIndex - 1] else 0L
    }
    return res
}