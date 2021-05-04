package DfsBfs;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        int solution1 = solution.solution(numbers, target);

        System.out.println("solution1 = " + solution1);
    }

}
