package kakao_blind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

// TODO: 2021/05/07 11:10
public class Solution4 {

    List<String> list = new ArrayList<>();

    public String[] solution(String[] orders, int[] course) {

        HashMap<String, Integer> map = new HashMap<>();
        for (String order : orders) {
            for (int i : course) {
                list = new ArrayList<>();

                List<String> comb = comb(order.toCharArray(), new char[order.length()], new boolean[order.length()], 0, order.length(), i);
                for (String s : comb) {
                    if (map.containsKey(s))
                        map.put(s, map.get(s) + 1);
                    else
                        map.put(s, 1);
                }
            }
        }
        int[] max = new int[Arrays.stream(course).max().getAsInt()];

        for (String s : map.keySet()) {
            if (map.get(s) >= 2) {
                if (max[s.length() - 1] < map.get(s))
                    max[s.length() - 1] = map.get(s);
            }
        }
        List<String> answer = new ArrayList<>();
        for (String s : map.keySet()) {
            if (map.get(s) == max[s.length() - 1])
                answer.add(s);
        }

        return answer.stream().sorted().toArray(String[]::new);
    }


    List<String> comb(char[] arr, char[] output, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
//            StringBuilder temp = new StringBuilder();
            List<Character> temp = new ArrayList<>();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    temp.add(arr[i]);
//                    temp.append(arr[i]);
                }
            }
//            list.add(temp.toString());
            list.add(temp.stream().sorted().map(Object::toString).collect(Collectors.joining()));
            return list;
        }
        for (int i = start; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                comb(arr, output, visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }
        return list;
    }

}
