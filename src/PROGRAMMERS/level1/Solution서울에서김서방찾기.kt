package PROGRAMMERS.level1

class Solution서울에서김서방찾기 {
    fun solution(seoul: Array<String>): String {
        seoul.forEachIndexed { index, s ->
            if (s == "Kim") {
                return "김서방은 " + index + "에 있다";
            }
        }
        return ""
    }
}