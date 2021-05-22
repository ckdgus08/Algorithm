package dev_carnival;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution4 {

    static int N;
    static Map<Integer, Boolean>[] maps;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input, " ");

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int result[] = new int[N + 1];
        maps = new HashMap[N + 1];
        for (int i = 0; i < maps.length; i++) {
            maps[i] = new HashMap<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            maps[first].put(second, true); // 정방향
            maps[second].put(first, false); // 역방향
        }

        for (int i = 1; i <= N; i++) {
            result[i] = gogo(i, maps);
        }

        int temp_index = 0;
        int temp_max = -1;
        for (int i = 0; i < result.length; i++) {
            if (result[i] > temp_max) {
                temp_max = result[i];
                temp_index = i+1;
            }
        }

        System.out.println(temp_index + " " + temp_max);
    }

    static int gogo(int start, Map<Integer, Boolean>[] maps) {

        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        visited[start] = true;
        queue.add(new Node(start, 1, true, visited));

        int count = 0;
        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.dist == N || count >= 2000)
                return now.dist;
            for (Integer next : maps[now.index].keySet()) {
                int temp_dist = now.dist;
                if (maps[now.index].get(next) == !now.direction) continue; // 역방향일때

                if (!visited[next]) {
                    temp_dist++;
                }
                now.visited[next] = true;
                queue.add(new Node(next, temp_dist, !now.direction, now.visited));
            }
            count++;
        }
        return -1;
    }

    static class Node {
        int index;
        int dist;
        boolean direction;
        boolean[] visited = new boolean[N + 1];

        public Node(int index, int dist, boolean direction, boolean[] visited) {
            this.index = index;
            this.dist = dist;
            this.direction = direction;
            for (int i = 0; i < visited.length; i++)
                this.visited[i] = visited[i];
        }
    }


}
//
//7 9
//2 1
//4 5
//3 6
//4 6
//1 3
//6 5
//5 2
//6 7
//4 1