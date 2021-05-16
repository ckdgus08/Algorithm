package PROGRAMMERS.DfsBfs;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    int answer;
    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited;

    public int solution(int n, int[][] computers) {

        visited = new boolean[n];

        for (int i = 0; i < n ; i++) {
            bfs(computers, i);
        }

        return answer;
    }

    void bfs(int[][] computers, int start) {

        if (visited[start])
            return;
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            for (int i = 0; i < computers.length; i++) {
                if (computers[now][i] == 0) continue;
                if (visited[i]) continue;

                queue.add(i);
                visited[i] = true;
            }
        }
        answer++;
    }

}
