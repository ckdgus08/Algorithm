package kakao2019_intern;

public class Main {

    public static void main(String[] args) {

        Solution3 solution = new Solution3();

//        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
//        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};


        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};

        int solution1 = solution.solution(user_id, banned_id);

        System.out.println("solution1 = " + solution1);


    }
}
