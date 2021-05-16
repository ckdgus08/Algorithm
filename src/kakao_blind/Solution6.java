package kakao_blind;

public class Solution6 {

    final int INF = 30000000;
    int[][] dist;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    dist[i][j] = 0;
                else
                    dist[i][j] = INF;
            }
        }

        for (int[] edge : fares) {
            dist[edge[0] - 1][edge[1] - 1] = edge[2];
            dist[edge[1] - 1][edge[0] - 1] = edge[2];
        }

        floyd(n);

        --s;
        --a;
        --b;

        int answer = INF;

        for (int i = 0; i < n; i++)
            answer = Math.min(answer, dist[s][i] + dist[i][a] + dist[i][b]);

        return answer;
    }

    void floyd(int n) {
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
    }
}
