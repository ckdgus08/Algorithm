package PROGRAMMERS.level1;

public class Solution2 {

    public int solution(int n, int[] lost, int[] reserve) {

        boolean[] visited = new boolean[n + 1];
        n -= lost.length;

        for (int l : lost)
            for (int r : reserve) {
                if (visited[r]) continue;
                if (l == r || l - 1 == r || l + 1 == r) {
                    visited[r] = true;
                    n++;
                    break;
                }
            }

        return n;
    }
}
