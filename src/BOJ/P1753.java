package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1753 {

    static ArrayList<Node>[] list;
    static int V, E, start;
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList[V];
        distance = new int[V];
        visited = new boolean[V];
        start = Integer.parseInt(br.readLine());

        for (int i = 0; i < V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int third = Integer.parseInt(st.nextToken());
            list[first - 1].add(new Node(second - 1, third));
        }
        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(
                Comparator.comparingInt(o -> o.dist)
        );

        queue.offer(new Node(start - 1, 0));
        distance[start - 1] = 0;

        while (!queue.isEmpty()) {

            Node now = queue.poll();

            if (visited[now.index]) continue;
            else
                visited[now.index] = true;

            for (Node next : list[now.index]) {
                if (distance[next.index] <= distance[now.index] + next.dist) continue;

                distance[next.index] = distance[now.index] + next.dist;
                queue.add(new Node(next.index, distance[next.index]));
            }
        }

        for (int i : distance) {
            if (i == Integer.MAX_VALUE)
                bw.append("INF" + "\n");
            else
                bw.append(i + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int index;
        int dist;

        public Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }
    }
}
