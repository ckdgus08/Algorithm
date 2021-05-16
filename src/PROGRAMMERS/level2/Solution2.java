package PROGRAMMERS.level2;

import java.util.Arrays;

public class Solution2 {

    int[][] weight;
    int[] distance;
    boolean[] visited;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        weight = new int[N][N];
        distance = new int[N];
        visited = new boolean[N];

        Arrays.fill(distance, 9999999);


        for (int[] ints : road) {
            if (weight[ints[0] - 1][ints[1] - 1] != 0) {
                weight[ints[0] - 1][ints[1] - 1] = Math.min(weight[ints[0] - 1][ints[1] - 1], ints[2]);
                weight[ints[1] - 1][ints[0] - 1] = Math.min(weight[ints[1] - 1][ints[0] - 1], ints[2]);
            } else {
                weight[ints[0] - 1][ints[1] - 1] = ints[2];
                weight[ints[1] - 1][ints[0] - 1] = ints[2];
            }
        }

        distance[0] = 0;

        for (int i = 0; i < N - 1; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;

            for (int j = 0; j < N; j++) {
                if (!visited[j] && distance[j] < min) {
                    min = distance[j];
                    index = j;
                }
            }

            visited[index] = true;

            for (int j = 0; j < N; j++) {
                if (!visited[j] && weight[index][j] != 0 && distance[index] + weight[index][j] < distance[j]) {
                    distance[j] = distance[index] + weight[index][j];
                }
            }
        }

        return (int) Arrays.stream(distance).filter(i -> i <= K).count();
    }
}
