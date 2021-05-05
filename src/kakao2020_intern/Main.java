package kakao2020_intern;

public class Main {

    public static void main(String[] args) {


//        int N = 9;
//        int[][] path = {{0, 1}, {0, 3}, {0, 7}, {8, 1}, {3, 6}, {1, 2}, {4, 7}, {7, 5}};
//        int[][] order = {{8, 5}, {6, 7}, {4, 1}};
////


        int N = 9;
        int[][] path = {{8, 1}, {0, 1}, {1, 2}, {0, 7}, {4, 7}, {0, 3}, {7, 5}, {3, 6}};
        int[][] order = {{4, 1}, {5, 2}};
//
//        int N = 9;
//        int[][] path = {{0, 1}, {0, 3}, {0, 7}, {8, 1}, {3, 6}, {1, 2}, {4, 7}, {7, 5}};
//        int[][] order = {{4, 1}, {8, 7}, {6, 5}};

        Solution5 solution = new Solution5();

        boolean solution1 = solution.solution(N, path, order);

        System.out.println("solution1 = " + solution1);
    }
}
