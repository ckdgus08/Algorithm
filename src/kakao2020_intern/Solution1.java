package kakao2020_intern;

class Solution1 {

    int left = 10; // *
    int right = 12; // #
    String hand = "";

    int[][] arr = {{0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}, {3, 0}, {3, 1}, {3, 2}};

    public String solution(int[] numbers, String hand) {

        this.hand = hand;
        String answer = "";

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0)
                numbers[i] = 11;

        }

        for (int target : numbers) {
            if (target % 3 == 1) {
                answer += "L";
                left = target;
            } else if (target % 3 == 0) {
                answer += "R";
                right = target;
            } else if (target % 3 == 2) {
                int leftDist = Math.abs(arr[target-1][0] - arr[left-1][0]) + Math.abs(arr[target-1][1] - arr[left-1][1]);
                int rightDist = Math.abs(arr[target-1][0] - arr[right-1][0]) + Math.abs(arr[target-1][1] - arr[right-1][1]);

                if (leftDist > rightDist) {
                    answer += "R";
                    right = target;
                } else if (leftDist < rightDist) {
                    answer += "L";
                    left = target;
                } else if (leftDist == rightDist) {
                    if (hand.equals("right")) {
                        answer += "R";
                        right = target;
                    } else {
                        answer += "L";
                        left = target;
                    }
                }
            }
        }

        return answer;
    }
}
