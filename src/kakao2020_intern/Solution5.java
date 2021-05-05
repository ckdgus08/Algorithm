package kakao2020_intern;

import java.util.*;

// TODO: 2021/05/05 17:50~
public class Solution5 {

    Queue<Integer> queue = new LinkedList<>();
    Map<Integer, List<Integer>> line = new HashMap<>();
    Map<Integer, List<Integer>> need = new HashMap<>();
    int[] visited;

    public boolean solution(int n, int[][] path, int[][] order) {
        boolean answer = true;

        visited = new int[n];

        for (int i = 0; i < path.length; i++) {
            int first = path[i][0];
            int second = path[i][1];
            putData(line, second, first);
            putData(line, first, second);
        }
        for (int i = 0; i < order.length; i++) {
            int first = order[i][0];
            int second = order[i][1];
            putData(need, second, first);
        }

        queue.add(0);
        visited[0]++;

        while (!queue.isEmpty()) {

            Integer now = queue.poll();

            if (0 == Arrays.stream(visited).filter(v -> v == 0).count())
                return true;

            if (line.containsKey(now))
                for (Integer next : line.get(now)) {
                    if (visited[next] >= 1000) return false;
                    if (need.containsKey(next)) {
                        int temp = 0;

                        for (Integer check : need.get(next)) {
                            if (visited[check] == 0) break;
                            temp++;
                        }

                        if (temp == need.get(next).size()) {
                            visited[next]++;
                            queue.add(next);
                        }
                    } else {
                        visited[next]++;
                        queue.add(next);
                    }
                }
        }

        return false;
    }

    private void putData(Map<Integer, List<Integer>> map, int first, int second) {
        if (!map.containsKey(first)) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(second);
            map.put(first, list);
        } else {
            List<Integer> list = map.get(first);
            list.add(second);
            map.put(first, list);
        }
    }
}
