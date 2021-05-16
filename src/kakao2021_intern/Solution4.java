package kakao2021_intern;

import java.util.*;

public class Solution4 {

    public int solution(int n, int start, int end, int[][] roads, int[] traps) {

        int answer = 0;
        int[][] graph = new int[n][n];
        int[] distance = new int[n];
        Arrays.fill(distance, 999999);
        boolean[] visited = new boolean[n];

        distance[start] = 0;
        for (int i = 0; i < roads.length; i++) {
            graph[roads[i][0] - 1][roads[i][1] - 1] = roads[i][2];
        }

        List<Integer> trap = new ArrayList<>();
        for (int i : traps) {
            trap.add(i);
        }

        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.distance < o2.distance) return -1;
                else if (o1.distance == o2.distance) return 0;
                else return 1;
            }
        });

        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            int now = pq.poll().index;

            if (visited[now]) continue;
            visited[now] = true;

            for (int i = 0; i < n; i++) {
                if (trap.contains(i)) {
                    for (int j = 0; j < n; j++) {
                        int temp = graph[i][j];
                        graph[i][j] = graph[j][i];
                        graph[j][i] = temp;
                    }
                }

                int temp = graph[now][i];
                if (temp > distance[now] + distance[i]) {
                    distance[i] = distance[now] + distance[i];
                    pq.offer(new Node(i, distance[i]));
                }
            }
        }

        return distance[end];
    }

    class Node {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
}
