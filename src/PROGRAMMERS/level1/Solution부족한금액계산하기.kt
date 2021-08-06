package PROGRAMMERS.level1

class Solution부족한금액계산하기 {
    fun solution(price: Int, money: Int, count: Int): Long {

        val requiredMoney = calculateRequiredMoney(price, count);

        if (money >= requiredMoney) {
            return 0
        }
        return requiredMoney - money
    }

    private fun calculateRequiredMoney(price: Int, count: Int): Long {
        return price * (count * (count + 1) / 2L);
    }
}