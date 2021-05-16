package PROGRAMMERS.DfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution3 {

    static int N = -1;
    static int start = -1;
    static boolean[] visited;
    static boolean[][] map;
    static Queue<Integer> queue = new LinkedList<>();
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        start = Integer.parseInt(split[2]);
        visited = new boolean[N];
        map = new boolean[N][N];

        for (int i = 0; i < Integer.parseInt(split[1]); i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int temp1 = Integer.parseInt(st.nextToken()) - 1;
            int temp2 = Integer.parseInt(st.nextToken()) - 1;
            map[temp1][temp2] = true;
            map[temp2][temp1] = true;
        }

        queue.add(start - 1);
        visited[start - 1] = true;

        while (!queue.isEmpty()) {
            Integer next = queue.poll();
            list.add(next);

            for (int i = 0; i < N; i++) {
                if (!map[next][i]) continue;
                if (visited[i]) continue;

                queue.add(i);
                visited[i] = true;
            }
        }

        System.out.print(list.get(0) + 1);
        for (int i = 1; i < list.size(); i++) {
            System.out.print(" " + (list.get(i) + 1));
        }
    }


}
