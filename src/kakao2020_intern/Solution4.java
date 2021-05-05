package kakao2020_intern;

import java.util.LinkedList;
import java.util.Queue;

public class Solution4 {

    int[][] D = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    Queue<Point> queue = new LinkedList<>();
    int result = Integer.MAX_VALUE;
    int N;

    public int solution(int[][] board) {

        N = board.length;

        bfs(board, 0, 0, N - 1, N - 1);

        return result;
    }


    void bfs(int[][] board, int start_x, int start_y, int end_x, int end_y) {

        queue.add(new Point(start_x, start_y, 0, -1));

        board[start_x][start_y] = 1;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (now.x == end_x && now.y == end_y)
                if (result > now.price)
                    result = now.price;

            for (int i = 0; i < 4; i++) {
                int new_x = now.x + D[i][0];
                int new_y = now.y + D[i][1];

                if (new_x < 0 || new_y < 0 || new_x >= N || new_y >= N) continue;
                if (board[new_x][new_y] == 1) continue;

                int temp_price;
                int temp_dist;
                // 세로방향 이동
                if (now.x == new_x) {
                    temp_dist = 1;
                    if (now.dis == -1 || now.dis == 1) {
                        temp_price = now.price + 100;
                    } else {
                        temp_price = now.price + 600;
                    }
                } else {
                    temp_dist = 2;
                    if (now.dis == -1 || now.dis == 2) {
                        temp_price = now.price + 100;
                    } else {
                        temp_price = now.price + 600;
                    }
                }
                if (board[new_x][new_y] == 0) {
                    board[new_x][new_y] = temp_price;
                    queue.add(new Point(new_x, new_y, temp_price, temp_dist));
                } else if (board[new_x][new_y] >= temp_price) {
                    board[new_x][new_y] = temp_price;
                    queue.add(new Point(new_x, new_y, temp_price, temp_dist));
                }
            }
        }
    }


    class Point {
        int x;
        int y;
        int price;
        int dis;

        public Point(int x, int y, int price, int dis) {
            this.x = x;
            this.y = y;
            this.price = price;
            this.dis = dis;
        }
    }

}
