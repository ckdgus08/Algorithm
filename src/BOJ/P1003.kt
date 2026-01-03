package BOJ

val cachedValues = mutableMapOf<Int, Int>()

fun main() {
    val br = System.`in`.bufferedReader()
    val T = br.readLine().toInt()

    repeat(T) {
        val N = br.readLine().toInt()
        if (N == 0) {
            println("1 0")
        } else if (N == 1) {
            println("0 1")
        } else {
            println("${cachedFibonachi(N - 1)} ${cachedFibonachi(N)}")
        }
    }
}

fun cachedFibonachi(n: Int): Int {
    return if (cachedValues.containsKey(n)) {
        cachedValues[n]!!
    } else {
        val result = fibonachi(n)
        cachedValues.put(n, result)
        result
    }
}

fun fibonachi(n: Int): Int {
    if (n == 0) {
        return 0
    } else if (n == 1) {
        return 1
    } else {
        return cachedFibonachi(n - 1) + cachedFibonachi(n - 2)
    }
}