package kakao2020_intern;

import java.util.*;

public class Solution3 {

    Set<String> set = new HashSet<>();
    Map<String, Integer> map = new HashMap<>();
    Queue<String> q = new LinkedList<>();
    int[] answer = {1, Integer.MAX_VALUE};
    int start = 1;

    public int[] solution(String[] gems) {

        for (int i = 0; i < gems.length; i++) {
            set.add(gems[i]);
        }

        int total_gem_count = set.size();

        for (int i = 0; i < gems.length; i++) {

            if (!map.containsKey(gems[i]))
                map.put(gems[i], 1);
            else
                map.put(gems[i], map.get(gems[i]) + 1);

            q.add(gems[i]);

            while (true) {
                if (map.get(q.peek()) >= 2) {
                    q.poll();
                    map.put(gems[i], map.get(gems[i]) - 1);
                    start++;
                } else {
                    break;
                }
            }

            if (map.size() == total_gem_count) {
                if (answer[1] - answer[0] >= q.size()-1) {
                    answer[0] = start;
                    answer[1] = start + q.size()-1;
                }
            }
        }

        return answer;
    }
}
