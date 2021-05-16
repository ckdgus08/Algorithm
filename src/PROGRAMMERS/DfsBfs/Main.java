package PROGRAMMERS.DfsBfs;

public class Main {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        int solution1 = solution.solution(n, computers);

        System.out.println("solution1 = " + solution1);
    }


}
