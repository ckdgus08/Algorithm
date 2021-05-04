package kakao2020_intern;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution4 {

    boolean[][] visited;
    int[][] D = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    Queue<Point> q = new LinkedList<>();
    int N;
    List<Point> result = new ArrayList<>();

    public int solution(int[][] board) {
        N = board.length;
        visited = new boolean[N][N];

        bfs(board, 0, 0, N - 1, N - 1);

        return result.stream().map(point -> (point.line * 100 + point.cour * 500)).max(Integer::min).get();
    }

    void bfs(int[][] board, int startX, int startY, int endX, int endY) {
        visited[startX][startY] = true;
        q.add(new Point(startX, startY, 0, 0, true));

        while (!q.isEmpty()) {
            Point now = q.remove();

            if (now.x == endX && now.y == endY)
                result.add(now);

            for (int i = 0; i < 4; i++) {
                int newX = now.x + D[i][0];
                int newY = now.y + D[i][1];

                if (newX < 0 || newY < 0 || newX >= N || newY >= N) continue;
                if (visited[newX][newY]) continue;
                if (board[newX][newY] == 1) continue;
                visited[newX][newY] = true;

                if (now.face) {
                    if (now.y != newY)
                        q.add(new Point(newX, newY, now.line + 1, now.cour, true));
                    else
                        q.add(new Point(newX, newY, now.line, now.cour + 1, false));
                } else {
                    if (now.x != newX)
                        q.add(new Point(newX, newY, now.line + 1, now.cour, false));
                    else
                        q.add(new Point(newX, newY, now.line, now.cour + 1, true));
                }
            }
        }
    }

    static class Point {
        int x;
        int y;
        int line;
        int cour;
        boolean face;

        public Point(int x, int y, int line, int cour, boolean face) {
            this.x = x;
            this.y = y;
            this.line = line;
            this.cour = cour;
            this.face = face;
        }
    }
}
