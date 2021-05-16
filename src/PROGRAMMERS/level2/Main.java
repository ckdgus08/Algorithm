package PROGRAMMERS.level2;

public class Main {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

        int solution1 = solution2.solution(6, new int[][]{{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}}, 4);
        System.out.println(solution1);
    }
}
