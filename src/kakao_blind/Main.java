package kakao_blind;

public class Main {

    public static void main(String[] args) {

        Solution6 solution6 = new Solution6();

        int solution = solution6.solution(6, 4, 6, 2,
                new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}});

        System.out.println("solution = " + solution);

    }
}
