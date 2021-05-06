package kakao2019_intern;

public class Solution5 {

    // TODO: 2021/05/06 21:00

    public int solution(int[] stones, int k) {

        int answer = Integer.MAX_VALUE;
        for (int start = 0; start < stones.length - k + 1; start++) {
            if (answer <= stones[start]) continue;

            int count = Integer.MIN_VALUE;
            for (int i = start; i < start + k; i++) {
                if (count < stones[i])
                    count = stones[i];
            }
            if (answer > count)
                answer = count;
        }
        return answer;
    }
}
