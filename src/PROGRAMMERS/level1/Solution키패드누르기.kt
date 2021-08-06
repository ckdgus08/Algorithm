package PROGRAMMERS.level1

import kotlin.math.abs

class Solution키패드누르기 {

    companion object {
        val LEFT_HAND_NUMBERS: List<Int> = listOf(1, 4, 7)
        val RIGHT_HAND_NUMBERS: List<Int> = listOf(3, 6, 9)
    }

    private var hand = ""
    private var leftHandPosition: Int = 10
    private var rightHandPosition: Int = 12

    fun solution(numbers: IntArray, hand: String): String {
        this.hand = if (hand.startsWith("l")) "L" else "R"

        return numbers.map { number ->
            push(parse(number))
        }.joinToString("")
    }

    private fun parse(number: Int): Int {
        if (number == 0)
            return 11
        return number
    }

    private fun push(number: Int): String {
        if (LEFT_HAND_NUMBERS.contains(number)) {
            leftHandPosition = number
            return "L"
        } else if (RIGHT_HAND_NUMBERS.contains(number)) {
            rightHandPosition = number
            return "R"
        } else {
            val leftHandDistance = getDistance(leftHandPosition, number)
            val rightHandDistance = getDistance(rightHandPosition, number)
            if (leftHandDistance > rightHandDistance) {
                rightHandPosition = number
                return "R"
            } else if (rightHandDistance > leftHandDistance) {
                leftHandPosition = number
                return "L"
            } else {
                if (hand == "L") {
                    leftHandPosition = number
                    return "L"
                } else {
                    rightHandPosition = number
                    return "R"
                }
            }
        }
        return ""
    }

    private fun getDistance(position1: Int, position2: Int): Int {
        return abs((position2 - 1) / 3 - (position1 - 1) / 3) + abs((position2 - 1) % 3 - (position1 - 1) % 3)
    }

}