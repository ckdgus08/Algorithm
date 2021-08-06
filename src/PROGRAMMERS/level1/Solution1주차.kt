package PROGRAMMERS.level1

class Solution1주차 {
    fun solution(price: Int, money: Int, count: Int): Long {
        val requiredMoney: Long = calculateRequiredMoney(price, count)

        if (money > requiredMoney) {
            return 0L
        }
        return requiredMoney - money
    }

    fun calculateRequiredMoney(price: Int, count: Int): Long {
        var requiredMoney = 0L
        for (i in 1..count) {
            requiredMoney += i * price
        }
        return requiredMoney
    }
}