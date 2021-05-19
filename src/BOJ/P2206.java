package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2206 {

    static int N;
    static int M;
    static int[][] board;
    static boolean[][][] visited;
    static Queue<Node> queue = new LinkedList<>();
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                int value = str.charAt(j) - '0';
                board[i][j] = value;
            }
        }
        visited[0][0][0] = true;
        queue.add(new Node(0, 0, 1, 0));

        while (!queue.isEmpty()) {

            Node now = queue.poll();

            if (now.x == N - 1 && now.y == M - 1) {
                System.out.println(now.distance);
                System.exit(0);
            }


            for (int i = 0; i < 4; i++) {
                int newX = now.x + dx[i];
                int newY = now.y + dy[i];

                if (newX < 0 || newX >= N || newY < 0 || newY >= M) continue;
                if (visited[newX][newY][now.isBreak]) continue;
                if (board[newX][newY] == 1 && now.isBreak == 1) continue;

                if (board[newX][newY] == 1 && now.isBreak == 0) {
                    visited[newX][newY][1] = true;
                    queue.add(new Node(newX, newY, now.distance + 1, 1));
                } else if (board[newX][newY] == 0) {
                    visited[newX][newY][now.isBreak] = true;
                    queue.add(new Node(newX, newY, now.distance + 1, now.isBreak));
                }
            }
        }
        System.out.println("-1");
    }

    static class Node {
        int x;
        int y;
        int distance;
        int isBreak;

        public Node(int x, int y, int distance, int isBreak) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.isBreak = isBreak;
        }
    }
}
