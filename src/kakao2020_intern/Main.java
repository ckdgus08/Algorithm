package kakao2020_intern;

public class Main {

    public static void main(String[] args) {
        int[][] str = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
//        int[][] str = {{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}};
        Solution4 solution = new Solution4();

        int solution1 = solution.solution(str);

        System.out.println("solution1 = " + solution1);
    }
}
