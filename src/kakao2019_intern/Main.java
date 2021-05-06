package kakao2019_intern;

public class Main {

    public static void main(String[] args) {

        Solution5 solution = new Solution5();

//        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
//        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};


        int[] room = {5, 3, 5, 4, 5, 5, 4, 4, 1, 1};

        int solution1 = solution.solution(room, 3);

        System.out.println("solution1 = " + solution1);


    }
}
