package kakao2019_intern;

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();

//        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
//        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};


        int[][] board = {{0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 2, 1, 0, 0}, {0, 2, 1, 0, 0}, {0, 2, 1, 0, 0}};
        int[] moves = {1, 2, 3, 3, 2, 3, 1};
        int solution1 = solution.solution(board, moves);

        System.out.println("solution1 = " + solution1);

    }
}
