package dev_carnival;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        N = Integer.parseInt(input);
        int[][] board = new int[N][N];
        int start_x1, start_y1, start_x2, start_y2;
        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};

        for (int i = 0; i < N; i++) {
            char[] elements = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                char element = elements[j];
                if (element == '.')
                    board[i][j] = 1;
                else if (element == 'D')
                    board[i][j] = 2;
//                else
//                    board[i][j];
            }
        }

        String[] split = br.readLine().split(" ");
        start_x1 = Integer.parseInt(split[0]);
        start_y1 = Integer.parseInt(split[1]);
        start_x2 = Integer.parseInt(split[2]);
        start_y2 = Integer.parseInt(split[3]);

        Queue<Unit> queue = new LinkedList<>();
        boolean[][] visited1 = new boolean[N][N];
        boolean[][] visited2 = new boolean[N][N];

        visited1[start_x1][start_y1] = true;
        visited2[start_x2][start_y2] = true;

        queue.add(new Unit(start_x1, start_y1, start_x2, start_y2, 0, visited1, visited2));

        while (!queue.isEmpty()) {
            Unit now = queue.poll();

            if (board[now.x1][now.y1] == 2 && board[now.x2][now.y2] == 2) {
                System.out.println(now.time);
                System.exit(0);
            }
            if (queue.size() >= 200000)
                break;

            for (int i = 0; i < 4; i++) {
                int new_x1 = now.x1 + dx[i];
                int new_y1 = now.y1 + dy[i];
                int new_x2 = now.x2 + dx[i];
                int new_y2 = now.y2 + dy[i];
                if (new_x1 < 0 || new_x1 >= N || new_y1 < 0 || new_y1 >= N
                        || visited1[new_x1][new_y1] || board[new_x1][new_y1] == 0 || board[now.x1][now.y1] == 2) {
                    new_x1 = now.x1;
                    new_y1 = now.y1;
                }
                if (new_x2 < 0 || new_x2 >= N || new_y2 < 0 || new_y2 >= N
                        || visited2[new_x2][new_y2] || board[new_x2][new_y2] == 0 || board[now.x2][now.y2] == 2) {
                    new_x2 = now.x2;
                    new_y2 = now.y2;
                }

                if (new_x1 == now.x1 && new_y1 == now.y1 && new_x2 == now.x2 && new_y2 == now.y2)
                    continue;

                now.visited1[new_x1][new_y1] = true;
                now.visited2[new_x2][new_y2] = true;
                queue.add(new Unit(new_x1, new_y1, new_x2, new_y2, now.time + 1, now.visited1, now.visited2));
            }
        }
        System.out.println("-1");
    }

    static class Unit {
        int x1;
        int y1;
        int x2;
        int y2;
        int time;

        boolean[][] visited1 = new boolean[N][N];
        boolean[][] visited2 = new boolean[N][N];

        public Unit(int x1, int y1, int x2, int y2, int time, boolean[][] visited1, boolean[][] visited2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.time = time;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    this.visited1[i][j] = visited1[i][j];
                    this.visited2[i][j] = visited2[i][j];
                }
            }
        }
    }
}
