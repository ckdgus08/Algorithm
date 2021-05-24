package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P2479 {

    public static int N;
    public static int K;
    public static int start;
    public static int end;
    public static String[] arr;

    public static int[][] distance;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        K = Integer.parseInt(split[1]);

        arr = new String[N];
        distance = new int[N][N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        String[] split1 = br.readLine().split(" ");
        start = Integer.parseInt(split1[0]);
        end = Integer.parseInt(split1[1]);

        start--;
        end--;

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int length = 0;
                for (int k = 0; k < K; k++) {
                    if (arr[i].charAt(k) != arr[j].charAt(k))
                        length++;
                }
                distance[i][j] = length;
                distance[j][i] = length;
            }
        }


            Queue<Node> queue = new LinkedList<>();
            boolean[] visited = new boolean[N];
            List<Integer> list = new ArrayList<>();

            queue.add(new Node(start, list));
            visited[start] = true;


            while (!queue.isEmpty()) {
                Node now = queue.poll();

                if (now.index == end) {
                    for (Integer integer : now.path) {
                        System.out.print((integer + 1) + " ");
                    }
                    return;
                }

                for (int i = 0; i < N; i++) {
                    if (visited[i]) continue;
                    if (distance[now.index][i] != 1) continue;

                    queue.add(new Node(i, now.path));
                    visited[i] = true;
                }
            }
        System.out.println("-1");
    }

    public static class Node {
        int index;
        List<Integer> path = new ArrayList<>();

        public Node(int index, List<Integer> path) {
            this.index = index;
            this.path.addAll(path);
            this.path.add(index);
        }
    }

}
