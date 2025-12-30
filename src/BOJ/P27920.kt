package BOJ

import java.util.LinkedList
import java.util.Scanner

fun main() {
    val N = Scanner(System.`in`).nextInt()

    println("YES")
    val orderOfNumbers = LinkedList<Int>()
    val orderOfPick = LinkedList<Int>()

    for (number in 1..N) {
        if (number % 2 == 1) {
            orderOfNumbers.addFirst(number)
        } else {
            orderOfNumbers.addLast(number)
        }
    }

    if (N % 2 == 1) {
        val center = (N / 2) + 1
        orderOfPick.addLast(center)
        for (number in 1..(N / 2)) {
            orderOfPick.addLast(center + number)
            orderOfPick.addLast(center - number)
        }
    } else {
        val center = N / 2
        orderOfPick.addLast(center)
        for (number in 1..((N / 2) - 1)) {
            orderOfPick.addLast(center + number)
            orderOfPick.addLast(center - number)
        }
        orderOfPick.addLast(N)
    }

    println(orderOfNumbers.joinToString(" ") { it.toString() })
    println(orderOfPick.joinToString(" ") { it.toString() })
}
