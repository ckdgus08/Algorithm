package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine()!!.toInt()
    val input = readLine().split(" ").map { str -> str.toInt() }

    val nums = IntArray(N)
    for (i in 0 until N)
        nums[i] = input[i]

    val sortNums = nums.clone()
    Arrays.sort(sortNums)

    val map: MutableMap<Int, Int> = HashMap()
    var index = 0

    for (n in sortNums)
        if (!map.containsKey(n))
            map[n] = index++

    val sb = StringBuilder()
    for (n in nums)
        sb.append(map[n]).append(' ')
    println(sb)
}
